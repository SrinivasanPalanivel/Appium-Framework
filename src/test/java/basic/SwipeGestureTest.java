package basic;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class SwipeGestureTest extends AppiumBase {
	
	@Test
	public void swipeTest() {
		
		click(Locators.ACCESSIBILITYID, "Views");
		click(Locators.ACCESSIBILITYID, "Gallery");
		click(Locators.ACCESSIBILITYID, "1. Photos");
		
		WebElement firstImage = locateElement(Locators.XPATH, "(//android.widget.ImageView)[1]");
		WebElement thirdImage = locateElement(Locators.XPATH, "(//android.widget.ImageView)[3]");
		Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
		
		//Swipe Gesture
		swipeAction(thirdImage, "left");
		
		Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
	}

}
