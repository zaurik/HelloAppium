package test.ios;

import java.io.File;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSTest {
	
	protected IOSDriver driver;
	Date date= new Date();
	
	@BeforeMethod
	public void setUp()	{
		
		try
		{
			System.out.println("**** SetUp Started *****");
			//set up appium
			File classPathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classPathRoot,"application");
			File app = new File(appDir, "Approve.ly.ipa");
			
            DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("platformName", "iOS");
//			capabilities.setCapability("browserName", "");
			capabilities.setCapability("deviceName", "iPad");	
			capabilities.setCapability("udid", "e298a13eb8ce797fabb1fff6fb0b430daf5f12ab");
//			capabilities.setCapability("avd", "NexusOneArm");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("realDeviceLogger", "idevicesyslog");
//			capabilities.setCapability("appPackage", "demo.hybrid.jqm");
//			capabilities.setCapability("appActivity", "demo.hybrid.jqm.MainActivity");
			
			if (driver != null)
			{
				driver.quit();
			}
			
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
			System.out.println("**** SetUp Ended *****");
			
			
		}
		catch(Exception ex)
		{
			System.out.println("**** Error occurred in SetUp *****");
			System.out.print(ex.getStackTrace());
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void LaunchTest()
	{
		System.out.println("**** [" + new Timestamp(date.getTime()) + "] LaunchTest Started *****");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		driver.quit();
	}

}
