package basic;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class DargDropTest extends AppiumBase {
	
	@Test
	public void swipeTest() {
		
		click(Locators.ACCESSIBILITYID, "Views");
		click(Locators.ACCESSIBILITYID, "Drag and Drop");
		
		WebElement source = locateElement(Locators.ID, "io.appium.android.apis:id/drag_dot_1");
		
		dragDropAction(source, 607, 557);
		
		String message = getText(Locators.ID, "io.appium.android.apis:id/drag_result_text");
		Assert.assertEquals(message, "Dropped!");
	}

}
