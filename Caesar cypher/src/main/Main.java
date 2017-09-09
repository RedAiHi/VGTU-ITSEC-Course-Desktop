package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		ArrayList<String> abc = new ArrayList<>();
		ArrayList<String> rezult = new ArrayList<>();
		int enc = 0;
		
		String raw_input;
		Scanner sc = new Scanner(System.in);
		char[] input_Arr;
		
		//Initializing alphabet array
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (char c : alphabet)
		{
			abc.add(String.valueOf(c));
		}
		
		System.out.println("Input your string, which you wish to encode with Caesar algorythm");
		raw_input = sc.nextLine();
		System.out.println("Input your modifier (any integer)");
		enc = sc.nextInt();
		sc.close();
		
		System.out.println("Thank you for your input! \nProcessing, please hold on for a moment... \n");
		input_Arr = raw_input.toCharArray();
		
		System.out.println("The input we got is: " + raw_input);
		//System.out.println("Modifier: " + enc + "\nArray: ");
		for(char c : input_Arr)
		{
			int index = abc.indexOf(String.valueOf(c));
			//System.out.println(c + " " + index);
			
			try
			{
				index = index + enc;
				abc.get(index);
			}
			catch(IndexOutOfBoundsException e)
			{
				index = index - abc.size();
			}
			
			//System.out.print(c + "   |   " + abc.get(index) + "\n");
			if(index >= 0)
			{
				rezult.add(abc.get(index));
			}
			else
			{
				rezult.add(" ");
			}
		}
		
		System.out.println("Result:");
		
		for(String s : rezult)
		{
			System.out.print(s);
		}
		System.out.println("\nFinished!");
	}

}
