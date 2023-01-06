package com.test.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB2 {

	Properties prop;
	WebDriver driver;

	@Test
	public void testLogin() throws IOException, InterruptedException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//data.properties");
		prop.load(fis);
		String app_url = prop.getProperty("url");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(app_url);
		Thread.sleep(3000);
		clickCreateAccount();
		Thread.sleep(3000);
		enterFirstName();
		enterLastName();
		selectDOB("birthday_day", "13");
		selectDOB("birthday_month", "2");
		selectDOB("birthday_year", "1981");
		
		
	}

	public void clickCreateAccount() {
		driver.findElement(By.xpath("//*[contains(text(), 'Create New Account')]")).click();

	}

	public void enterFirstName() {
		driver.findElement(By.name("firstname")).sendKeys(prop.getProperty("f_name"));

	}

	public void enterLastName() {

		driver.findElement(By.name("lastname")).sendKeys(prop.getProperty("l_name"));

	}
	
	public void selectDOB(String listname, String val) {
		WebElement el = driver.findElement(By.name(listname));
		Select objSelect = new Select(el);
		objSelect.selectByValue(val);
	}

	
}
