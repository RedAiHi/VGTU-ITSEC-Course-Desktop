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
		ArrayList<String> result = new ArrayList<>();
		
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
		
		//Encoding the message
		for(ArrayList<String> list : input_arr)
		{
			result.add(encode(list, table_arr));
		}
		
		//Printing final result
		for(String s : result)
		{
			System.out.print(s);
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	//********************************************************************************************//
	//**************************************Custom Functions**************************************//
	//********************************************************************************************//
	////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	//Finds the coordinates of the given string in the 5x5 matrix
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
	
	//Encodes the pair of letters and gives back the encoded variant of the pair
	private static String encode(ArrayList<String> list, String[][] table_arr)
	{
		String res = "";
		int[] yx1, yx2; 
		yx1 = find_x_y_of(list.get(0), table_arr);
		yx2 = find_x_y_of(list.get(1), table_arr);
		
		int i1 = yx1[0];
		int j1 = yx1[1];
		int i2 = yx2[0];
		int j2 = yx2[1];
		
		//If same column
		if(j1 == j2)
		{
			try
			{
				res = table_arr[i1+1][j1] + table_arr[i2+1][j2];
				return res;
			}
			//If end of table, wrap around
			catch(IndexOutOfBoundsException e)
			{
				if(i1>5)
					i1-=5;
				else
					i2-=5;
				
				res = table_arr[i1+1][j1] + table_arr[i2+1][j2];
				return res;
			}
		}
		else
		{
			//If same row
			if(i1 == i2)
			{
				try
				{
					res = table_arr[i1][j1+1] + table_arr[i2][j2+1];
					return res;
				}
				//If end of table, wrap around
				catch(IndexOutOfBoundsException e)
				{
					if(j1>5)
						j1-=5;
					else
						j2-=5;
					
					res = table_arr[i1][j1+1] + table_arr[i2][j2+1];
					return res;
				}
			}
			else
			{
				//If rectangle
				try
				{
					res = table_arr[i1][j2] + table_arr[i2][j1];
					return res;
				}
				//If end of table, wrap around
				//Should be impossible
				catch(IndexOutOfBoundsException e)
				{
					System.out.println("ERROR:Did not fit any rule. Letter combination:" + list.get(0) + list.get(1));
				}
			}	
		}
		return null;
	}
	
}