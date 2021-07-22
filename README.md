# Home challenge - Yellowpepper

## 1. Overview
The main purpose of this document is to answer to different questions about Yellowpepper's home challenge.
## 2. Exploratory test charters
You can find test charters [HERE](https://github.com/dasequerap/YellowPepperDSPTests/blob/master/Test%20charters.md).

 ***1. Findings from your charters. Did everything work as expected? What bugs were
discovered?***
The application in general worked as the developer offered. Nonetheless, these bugs were found:
* Bug #1: Percentage of expense entries is not updated on main screen.
* Bug #2: Icons for expenses are not ordered by percentage.
* Bug #3: Edit icon is not displayed when editing an income/expense.
* Bug #4: Incomes/Expenses changes are saved when pressing system's ""Back"" button."
* Bug #5: Not all menus are translated when changing language.
* Bug #6: Accounting is lost when changing any setting on ""Settings"" menu."
* Bug #7: Back button is not displayed on "Paywall" screen.
* Bug #8: Hamburger "Settings" menu is  hidden on horizontal mode.

 ***2. Prioritization of those charters - which area of the app or testing would you
explore first and why? How much time have you planned to spend for each
charter?***

* The first area to explore is the expense management because it is the core feature od the app.
* About one hour.

 ***3. What kind of risks do you need to mitigate for this type of application?***
According to the test charters findings:

* Icons an buttons size can't be changed, denying people with visual disabilities to watch bigger icons.
* Numeric values can't be entered with an external keyboard.
* Presentation of the UI on different screens / resolutions.
* Lack of more devices and Android versions.
* Navigation buttons are too small on high resolutions.
* Only system's back button can be used to return to main screen.

## 3. Automated tests - MoneyFy app

 ***1. Ideas for testing***
 Proposed test cases include:
 - Create a new income.
 - Create a new expense.
 - Modify an income or expense.
 - Delete an income or expense.
In all these test cases, the accounting of the incomes and expenses is evaluated.
	 
 ***2. Proposed solution***
A project was created to check MoneyFy expense management. Tech stack includes Java, Appium, Maven and, Junit. Project structure has following parts:
 * Models: A representation of the different entities of the app. For this project, classes are created with test data directly on code.
 * Activites: Similar to the page object model, these classes interact directly with apps' activities. The activity classes interacts with differnet controls and fields to input and extract data for further comparisons.
 * Tests: Here is where the test cases are defined and run. Main purpose of the test cases are check the management of the expenses on the app and the calculations after adding, modifying and deleting a few of them.
 * 
 ***3. How to run test suite***
Please check README file of the project in this repository.
## 4. Automated tests - Swagger petstore

 ***1. Ideas for testing***
 * Test specific scenarios.
	* On user scenario:
		- Create a user.
		- Get information about an existing user.
		- Login with proper credentials.
		 - Logout.
	* On pet scenario
		- Get an existing pet id. 
		- Get a not existing pet by id .
		- Get pets by status.
		- Create a new pet. 
		- Update a pet.
	* Store:
		 - Get current inventory of pets.
		 - Create a purchase order.
		 - Get a created purchase order
		 - Get inventory of pets after placing a new order.
		 - Delete a purchase order.
		 - Get a not existent place order.
 * Out of scope due to lack of validations:
	 - Login with invalid credentials
	 
 ***2. Proposed solution***
A project was created to check basic features of Swagger pet store. Tech stack includes Java, RestAssured, Maven and, Junit. Project structure has following parts:
 * Models: A representation of the different entities of the pet store. This classes stores test data information from external sources.
 * Views: Similar to the page object model, these classes interact directly with the web service, setting up and making the requests.
 * Tests: Here is where the test cases are defined and run. Using models to represent test data and views to interact with petstore, the test suites execute all necessary validations.
 Each test suite test a group of features of the app.
 
 ***3. How to run test suite***
Please check README file of the project in this repository.
