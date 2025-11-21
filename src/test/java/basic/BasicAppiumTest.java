package basic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.AppiumBy;

public class BasicAppiumTest extends BaseTest {
	
	@Test
	public void firstTest() throws InterruptedException {
		
		getDriver().findElement(AppiumBy.accessibilityId("Preference")).click();
		//Thread.sleep(3000);
		getDriver().findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		getDriver().findElement(AppiumBy.id("android:id/checkbox")).click();
		getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
		String popUpTitle = getDriver().findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(popUpTitle);
		Assert.assertEquals(popUpTitle, "WiFi settings");
		getDriver().findElement(AppiumBy.id("android:id/edit")).sendKeys("Nexus 5G");
		getDriver().findElement(AppiumBy.id("android:id/button1")).click();
		
		Thread.sleep(3000);
		
		
	}

}
