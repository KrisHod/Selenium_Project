import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autocomplete {
    private DriverUtilities driverUtilities;
    private WebDriver driver;

    @Before
    public void setUp() {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }

    @Test
    public void test1() {
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("222 Cow Bay road, Eastern Passage, NS, CA");

        // Use WebDriverWait for explicit waiting
        WebDriverWait wait = new WebDriverWait(driver,10);  // Wait up to 10 seconds
        WebElement autocompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));
        autocompleteResult.click();

        driver.quit();
    }
}
