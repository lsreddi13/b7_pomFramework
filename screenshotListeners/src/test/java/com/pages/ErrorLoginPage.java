package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testcases.Base;

public class ErrorLoginPage extends Base{
	

	@FindBy(xpath = "//*[contains(text(), 'The password that you')]")
	WebElement errorText_ele;

	@FindBy(id = "email")
	WebElement emaiID_ele;

	@FindBy(id = "pass")
	WebElement password_ele;

	@FindBy(name = "login")
	WebElement loginBtn_ele;

	@FindBy(linkText = "Forgotten password?")
	WebElement forgotPasswordLink_ele;

	public ErrorLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String verifyError() {
		String error_Text = errorText_ele.getText();
		return error_Text;
	}
	
	
	public void enterPassword(String password) {
		password_ele.clear();
		password_ele.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn_ele.click();
	}
	
	
}
