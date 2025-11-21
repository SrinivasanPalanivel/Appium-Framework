package testCases.GeneralStore;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class Ecom_TC02 extends AppiumBase {
	
	@Test
	public void fillForm() throws InterruptedException {
		click(Locators.CLASSNAME, "android.widget.Spinner");
		scrollAction("Algeria");
		click(Locators.ANDROIDUIAUTOMATOR, "new UiSelector().text(\"Algeria\")");
		setText(Locators.CLASSNAME, "android.widget.EditText","TestUser619");
		click(Locators.ID, "com.androidsample.generalstore:id/radioFemale");
		click(Locators.ID, "com.androidsample.generalstore:id/btnLetsShop");
		String pageName = getText(Locators.ID, "com.androidsample.generalstore:id/toolbar_title");
		System.err.println(pageName);
		Assert.assertEquals(pageName, "Products");
		Thread.sleep(3000);
	}

}
