package basic;

import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import utils.AppiumBase;
import utils.Locators;

public class MiscellaneousTest extends AppiumBase {
	
	@Test
	public void screenRotationTest() throws InterruptedException {
		//Rotate Screen Test
		rotateScreen(90);
		Thread.sleep(3000);
		rotateScreen(0);
		System.out.println("Screen Rotation is Successful");
	}
	
	@Test
	public void clipBoardTest() {
		click(Locators.ACCESSIBILITYID, "Preference");
		click(Locators.ACCESSIBILITYID, "3. Preference dependencies");
		click(Locators.ID, "android:id/checkbox");
		click(Locators.ANDROIDUIAUTOMATOR, "new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)");
		setClipboardText("HP Victus i9");
		//setText(Locators.ID, "android:id/edit", getClipboardText());
	}
	
	@Test
	public void keyboardEventsTest() {
		click(Locators.ACCESSIBILITYID, "Preference");
		if(isVisible("3. Preference dependencies"))
			keyboardActions(AndroidKey.BACK);
		click(Locators.ACCESSIBILITYID, "Views");
		if(isVisible("Focus"))
			keyboardActions(AndroidKey.HOME);
	}

}
