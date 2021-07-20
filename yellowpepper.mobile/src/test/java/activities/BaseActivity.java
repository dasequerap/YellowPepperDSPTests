package activities;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.android.AndroidDriver;

class BaseActivity {
	protected AndroidDeviceDriver androidDriver;
	
	public BaseActivity(AndroidDeviceDriver androidDriver) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
		this.androidDriver = androidDriver;
	}

	protected AndroidDriver getCurrentDriver(){
		return androidDriver.getCurrentDriver();
	}

	public void launchApp() throws InterruptedException, UnsupportedEncodingException {
		this.getCurrentDriver().launchApp();
	}

	public void quitActivity() { this.getCurrentDriver().closeApp(); }
}
