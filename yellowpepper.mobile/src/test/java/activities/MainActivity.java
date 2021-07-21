package activities;

import helpers.AndroidDeviceDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import models.BudgetEntryModel.BudgetEntryType;

public class MainActivity extends BaseActivity {

	protected final MobileBy hamburgerMenuButton = (MobileBy) MobileBy.AccessibilityId("Settings");
	private final By expenseButton = By.id("com.monefy.app.lite:id/expense_button");
	private final By incomeButton = By.id("com.monefy.app.lite:id/income_button");
	private final By snackBarText = By.id("com.monefy.app.lite:id/snackbar_text");
	final WebDriverWait wait = new WebDriverWait(androidDriver.getCurrentDriver(), 10);


	public MainActivity(AndroidDeviceDriver androidDriver)  {
		super(androidDriver);
	}

	public void clickSuggestion(){
		try {
			wait.until(ExpectedConditions.elementToBeClickable(suggestionLocator));
			currentElement = (MobileElement) this.getCurrentDriver().findElement(suggestionLocator);
			currentElement.click();
		} catch (TimeoutException ignored){ }
	}

	public void clickHamburgerMenu(){
		currentElement = (MobileElement) this.getCurrentDriver().findElement(hamburgerMenuButton);
		currentElement.click();
	}

	public void clickExpensesButton(){
		wait.until(ExpectedConditions.elementToBeClickable(expenseButton));
		currentElement = (MobileElement) this.getCurrentDriver().findElement(expenseButton);
		currentElement.click();
	}

	public void clickIncomeButton(){
		wait.until(ExpectedConditions.elementToBeClickable(incomeButton));
		currentElement = (MobileElement) this.getCurrentDriver().findElement(incomeButton);
		currentElement.click();
	}

	public void cleanUpScreen(){
		clickSuggestion();
		clickSuggestion();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(snackBarText));
	}

	public void cleanUpSuggestions() {
		clickSuggestion();
		clickSuggestion();
		clickSuggestion();
		clickSuggestion();
		clickHamburgerMenu();
		clickExpensesButton();
		clickSuggestion();
		clickBackButton();
	}

	public void clickBudgetButtonByBudgetType(BudgetEntryType type){
		switch (type){
			case INCOME:
				clickIncomeButton();
				break;
			case EXPENSE:
				clickExpensesButton();
				break;
			default:
				break;
		}
	}

}
