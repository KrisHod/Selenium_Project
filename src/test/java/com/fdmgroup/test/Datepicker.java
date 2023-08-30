package com.fdmgroup.test;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fdmgroup.util.DriverUtilities;

public class Datepicker {
	private DriverUtilities driverUtilities;

    private WebDriver driver;

    @Before
    public void setUp() {
    	driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }
    
    @Test
    public void test1(){

        driver.get("https://formy-project.herokuapp.com/datepicker");
        
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("03/03/2023");
        dateField.sendKeys(Keys.RETURN);
        
        driver.quit();
    }
}