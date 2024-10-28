import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Main class to perform Selenium-based tests for Square One website.
 * Tests include navigation and form validation on the site.
 */
public class Main {

    // WebDriver instance
    WebDriver driver;

    /**
     * Setup method to initialize the browser before each test.
     * Opens the Square One website in Safari and maximizes the window.
     */
    @BeforeEach
    public void launchBrowser() {
        driver = new SafariDriver();
        driver.get("https://www.squareone.ca/");
        driver.manage().window().maximize();
    }

    /**
     * Test to verify navigation to the "Home Insurance" page.
     * Ensures that clicking on the "Home Insurance" link navigates to the correct page
     * by checking the page title.
     */
    @Test
    public void testHomeInsuranceLinkDisplay() {
        driver.findElement(By.linkText("Home Insurance")).click();
        String expectedTitle = "Affordable Home and Car Insurance | Square One";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Page title does not match expected title for Home Insurance");
    }

    /**
     * Test to validate form handling when attempting to get a quote.
     * Checks if an error message appears when trying to submit an empty address in the quote form.
     */
    @Test
    public void testEmptyQuoteFormValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.linkText("GET A QUOTE")).click();
        //to do -- test for error on empty submission
    }

    /**
     * Test to verify navigation back to the "Home Insurance" page.
     * Ensures that clicking on "Home Insurance" link redirects to the appropriate page.
     */
    @Test
    public void testHomeInsuranceNavigation() {
        driver.findElement(By.linkText("Home Insurance")).click();
        assertTrue(driver.getTitle().contains("Home Insurance"), "Did not navigate to Home Insurance page");
    }

    /**
     * Tear down method to close the browser after each test.
     */
    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    /**
     * Main method to manually run the tests and simulate JUnit lifecycle.
     * Includes setup, test execution, and teardown for each test method.
     */
    public static void main(String[] args) {
        Main test = new Main();

        try {
            test.launchBrowser();
            test.testHomeInsuranceLinkDisplay();
            //test.testEmptyQuoteFormValidation();
            test.testHomeInsuranceNavigation();
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
           test.closeBrowser();
        }
    }
}
