package actionClassExample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassEvent
{
	static WebDriver driver;

	@Test
	public static void launchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public static void openApplicationUrl()
	{
		driver.get("https://www.amazon.in/");
	}
	
	@Test(priority = 1)
	public void handleMouseEvent()
	{
		WebElement signlink = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(signlink);
		
		action.moveToElement(driver.findElement(By.xpath("//div[@data-value='search-alias=aps']"))).click().build();
		
		action.moveToElement(driver.findElement(By.xpath("//div[@data-value='search-alias=aps']"))).perform();
		
		action.moveToElement(driver.findElement(By.linkText("Gift a Smile"))).perform();
		
		action.clickAndHold(driver.findElement(By.linkText("About Us"))).perform();
		
		//action.contextClick(signlink).perform();
		//action.clickAndHold(driver.findElement(By.linkText("About Us"))).doubleClick().perform();
		
		action.keyDown(Keys.SHIFT).sendKeys(driver.findElement(By.xpath("//input[@aria-label='Search']")),"phone").click();
		action.keyUp(Keys.SHIFT).perform();
	}
}
