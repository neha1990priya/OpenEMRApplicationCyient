package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;

public class LoginTest extends WebDriverWrapper {

	@Test
	public void invalidCredentialTest() {

		LoginPage login = new LoginPage(driver);
		login.sendUsername("admin123");
		login.sendPassword("pass123");
		login.selectLanaguageByText("English (Indian)");
		login.clickOnLogin();

		String actualValue = login.getErrorMessage();
		Assert.assertEquals(actualValue, "Invalid username or password"); // on not matching --abort and method will be
																			// resulted as failure
	}

	@Test
	public void validCredentialTest() {

		LoginPage login = new LoginPage(driver);
		login.sendUsername("admin");
		login.sendPassword("pass");
		login.selectLanaguageByText("English (Indian)");
		login.clickOnLogin();

		DashboardPage dashboard = new DashboardPage(driver);
		String actualValue = dashboard.getDashboardPageTitle();
		Assert.assertEquals(actualValue, "OpenEMR");
	}

	@Test
	public void validateUIComponentTest() {

		String actualDescription = driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
		Assert.assertEquals(actualDescription,
				"The most popular open-source Electronic Health Record and Medical Practice Management solution.");

		String actualAckText = driver.findElement(By.partialLinkText("Acknowledgments")).getText();
		Assert.assertEquals(actualAckText, "Acknowledgments, Licensing and Certification");

		String actualUsernamePlaceholderValue = driver.findElement(By.id("authUser")).getAttribute("placeholder");
		Assert.assertEquals(actualUsernamePlaceholderValue, "Username:");

		// password placeholder
		String actualPasswordPlaceholderValue = driver.findElement(By.id("clearPass")).getAttribute("placeholder");
		Assert.assertEquals(actualPasswordPlaceholderValue, "Password:");

		// default value should be English (Standard)
	}
}
