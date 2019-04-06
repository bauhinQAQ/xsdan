package model;

public class Tjiangcheng
{
	private int id;
	private int xuesheng_id;
	private String shijian;
	private String shuxing;
	
	private String beizhu;
	
	private Txuesheng xuesheng;

	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public String getShuxing()
	{
		return shuxing;
	}

	public void setShuxing(String shuxing)
	{
		this.shuxing = shuxing;
	}

	public Txuesheng getXuesheng()
	{
		return xuesheng;
	}

	public void setXuesheng(Txuesheng xuesheng)
	{
		this.xuesheng = xuesheng;
	}

	public int getXuesheng_id()
	{
		return xuesheng_id;
	}

	public void setXuesheng_id(int xuesheng_id)
	{
		this.xuesheng_id = xuesheng_id;
	}

	
}
