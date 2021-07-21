package tests;

import activities.budgetEntryActivity.BudgetEntryActivity;
import helpers.AndroidDeviceDriver;
import helpers.TestDataLoader;
import models.BudgetEntryModel;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class BaseTests {

    static AndroidDeviceDriver androidDriver = null;
    static TestDataLoader testDataLoader;

    BaseTests(){

    }

    static void init() throws UnsupportedEncodingException, MalformedURLException {
        androidDriver = new AndroidDeviceDriver();
        testDataLoader = new TestDataLoader();
        androidDriver.initDriver();
    }

    static void createNewBudgetEntry(BudgetEntryActivity budgetEntryActivity, BudgetEntryModel budgetEntryModel){
        budgetEntryActivity.setDateWithString(budgetEntryModel.getDate());
        budgetEntryActivity.setNotes(budgetEntryModel.getNotes());
        budgetEntryActivity.selectPaymentType(budgetEntryModel.getPaymentType());
        budgetEntryActivity.setValue(budgetEntryModel.getValue());
        budgetEntryActivity.chooseCategory(budgetEntryModel.getCategory());
    }

}
