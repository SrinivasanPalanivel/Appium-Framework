package base;

import java.time.Duration;

import absa.aic.driver.DriverInstance;
import absa.aic.utils.AppiumServerManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import absa.aic.utils.PropertiesUtil;

public class BaseTest extends DriverInstance {


	public static final String APK_NAME = PropertiesUtil.getPropertyValue("APK_Name");
	public static final String DEVICE_NAME = PropertiesUtil.getPropertyValue("Device_Name");

	@BeforeClass
	public static void appiumSetUp() {

		AppiumServerManager.startAppiumServer();
		
		setDriver(APK_NAME, DEVICE_NAME);
		setWait();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterClass
	public static void appiumTearDown() {
		getDriver().quit();
		AppiumServerManager.stopAppiumServer();
	}



}
