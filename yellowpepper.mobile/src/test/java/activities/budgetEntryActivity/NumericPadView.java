package activities.budgetEntryActivity;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class NumericPadView {
    private final AndroidDeviceDriver androidDriver;
    protected By numberButton = null;
    protected MobileElement currentElement;
    protected final By dotButton = MobileBy.id("com.monefy.app.lite:id/buttonKeyboardDot");

    public NumericPadView(AndroidDeviceDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void enterValue(double value){
        String[] parsedValue = String.format("%.2f", value).replace(",", ".").split("");

        for(String digit: parsedValue){
            if (digit.equals(".")) {
                currentElement = (MobileElement) androidDriver.getCurrentDriver().findElement(dotButton);
            } else {
                numberButton = By.id("com.monefy.app.lite:id/buttonKeyboard" + digit);
                currentElement = (MobileElement) androidDriver.getCurrentDriver().findElement(numberButton);
            }
            currentElement.click();
        }
    }
}