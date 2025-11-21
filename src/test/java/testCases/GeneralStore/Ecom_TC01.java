package testCases.GeneralStore;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class Ecom_TC01 extends AppiumBase {
	
	@Test
	public void validateErrorMessage() {
		
		click(Locators.CLASSNAME, "android.widget.Spinner");
		scrollAction("Algeria");
		click(Locators.ANDROIDUIAUTOMATOR, "new UiSelector().text(\"Algeria\")");
		click(Locators.ID, "com.androidsample.generalstore:id/radioFemale");
		click(Locators.ID, "com.androidsample.generalstore:id/btnLetsShop");
		String toastText = getToastMsg(1);
		System.out.println(toastText);
		Assert.assertEquals(toastText, "Please enter your name");
		
	}

}
