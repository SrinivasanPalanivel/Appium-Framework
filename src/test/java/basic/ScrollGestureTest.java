package basic;

import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class ScrollGestureTest extends AppiumBase{
	
	@Test
	public void swipeTest() throws InterruptedException {
		
		click(Locators.ACCESSIBILITYID, "Views");
		
		/*
		 * We Can Scroll in Two different ways
		 */
		
		//Way 1- Scroll using UIScrollable
		//scrollAction("Seek Bar");
		
		
		//Way 2 - Using Scroll Gesture
		scrollAction(Locators.ACCESSIBILITYID, 1500, 0.1, "Seek Bar");
		
		Thread.sleep(3000);
		
	}

}
