package testCases.GeneralStore;

import absa.aic.driver.DriverInstance;
import absa.aic.pageObjects.android.FormPage;
import base.BaseTest;
import org.testng.annotations.Test;

public class TC02_FormSubmissionTest extends BaseTest {

    @Test
    public void submitform() throws InterruptedException {
        FormPage formPage = new FormPage(DriverInstance.getDriver());

        formPage.setCounrty("Austria");
        formPage.setName("Jeff Hardy");
        formPage.setGender("female");
        formPage.clickLetsShop();
        Thread.sleep(2000);
    }
}
