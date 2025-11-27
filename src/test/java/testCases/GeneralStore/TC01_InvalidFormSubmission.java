package testCases.GeneralStore;

import absa.aic.pageObjects.android.FormPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_InvalidFormSubmission extends BaseTest {
	
	@Test
	public void validateErrorMessage() throws InterruptedException {
		FormPage formPage = new FormPage(getDriver());

		formPage.setCounrty("Austria");
		formPage.setGender("female");
		formPage.clickLetsShop();
		Assert.assertEquals(formPage.getErrorMessage(),"Please enter your name");
		Thread.sleep(2000);
	}

}
