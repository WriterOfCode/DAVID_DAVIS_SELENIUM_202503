/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week2.java
 * Author: David Davis
 * Date: March 19, 2025
 */

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 
import java.util.function.Consumer; 


/**
 * I chose to make some of the answers more complex to learn the language.
 */
public class DAVIS_Selenium_Week2 {
	public static void main(String[] args) throws IOException {
 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
		/**
		 * 1 Write a Java program to print Hello and your name.
		 */ 
	    System.out.println("---------------------------");
		System.out.println("1 Write a Java program to print Hello and your name.");
		System.out.println();
		System.out.print("Please enter your name : ");
		String username = null;
	    try {
	        username = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println(String.format("Hello %s", username));
	    System.out.println();
	    
		/**
		 * 2 Write an if condition where "a" is equal to 1.
		 */ 
	    System.out.println("2 Write an if condition where \"a\" is equal to 1.");
	    System.out.println();
	    System.out.print("Please enter a integer: ");
		String numberString = null;
	    try {
	    
    		numberString = reader.readLine();
			try {
			    int a = Integer.parseInt(numberString);
			    if (a == 1) {
			    	System.out.println("a is equal to 1.");
			    } else { System.out.println("a is Not equal to 1.");}
			    
			} catch (NumberFormatException e) {
			    System.out.println("Invalid number format: " + numberString);
			}
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println();
	    
		/**
		 * 3. Write a java program to print the sum of two numbers. 
		 */
	    System.out.println("---------------------------");
	    System.out.println("3. Write a java program to print the sum of two numbers. ");
	    System.out.println();
	    System.out.print("Please enter a integer to add with next integer prompt: ");	
	    String firstNumberString = null;
		try {
			firstNumberString = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int firstInteger = 0;
	    try {
	        firstInteger = Integer.parseInt(firstNumberString);	    
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid number format: " + firstNumberString);
	    }
	    System.out.println();
	    System.out.print("Please enter a integer to add with the first integer prompt: ");
	    String secondNumberString = null;
		try { 
			secondNumberString = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int secondInteger = 0;
	    try {
	    	secondInteger = Integer.parseInt(secondNumberString);	    
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid number format: " + secondNumberString);
	    } 
	    System.out.println();
	    System.out.print("The sum of " + firstInteger + " and " +  secondInteger + " is " + Long.toString(SumTwoNumbers(firstInteger,secondInteger)));
	    System.out.println();
	    System.out.println();
		/**
		 * 4. How can you store "Hello World" value in a String variable.
		 * Declare a variable as a string and then assign the variable the value "Hello World"
		 */
	    System.out.println("---------------------------");
	    System.out.println("4. How can you store \"Hello World\" value in a String variable.");
	    System.out.println();
	    System.out.println("Declare a variable as a string and then assign the variable the value \"Hello World\"");
	    String hellowWorld = "Hello World";
	    System.out.println(hellowWorld);
	    System.out.println();
	    
	    /**
	     * 5. Write a Java program to print the output of multiplication of three numbers which will be entered by the user.
	     */
	    System.out.println("---------------------------");
	    System.out.println("5. Write a Java program to print the output of multiplication of three numbers which will be entered by the user.");
	    System.out.println();
	    List<String> multipliersPrompts = new ArrayList<>(); 
        multipliersPrompts.add("Please enter first of 3 integer to multiply with the next integer prompt:");        
        multipliersPrompts.add("Please enter second of 3 integer to multiply with the next integer prompt:"); 
        multipliersPrompts.add("Please enter third of 3 integer to multiply with the next integer prompt:"); 
        
        List<Integer> Multipliers = new ArrayList<>(); 
        Iterator<String> i = multipliersPrompts.iterator(); 
        while (i.hasNext()) { 
            System.out.print(i.next()); 
       
		    String inputValue = null;
			try { 
				inputValue = reader.readLine();
				System.out.println();
			    try {
			    	int inputValueInt = Integer.parseInt(inputValue);
			        Multipliers.add(inputValueInt);
			    } catch (NumberFormatException e) {
			    	 System.out.println(e.getMessage());
			        System.out.println("Invalid number, It might be to big: max value is  2,147,483,647" + inputValue); 
			    }
			} catch (IOException e) {
				e.printStackTrace();
			}
        } 


	    long product = MultiplyThreeNumbers(Multipliers.get(0), Multipliers.get(1),Multipliers.get(2));
	    System.out.println("The product of " + String.valueOf(Multipliers.get(0)) + " * " + String.valueOf(Multipliers.get(1)) + " * " +  String.valueOf(Multipliers.get(2)) + " = " +  String.valueOf(product));
        System.exit(0);
	}
	
 
	private static long MultiplyThreeNumbers(int a, int b, int c) { return (a * b * c);}
	
	private static long SumTwoNumbers(int a, int b) { return a + b; }

}
