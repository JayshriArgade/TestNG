package alertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandlingExample 
{
	static WebDriver driver;

	@Test(priority = 0)
	public static void launchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/delete_customer.php");
	}
	
	@Test(priority = 1)
	public void handleAlert() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123");
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println("First alert = "+alert.getText());
		
		alert.accept();
		Thread.sleep(2000);
		System.out.println("Second alert = "+alert.getText());
		
		alert.accept();
		System.out.println("Current Page Title = "+driver.getTitle());
	}
}
