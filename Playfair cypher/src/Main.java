import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{	
	//AUTHOR LT: Kšyštof Dunovski (ITSfmu-17)
	//AUTHOR EN: Ksystof Dunovski (ITSfmu-17)
	
	public static void main(String[] args)
	{
		//Initialize input storage variables
		String word_to_encode;
		char[] alphabet = "abcdefghiklmnopqrstuvwxyz".toCharArray();//ignoring j, as per task instructions
		String[][] table_arr = new String [5][];
		ArrayList<ArrayList<String>> input_arr = new ArrayList<>();
		
		//Initializing the 5x5 array
		for(int i=0;i<5;i++)
			table_arr[i] = new String[5];
		
		for(int i = 0; i<5; i++)
			for(int j=0; j<5; j++)
			{
				//Filling the initial array with the default matrix
				table_arr[i][j] = String.valueOf(alphabet[i*5 + j]);
			}
		//Initialize additional variables
		Scanner sc = new Scanner(System.in);
		
		//Reading input variables
		System.out.println("Input your word you want to encode");
		word_to_encode = sc.nextLine();
		sc.close();
		
		//Outputting the variables
		System.out.println("What to encode: " + word_to_encode);
		
		//Checking if the matrix was correctly assigned
		System.out.println("\nThe 5x5 matrix:");
				for(int i=0; i<5; i++)
				{
					for(int j=0; j<5; j++)
					{
						System.out.print(table_arr[i][j] + "   ");
					}
					System.out.print("\n");
				}
		
		//Splitting the word, in order to prepare for use in the encoding array
		prepare_word(word_to_encode, input_arr);
		
		//Check if the word was split correctly
		System.out.println("\nThe word after beig split inot pairs:");
		for(ArrayList<String> list : input_arr)
		{
			System.out.print(list.get(0) + list.get(1) + "   ");
		}
		System.out.println();
		
		for(ArrayList<String> list : input_arr)
		{
			//System.out.print(list.get(0) + list.get(1) + "   ");
			//int x1=-1, x2=-1, y1=-1, y2=-1;
			int[] yx1, yx2; 
			
			yx1 = find_x_y_of(list.get(0), table_arr);
			yx2 = find_x_y_of(list.get(1), table_arr);
			
			System.out.print(list.get(0) + list.get(1) + "   " + 
			"\n(" + yx1[0] + ";" + yx1[1] + ")" + "   " + "(" + yx2[0] + ";" + yx2[1] + ")\n");
		}
		
		
//		for(String[] s_y : arr)
//		{
//			for(String s_x : s_y)
//			{
//				System.out.print(s_x + "   ");
//			}
//			System.out.print("\n");
//		}
		
//		System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
//		System.out.println("Old VERSION:");
//		System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
	}
	
	//Splits the word into an array of pairs according to the Playfair Cypher rules
	private static void prepare_word(String word_to_encode, ArrayList<ArrayList<String>> arr)
	{
		word_to_encode = word_to_encode.toUpperCase();
		word_to_encode = word_to_encode.replaceAll("\\s+", "");
		char[] word_arr_temp = word_to_encode.toCharArray();
		
		for(int i = 0; i<word_arr_temp.length; i++)
		{
			ArrayList<String> str = new ArrayList<>();
			String current_char = String.valueOf(word_arr_temp[i]);
			str.add(current_char);
			
			try
			{
				String next_char = String.valueOf(word_arr_temp[i+1]);
				if(next_char.equals(current_char))
				{
					str.add("X");
				}
				else
				{
					str.add(next_char);
					i++;
				}
			}
			//If the last letter doesnt have a pair, add X at the end
			catch (IndexOutOfBoundsException e)
			{
				str.add("X");
			}
			arr.add(str);
		}
	}
	
	private static int[] find_x_y_of(String target, String[][] source)
	{
		int[] x_y = new int[2];
		for(int i = 0; i<5; i++)
		{
			for(int j = 0; j<5; j++)
			{
				if(source[i][j].toUpperCase().equals(target))
				{
					x_y[0] = i;
					x_y[1] = j;
					return x_y;
				}
			}
		}
		System.out.println("Was Unable to find coordinates of \"" + target + "\"");
		return null;
	}
}
