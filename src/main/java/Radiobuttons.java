import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Radiobuttons {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/radiobutton");
        
        //using ID
        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();
        
        //using value
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();
        
        //using XPath
        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/label"));
        radioButton3.click();
        

        driver.quit();
    }
}
