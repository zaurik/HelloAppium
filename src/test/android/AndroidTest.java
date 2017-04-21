package test.android;

import java.io.File;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTest {
	
	protected AppiumDriver driver;
	Date date= new Date();
	
	@BeforeMethod
	public void setUp()	{
		
		try
		{
			System.out.println("**** SetUp Started *****");
			//set up appium
			File classPathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classPathRoot,"application");
			File app = new File(appDir, "android-debug.apk");
			
            DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("platformName", "Android");
//			capabilities.setCapability("browserName", "");
			capabilities.setCapability("deviceName", "3300dc5b17b15319");	
//			capabilities.setCapability("avd", "NexusOneArm");
//			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("app", "\\\\172.20.4.51\\shared\\android-debug.apk");
			capabilities.setCapability("appPackage", "demo.hybrid.jqm");
			capabilities.setCapability("appActivity", "demo.hybrid.jqm.MainActivity");
			
			if (driver != null)
			{
				driver.quit();
			}
			
//			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
			driver = new AndroidDriver(new URL("http://172.20.4.59:4723/wd/hub"), capabilities);
			System.out.println("**** SetUp Ended *****");
			
			
		}
		catch(Exception ex)
		{
			System.out.println("**** Error occurred in SetUp *****");
			System.out.print(ex.getStackTrace());
			ex.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		driver.quit();
	}
	
	@Test
	public void SuccessfulLoginTest() throws InterruptedException
	{
		System.out.println("**** [" + new Timestamp(date.getTime()) + "] LoginTest Started *****");
		Thread.sleep(10000);
//		String userName = "admin";
//		String password = "pass@123";
//		WebDriverWait wait;
//		
//		try {
//		    Thread.sleep(7000);                 //1000 milliseconds is one second.
//		} catch(InterruptedException ex) {
//		    Thread.currentThread().interrupt();
//		}
//		
//		
//		Set<String> contextNames = driver.getContextHandles();
//		System.out.println("**** Contextes found: *****");
//		for (String contextName : contextNames) {
//			System.out.println(contextName); 
//		}
//		
////		driver.context("WEBVIEW_demo.hybrid.jqm");
//		driver.context("WEBVIEW");
//		
//		wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("login-username")));
//
//		driver.findElement(By.id("login-username")).sendKeys(userName);
//		driver.findElement(By.id("login-password")).sendKeys(password);
//		driver.findElement(By.id("login-button")).click();
//		
//		System.out.println("**** [" + new Timestamp(date.getTime()) + "] Wait Started *****");
//		wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@id=\"home-page\"]/div[1]/div[1]/h1")));
//		
//		System.out.println("**** [" + new Timestamp(date.getTime()) + "] Assert Started *****");
//		String displayedHeader = 
//				driver.findElementByXPath("//*[@id=\"home-page\"]/div[1]/div[1]/h1").getText().trim().toLowerCase();
//		String expectedHeader = "compello dev day";
//		System.out.println("**** [" + new Timestamp(date.getTime()) + "] Displayed header: " + displayedHeader +" *****");
//		System.out.println("**** [" + new Timestamp(date.getTime()) + "] Expected header: " + expectedHeader +" *****");
//		Assert.assertEquals(displayedHeader, expectedHeader);
	}

}
