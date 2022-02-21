package robotClassExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SendKeysByRobotClass
{
	static WebDriver driver;

	@Test(priority = 0)
	public static void launchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	@Test(priority = 1)
	public static void handleMouseEvent()
	{
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		
		//Robot robot = new Robot();
		
	}
}
