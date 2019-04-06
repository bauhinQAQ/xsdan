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

import model.Tchengji;
import model.Txuesheng;

public class chengji_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("chengjiAdd"))
		{
			chengjiAdd(req, res);
		}
		if(type.endsWith("chengjiMana"))
		{
			chengjiMana(req, res);
		}
		if(type.endsWith("chengjiDel"))
		{
			chengjiDel(req, res);
		}
		
		if(type.endsWith("chengjiMine"))
		{
			chengjiMine(req, res);
		}
		
	}
	
	public void chengjiAdd(HttpServletRequest req,HttpServletResponse res)
	{
		int xuesheng_id=Integer.parseInt(req.getParameter("xuesheng_id"));
		int kecheng_id=Integer.parseInt(req.getParameter("kecheng_id"));
		int fenshu=Integer.parseInt(req.getParameter("fenshu"));
		String shijian=req.getParameter("shijian");
		
		String sql="insert into t_chengji(xuesheng_id,kecheng_id,fenshu,shijian) values(?,?,?,?)";
		Object[] params={xuesheng_id,kecheng_id,fenshu,shijian};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "�����ɹ�");
		req.setAttribute("path", "chengji?type=chengjiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void chengjiMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chengjiList=new ArrayList();
		String sql="select * from t_chengji";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchengji chengji=new Tchengji();
				
				chengji.setId(rs.getInt("id"));
				chengji.setXuesheng_id(rs.getInt("xuesheng_id"));
				chengji.setKecheng_id(rs.getInt("kecheng_id"));
				chengji.setFenshu(rs.getInt("fenshu"));
				chengji.setShijian(rs.getString("shijian"));
				
				chengji.setXuesheng(utilService.get_xuesheng(rs.getInt("xuesheng_id")));
				chengji.setKecheng(utilService.get_kecheng(rs.getInt("kecheng_id")));
								
				chengjiList.add(chengji);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chengjiList", chengjiList);
		req.getRequestDispatcher("admin/chengji/chengjiMana.jsp").forward(req, res);
	}
	
	
	public void chengjiDel(HttpServletRequest req,HttpServletResponse res)
	{
		
		String sql="delete from t_chengji where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "�����ɹ�");
		req.setAttribute("path", "chengji?type=chengjiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	
	public void chengjiMine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Txuesheng xuesheng=(Txuesheng)req.getSession().getAttribute("xuesheng");
		
		List chengjiList=new ArrayList();
		String sql="select * from t_chengji where xuesheng_id=?";
		Object[] params={xuesheng.getId()};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchengji chengji=new Tchengji();
				
				chengji.setId(rs.getInt("id"));
				chengji.setXuesheng_id(rs.getInt("xuesheng_id"));
				chengji.setKecheng_id(rs.getInt("kecheng_id"));
				chengji.setFenshu(rs.getInt("fenshu"));
				chengji.setShijian(rs.getString("shijian"));
				
				chengji.setXuesheng(utilService.get_xuesheng(rs.getInt("xuesheng_id")));
				chengji.setKecheng(utilService.get_kecheng(rs.getInt("kecheng_id")));
								
				chengjiList.add(chengji);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chengjiList", chengjiList);
		req.getRequestDispatcher("admin/chengji/chengjiMine.jsp").forward(req, res);
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
