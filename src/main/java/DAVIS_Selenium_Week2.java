/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week2.java
 * Author: David Davis
 * Date: March 19, 2025
 */

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import DAVIS_Selenium_IWeek2_Buffer.*;
import DAVIS_Selenium_Week2_Scanner.*;

/** 
 * I chose to make some of the answers more complex to learn the language.
 */
public class DAVIS_Selenium_Week2 {
	public static void main(String[] args) throws IOException {
 
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//DAVIS_Selenium_IWeek2_Buffer week2Buffer = new DAVIS_Selenium_Week2_Buffer();
		
		Scanner sc = new Scanner(System.in);
		DAVIS_Selenium_IWeek2_Scanner week2Scanner = new DAVIS_Selenium_Week2_Scanner();
		/**
		 * 1 Write a Java program to print Hello and your name.
		 */
		//week2Buffer.Hello(reader);
		week2Scanner.Hello(sc);
		/**
		 * 2 Write an if condition where "a" is equal to 1.
		 */ 
		//week2Buffer.IsEqualTo(reader);
		week2Scanner.IsEqualTo(sc);
		/**
		 * 3. Write a java program to print the sum of two numbers. 
		 */
		//week2Buffer.SumOfTwoNumbers(reader);
		week2Scanner.SumOfTwoNumbers(sc);
		/**
		 * 4. How can you store "Hello World" value in a String variable.
		 * Declare a variable as a string and then assign the variable the value "Hello World"
		 */
		//week2Buffer.HelloWorld(reader);
		week2Scanner.HelloWorld(sc);
		/**
	     * 5. Write a Java program to print the output of multiplication of three numbers which will be entered by the user.
	     */
		//week2Buffer.MulitplicationOfThreeNumbers(reader);
		week2Scanner.MulitplicationOfThreeNumbers(sc);
		sc.close();
	}
}
