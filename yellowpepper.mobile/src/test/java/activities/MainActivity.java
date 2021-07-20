package activities;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MainActivity extends BaseActivity {

	private final By suggestionLocator = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView");
	private MobileElement suggestion;


	public MainActivity(AndroidDeviceDriver androidDriver) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
		super(androidDriver);
	}

	public void tapSuggestions() {
		suggestion = (MobileElement) this.getCurrentDriver().findElement(suggestionLocator);
		System.out.println(suggestion.getText());
		suggestion.click();
		suggestion = (MobileElement) this.getCurrentDriver().findElement(suggestionLocator);
		System.out.println(suggestion.getText());
		suggestion.click();
		suggestion = (MobileElement) this.getCurrentDriver().findElement(suggestionLocator);
		System.out.println(suggestion.getText());
		suggestion.click();
		suggestion = (MobileElement) this.getCurrentDriver().findElement(suggestionLocator);
		System.out.println(suggestion.getText());
		suggestion.click();
	}
}
