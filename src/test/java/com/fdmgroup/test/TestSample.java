package com.fdmgroup.test;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fdmgroup.util.DriverUtilities;

public class TestSample {
	private DriverUtilities driverUtilities;

	private WebDriver driver;

	@Before
	public void setUp() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}

	@Test
	public void test1() throws IOException {
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		System.out.println("Title of browser is: " + driver.getTitle());
		System.out.println("URL is: " + driver.getCurrentUrl());
		// driver.navigate().to(null);
		driver.navigate().back(); // Navigation commands
		driver.navigate().forward();
		driver.navigate().refresh();
		
		System.out.println("Browser name : " + ((RemoteWebDriver)driver).getCapabilities().getBrowserName());
		System.out.println("Browser version : " + ((RemoteWebDriver)driver).getCapabilities().getBrowserVersion());
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileHandler.copy(srcFile, new File("C:\\Users\\Kris\\Desktop\\scrsht1.png"));

		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Now submit the form
		element.submit();
	}

	@After
	public void destroy() {
		driver.quit(); // close the entire browser
		//driver.close(); // close a specific tab in the browser

	}
}
