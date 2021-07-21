package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import models.BudgetEntryModel;
import models.BudgetEntryModel.BudgetEntryType;
import models.BudgetEntryModel.PaymentType;
import models.BudgetEntryModel.Category;

public class TestDataLoader {

    private final String ordersTestData = "src/resources/orders.csv";

    public TestDataLoader(){}

    public BudgetEntryModel createNewIncomeEntry(){
        BudgetEntryModel testBudgetEntry = new BudgetEntryModel();
        testBudgetEntry.setDate("06/20/2021");
        testBudgetEntry.setType(BudgetEntryType.INCOME);
        testBudgetEntry.setPaymentType(PaymentType.CASH);
        testBudgetEntry.setValue(123456789.52);
        testBudgetEntry.setCategory(Category.DEPOSIT);
        testBudgetEntry.setNotes("Test income 1");
        return testBudgetEntry;
    }

    public BudgetEntryModel createNewExpenseEntry(){
        BudgetEntryModel testBudgetEntry = new BudgetEntryModel();
        testBudgetEntry.setDate("04/20/2021");
        testBudgetEntry.setType(BudgetEntryType.EXPENSE);
        testBudgetEntry.setPaymentType(PaymentType.CASH);
        testBudgetEntry.setValue(20.34);
        testBudgetEntry.setCategory(Category.BILLS);
        testBudgetEntry.setNotes("Test expense 1");
        return testBudgetEntry;
    }

}