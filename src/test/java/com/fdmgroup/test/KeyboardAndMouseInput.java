package com.fdmgroup.test;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fdmgroup.util.DriverUtilities;

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
        button.click();
        //driver.quit();
    }
}