/**
 * 
 */
package DAVIS_Selenium_Week2_Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class DAVIS_Selenium_Week2_Scanner implements DAVIS_Selenium_IWeek2_Scanner{
	/**
	 * 1 Write a Java program to print Hello and your name.
	 */ 
	@Override
	public void Hello(Scanner reader) {
	    System.out.println("-----------------------------------------------------");
		System.out.println("1 Write a Java program to print Hello and your name.");
	    System.out.println("-----------------------------------------------------");
		System.out.print("Please enter your name : ");
        // String input
        String username = reader.nextLine();
	    System.out.println(String.format("Hello %s", username));
	    System.out.println();
	}
	/**
	 * 2 Write an if condition where "a" is equal to 1.
	 */ 
	@Override
	public void IsEqualTo(Scanner reader) {
	    System.out.println("-----------------------------------------------------");
	    System.out.println("2 Write an if condition where \"a\" is equal to 1.");
	    System.out.println("-----------------------------------------------------");
		int a = 0;
		int number;
		do {
		    System.out.print("Please enter a positive number!");
		    while (!reader.hasNextInt()) {
		        System.out.println("Not a number, try again.");
		        reader.next(); // this is important!
		    }
		    number = reader.nextInt();
		} while (number <= 0);
		a = number;
	    if (a == 1) {
	    	System.out.println("a is equal to 1.");
	    } else { System.out.println("a is Not equal to 1.");}
	}
	/**
	 * 3. Write a java program to print the sum of two numbers. 
	 */
	@Override
	public void SumOfTwoNumbers(Scanner reader) {
	    System.out.println("---------------------------------------------------------");
	    System.out.println("3. Write a java program to print the sum of two numbers. ");
	    System.out.println("---------------------------------------------------------");
	    System.out.print("Please enter a integer to add with next integer prompt: ");
	    
		int firstInteger;
		do {
		    System.out.println("Please enter a positive number!");
		    while (!reader.hasNextInt()) {
		        System.out.println("Not a number, try again.");
		        reader.next(); 
		    }
		    firstInteger = reader.nextInt();
		} while (firstInteger < 0);		
		int secondInteger;
		do {
		    System.out.println("Please enter a positive number!");
		    while (!reader.hasNextInt()) {
		        System.out.println("Not a number, try again.");
		        reader.next(); 
		    }
		    secondInteger = reader.nextInt();
		} while (secondInteger < 0);
	    System.out.println();
	    System.out.print("The sum of " + firstInteger + " and " +  secondInteger + " is " + Long.toString(SumTwoNumbers(firstInteger,secondInteger)));
	    System.out.println();
	}
	/**
	 * 4. How can you store "Hello World" value in a String variable.
	 * Declare a variable as a string and then assign the variable the value "Hello World"
	 */
	@Override
	public void HelloWorld(Scanner reader) {
	    System.out.println("-----------------------------------------------------------------");
	    System.out.println("4. How can you store \"Hello World\" value in a String variable.");
	    System.out.println("-----------------------------------------------------------------");
	    System.out.println("Declare a variable as a string and then assign the variable the value \"Hello World\"");
	    String hellowWorld = "Hello World";
	    System.out.println(hellowWorld);
	    System.out.println();
	}
	/**
	* 5. Write a Java program to print the output of multiplication of three numbers which will be entered by the user.
	*/
	@Override
	public void MulitplicationOfThreeNumbers(Scanner reader) {
	    System.out.println("-----------------------------------------------------------------");
	    System.out.println("5. Write a Java program to print the output of multiplication ");
	    System.out.println("    three numbers which will be entered by the user.");
	    System.out.println("-----------------------------------------------------------------");
	    
	    
	    List<String> multipliersPrompts = new ArrayList<>(); 
        multipliersPrompts.add("Please enter first of 3 integers to multiply with the next integer prompt:");        
        multipliersPrompts.add("Please enter second of 3 integers to multiply with the prior integer entered:"); 
        multipliersPrompts.add("Please enter third of 3 integers to multiply with the prior integers entered:"); 
        
		/*
		 * multipliersPrompts.
		 * add("Please enter first of 3 integers to multiply with the next integer prompt:"
		 * ); multipliersPrompts.
		 * add("Please enter second of 3 integers to multiply with the prior integer entered:"
		 * ); multipliersPrompts.
		 * add("Please enter third of 3 integers to multiply with the prior integers entered:"
		 * );
		 * 
		 * multipliersPrompts.
		 * add("Please enter first of 3 integers to multiply with the next integer prompt:"
		 * ); multipliersPrompts.
		 * add("Please enter second of 3 integers to multiply with the prior integer entered:"
		 * ); multipliersPrompts.
		 * add("Please enter third of 3 integers to multiply with the prior integers entered:"
		 * );
		 */
        
        List<Integer> userInputNumbers = new ArrayList<>(); 
        
        Iterator<String> i = multipliersPrompts.iterator(); 
        while (i.hasNext()) { 
        	System.out.println(i.next());
    		int nextInteger = 0;
    		    while (!reader.hasNextInt()) {
    		        System.out.println("Not a number, try again.");
    		        // System.out.println("Invalid number, It might be to big: max value is  2,147,483,647" + nextInteger); 
    		        reader.next(); // this is important!
    		    }
    		    nextInteger = reader.nextInt();
    	    userInputNumbers.add(nextInteger);
        } 
        long product = 0;
        product  = multiplyListValues(userInputNumbers);  
        
        StringBuilder summary = new StringBuilder();
     
        for (int num : userInputNumbers) {
        	if (summary.length()==0 ) { 
        		summary.append("The product of ");
        		summary.append(num) ;
        		}
        	else {  
        		summary.append(" * ");
        		summary.append(num) ;
        		}
        }
        
        summary.append( " is " ) ;
        summary.append(product);
        System.out.println(summary);
        
        
	}
	
    public static int multiplyListValues(List<Integer> list) {
        int product = 1;       
        for (int num : list) {
            product *= num;
        }
        return product;
    }
	private static long SumTwoNumbers(int a, int b) { return a + b; }
}
