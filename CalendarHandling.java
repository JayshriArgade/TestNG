import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarHandling {
	
	static WebDriver driver;

	@Test(priority = 0)
	public static void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\jayshri JAVA\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test(priority =1)
	public static void openApplicationUrl() {

		driver.get("https://www.goibibo.com/");

	}
	
	@Test(priority = 2)
	public static void handlingTheCalendar() throws ParseException{
		String expectedDate =  "27 December 2022";
		
		driver.findElement(By.cssSelector("div[class*='dF whiteBg col-sm-5 alignItemsCenter col-md-2']")).click();

		String actualValue = driver.findElement(By.cssSelector("div[class='DayPicker-Caption'] div")).getText();
		
		SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy");
		String currentDateValue = format.format(new Date());
		SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
		
		Assert.assertEquals(actualValue, currentDateValue);
		int actualMonth = monthInNumber(actualValue.split(" ")[0]);
		int expectedMonth = monthInNumber(expectedDate.split(" ")[1]);
		int diffInMonth = 0;

		
		int actualYear = Integer.parseInt(actualValue.split(" ")[1]);
		int expectedYear = Integer.parseInt(expectedDate.split(" ")[2]);
		
		int diffInYear = expectedYear - actualYear;
		
		Date d = format1.parse(format1.format(new Date()));
		Date d1 = format1.parse(expectedDate);
		if(d.after(d1)){
			Assert.fail("User Entered Passed Date for booking");
		}
		else{
			if(diffInYear == 0){
		 
			diffInMonth = expectedMonth - actualMonth;
		}else{
			int month = diffInYear * 12;
			if(expectedMonth< actualMonth){
				diffInMonth = actualMonth - expectedMonth;
				diffInMonth = month - diffInMonth;
			}else if(expectedMonth > actualMonth){
				diffInMonth = expectedMonth - actualMonth;
				diffInMonth = month + diffInMonth;
			}
			
		}
			
		for (int i = 0; i < diffInMonth; i++) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div[text()='"+expectedDate.split(" ")[0]+"']")).click();
		}
	}
	
	public static int monthInNumber(String month)
	{
		int m = 0;
		
		switch (month)
		{
		    case "January": m = 1;
			            break;
	     	case "February":m = 2;
			            break;
		    case "March": m = 3;
					  break;
		    case "April":m = 4;
					break;
		    case "May":	m = 5;
					break;
		    case "June":m = 6;
					break;
		    case "July":m = 7;
					break;
		    case "August":m = 8;
						break;
		    case "September":m = 9;
						  break;
		    case "October":	m = 10;
   			            break;
		    case "November":  m = 11;
			              break;
		    case "December":  m = 12;
		 	              break;
		    default: m = 0;
			     break;
		}
		return m;
	}
	
}