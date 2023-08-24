import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestSample  {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form
        element.submit();

        //Close the browser
        driver.quit();
  
}
    }


