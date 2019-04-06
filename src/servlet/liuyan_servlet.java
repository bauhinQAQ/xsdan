package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.utilService;
import util.DB;

import model.TLiuyan;
import model.Txuesheng;


public class liuyan_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        if(type.endsWith("liuyanAdd"))
		{
			liuyanAdd(req, res);
		}
        if(type.endsWith("liuyanMana"))
		{
			liuyanMana(req, res);
		}
		if(type.endsWith("liuyanDel"))
		{
			liuyanDel(req, res);
		}
		if(type.endsWith("liuyanHuifu"))
		{
			liuyanHuifu(req, res);
		}
		if(type.endsWith("liuyanAll"))
		{
			liuyanAll(req, res);
		}
		
		if(type.endsWith("liuyanDetail"))
		{
			liuyanDetail(req, res);
		}
	}
	
	
	public void liuyanAdd(HttpServletRequest req,HttpServletResponse res)
	{
		
		HttpSession session=req.getSession();
		Txuesheng xuesheng=(Txuesheng)session.getAttribute("xuesheng");
		
		
		String neirong=req.getParameter("neirong");
		String liuyanshi=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		int xuesheng_id=xuesheng.getId();
		String huifu="";
		
		String huifushi="";
		
		String sql="insert into t_liuyan(neirong,liuyanshi,xuesheng_id,huifu,huifushi) values(?,?,?,?,?)";
		Object[] params={neirong,liuyanshi,xuesheng_id,huifu,huifushi};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "�������");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void liuyanMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List liuyanList=new ArrayList();
		String sql="select * from t_liuyan order by liuyanshi";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TLiuyan liuyan=new TLiuyan();
				
				liuyan.setId(rs.getInt("id"));
				liuyan.setNeirong(rs.getString("neirong"));
				liuyan.setLiuyanshi(rs.getString("liuyanshi"));
				liuyan.setXuesheng_id(rs.getInt("xuesheng_id"));
				
				liuyan.setHuifu(rs.getString("huifu"));
				liuyan.setHuifushi(rs.getString("huifushi"));
				
				liuyan.setXuesheng(utilService.get_xuesheng(liuyan.getXuesheng_id()));
			
				liuyanList.add(liuyan);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("liuyanList", liuyanList);
		req.getRequestDispatcher("admin/liuyan/liuyanMana.jsp").forward(req, res);
	}
	
	public void liuyanDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="delete from t_liuyan where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "������Ϣɾ�����");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void liuyanHuifu(HttpServletRequest req,HttpServletResponse res)
	{
		String huifu=req.getParameter("huifu");
		String huifushi=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_liuyan set huifu=?,huifushi=? where id=?";
		Object[] params={huifu,huifushi,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "�ظ�������");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}

	public void liuyanAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List liuyanList=new ArrayList();
		String sql="select * from t_liuyan order by liuyanshi";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TLiuyan liuyan=new TLiuyan();
				
				liuyan.setId(rs.getInt("id"));
				liuyan.setNeirong(rs.getString("neirong"));
				liuyan.setLiuyanshi(rs.getString("liuyanshi"));
				liuyan.setXuesheng_id(rs.getInt("xuesheng_id"));
				
				liuyan.setHuifu(rs.getString("huifu"));
				liuyan.setHuifushi(rs.getString("huifushi"));
				
				liuyan.setXuesheng(utilService.get_xuesheng(liuyan.getXuesheng_id()));
			
				liuyanList.add(liuyan);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("liuyanList", liuyanList);
		req.getRequestDispatcher("admin/liuyan/liuyanAll.jsp").forward(req, res);
	}
	
	public void liuyanDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		req.setAttribute("liuyan", get_liuyan(id));
		req.getRequestDispatcher("admin/liuyan/liuyanDetail.jsp").forward(req, res);
	}
	
	
	public TLiuyan get_liuyan(int id)
	{
		TLiuyan liuyan=new TLiuyan();
		
		String sql="select * from t_liuyan where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				liuyan.setId(rs.getInt("id"));
				liuyan.setNeirong(rs.getString("neirong"));
				liuyan.setLiuyanshi(rs.getString("liuyanshi"));
				liuyan.setXuesheng_id(rs.getInt("xuesheng_id"));
				
				liuyan.setHuifu(rs.getString("huifu"));
				liuyan.setHuifushi(rs.getString("huifushi"));
			
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return liuyan;
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
