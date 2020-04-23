package com.kauruck.Jars;

import java.util.ArrayList;

public class Pantry 
{
	private Jar[] jars;
	private int selected = 0;
	
	public Pantry(Jar[] jars)
	{
		this.jars = jars;
	}
	
	
	@Override
	public String toString()
	{
		String out = "";
		int i = 0;
		for(Jar c : jars)
		{
			i++;
			out += "Jar " + i + ": " + c + '\n';
		}
		return out;
	}
	
	public boolean selectJar(int index)
	{
		index--;
		if(index < jars.length && index >= 0)
			selected = index;
		else if(index >= jars.length)
			throw new ArrayIndexOutOfBoundsException("Index must be less than the amount of Jars on the Pantry!");
		else
			throw new ArrayIndexOutOfBoundsException("Index must be greater or equal to 1");
		return true;
	}
	
	public float spread(float amount)
	{
		float spreadedAmount = jars[selected].spread(amount);
		cleanup();	
		return spreadedAmount;
	}
	
	private void cleanup()
	{
		ArrayList<Jar> newJarsList = new ArrayList<Jar>();
		for(Jar c : jars)
		{
			if(!c.isEmpty())
				newJarsList.add(c);
		}
		Jar[] newJars = new Jar[newJarsList.size()];
		int i = 0;
		for(Jar c : newJarsList)
		{
			
			newJars[i] = c;
			i++;
		}
		
		jars = newJars;
	}
	
	public int length()
	{
		return jars.length;
	}
	
	public boolean replace(Jar newJar, int index)
	{
		index--;
		if(index < 0)
			throw new ArrayIndexOutOfBoundsException("Index must be greater or equal to 1");
		if(index >= jars.length)
			throw new ArrayIndexOutOfBoundsException("Index must be less than the amount of Jars on the Pantry!");
		jars[index] = newJar;
		return true;
	}
	
	public boolean mixedFruit()
	{
		boolean isMixable = false;
		float newAmount = 0.0f;
		Date newDate = Date.MAX_VALUE;
		String newContent = "";
		for(Jar c : jars)
		{
			if(c.getCapacity() <= 2.0f)
				isMixable = true;
			else
				isMixable = false;
			newAmount += c.getCapacity();
			if(c.getDate().lessThen(newDate))
				newDate = c.getDate();
			newContent += c.getContents() +  "/";
		}
		
		if(!isMixable)
			return false;
		
		jars = new Jar[1];
		jars[0] = new Jar(newContent.substring(0 ,newContent.length() - 1), newDate.toString(), newAmount);
		return true;
	}
}
