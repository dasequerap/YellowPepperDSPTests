package activities.budgetEntryActivity;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CalendarView {
    private final AndroidDeviceDriver androidDriver;
    protected MobileElement currentElement;
    private final By textInputModeButton = By.id("com.monefy.app.lite:id/mtrl_picker_header_toggle");
    private final By textInputField = By.xpath(
            "//*[@resource-id='com.monefy.app.lite:id/mtrl_picker_text_input_date']/android.widget.FrameLayout/android.widget.EditText");
    private final By confirmDateOkButton = By.id("com.monefy.app.lite:id/confirm_button");

    public CalendarView(AndroidDeviceDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void clickTextInputModeButton(){
        currentElement = (MobileElement) androidDriver.getCurrentDriver().findElement(textInputModeButton);
        currentElement.click();
    }

    public void setDateWithText(String date){
        clickTextInputModeButton();
        currentElement = (MobileElement) androidDriver.getCurrentDriver().findElement(textInputField);
        currentElement.sendKeys(date);
        androidDriver.getCurrentDriver().navigate().back();
        currentElement = (MobileElement) androidDriver.getCurrentDriver().findElement(confirmDateOkButton);
        currentElement.click();
    }
}