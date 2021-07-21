package models;

public class BudgetEntryModel {

	public enum BudgetEntryType {
		INCOME, EXPENSE
	}

	public enum PaymentType {
		CASH, PAYMENT_CARD
	}

	public enum Category {
		DEPOSIT ("Deposits"),
		SALARY  ("Salary"),
		SAVINGS ("Savings"),
		BILLS ("Bills"),
		CAR ("Car"),
		CLOTHES ("Clothes"),
		COMMUNICATIONS ("Communications"),
		EATING_OUT ("Eating out"),
		ENTERTAINMENT ("Entertainment"),
		FOOD ("Food"),
		GIFTS ("Gifts"),
		HEALTH ("Health"),
		PETS ("Pets"),
		SPORTS ("Sports"),
		TAXI ("Taxi"),
		TOILETRY ("Toiletry"),
		TRANSPORT ("Transport");

		private String category;

		Category(String category) {
			this.category = category;
		}

		 @Override
		public String toString(){ return this.category; }
	}

	private String date;
	private BudgetEntryType type;
	private PaymentType paymentType;
	private double value;
	private Category Category;
	private String notes;

	public BudgetEntryModel() { }

	public String getDate() { return date;	}

	public BudgetEntryType getType() { return type;	}

	public PaymentType getPaymentType() { return paymentType; }

	public double getValue() { return value; }

	public Category getCategory() { return Category; }

	public String getNotes() { return notes; }

	public void setDate(String date) { this.date = date; }

	public void setType(BudgetEntryType type) { this.type = type; }

	public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }

	public void setValue(double value) {	this.value = value;	}
	public void setCategory(Category category) { Category = category;	}

	public void setNotes(String notes) { this.notes = notes; }
}
