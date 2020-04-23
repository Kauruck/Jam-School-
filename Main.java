package com.kauruck.Jars;

import java.util.Scanner;

public class Main 
{
	public static Pantry pantry;
	
	public static boolean running = true;
	
	public static void main(String[] args)
	{
		Jar[] jars = {new Jar("Gooseberry", "7/4/86", 12f), new Jar("Carb Apple", "9/30/99", 8f), new Jar("Rhubarb", "9/30/99", 16f)};
		pantry  = new Pantry(jars);
		System.out.println("Welcome to Mother Hubbard's Pantry! \n");
		Scanner s = new Scanner(System.in);
		
		System.out.print("The jams are: \n" + pantry);
		
		while(running)
		{
			System.out.println("\nEnter your selection (1 to " + pantry.length() + ") type " + (pantry.length() + 1) + " to mix, type -1 to exit");
			int selected = s.nextInt();
			if(selected == -1)
			{
				running = false;
				continue;
			}
			if(selected == pantry.length() + 1)
			{
				System.out.println(pantry.mixedFruit() ? "Succsessfuly mixed the fruits" : "Cound not mix the fruits");
				System.out.print("The jams are: \n" + pantry);
				continue;
			}
			pantry.selectJar(selected);
			System.out.println("Enter amount to spread");
			float amount = s.nextFloat();
			pantry.spread(amount);
			System.out.print("The jams are: \n" + pantry);
		}
		System.out.println("God by");
		s.close();
	}
}
