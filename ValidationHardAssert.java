package assertion;

import org.testng.Assert;

public class ValidationHardAssert {

	public static void main(String[] args) 
	{
		System.out.println("Statement 1");
		String expected = "java";
		String actual = "java";
		
		Assert.assertEquals(actual, expected);
		System.out.println("Statement 2");
		actual = "asdgff";
		
	    Assert.assertEquals(expected, actual, "Strings are matched");
	    
	    Assert.assertFalse(true);
	    System.out.println("Statement 3");
	}

}
