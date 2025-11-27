package testCases.GeneralStore;

import absa.aic.driver.DriverInstance;
import absa.aic.pageObjects.android.FormPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import absa.aic.utils.AppiumBase;
import absa.aic.enums.Locators;

public class Ecom_TC01 extends AppiumBase {
	
	@Test
	public void validateErrorMessage() throws InterruptedException {

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
