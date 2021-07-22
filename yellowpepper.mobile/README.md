# Moneyfy automated tests for Yellowpepper

## Overview
This project has all tests necessary to run "Moneyfy" app test suite.

**Requeriments** 

 - Java 8: https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html.
 - Maven v3.8.1: https://maven.apache.org/docs/3.8.1/release-notes.html.
	 - Configure properly the MVN_HOME and test it before running petstore and automated test projects.
	 - An Internet connection required for Maven to download and install libraries for the petstore and automated test suite projects.
 - Appium v1.21.0: https://appium.io/downloads.html.
 - Android SDK and Android Studio bundle: https://developer.android.com/studio.
 
 **How to run automated test suite**

 - Install pre requisites.
 - Open Android Studio.
 - Click on "Configure" menu at the botton part of the "Welcome to Android Studio" window.
 - Click on "AVD Manager" option to create a new virtual device.
 - Click on "Create Virtual Device".
 - Create a virtual device with following requirements:
	 - Virtual device name: TestAndroid9Device (Optional).
	 - System image: Pie x86_64 (Android 9).
 - Start Appium Server with default port (4723).
 - Clone this repository locally. Be aware of cloning the ```master ``` branch.
 - Open a command line window.
 - Go to the directory where the repository is located.
 - On the directory where this repository is cloned, run this command:
```mvn test```
Through this command:
	 - Maven will download and install libraries required to execute automated test suite.
	 - Tests will start inmediately. Typical run time is about 1m - 1m20 seconds.
	 - MoneyFy app is bundled with the repository. The tests will install and uninstall the app automatically.
	 - If you want to use different settings for the virtual device, please change following capabilities on [ **AndroidDeviceDriver.java**](https://github.com/dasequerap/YellowPepperDSPTests/blob/master/yellowpepper.mobile/src/test/java/helpers/AndroidDeviceDriver.java) file:
	
		 - ```capabilities.setCapability("avd", "TestAndroid9Device")```: Change ```TestAndroid9Device``` with the name of the device created on AVD manager.
		 - ```capabilities.setCapability("platformVersion", "9")```: change ```9``` with the version installed on created virtual device. Please, be aware installed Android version is supported by MoneyFy app.
		 - ```capabilities.setCapability("deviceName", "emulator-5554")```: If you are not sure about the ADB name of the device, please change ```emulator-5554``` with the device name you get after running command ```adb devices```.

