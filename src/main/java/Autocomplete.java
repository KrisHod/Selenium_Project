import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Autocomplete {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/autocomplete");
        
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("222 Cow Bay road, Eastern Passage, NS, CA");
        
        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();
        
        driver.quit();
    }
}
