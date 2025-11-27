package absa.aic.pageObjects.android;

import absa.aic.enums.Locators;
import absa.aic.utils.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AppiumBase {

    private AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
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

    public void setName(String name) {
        setText(txtNameField, name);
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("Female"))
            click(radioBtnFemale);
        else if (gender.equalsIgnoreCase("Male"))
            click(radioBtnMale);
        else
            throw new RuntimeException("Invalid Gender!!!");
    }

    public void clickLetsShop() {
        click(btnLetsShop);
    }

    public String getErrorMessage() {
        String toastText = getToastMsg(1);
        System.out.println(toastText);
        return toastText;
    }
}
