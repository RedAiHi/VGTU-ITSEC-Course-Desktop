import java.util.Scanner;

public class Main 
{	
	//AUTHOR LT: Kšyštof Dunovski (ITSfmu-17)
	//AUTHOR EN: Ksystof Dunovski (ITSfmu-17)
	
	public static void main(String[] args)
	{
		//Initialize input storage variables
		String word_to_encode;
		String keyword;
		String[][] arr = new String [5][];
		for(int i=0;i<5;i++)
			arr[i] = new String[5];	
		
		//Initialize additional variables
		Scanner sc = new Scanner(System.in);
		
		//What input is expected? only keyword and what to encode? or the whole array?
		System.out.println("Input your keyword for Playfair cypher");
		keyword = sc.nextLine();
		System.out.println("Input your word you want to encode");
		word_to_encode = sc.nextLine();
		sc.close();
		
		//Outputting the variables
		//MAINLY TESTING
		System.out.println("Keyword: " + keyword);
		System.out.println("What to encode: " + word_to_encode);
	}
}