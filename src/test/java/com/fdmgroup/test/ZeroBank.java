package com.fdmgroup.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.fdmgroup.util.DriverUtilities;

public class ZeroBank {
	private DriverUtilities driverUtilities;

	private WebDriver driver;

	@Before
	public void setUp() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}

	@Test
	public void testLoginFunctionality() {
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
		WebElement signInButton = driver.findElement(By.xpath("//*[contains(@id, 'signin')]"));
		if (signInButton.isDisplayed()) {
			signInButton.click();
		}

		String actualLoginPageHeader = driver.findElement(By.tagName("h3")).getText();
		assertEquals("Log in to ZeroBank", actualLoginPageHeader);

		driver.findElement(By.xpath("//*[contains(@id,'_login')]")).sendKeys("username");
		driver.findElement(By.xpath("//*[contains(@id,'_password')]")).sendKeys("password");
		
		WebElement rememberMeCheckBox = driver.findElement(By.id("user_remember_me"));
		if(!rememberMeCheckBox.isSelected()) {
			rememberMeCheckBox.click();
		}
		
		WebElement submitButton = driver.findElement(By.xpath("//*[contains(@value,'Sign in')]"));
		//submitButton.click(); //mouse event
		//submitButton.sendKeys(Keys.ENTER); //keyboard event
		submitButton.submit(); //submit form
		
		driver.navigate().back();

		driver.findElement(By.xpath("//*[contains(@id,'onlineBanking')]")).click();
		driver.findElement(By.id("pay_bills_link")).click();
		
		WebElement payeeDropDown = driver.findElement(By.name("payee"));
		Select selectedPayeeDropDown = new Select(payeeDropDown);
		List<WebElement> listOfOptions = selectedPayeeDropDown.getOptions();
		for (WebElement element : listOfOptions) {
			System.out.println(element.getText());
		}
		
		selectedPayeeDropDown.selectByIndex(2);
		selectedPayeeDropDown.selectByValue("sprint");
		
		WebElement usernameLabel = driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a"));
		String actualUsername = usernameLabel.getText();
		assertEquals("username", actualUsername);
		usernameLabel.click();
		
		WebElement myProfileLabel = driver.findElement(By.xpath("//*[contains(@id,'settingsBox')]"));
		System.out.println("My profile link is enabled: " + myProfileLabel.isEnabled());

		WebElement logOutLink = driver.findElement(By.linkText("Logout"));
		if (logOutLink.isEnabled()) {
			logOutLink.click();
		}

	}

	@After
	public void destroy() {
		driver.quit();
	}
}
