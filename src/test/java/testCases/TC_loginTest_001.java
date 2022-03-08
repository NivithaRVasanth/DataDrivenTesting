package testCases;

import org.testng.annotations.Test;

import pageObjects.loginPage;

public class TC_loginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest1()
	{
		loginPage obj1=new loginPage(driver);
		driver.navigate().to(url);
		obj1.login(email, password);
		logger.info("First user successful");
	}
	
	@Test
	public void loginTest2()
	{
		loginPage obj1=new loginPage(driver);
		driver.navigate().to(url);
		obj1.login(email, password);
		logger.info("Second user successful");
	}
	@Test
	public void loginTest3()
	{
		loginPage obj1=new loginPage(driver);
		driver.navigate().to(url);
		obj1.login(email, password);
		logger.info("Third user successful");
	}

}
