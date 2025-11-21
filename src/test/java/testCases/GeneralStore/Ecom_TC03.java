package testCases.GeneralStore;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class Ecom_TC03 extends AppiumBase {
	
	@Test
	public void addToCartTest() throws InterruptedException {
		
		setText(Locators.CLASSNAME, "android.widget.EditText","TestUser619");
		click(Locators.ID, "com.androidsample.generalstore:id/btnLetsShop");
		
		scrollAction("Jordan Lift Off");
		int products = locateElements(Locators.ID, "com.androidsample.generalstore:id/productName").size();
		
		for(int i=0; i<products; i++) {
			String productName = locateElements(Locators.ID, "com.androidsample.generalstore:id/productName").get(i).getText();
			if(productName.equals("Jordan Lift Off")) {
				locateElements(Locators.ID, "com.androidsample.generalstore:id/productAddCart").get(i).click();
			}
		}
		
		click(Locators.ID, "com.androidsample.generalstore:id/appbar_btn_cart");
		
		waitTillAttributeChange(Locators.ID, "com.androidsample.generalstore:id/toolbar_title", "text", "Cart");
		
		String cartProduct = getText(Locators.ID, "com.androidsample.generalstore:id/productName");
		Assert.assertEquals(cartProduct, "Jordan Lift Off");
		
		Thread.sleep(3000);
	}

}
