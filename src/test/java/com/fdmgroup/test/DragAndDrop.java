package com.fdmgroup.test;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fdmgroup.util.DriverUtilities;

public class DragAndDrop {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/dragdrop");
        
        WebElement image = driver.findElement(By.id("image"));
        
        WebElement box = driver.findElement(By.id("box"));
        
        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();

        driver.quit();
    }
}

