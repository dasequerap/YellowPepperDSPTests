package activities;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

@SuppressWarnings("ALL")
public class BaseActivity {
	protected final AndroidDeviceDriver androidDriver;
	protected final By suggestionLocator = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView");
	protected final MobileBy backButton = (MobileBy) MobileBy.AccessibilityId("Navigate up");
	protected MobileElement currentElement;

	public BaseActivity(AndroidDeviceDriver androidDriver)  {
		this.androidDriver = androidDriver;
	}

	protected AndroidDriver getCurrentDriver(){
		return androidDriver.getCurrentDriver();
	}

	public void clickBackButton(){
		currentElement = (MobileElement) this.getCurrentDriver().findElement(backButton);
		currentElement.click();
	}

	public void quitActivity() { this.getCurrentDriver().closeApp(); }
}
