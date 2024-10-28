import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    WebDriver driver;

    @BeforeEach
    public void launchBrowser() {
        driver = new SafariDriver();
        driver.get("https://www.squareone.ca/");
        driver.manage().window().maximize();
    }

    @Test
    public void testHomeInsuranceLinkDisplay() {
        // Click on Home Insurance link
        driver.findElement(By.linkText("Home Insurance")).click();
        //Working exception example
        // String expectedTitle = "Not Affordable Home and Car Insurance | Square One";
        String expectedTitle = "Affordable Home and Car Insurance | Square One";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Page title does not match expected title for Home Insurance");
    }

    @Test
    public void testEmptyQuoteFormValidation() {
        // Click on Get a Quote button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.linkText("GET A QUOTE")).click();
        driver.findElement(By.name("address")).sendKeys("123 Main St");
        // Attempt to proceed without filling the form


        // Assuming there's an error message element for required fields
         }

    @Test
    public void testHomeInsuranceNavigation() {
        // Click on Home Insurance link and check title
        driver.findElement(By.linkText("Home Insurance")).click();
        assertTrue(driver.getTitle().contains("Home Insurance"), "Did not navigate to Home Insurance page");
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static void main(String[] args) {
        Main test = new Main();

        // Simulate JUnit lifecycle by calling methods manually
        try {
            test.launchBrowser();

            // Run tests
            test.testHomeInsuranceLinkDisplay();
            test.testEmptyQuoteFormValidation();
            test.testHomeInsuranceNavigation();

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
           test.closeBrowser();
        }
    }
}
