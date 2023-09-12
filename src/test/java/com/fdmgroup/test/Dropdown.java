package com.fdmgroup.test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fdmgroup.util.DriverUtilities;

public class Dropdown {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1() throws InterruptedException{

        driver.get("https://formy-project.herokuapp.com/dropdown");
        
        //driver.findElement(By.id("dropdownMenuButton")).click(); //By id
        //driver.findElement(By.xpath("//*[@id='dropdownMenuButton']")).click(); // By xpath
        //driver.findElement(By.xpath("//*[contains(@id,'dropdown')]")).click(); // contains(@attributeName, "attributeValue")
        driver.findElement(By.xpath("//*[starts-with(@id,'drop')]")).click(); // starts-with(@attributeName, "startingValue")
        
        
        driver.findElement(By.id("autocomplete")).click();
        
        Thread.sleep(1000);
        
        String actualText = driver.findElement(By.tagName("h1")).getText(); //By tag name
        System.out.println(actualText);
        assertEquals("Autocomplete", actualText);
        
        WebElement formLink = driver.findElement(By.linkText("Form")); //By link text
        formLink.click();
        
        Thread.sleep(1000);
        
        List<WebElement> list = driver.findElements(By.className("form-control"));
        for (WebElement webElement : list) {
        	System.out.println(webElement.getText());
		}
        
        //driver.quit();
    }
}
