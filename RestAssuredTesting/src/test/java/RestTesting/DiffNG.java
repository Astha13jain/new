package RestTesting;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DiffNG {
		
		@BeforeTest
		public void BT()
		{
			String Name = "Abhishek";
			String SName = "Kadam";
			
			Assert.assertEquals(Name, SName);
			
		}
		@Test
		public void testcase1()
		{
			System.out.println("First method");
		}
		
		@AfterTest
		public void AT()
		{
			System.out.println("2nd Method");
		}

}

