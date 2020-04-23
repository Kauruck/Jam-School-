package com.kauruck.Jars;

public class Date 
{
	public static final Date MIN_VALUE = new Date(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
	public static final Date MAX_VALUE = new Date(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	
	int year;
	int month;
	int day;
	
	public Date(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public String toString()
	{
		return day + "/" + month + "/" + year;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == this)
			return true;
		
		if(!(o instanceof Date))
			return false;
			
		Date com = (Date) o;
		
		if(com.day == this.day && com.month == this.month && com.year == this.year)
			return true;
		
		return false;
	}
	
	public boolean greaterThen(Object o)
	{
		if(o == this)
			return true;
		
		if(!(o instanceof Date))
			return false;
			
		Date com = (Date) o;
		
		if(com.day < this.day && com.month < this.month && com.year < this.year)
			return true;
		
		return false;
	}
	
	public boolean lessThen(Object o)
	{
		if(o == this)
			return true;
		
		if(!(o instanceof Date))
			return false;
			
		Date com = (Date) o;
		
		if(com.day > this.day && com.month > this.month && com.year > this.year)
			return true;
		
		return false;
	}
}
