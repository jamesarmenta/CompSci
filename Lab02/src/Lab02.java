import java.util.Scanner;

/**
 * 
 */

/**
 * @author jarmenta
 *
 */
public class Lab02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Student Scores
		
		StudentScore studentList[] = new StudentScore[10];
		
		studentList[0] = new StudentScore("Bob", 51);
		studentList[1] = new StudentScore("Bill", 92);
		studentList[2] = new StudentScore("Tim", 74);
		studentList[3] = new StudentScore("Jon", 100);
		studentList[4] = new StudentScore("Kim", 100);
		studentList[5] = new StudentScore("Nicki", 40);
		studentList[6] = new StudentScore("Zeus", 60);
		studentList[7] = new StudentScore("Jessica", 98);
		studentList[8] = new StudentScore("Holly", 79);
		studentList[9] = new StudentScore("Cortana", 90);
		
		menuQuestion(studentList);
	}

	private static void menuQuestion(StudentScore list[]) {
		
		StudentScore[] studentList = list;
		
		Scanner input =  new Scanner(System.in);
		
/* MENU **************/
		
        // Criterion
		System.out.println("1 Add a student and a test score to the list of students / scores.");
		System.out.println("2 Find the score for a particular student.");
        System.out.println("3 Find the student with the maximum score");
        System.out.println("4 Find the student with the minimum score.");
        System.out.println("5 Display the students sorted by test score.");
        System.out.println("6 Delete a student.");
        System.out.println("7 Change a score for a particular student.");
        System.out.println("8 Quit");

        int menuAnswer = 0;
        boolean invalid1 = true;
        
        do{
        	System.out.println("Your Answer:");
        	try {
        		//Input from User
        		menuAnswer = input.nextInt();
        		//Re-prompt if not 1-8
        		if(menuAnswer<1 || menuAnswer>8) {
        			System.out.println("Invalid value! Please enter 1, 2, 3 or 4 for your answer.");
        		} else {
        			invalid1 = false;
        		}
            } 
        	//Re-Prompt If Wrong Type
            catch (Exception e)
                   {
     	   System.out.println("Invalid type! Please user numbers 1-4 for your answer.");
                       input.nextLine();   // Flush garbage from the line characters not Int
                   }
        }while(invalid1);
        
        if( menuAnswer == 1 ){System.out.println("Answer was 1");}
        if( menuAnswer == 2 ){										searchName(studentList);}
        if( menuAnswer == 3 ){System.out.println("Highest Score:"); findHighest(studentList);}
        if( menuAnswer == 4 ){System.out.println("Lowest Score:"); findLowest(studentList);}
        if( menuAnswer == 5 ){System.out.println("Sorted Scores:"); selectionSort(studentList);}
        if( menuAnswer == 6 ){System.out.println("Answer was 6");}
        if( menuAnswer == 7 ){System.out.println("Answer was 7");}
        if( menuAnswer == 8 ){System.out.println("Goodbye!");}

   }

	public static void searchName(StudentScore list[]){
	{
		Scanner input =  new Scanner(System.in);
		System.out.println("Input Name:");
		String desiredName = input.nextLine();
		
		System.out.println("Result:");
		
		boolean found = false;
	    for (int i = 0; i < list.length; i++)
	    {
	    	if ( list[i].getName().equals(desiredName) ) //.searchName(desiredName)) == 1 )
	    	{
	    	   System.out.println(list[i].toString()); //found it!
	    	   found = true;
	           break;
	    	}
	    }
	      
	    if (!found)
	    {
	    	System.out.println("Name not found!");
	    }
	    System.out.println();
	    main(null);
	}
	}
	      
	
	private static void findHighest(Comparable list[]) 
	{
		int max = 0;
		for (int pass = 0; pass < list.length; pass++){
			for (int i = 1; i < list.length - pass; i++){
				if (list[i].compareTo(list[max]) > 0){
					max = i;
				}
			}
		}
		System.out.println(list[max].toString());
		System.out.println();
		main(null);
	}
	
	private static void findLowest(Comparable list[]) 
	{
		int max = 0;
		for (int pass = 0; pass < list.length; pass++){
			for (int i = 1; i < list.length - pass; i++){
				if (list[i].compareTo(list[max]) < 0){
					max = i;
				}
			}
		}
		System.out.println(list[max].toString());
		System.out.println();
		main(null);
	}
	
	public static void selectionSort(Comparable list[]){
		int indexToSwap = list.length - 1;
		for (int pass=0; pass < list.length-1; pass++){
			int max = 0;
			for (int i = 1; i < list.length - pass; i++){
				if (list[i].compareTo(list[max]) > 0){
					max = i;
				}
			}
		
			Comparable temp = list[max];
			list[max] =  list[indexToSwap];
			list[indexToSwap] = temp;
			indexToSwap--;
		}
		displayList(list);
		System.out.println("");
		main(null);
	}
	
	public static void displayList(Object list[]){
		for (int i=0; i<list.length; i++){
			System.out.println(list[i].toString());
		}
	}
}
