package tests;

import helpers.AndroidDeviceDriver;
import org.junit.jupiter.api.*;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import activities.MainActivity;

public class Tests {

	static AndroidDeviceDriver androidDriver = null;
	static MainActivity mainActivity;

	public Tests() throws UnsupportedEncodingException, URISyntaxException, MalformedURLException { }

	@BeforeAll
	static void init() throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
		androidDriver = new AndroidDeviceDriver();
		mainActivity = new MainActivity(androidDriver);
		androidDriver.initDriver();
	}

	@Order(1)
	@Test
    @DisplayName("First Test")
	public void openApp() throws InterruptedException, UnsupportedEncodingException {
		mainActivity.tapSuggestions();
	}

	@AfterAll
	static void tearDown(){
		mainActivity.quitActivity();
		androidDriver.removeApp();
		androidDriver.closeDriver();
	}
}
