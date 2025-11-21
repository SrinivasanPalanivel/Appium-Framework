package basic;

import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class OpenTargetScreen extends AppiumBase {
	
	@Test
	public void openDateWidget() throws InterruptedException {
		
		String activity = "io.appium.android.apis/io.appium.android.apis.view.DateWidgets2";
		openActivityScreen(activity);
		
		click(Locators.ACCESSIBILITYID, "6");
		click(Locators.ACCESSIBILITYID, "45");
		click(Locators.ID, "android:id/am_label");
		
		Thread.sleep(3000);
		
	}

}
