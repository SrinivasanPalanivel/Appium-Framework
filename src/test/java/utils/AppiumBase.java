package utils;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumBase extends BaseTest {
	
	public WebElement locateElement(Locators locatorType, String value) {
		try {
			switch(locatorType) {
			case ID:
				return getDriver().findElement(AppiumBy.id(value));
			case XPATH:
				return getDriver().findElement(AppiumBy.xpath(value));
			case CLASSNAME:
				return getDriver().findElement(AppiumBy.className(value));
			case ACCESSIBILITYID:
				return getDriver().findElement(AppiumBy.accessibilityId(value));
			case ANDROIDUIAUTOMATOR:
				return getDriver().findElement(AppiumBy.androidUIAutomator(value));
			default:
				System.err.println("Invalid Locator!!!");
				break;
			}
		} catch(NoSuchElementException e) {
			System.err.println("Unable to find Element. Try different Locator.\n" + e.toString());
			throw e;
		} catch(StaleElementReferenceException e) {
			System.err.println("Caught Stale Element Exception. So Trying to Relocate the Element");
			locateElement(locatorType, value);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return null;
	}
	
	public List<WebElement> locateElements(Locators locator, String locatorValue) {
		try {
			switch(locator) {
			case ID:
				return getDriver().findElements(AppiumBy.id(locatorValue));
			case XPATH:
				return getDriver().findElements(AppiumBy.xpath(locatorValue));
			case CLASSNAME:
				return getDriver().findElements(AppiumBy.className(locatorValue));
			case ACCESSIBILITYID:
				return getDriver().findElements(AppiumBy.accessibilityId(locatorValue));
			case ANDROIDUIAUTOMATOR:
				return getDriver().findElements(AppiumBy.androidUIAutomator(locatorValue));
			default:
				System.err.println("Invalid Locator!!!");
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Unable to find Element. Try different Locator.\n" + e.toString());
			throw e;
		} catch(Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return null;
	}
	
	public void click(Locators locator, String value) {
		try {
			locateElement(locator, value).click();
		} catch(Exception e) {
			System.err.println(e.getMessage()+ ": Click Operation Failed");
		}
	}
	
	public String getText(Locators locator, String value) {
		String elementText = null;
		try {
			elementText = locateElement(locator, value).getText();
		} catch(Exception e) {
			System.err.println("GetElementText Operation Failed: "+e.toString());
		}
		return elementText;
	}
	
	public void setText(Locators locator, String value, String input) {
		try {
			locateElement(locator, value).sendKeys(input);
		} catch(Exception e) {
			System.err.println(e.toString() + ": SetText Operation Failed");
		}
	}
	
	public void longPressAction(WebElement ele, int duration) {
		try {
			((JavascriptExecutor)getDriver()).executeScript("mobile: longClickGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement)ele).getId(),
					"duration", duration));
		} catch(Exception e) {
			System.err.println(e.getMessage() + ": LongPress Operation Failed");
		}
	}
	
	public void swipeAction(WebElement ele, String direction) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement)ele).getId(),
					"direction", direction,
					"percent", 0.75
					));
		} catch(Exception e) {
			System.err.println(e.getMessage() + ": Swipe Operation Failed");
		}
	}
	
	public void scrollAction(String value) {
		try {
			locateElement(Locators.ANDROIDUIAUTOMATOR, "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));");
		} catch(Exception e) {
			System.err.println(e.getMessage()+": Scroll using UiScrollable Operation Failed");
		}
	}
	
	public void scrollAction(Locators locator, int height, double percent, String value) {
		boolean canScrollMore;
		try {
			do {
				if(isVisible(locator, value)) 
					break;
				canScrollMore = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", height,
				    "direction", "down",
				    "percent", percent
				));
			} while(canScrollMore);
		} catch(Exception e) {
			System.err.println(e.getMessage()+": Scoll using Scroll Gesture is Failed");
		}
	}
	
	public boolean isVisible(Locators locator, String value) {
		// Store current implicit wait
		Duration originalTimeOut = getDriver().manage().timeouts().getImplicitWaitTimeout();
		try {
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			return locateElement(locator, value).isDisplayed();
		} catch(NoSuchElementException |NullPointerException e) {
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// Restore original implicit wait
			getDriver().manage().timeouts().implicitlyWait(originalTimeOut);
		}
		
	}
	
	public boolean isVisible(String value) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(value)));
			return true;
		} catch(TimeoutException e) {
			System.err.println(e.toString()+": Element is not Visible");
			return false;
		}
	}
	
	public void dragDropAction(WebElement source, int dropX, int dropY) {
		try {
			((JavascriptExecutor)getDriver()).executeScript("mobile: dragGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement)source).getId(),
					"endX", dropX,
					"endY", dropY
					));
		} catch(Exception e) {
			System.err.println(e.getMessage()+ ": Drag and Drop Operation is Failed");
		}
	}
	
	/*
	 * Provide 90 to rotate the Screen to LandScape
	 * Provide 0 to rotate the Screen to Portrait
	 */
	public void rotateScreen(int zAxis) {
		try {
			DeviceRotation rotate = new DeviceRotation(0, 0, zAxis);
			getDriver().rotate(rotate);
		} catch(WebDriverException e) {
			System.err.println(e.toString()+": Screen Rotate Operation is Failed");
		}
	}
	
	public void setClipboardText(String input) {
		try {
			getDriver().setClipboardText(input);
		} catch(WebDriverException e) {
			System.err.println(e.toString()+": Set Text to Clipboard Operation is Failed");
		}
	}

	/*
	public String getClipboardText() {
		try {
			return getDriver().getClipboardText();
		} catch(WebDriverException e) {
			System.err.println(e.toString()+": Get Text from Clipboard Operation is Failed");
		}
		return null;
	}
	*/
	
	public void keyboardActions(AndroidKey key) {
		try {
			getDriver().pressKey(new KeyEvent(key));
		} catch(WebDriverException e) {
			System.err.println(e.toString()+": Press Key Event Operation is Failed");
		}
	}
	
	public void openActivityScreen(String appActivity) {
		try {
			((JavascriptExecutor)getDriver()).executeScript("mobile: startActivity", ImmutableMap.of(
					"intent", appActivity
					));
		} catch(Exception e) {
			System.err.println(e.toString()+": Open App Activity Operation is Failed");
		}
	}
	
	public String getToastMsg(int toastIndex) {
		try {
			return locateElement(Locators.XPATH, "(//android.widget.Toast)["+toastIndex+"]").getText();
		} catch (WebDriverException e) {
			return "Unable to Capture Toast: "+e.toString();
		}
	}
	
	public void waitTillAttributeChange(Locators locator, String locatorValue, String attributeName, String attributeValue) {
		try {
			Thread.sleep(3000); //For Navigation
			WebElement element =  locateElement(locator, locatorValue);
			getWait().until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
		} catch (TimeoutException e) {
			System.err.println("Yet unable to Find the Elememt after 10 seconds: "+e.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
