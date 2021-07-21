package activities.budgetEntryActivity;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import activities.BaseActivity;
import models.BudgetEntryModel.PaymentType;
import models.BudgetEntryModel.Category;
import org.openqa.selenium.By;

public class BudgetEntryActivity extends BaseActivity {

    protected final By paymentTypeMenu = MobileBy.id("com.monefy.app.lite:id/icon");
    protected final By cashOption = By.xpath("//*[@text='Cash']");
    protected final By cardOption = By.xpath("//*[@text='Payment card']");

    protected final By dateButton = By.id("com.monefy.app.lite:id/textViewDate");
    protected final By notesField = By.id("com.monefy.app.lite:id/textViewNote");
    protected final By categoryButton = By.id("com.monefy.app.lite:id/keyboard_action_button");
    protected By getCategoryNameButton = null;

    public BudgetEntryActivity(AndroidDeviceDriver androidDriver) {
        super(androidDriver);
    }

    public void clickDateButton(){
        currentElement = (MobileElement) this.getCurrentDriver().findElement(dateButton);
        currentElement.click();
    }

    public void setDateWithString(String date){
        CalendarView calendarView = new CalendarView(this.androidDriver);
        clickDateButton();
        calendarView.setDateWithText(date);
    }

    public void clickChooseCategoryButton(){
        currentElement = (MobileElement) this.getCurrentDriver().findElement(categoryButton);
        currentElement.click();
    }

    public void selectPaymentType(PaymentType paymentType){
        currentElement = (MobileElement) this.getCurrentDriver().findElement(paymentTypeMenu);
        currentElement.click();

        switch (paymentType){
            case CASH:
                currentElement = (MobileElement) this.getCurrentDriver().findElement(cashOption);
                break;
            case PAYMENT_CARD:
                currentElement = (MobileElement) this.getCurrentDriver().findElement(cardOption);
                break;
            default:
                break;
        }
        currentElement.click();
    }

    public void setValue(Double budgetValue){
        NumericPadView numericPadView = new NumericPadView(this.androidDriver);
        numericPadView.enterValue(budgetValue);
    }

    public void chooseCategory(Category category){
        clickChooseCategoryButton();
        getCategoryNameButton = By.xpath("//*[@text='" + category.toString() + "']");
        currentElement = (MobileElement) this.getCurrentDriver().findElement(getCategoryNameButton);
        currentElement.click();
    }

    public void setNotes(String notes){
        currentElement = (MobileElement) this.getCurrentDriver().findElement(notesField);
        currentElement.setValue(notes);
    }
}