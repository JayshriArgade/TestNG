package assertion;

import org.testng.asserts.SoftAssert;

public class VerificationSoftAssert {

	public static void main(String[] args)
	{
		System.out.println("Statement 1");
		String s = "Java123";
		String s1 = "Java123";
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(s, s1);
		System.out.println("Statement 2");
	}

}
