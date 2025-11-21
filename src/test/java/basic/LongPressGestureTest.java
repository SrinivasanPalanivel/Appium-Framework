package basic;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import utils.AppiumBase;
import utils.Locators;

public class LongPressGestureTest extends AppiumBase{
	
	@Test
	public void longPress() throws InterruptedException {
		click(Locators.ACCESSIBILITYID, "Views");
		click(Locators.ACCESSIBILITYID, "Expandable Lists");
		click(Locators.ACCESSIBILITYID, "1. Custom Adapter");
		
		WebElement ele = locateElement(Locators.XPATH, "//android.widget.TextView[@text='People Names']");
		
		longPressAction(ele, 2000);
		
		Thread.sleep(3000);
		String text = getText(Locators.ANDROIDUIAUTOMATOR, "new UiSelector().text(\"Sample menu\")");
		Assert.assertEquals(text, "Sample menu");
		boolean eleVisibilty = getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")")).isDisplayed();
		Assert.assertTrue(eleVisibilty);
	}

}
