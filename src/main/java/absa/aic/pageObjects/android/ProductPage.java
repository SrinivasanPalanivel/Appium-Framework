package absa.aic.pageObjects.android;

import absa.aic.enums.Locators;
import absa.aic.utils.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AppiumBase {

    private AndroidDriver driver;

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //******************************* Page Elements ************************************
    @AndroidFindBy(className = "android.widget.Spinner")
    private WebElement drpDownCountry;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement txtNameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement radioBtnFemale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement radioBtnMale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    //******************************* Page Actions ************************************

    public void setCounrty(String countryName) {
        click(drpDownCountry);
        scrollAction(countryName);
        click(Locators.ANDROIDUIAUTOMATOR, "new UiSelector().text(\""+countryName+"\")");
    }

}
