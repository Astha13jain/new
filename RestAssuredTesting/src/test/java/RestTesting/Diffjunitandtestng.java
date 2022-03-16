package RestTesting;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Diffjunitandtestng {

	@Before
	public void BT()
	{
		String Name = "Abhishek";
		String SName = "Kadam";
		
		Assert.assertEquals(SName,Name);
		
	}
	@Test
	public void testcase1()
	{
		System.out.println("First Method");
	}
	@After
	public void testcase2()
	{
		System.out.println("2nd Method");
	}

}
