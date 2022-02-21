package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CrossBrowserTesting
{
   static WebDriver driver;
   
   public static void launchBrowser(String browserName)
   {
   	switch(browserName.trim().toUpperCase())
   	{
   	    case "CHROME" :
   	          System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
   	          driver = new ChromeDriver();
   	
   	    case "IE" :
       	      System.setProperty("webdriver.ie.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
              	  driver = new ChromeDriver();
       	
   	    case "FIREFOX" :
       	      System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
       	      driver = new ChromeDriver();
       	
       	default :
       		System.out.println("Invalid Browser Name");
       		Assert.fail("Invalid Browser Name");
       		break;
   	}
   	
   	driver.manage().window().maximize();
   }
}
