package helpers;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("rawtypes")
public class AndroidDeviceDriver {
	private final URL resourceLocation = getClass().getResource("/com.monefy.app.lite.apk");
	private final String URI;
	{
		assert resourceLocation != null;
		URI = java.net.URLDecoder.decode(
				resourceLocation.toString(), String.valueOf(StandardCharsets.UTF_8));
	}

	private final String appLocation = URI.substring(6);
	private final String appName = "com.monefy.app.lite";
	protected static AndroidDriver mobileDriver;

	public AndroidDeviceDriver() throws UnsupportedEncodingException { }

	public void initDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("avd", "TestAndroid9Device");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("noResetValue","true");
		capabilities.setCapability("app", appLocation);
		capabilities.setCapability("appPackage", appName);
		String mainActivityName = "com.monefy.activities.main.MainActivity_";
		capabilities.setCapability("appActivity", mainActivityName);

		mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public AndroidDriver getCurrentDriver() { return mobileDriver; }

	public void removeApp(){ mobileDriver.removeApp(this.appName);	}

	public void closeDriver() { mobileDriver.quit(); }

}
