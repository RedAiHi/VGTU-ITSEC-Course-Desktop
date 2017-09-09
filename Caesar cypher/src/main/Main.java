package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//ArrayList<String> input = new ArrayList<>();
		ArrayList<String> abc = new ArrayList<>();
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
		System.out.println("Input your caesar algorythm modifier");
		enc = sc.nextInt();
		
		System.out.println("Thank you for your input! \nProcessing, please hold on for a moment... \n");
		input_Arr = raw_input.toCharArray();
		
		System.out.println("The input we got is: " + raw_input);
		System.out.println("Modifier: " + enc + "\nArray: ");
		for(char c : input_Arr)
		{
			int index = abc.indexOf(String.valueOf(c));
			System.out.println(c + " " + index);
			
			
			System.out.print("   |   " + "\n");
		}
			
		
		System.out.println("Finished!");
	}

}
