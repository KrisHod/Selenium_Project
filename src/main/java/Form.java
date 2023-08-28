import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Form {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/form");
        
        submitForm(driver);
        
        waitForAlertBanner(driver);
        
        assertEquals("The form was successfully submitted!", getAlertBannerText(driver));
        driver.quit();
    }
    
    public static void submitForm(WebDriver driver) {
    	driver.findElement(By.id("first-name")).sendKeys("John");

        driver.findElement(By.id("last-name")).sendKeys("Doe");

        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");

        driver.findElement(By.id("radio-button-2")).click();

        driver.findElement(By.id("checkbox-2")).click();

        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("05/28/2024");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
    
    public static void waitForAlertBanner(WebDriver driver) {
    	 WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
    }
    
    public static String getAlertBannerText(WebDriver driver) {
    	return driver.findElement(By.className("alert")).getText();
     }
}
