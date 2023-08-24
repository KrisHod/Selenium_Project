import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/switch-window");
        
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        
        String originHandle = driver.getWindowHandle();
        
        for(String handle1: driver.getWindowHandles()) {
        	driver.switchTo().window(handle1);
        }
        
        driver.switchTo().window(originHandle);
        
        driver.quit();
    }
}
