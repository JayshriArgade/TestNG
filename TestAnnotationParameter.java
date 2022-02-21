package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestAnnotationParameter 
{
    static WebDriver driver;
    
    @DataProvider (name = "LoginDetails")
    public String[][] getData()
    {
    	String[][] values = { {"user@yourstore.com", "user"} , {"password@yourstore.com", "password"} ,
    			{"userpass@yourstore.com", "userpass"} , {"admin123@yourstore.com", "admin123"} ,
    			{"admin@yourstore.com", "admin"} };
    	
    	return values;
    }
    
    @Test (dataProvider = "LoginDetails")
    public void loginTesting(String uname, String pass)
    {
    	driver.findElement(By.id("Email")).clear();
    	driver.findElement(By.id("Email")).sendKeys(uname);
    	
    	driver.findElement(By.id("Password")).clear();
    	driver.findElement(By.id("Password")).sendKeys(pass);
    	
    	driver.findElement(By.tagName("button")).click();
    	
    	if(driver.getTitle().contains("Dashboard"))
    	{
    		System.out.println("User logged in successfully with "+uname+" and "+pass);
    	}
    	else
    	{
    		System.out.println("User is not logged in with "+uname+" and "+pass);
    	}
    }
    
    @BeforeSuite
    public static void launchBrowser()
    {
         System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    }
    
    @BeforeTest
    public static void getApplicationUrl()
    {
    	driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2FAdmin%2FProduct%2FList");
    }
    	
}
