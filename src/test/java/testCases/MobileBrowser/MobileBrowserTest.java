package testCases.MobileBrowser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class MobileBrowserTest {

    public AndroidDriver driver;

    @Test
    public void browserTest() throws URISyntaxException, MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("Pixel 7");
        //options.setChromedriverExecutable("Path to the Driver");
        options.setAutomationName("UiAutomator2");
        options.setCapability("browserName","Chrome");
        options.setCapability("chromedriverAutodownload", true);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Qeagle Assurance");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }
}
