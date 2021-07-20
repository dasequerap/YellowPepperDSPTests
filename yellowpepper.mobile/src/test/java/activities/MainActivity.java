package activities;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MainActivity extends BaseActivity {

	public MainActivity(AndroidDeviceDriver androidDriver) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
		super(androidDriver);
	}

	public void tapSuggestions() {
		MobileElement suggestion = (MobileElement) this.getCurrentDriver().findElement(new By.ByClassName("android.widget.TextView"));
		System.out.print(suggestion.getText());
	}
}
