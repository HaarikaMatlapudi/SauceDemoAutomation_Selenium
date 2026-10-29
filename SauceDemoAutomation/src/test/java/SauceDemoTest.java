import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoTest {
    public static void main(String args[]) {

        ChromeDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        String title=driver.getTitle();
        System.out.println("Page Title: "+title);
        driver.manage().window().maximize();

        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();

        // Locate the third product container and click on add to cart
        WebElement thirdElement= driver.findElement(By.xpath("(//div[@class='inventory_item'])[3]"));
        String product = thirdElement.findElement(By.className("inventory_item_name")).getText();
        wait.until(ExpectedConditions.elementToBeClickable(thirdElement.findElement(By.tagName("button")))).click();
        System.out.println(product + " is added to the cart");

        //Verify does the cart consists the product
        driver.findElement(By.className("shopping_cart_link")).click();
        System.out.println("Navigated to cart page");

        String productInserted=driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        System.out.println(productInserted + " is in the cart");

        //compare both the products
        if(product.equals(productInserted)){
            System.out.println("PASS: Correct product is present in the cart.");
        } else {
            System.out.println("FAIL: Product mismatch in the cart.");
        }

        //click the "Checkout" button.
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("checkout")))).click();

        //        Fill out the checkout form with the following:
        //        First Name: Test
        //        Last Name: User
        //        Zip Code: 12345
        //        Click "Continue."

        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("continue")))).click();

        System.out.println("Current URL: " + driver.getCurrentUrl());

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("finish")))).click();

        driver.quit();
    }
}
