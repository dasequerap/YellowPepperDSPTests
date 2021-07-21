package helpers;

import models.BudgetEntryModel;
import models.BudgetEntryModel.BudgetEntryType;
import models.BudgetEntryModel.PaymentType;
import models.BudgetEntryModel.Category;

public class TestDataLoader {

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