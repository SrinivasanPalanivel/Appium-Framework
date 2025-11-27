package testCases.GeneralStore;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import absa.aic.utils.AppiumBase;

import java.util.Set;

public class Ecom_TC05_Hybrid extends AppiumBase {

    @Test
    public void handleWebView() throws InterruptedException {

        //Using TC04
        Ecom_TC04 hybrid = new Ecom_TC04();
        hybrid.addToCartTest();

        //Getting Context and Context Switching
        Set<String> contexts = getDriver().getContextHandles();
        for(String context : contexts) {
            System.out.println(context);
        }

        getDriver().context("WEBVIEW_com.androidsample.generalstore");

        getDriver().findElement(By.name("q")).sendKeys("Qeagle Assurance");
        getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        getDriver().context("NATIVE_APP");

    }

}
