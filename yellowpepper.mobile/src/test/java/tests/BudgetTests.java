package tests;

import org.junit.jupiter.api.*;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Time;

import org.junit.jupiter.api.TestMethodOrder;

import activities.MainActivity;
import activities.BudgetEntryActivity.BudgetEntryActivity;
import models.BudgetEntryModel;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BudgetTests extends BaseTests {

	static MainActivity mainActivity;
	static BudgetEntryActivity budgetEntryActivity;
	static BudgetEntryModel testIncomeEntry;
	static BudgetEntryModel testExpenseEntry;

	public BudgetTests() { }

	@BeforeAll
	static void setUp() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {
		init();
		mainActivity = new MainActivity(androidDriver);
		budgetEntryActivity = new BudgetEntryActivity(androidDriver);

		testIncomeEntry = testDataLoader.createNewIncomeEntry();
		testExpenseEntry = testDataLoader.createNewExpenseEntry();
		mainActivity.cleanUpSuggestions();
	}

	@Order(1)
	@Test
    @DisplayName("GIVEN user has data to create a new income WHEN user enters income data THEN a new income is created")
	public void createANewIncome() {
		mainActivity.clickBudgetButtonByBudgetType(testIncomeEntry.getType());
		createNewBudgetEntry(budgetEntryActivity, testIncomeEntry);
		mainActivity.cleanUpScreen();
	}

	@Order(2)
	@Test
	@DisplayName("GIVEN user has data to create a new expense WHEN user enters expense data THEN a new expense is created")
	public void createANewExpense() {
		mainActivity.clickBudgetButtonByBudgetType(testExpenseEntry.getType());
		createNewBudgetEntry(budgetEntryActivity, testExpenseEntry);
		mainActivity.cleanUpScreen();
	}

	@AfterAll
	static void tearDown(){
		mainActivity.quitActivity();
		androidDriver.removeApp();
		androidDriver.closeDriver();
	}
}
