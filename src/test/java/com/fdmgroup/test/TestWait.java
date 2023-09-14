package com.fdmgroup.test;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.util.DriverUtilities;

public class TestWait {
	private DriverUtilities driverUtilities;

	private WebDriver driver;

	@Before
	public void setUp() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void explicitWaitTest() {
		driver.manage().window().maximize();
		driver.get("http://google.com/");
		driver.findElement(By.name("q")).sendKeys("FDM Group" + Keys.ENTER);

		WebElement result = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText("Tech & Business"))));

		System.out.println(result.getText());
		result.click();
	}

}
