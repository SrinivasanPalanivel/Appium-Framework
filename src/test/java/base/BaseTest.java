package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.PropertiesUtil;

public class BaseTest extends DriverInstance {

	private static AppiumDriverLocalService service;	
	public static final String APK_NAME = PropertiesUtil.getPropertyValue("APK_Name");
	public static final String DEVICE_NAME = PropertiesUtil.getPropertyValue("Device_Name");

	@BeforeClass
	public static void appiumSetUp() throws MalformedURLException, URISyntaxException {

		//startAppiumServer();
		
		setDriver(APK_NAME, DEVICE_NAME);
		setWait();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterClass
	public static void appiumTearDown() {
		getDriver().quit();
		//service.stop();
	}

	public static void startAppiumServer() {
		// To Start the Appium Server Programmatically
		File file = new File("C:\\nvm4w\\nodejs\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder()
				.withAppiumJS(file)
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
	}

}
