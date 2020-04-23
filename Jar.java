package com.kauruck.Jars;

public class Jar 
{
	private String contents;
	private Date date;
	private float capacity;
	
	public Jar(String contents, String date, float capacity)
	{
		this.capacity = capacity;
		this.contents = contents;
		String[] splited = date.split("/");
		this.date = new Date(Integer.parseInt(splited[2]),Integer.parseInt(splited[1]),Integer.parseInt(splited[0]));
	}
	
	public float getCapacity()
	{
		return capacity;
	}
	
	public String getContents()
	{
		return contents;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public boolean isEmpty()
	{
		return capacity <= 0.0f;
	}
	
	public float spread(float amount)
	{
		if(!isEmpty())
		{
			if(amount <= capacity)
			{
				System.out.println("Spreading " + amount + " fluid ounces of " + contents);
				capacity -= amount;
				return amount;
			}
			else
			{
				float spreading = capacity;
				System.out.println("Spreading " + spreading + "fluid ounces of " + contents);
				capacity = 0.0f;
				return spreading;
			}
		}
		else
		{
			System.out.println("Jar is empty!");
			return 0.0f;
		}
	}
	
	@Override
	public String toString()
	{
		return contents + "   " + date + "   " + capacity + " fl. oz";
	}
}
