import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class KeyboardAndMouseInput {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/keypress");
        
        WebElement name = driver.findElement(By.id("name"));
        name.click();
        name.sendKeys("Kristina");
        
        WebElement button = driver.findElement(By.id("button"));

        driver.quit();
    }
}