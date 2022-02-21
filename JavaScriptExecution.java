package javaScriptProgram;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecution
{
	static WebDriver driver;

	@Test(priority = 0)
	public static void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority =1)
	public static void openApplicationUrl() 
	{

		driver.get("https://www.goibibo.com/");

	}
	
	@Test(priority =2)
	public static void getData()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title").toString();
	    System.out.println("Title = "+title);
	    
	    String domain = js.executeScript("return document.domain").toString();
	    System.out.println("Domain = "+domain);
	    
	    String url = js.executeScript("return document.URL").toString();
	    System.out.println("Url = "+url);
	}

}
