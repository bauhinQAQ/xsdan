package model;

public class Tchengji
{
	private int id;
	private int xuesheng_id;
	private int kecheng_id;
	private int fenshu;
	private String shijian;
	
	private Txuesheng xuesheng;
	private Tkecheng kecheng;
	
	
	public int getFenshu()
	{
		return fenshu;
	}
	public void setFenshu(int fenshu)
	{
		this.fenshu = fenshu;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getKecheng_id()
	{
		return kecheng_id;
	}
	public void setKecheng_id(int kecheng_id)
	{
		this.kecheng_id = kecheng_id;
	}
	public String getShijian()
	{
		return shijian;
	}
	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}
	public int getXuesheng_id()
	{
		return xuesheng_id;
	}
	
	public Tkecheng getKecheng()
	{
		return kecheng;
	}
	public void setKecheng(Tkecheng kecheng)
	{
		this.kecheng = kecheng;
	}
	public Txuesheng getXuesheng()
	{
		return xuesheng;
	}
	public void setXuesheng(Txuesheng xuesheng)
	{
		this.xuesheng = xuesheng;
	}
	public void setXuesheng_id(int xuesheng_id)
	{
		this.xuesheng_id = xuesheng_id;
	}
	
}
