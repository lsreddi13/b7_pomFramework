package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testcases.Base;

public class LoginPage extends Base{
	

	@FindBy(xpath = "//*[contains(text(), 'Create New Account')]")
	WebElement createAccountButton_ele;

	@FindBy(id = "email")
	WebElement emaiID_ele;

	@FindBy(id = "pass")
	WebElement password_ele;

	@FindBy(name = "login")
	WebElement loginBtn_ele;

	@FindBy(linkText = "Forgotten password?")
	WebElement forgotPasswordLink_ele;

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void enterEmailID(String emailID) {
		emaiID_ele.clear();
		emaiID_ele.sendKeys(emailID);
	}
	
	
	public void enterPassword(String password) {
		password_ele.clear();
		password_ele.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn_ele.click();
	}
	
	public void clickCreateAccount() throws InterruptedException, IOException {
		Thread.sleep(3000);
		createAccountButton_ele.click();
//		return new CraeteAccountPage() ;
	}
}
