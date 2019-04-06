package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.utilService;
import util.DB;

import model.TAdmin;
import model.Tkecheng;
import model.Txuesheng;

public class xuesheng_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("xueshengAdd"))
		{
			xueshengAdd(req, res);
		}
		if(type.endsWith("xueshengMana"))
		{
			xueshengMana(req, res);
		}
		if(type.endsWith("xueshengDel"))
		{
			xueshengDel(req, res);
		}
		
		if(type.endsWith("xueshengAll"))
		{
			xueshengAll(req, res);
		}
		
		if(type.endsWith("xueshengEditMe"))
		{
			xueshengEditMe(req, res);
		}
	}
	
	public void xueshengAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String xuehao=req.getParameter("xuehao");
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		
		String nianling=req.getParameter("nianling");
		String loginpw=req.getParameter("loginpw");
		String del="no";
		
		String sql="insert into t_xuesheng(xuehao,xingming,xingbie,nianling,loginpw,del) values(?,?,?,?,?,?)";
		Object[] params={xuehao,xingming,xingbie,nianling,loginpw,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "xuesheng?type=xueshengMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void xueshengMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List xueshengList=new ArrayList();
		String sql="select * from t_xuesheng where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Txuesheng xuesheng=new Txuesheng();
				
				xuesheng.setId(rs.getInt("id"));
				xuesheng.setXuehao(rs.getString("xuehao"));
				xuesheng.setXingming(rs.getString("xingming"));
				
				xuesheng.setXingbie(rs.getString("xingbie"));
				xuesheng.setNianling(rs.getString("nianling"));
				xuesheng.setLoginpw(rs.getString("loginpw"));
				xuesheng.setDel(rs.getString("del"));
				
				
				xueshengList.add(xuesheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("xueshengList", xueshengList);
		req.getRequestDispatcher("admin/xuesheng/xueshengMana.jsp").forward(req, res);
	}
	
	
	
	public void xueshengDel(HttpServletRequest req,HttpServletResponse res)
	{
		
		String sql="update t_xuesheng set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "xuesheng?type=xueshengMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void xueshengAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List xueshengList=new ArrayList();
		String sql="select * from t_xuesheng where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
                Txuesheng xuesheng=new Txuesheng();
				
				xuesheng.setId(rs.getInt("id"));
				xuesheng.setXuehao(rs.getString("xuehao"));
				xuesheng.setXingming(rs.getString("xingming"));
				
				xuesheng.setXingbie(rs.getString("xingbie"));
				xuesheng.setNianling(rs.getString("nianling"));
				xuesheng.setLoginpw(rs.getString("loginpw"));
				xuesheng.setDel(rs.getString("del"));
				
				
				xueshengList.add(xuesheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("xueshengList", xueshengList);
		req.getRequestDispatcher("admin/xuesheng/xueshengAll.jsp").forward(req, res);
	}
	
	
	
	
	public void xueshengEditMe(HttpServletRequest req,HttpServletResponse res)
	{
		String xuehao=req.getParameter("xuehao");
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		
		String nianling=req.getParameter("nianling");
		String loginpw=req.getParameter("loginpw");
		
		String id=req.getParameter("id");
		
		
		String sql="update t_xuesheng set xuehao=?,xingming=?,xingbie=?,nianling=?,loginpw=? where id=?";
		Object[] params={xuehao,xingming,xingbie,nianling,loginpw,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "修改成功，重新登陆后生效");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
