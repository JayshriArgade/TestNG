import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) throws ParseException {
		
		String expectedDate = "07 January 2022";
		
		SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
		String currentDateValue = format.format(new Date());
		
		System.out.println("Expected : "+expectedDate);
		System.out.println("Current Date : "+currentDateValue);
		
		Date d = format.parse(currentDateValue);
		Date d1 = format.parse(expectedDate);
		
		System.out.println(d.after(d1));
		
		
		
	}

}