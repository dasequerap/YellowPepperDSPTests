# **Exploratory test charts - Moneyfy app**

## 1. Test charter: functional tests on expenses management

 - **Description**: Explore adding  different categories with an Android emulator device to discover how moneyfy CRUD actions to manage expense.
 - **Areas**:
	- *OS*: Android 8.1.0
	- *Device*: Xiaomi Redmi
	 - *Screen*: Main Screen (Main activity of Moneyfy).
	 - Features:
		 - Add an income.
		 - Add an expense.
		 - Add multiple incomes with hamburger menu.
		 - Add multiple expenses available on main screen.
		 - Modify an income.
		 - Modify an expense.
		 - Delete an income.
		 - Delete an expense.
		 - Change view to expenses summary.
	- Strategy: Functional testing.
 - **Start**: 16/07/2021 - 3:00 P.M.
 - **Duration**: Normal.
 - **Test design and execution**: 45 minutes.
 - **Bug investigation and reporting**: 15 minutes.
 - **Session setup**: 10 minutes.
 - **Charter vs opportunity**: 80/20.
 - **Test Notes**: 
	I created an expenses account using different features available on main screen to check if accounting calculation is done through:
	 - Add a new income using "+" button.
	 - Add a new expense using "-" button.
	 - Add a new expense from random expense icons in main screen.
	 - Change to expenses summary menu.
	 - Modify an expense.
	 - Modify an income
	 - Delete an expense
	 - Delete an income
	 - Change payment type.
	The features tested when adding/modifying an income or expense were:
	 - Entering a value
	 - Calculating an addition, delete, multiply or divide.
	 - Select or change the category.
	 - Confirm the changes through "add" button.
	 - Canceling changes with "back". button.
	 
 - **Opportunities**:
	 - Random calculations on add/modify income/expense.
	 - Change from/to main screen to summary screen.
	 - Changing the date of the income / expense.
	 - Adding or modifying notes.
	 - Checking when adding a new expense from main menu, category was not changed.
	- Order incomes/expenses by value in summary screen.
	- Order incomes/expenses by date in summary screen.
 - **Risks**:
	 * Icons an buttons size can't be changed, denying people with visual disabilities to watch bigger icons.
	* Numeric values can't be entered with an external keyboard.
	* Presentation of the UI on different screens / resolutions.
	* Lack of more devices and Android versions.
	* There's no way to separate deposit type incomes from monthly incomes.
	* Navigation buttons are too small on high resolutions.
 - **Bugs**:
	* Bug #1: Percentage of expense entries is not updated on main screen.
	* Bug #2: Icons for expenses are not ordered by percentage.
	* Bug #3: Edit icon is not displayed when editing an income/expense.
	* Bug #4: Incomes/Expenses changes are saved when pressing system's "Back" button.
 - **Issues**:
	* What should be the behaviour of systems "Back" button"?.
	* It's no clear what is the ordering type the app applies when user presses "Order" button.
	* What should be the expense icons order on main screen after adding expenses.

## 2. Test charter: Non-functional tests
 - **Description**: Explore non-functional features on a real Android device to discover how moneyfy reacts to different device features.
 - **Areas**:
	 - OS: Android 8.1.0
	- Device: Xiaomi Redmi
	- *Screen*: Main Screen (Main activity of Moneyfy).	
	- Features:
		 * Lock / unlock screen.
		 * Gestures.
		 * Orientation (Vertical and forced horizontal).
		 * Temperature sensors.
		 * Keyboards (Android built-in and external).
		 * Movement sensors.
	- Strategy: Non functional mobile testing
 - **Start**:16/07/2021 - 4:10 P.M.
 - **Duration**: Short.
 - **Test design and execution**: 15 minutes.
 - **Bug investigation and reporting**: 10 minutes.
 - **Session setup**: 5 minutes.
 -  **Charter vs opportunity**: 80/20.
 - **Test Notes**:
	I tested device specific features to check if them don't affect the presentation and data on the app. Tests include:
	- Locking and unlocking the screen repeatedly while app was displayed.
	- Sending app to the background and opening again using navigation buttons.
	- Appling random gestures on main screen.
	- Forcing horizontal view using a 3rd party app.
	- Rotating the device.
	- Shacking the screen physically and using monkeytools.
	- Monitoring device temperature when app was opened ann running in background.
	- Using a physical and default touch keyboard provided by android os.
 - **Opportunities**:
	* Using divided screen feature.
	* Smoke test on battery levels.
	* Enabling network features "Wifi", "bluetooth" and, "Mobile".
 - **Risks**:
	* Presentation of the UI on different screens / resolutions.
	* Lack of more devices and Android versions.
	* Numeric values can't be entered with an external keyboard.
 - **Bugs**:
	* Bug #8: Hamburger "Settings" menu is  hidden on horizontal mode.
 - **Issues**:
	None

## 3. Test charter 3
 - **Description**:Explore changing settings on an Android emulator to discover what is the behaviour of moneyfy with each setting.
 - **Areas**:
	* OS: Android 8.1.0.
	* Device: Xiaomi Redmi.
	* Menu: Hamburger menu -> Settings.
	* Features:
		 - Balance.
		 - General settings.
		 - Data backup.
	* Strategy: Functional testing
 - **Start**: 16/07/2021 - 4:40 P.M.
 - **Duration**: Short.
 - **Test design and execution**: 15 minutes.
 - **Bug investigation and reporting**: 10 minutes.
 - **Session setup**: 5 minutes.
 - **Charter vs opportunity**: 100/0.
 - **Test Notes**:
I tested all features from "Settings" hamburger menu. To access all of them I tapped on hamburger menu, then on "Settings" menu on the right side of the screen. Tested features will not modify accounting or expenses. Following features were tested:
	  - Language.
	  - Budget mode.
	  - Currency.
	  - Carry over.
	  - Language.
	  - Application review.
	 - Export to file.
	 - First day of the week.
	 - First day of the month.
	 - About Moneyfy.
	 - Privact policy.
	 - Create data backup.
	 - Restore data.
 - **Opportunities**:
	None
 - **Risks**:
	* Navigation buttons are too small on high resolutions.
	* No warning message is displayed in order to avoid accidental changes.
 - **Bugs**:
	* Bug #9: Not all menus are translated when changing language.
	* Bug #10: Accounting is lost when changing any setting on "Settings" menu.
 - **Issues**:
	* Carry over menu doesn't show clearly how carry over is done.

## 4. Test charter 4
 - **Description**: Explore adding  different categories with an Android emulator device to discover how moneyfy CRUD actions to manage expense
 - **Areas**:
	* OS: Android 8.1.0
	* Device: Xiaomi Redmi
	* Menu: Hamburger menu -> Settings.
	* Features:
		 - Add expense category.
		 - Change currency name when adding income type.
		 - Add new currency.
		 - Synchronization.
		 - Dark mode.
	* Strategy: Functional testing
 - **Start**: 16/07/2021 - 5:10 P.M.
 - **Duration**: Short.
 - **Test design and execution**: 20 minutes.
 - **Bug investigation and reporting**: 5 minutes.
 - **Session setup**: 5 minutes.
 - **Charter vs opportunity**: 
 - **Test Notes**: 
I tested premium features to check if paywall was displayed with benefits of the premium version of the app. Actions taken included:
	* Change currency when adding or modifying an income or expense.
	* Adding a new expense categoryon "Category" menu.
	* Adding a new expense category on "Accounts" menu.
	* Adding a new currency on "Currency" menu.
	* On settings menu:
		 - Enabling dark theme.
		 - Adding passcode protection.
		 - Adding a synchronization on dropbox or google drive.
 - **Opportunities**:
	- Clicking on different options on "Paywall" menu".
	- Clicking on red button to check if payment process is started.
 - **Risks**:
	* Only system's back button can be used to return to main screen.
	* Premium featues list does not lead to a page with detailed feature explanation.
 - **Bugs**:
	* Bug #11: Back button is not displayed on "Paywall" screen.
 - **Issues**:
	 * It is difficult to know what are the premium features.
