package App2;

import Base.BaseTestNG;
import Core.UserDto;
import Pages.NewtoursLoginPage;
import Pages.NewToursTestNgPage;
import Pages.RegisterSucessPage;
import Pages.RegisterPage;
import Utils.ConfigReader;
import Utils.ElementUtils; 
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.openqa.selenium.By; 
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DAVIS_Selenium_TestNg_App extends BaseTestNG{
  @Test(dataProvider = "dp",description ="Validate New Tours Page")
  public void validateNewToursHomeAndLogin(Integer n, UserDto s) {
      NewToursTestNgPage page4 = new NewToursTestNgPage(webdriver);

      // Open homepage
      page4.open();
       
      assertTrue(page4.getTitle().contains("Welcome: Mercury Tours"),
      "Title does not contain expected text.");
   
      //login
      takeSchreenshot("validateToursLogin");
      page4.populateLogin(s.getUsername(),s.getPassword());
      takeSchreenshot("validateToursLogin");

      super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
      page4.clickOnSubmitButton(); 
      takeSchreenshot("validateToursLogin");
      
      // Verify the page title co
      assertTrue(page4.getTitle().contains("Login: Mercury Tours"),
             "Title does not contain expected text.");
      
      // Verify login success message
       assertTrue(ElementUtils.isElementPresent(webdriver, 
          By.xpath("//h3[text()='Login Successfully']")),
          "Title does not contain expected text.");

      takeSchreenshot("validateToursLogin");
  }
 
	 @Test(dataProvider = "UsersFromJsonFile", description ="Validate Register Page")
	public void validateRegisterPage(UserDto UserInfo){ 
	    RegisterPage register_page = new RegisterPage(webdriver);   
	    RegisterSucessPage sucess_page = new RegisterSucessPage(webdriver);  
	    NewtoursLoginPage login_page = new NewtoursLoginPage(webdriver);
	    
 
	    // -----------------------------
	    //newtours register page
	     // -----------------------------
	    // Open the regiser page
	    register_page.Open();
	    //are we on the right page
	    assertTrue(register_page.getTitle().contains("Register: Mercury Tours"),
	    "Title does not contain expected text.");
	    //take picutre before any changes
	    takeSchreenshot("validateRegisterPageNGTest");
	    //fill out the form
	    register_page.PopulateFormUserInformaion(UserInfo);
	    //take picutre of form filled out
	    takeSchreenshot("validateRegisterPageNGTest");
	    //wait for the submit button to be clickable. Assuming that the button would be 
	    //defined not to allow someone to click on it untill the form is correctly filled out. 
	    // If not you should raise and coner at the next meeting if we are in scrum then the int next scrum meeting.
	    super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
	    takeSchreenshot("validateRegisterPageNGTest");
	    // submit the register form
	    register_page.clickOnSubmitButton(); 
	    // -----------------------------
	    // navigate away form register page.
	    // -----------------------------
	    // this could be a long wait
	    // A website page should ideally load in two seconds or less. 
	    // This timeframe is considered fast for a positive user experience and can impact SEO.
	    
	    // -----------------------------
	    // navigated to Register Sucess page
	    // -----------------------------
	    takeSchreenshot("validateRegisterPageNGTest");
	    // Verify the page title so we know we are on the right page.
	    assertTrue( sucess_page.getTitle().contains("Register: Mercury Tours"),
	           "Title does not contain expected text.");
	    assertTrue( sucess_page.getUserName().contains(UserInfo.getUsername()),
	    "Title does not contain expected text.");
	    sucess_page.clickOnSignInLinkElement();
	    // -----------------------------
	    // navigate away form Register Sucess page
	    // -----------------------------
	    // -----------------------------
	    // navigated to Register Sucess page
	    // -----------------------------
	    takeSchreenshot("validateRegisterPageNGTest");
	    assertTrue( login_page.getTitle().contains("Sign-on: Mercury Tours"),
	    "Title does not contain expected text.");
	    login_page.populateLogin(UserInfo.getUsername(),UserInfo.getPassword());    
	    takeSchreenshot("validateRegisterPageNGTest");
	    login_page.clickOnSubmitButton();
	    takeSchreenshot("validateRegisterPageNGTest");
	
	};

  /*
   * https://www.linkedin.com/advice/0/how-do-you-parameterize-testng-dataprovider#how-to-use-testng-dataprovider-with-excel?
   * If your data is in CSV format, use a CSV parsing library (e.g., OpenCSV) to read the data.
   *  Their is no good reason to write your own csv file reader. There are too many open source readers that handle more 
   *  combinations of  csv file formats. Anything you write in a few minutes will never be as 
   *  flexible with more options than an open source which you could integrate in a few minutes.  
   *  Here are some of the simple parameters that can be used…. 
   *  1 Record Separator
   *  2 Delimiter
   *  3 qualifier such as a record like this….  1,”text”,”more text”,1
   *  4 escape character
   *  5 end of file 
   *  Using just the split is not sufficient to handle csv files successfully.
   *  Take for example this record 
   *  1,”But, this would break if you only split on the comma”,”More
   * Text”,1
   *     Oops you did not handle the comma in the middle of the text string and what 
   *     about the cr line feed in the second text field. You probably only thought about 
   *     a cr/lf as only at the end of a record. I could go on but you get the idea. 
   *     what about tab delimited files.... they are often Considered  a csv file.  
   */
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, new UserDto( 1,"David","Davis",
      "8635143974","davis2go@hotmail.com","123456 Geek way",
      "digital","informaion","101010010","IRAN",
      "writerofcode@gmail.com","12rdqw42!@SA") },
      new Object[] { 2, new UserDto( 2,"Bob","Davis",
      "8542542987","bob123558@hotmail.com","123455 Geek way",
      "digital","informaion","101010010","UNITED STATES",
      "bob123558","12UIRFYh2!@SA") },
    };
  }
  @DataProvider
  public UserDto[] dp2() {
    return new UserDto[]{
      new UserDto( 1,"David","Davis",
      "8635143974","davis2go@hotmail.com","123456 Geek way",
      "digital","informaion","101010010","IRAN",
      "writerofcode@gmail.com","12rdqw42!@SA"),
      new UserDto( 2,"Bob","Davis",
      "8542542987","bob123558@hotmail.com","123455 Geek way",
      "digital","informaion","101010010","UNITED STATES",
      "bob123558","12UIRFYh2!@SA")
    };
  }
  @DataProvider
  public UserDto[] UsersFromJsonFile() throws FileNotFoundException {
	  String filename = ConfigReader.getProperty("testusers");
      Gson gson = new Gson();
      JsonReader reader = new JsonReader(new FileReader(filename));
      UserDto[] users =  gson.fromJson(reader,  UserDto[].class);
      return users;
  }
 
}
