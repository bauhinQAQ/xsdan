package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import model.Tkecheng;
import model.Txuesheng;

public class utilService
{
	public static Tkecheng get_kecheng(int id)
	{
		Tkecheng kecheng=new Tkecheng();
		String sql="select * from t_kecheng where del='no' and id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kecheng.setId(rs.getInt("id"));
				kecheng.setMingcheng(rs.getString("mingcheng"));
				kecheng.setDel(rs.getString("del"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return kecheng;
	}
	
	
	
	public static Txuesheng get_xuesheng(int id)
	{
		Txuesheng xuesheng=new Txuesheng();
		String sql="select * from t_xuesheng where del='no' and id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				xuesheng.setId(rs.getInt("id"));
				xuesheng.setXuehao(rs.getString("xuehao"));
				xuesheng.setXingming(rs.getString("xingming"));
				
				xuesheng.setXingbie(rs.getString("xingbie"));
				xuesheng.setNianling(rs.getString("nianling"));
				xuesheng.setLoginpw(rs.getString("loginpw"));
				xuesheng.setDel(rs.getString("del"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return xuesheng;
	}
	
	
	
	
}
