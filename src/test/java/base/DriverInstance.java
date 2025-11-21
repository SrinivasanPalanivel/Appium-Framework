package base;

import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.ConstantPaths.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverInstance {
	
	private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();
	private static final ThreadLocal<WebDriverWait> wait =  new ThreadLocal<WebDriverWait>();
	
	public static void setDriver(String apkName, String deviceName) {
		// Setting Capabilities
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName(deviceName);
		options.setApp(RESOURCE_PATH + apkName);
		
		try {
			driver.set(new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options));
		} catch (MalformedURLException | URISyntaxException e) {
			System.err.println("Failed to Initialize the driver: "+e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static AndroidDriver getDriver() {
		return driver.get();
	}
	
	public static void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
	}
	
	public static WebDriverWait getWait() {
		return wait.get();
	}

}
