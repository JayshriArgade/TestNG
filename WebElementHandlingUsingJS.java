package javaScriptProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementHandlingUsingJS
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

		driver.get("https://www.amazon.in/");

	}
	
	@Test(priority =2)
	public static void handleElement()
	{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	   js.executeScript("document.getElementsByName('field-keywords')[0].value='laptop Bags'");
	   
	   WebElement searchbox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
	   js.executeScript("arguments[0].value='Mobile'", searchbox);
	   
	   js.executeScript("window.scrollBy(0,900)");
	   
	   js.executeScript("document.getElementById('nav-link-accountList-nav-line-1').click()");
	   js.executeScript("document.getElementById('ap_email').value='abc@gmail.com'");
	   //js.executeScript("document.getElementByXpath('//input[@type='submit']').click()");
	}
}
