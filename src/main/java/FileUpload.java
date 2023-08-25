import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class FileUpload {
    	private DriverUtilities driverUtilities;

        private WebDriver driver;

        @Before
        public void setUp() {
        	driverUtilities = DriverUtilities.getInstance();
            driver = driverUtilities.getDriver();
        }
        
        @Test
        public void test1(){

        driver.get("https://formy-project.herokuapp.com/fileupload");
        
        WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));
        fileUploadField.sendKeys("file-to -upload.docx");

        //driver.quit();
    }
}
