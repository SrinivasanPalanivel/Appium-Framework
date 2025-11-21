package testCases.GeneralStore;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.AppiumBase;
import utils.Locators;

public class Ecom_TC04 extends AppiumBase {
	
	@Test
	public void addToCartTest() throws InterruptedException {
		
		setText(Locators.CLASSNAME, "android.widget.EditText","TestUser619");
		click(Locators.ID, "com.androidsample.generalstore:id/btnLetsShop");
		
		click(Locators.XPATH, "(//android.widget.TextView[@text='ADD TO CART'])[1]");
		click(Locators.XPATH, "(//android.widget.TextView[@text='ADD TO CART'])[1]");
		
		click(Locators.ID, "com.androidsample.generalstore:id/appbar_btn_cart");
		
		waitTillAttributeChange(Locators.ID, "com.androidsample.generalstore:id/toolbar_title", "text", "Cart");
		System.out.println(getText(Locators.ID, "com.androidsample.generalstore:id/toolbar_title"));
		
		int cart_products= locateElements(Locators.ID, "com.androidsample.generalstore:id/productPrice").size();
		
		double cart_value = 0.0;
		for(int i=1; i<=cart_products; i++) {
			String value = getText(Locators.XPATH, "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])["+i+"]");
			cart_value = cart_value + Double.valueOf(value.replaceAll("[^0-9.]", ""));
		}
		System.out.println("Cart Value: "+cart_value);
		
		String total_value = getText(Locators.ID, "com.androidsample.generalstore:id/totalAmountLbl");
		double total_amount = Double.valueOf(total_value.replaceAll("[^0-9.]", ""));
		System.out.println("Total Amount: "+total_amount);
		
		Assert.assertEquals(total_amount, cart_value);
		
		Thread.sleep(3000);
	}

}
