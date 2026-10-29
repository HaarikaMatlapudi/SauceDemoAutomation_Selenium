# SauceDemo UI Automation Assignment

## 1. Problem Statement

Automate the end-to-end shopping workflow of the SauceDemo web application using Selenium WebDriver and Java.

The assignment involves logging into the application with valid credentials, selecting the third product from the inventory, adding it to the cart, verifying that the correct product is present, and completing the checkout process.

The automation script should use explicit waits to handle dynamic page loading and ensure that elements are visible or clickable before performing actions.

**Application URL:** https://www.saucedemo.com/

## 2. Objectives

* Automate the login functionality using valid credentials.
* Select the third product from the inventory page.
* Add the selected product to the shopping cart.
* Verify that the product added to the cart matches the selected product.
* Complete the checkout process by entering customer information.
* Verify successful order completion.
* Implement explicit waits to improve synchronization and reduce timing-related failures.

## 3. Test Scenario

| Step | Action                                       | Expected Result                            |
| ---- | -------------------------------------------- | ------------------------------------------ |
| 1    | Launch the SauceDemo application             | Login page is displayed                    |
| 2    | Verify the page title                        | Page title is `Swag Labs`                  |
| 3    | Enter valid login credentials                | Credentials are entered successfully       |
| 4    | Click the Login button                       | Inventory page is displayed                |
| 5    | Select the third product                     | Product name is captured                   |
| 6    | Click Add to Cart                            | Product is added to the cart               |
| 7    | Open the shopping cart                       | Cart page is displayed                     |
| 8    | Verify the cart item                         | Product matches the selected item          |
| 9    | Click Checkout                               | Checkout information page is displayed     |
| 10   | Enter first name, last name, and postal code | Customer information is entered            |
| 11   | Click Continue                               | Checkout overview page is displayed        |
| 12   | Click Finish                                 | Order completion page is displayed         |
| 13   | Verify the confirmation message              | Successful order confirmation is displayed |

## 4. Technologies Used

* **Programming Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Browser:** Google Chrome
* **IDE:** IntelliJ IDEA
* **Wait Mechanism:** Selenium WebDriverWait and ExpectedConditions

## 5. Test Data

| Field             | Value                          |
| ----------------- | ------------------------------ |
| Application URL   | `https://www.saucedemo.com/`   |
| Username          | `standard_user`                |
| Password          | `secret_sauce`                 |
| Product Selection | Third product in the inventory |
| First Name        | `Test`                         |
| Last Name         | `User`                         |
| Postal Code       | `12345`                        |

*Note: These credentials and test values are for the SauceDemo practice application.*

## 6. Key Implementation Details

### Explicit Waits

The script uses `WebDriverWait` with `ExpectedConditions` to wait for elements to meet specific conditions before interacting with them.

Examples include:

* `visibilityOfElementLocated()` to wait for input fields and page elements to become visible.
* `elementToBeClickable()` to wait for buttons and links to become clickable.

The maximum wait time is configured as 10 seconds. Selenium proceeds as soon as the required condition is satisfied.

### Product Verification

The script captures the name of the third product before adding it to the cart. After navigating to the cart, it retrieves the product name and compares both values.

If the names match, the script prints a PASS message. Otherwise, it prints a FAIL message.

### Checkout Verification

After clicking the Finish button, the script waits for the order confirmation element to appear and prints the confirmation message.

This verifies that the checkout workflow reached the order completion page.

## 7. Prerequisites

Before running the automation script, ensure that the following are installed and configured:

* Java Development Kit (JDK)
* IntelliJ IDEA
* Google Chrome browser
* Selenium WebDriver dependency in the project
* A compatible ChromeDriver setup

The project must include the Selenium Java library in its dependencies. If using Maven, configure Selenium in the `pom.xml` file.

## 8. How to Execute

1. Open the project in IntelliJ IDEA.
2. Verify that Java and Selenium dependencies are configured.
3. Open the `SauceDemoTest.java` file.
4. Ensure the browser and driver setup is compatible with your installed Chrome version.
5. Run the `main()` method.
6. Observe the browser actions and console output.
7. Verify that the script completes checkout and displays the order confirmation message.

## 9. Expected Results

The automation script should:

* Launch the SauceDemo application.
* Log in successfully.
* Select the third inventory product and add it to the cart.
* Verify that the selected product matches the cart item.
* Enter the checkout information.
* Complete the checkout process.
* Display the order confirmation message.
* Close the browser after execution.

## 10. Important Notes

* Explicit waits are used to synchronize browser interactions with page loading and element states.
* The script uses valid test credentials provided by the SauceDemo practice application.
* Product verification is performed by comparing the product names before and after adding the item to the cart.
* The script prints PASS or FAIL for the product comparison. These messages are console checks, not a formal test framework report.
* The browser is closed using `driver.quit()` after the workflow completes.
* If an element is not found or a wait condition is not met within the configured timeout, execution may fail with a Selenium exception.

## 11. Conclusion

This assignment demonstrates the automation of a complete e-commerce shopping workflow using Java and Selenium WebDriver. It covers browser interaction, login automation, product selection, cart verification, checkout processing, explicit waits, and order confirmation.
