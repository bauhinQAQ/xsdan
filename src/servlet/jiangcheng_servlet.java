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

import model.Tjiangcheng;
import model.Txuesheng;

import service.utilService;
import util.DB;


public class jiangcheng_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        if(type.endsWith("jiangchengAdd"))
		{
			jiangchengAdd(req, res);
		}
		if(type.endsWith("jiangchengMana"))
		{
			jiangchengMana(req, res);
		}
		
		if(type.endsWith("jiangchengDel"))
		{
			jiangchengDel(req, res);
		}
		if(type.endsWith("jiangchengMine"))
		{
			jiangchengMine(req, res);
		}
	}
	
	
	public void jiangchengAdd(HttpServletRequest req,HttpServletResponse res)
	{
		int xuesheng_id=Integer.parseInt(req.getParameter("xuesheng_id"));
		String shijian=req.getParameter("shijian");
		String shuxing=req.getParameter("shuxing");
		String beizhu=req.getParameter("beizhu");
		
		String sql="insert into t_jiangcheng(xuesheng_id,shijian,shuxing,beizhu) values(?,?,?,?)";
		Object[] params={xuesheng_id,shijian,shuxing,beizhu};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jiangcheng?type=jiangchengMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void jiangchengDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="delete from t_jiangcheng where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jiangcheng?type=jiangchengMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void jiangchengMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List jiangchengList=new ArrayList();
		String sql="select * from t_jiangcheng";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjiangcheng jiangcheng=new Tjiangcheng();
				
				jiangcheng.setId(rs.getInt("id"));
				jiangcheng.setXuesheng_id(rs.getInt("xuesheng_id"));
				jiangcheng.setShijian(rs.getString("shijian"));
				jiangcheng.setShuxing(rs.getString("shuxing"));
				jiangcheng.setBeizhu(rs.getString("beizhu"));
				
				jiangcheng.setXuesheng(utilService.get_xuesheng(rs.getInt("xuesheng_id")));
				
				jiangchengList.add(jiangcheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("jiangchengList", jiangchengList);
		req.getRequestDispatcher("admin/jiangcheng/jiangchengMana.jsp").forward(req, res);
	}
	
	
	
	public void jiangchengMine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Txuesheng xuesheng=(Txuesheng)req.getSession().getAttribute("xuesheng");
		
		List jiangchengList=new ArrayList();
		String sql="select * from t_jiangcheng where xuesheng_id=?";
		Object[] params={xuesheng.getId()};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjiangcheng jiangcheng=new Tjiangcheng();
				
				jiangcheng.setId(rs.getInt("id"));
				jiangcheng.setXuesheng_id(rs.getInt("xuesheng_id"));
				jiangcheng.setShijian(rs.getString("shijian"));
				jiangcheng.setShuxing(rs.getString("shuxing"));
				jiangcheng.setBeizhu(rs.getString("beizhu"));
				
				jiangcheng.setXuesheng(utilService.get_xuesheng(rs.getInt("xuesheng_id")));
				
				jiangchengList.add(jiangcheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("jiangchengList", jiangchengList);
		req.getRequestDispatcher("admin/jiangcheng/jiangchengMine.jsp").forward(req, res);
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
