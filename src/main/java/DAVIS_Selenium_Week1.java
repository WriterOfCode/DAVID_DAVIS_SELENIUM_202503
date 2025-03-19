/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week1.java
 * Author: David Davis
 * Date: March 14, 2025
 */
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * 
 */
public class DAVIS_Selenium_Week1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
	    // ====
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter user name : ");
	    String username = null;
	    try {
	        username = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + username);

	    // ===== In Java 5, Java.util,Scanner is used for this purpose.
	    Scanner in = new Scanner(System.in);
	    System.out.print("Please enter user name : ");
	    username = in.nextLine();      
	    System.out.println("You entered : " + username);
	    in.close();

	    // ====== Java 6
	    Console console = System.console();
	    username = console.readLine("Please enter user name : ");   
	    System.out.println("You entered : " + username);
	}

}
