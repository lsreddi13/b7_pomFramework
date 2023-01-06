package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.testcases.Base;

public class CraeteAccountPage extends Base {

	@FindBy(name = "firstname")
	WebElement firstName_ele;

	@FindBy(name = "lastname")
	WebElement lastName_ele;

	public CraeteAccountPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String f_name) {

		firstName_ele.clear();
		firstName_ele.sendKeys(f_name);
	}

	public void enterLasttName(String l_name) {

		lastName_ele.clear();
		lastName_ele.sendKeys(l_name);
	}

}
