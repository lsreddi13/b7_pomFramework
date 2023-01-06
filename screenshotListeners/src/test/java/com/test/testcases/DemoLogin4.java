package com.test.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoLogin4 {

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
		Thread.sleep(5000);
		login();

	}

	public void login() throws InterruptedException {
		String UserName = prop.getProperty("username");
		String Password = prop.getProperty("password");
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(UserName);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 10);

//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a//span[contains(text(), 'Dashboard')]")));
//																										Dashboard

		List<WebElement> li = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']//li"));

		List<String> exp_Tabs = new ArrayList<>(Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info",
				"Performance", "Dashboard", "Directory", "Maintenance", "Buzz"));

		List<String> act_Tabs = new ArrayList<>();
		for (WebElement we : li) {
			act_Tabs.add(we.getText());

		}
		Assert.assertEquals(act_Tabs, exp_Tabs);
		test23(li, "Admin"); // using reusable method.
		Thread.sleep(3000);
		// print table header
		List<WebElement> table_headers_list = driver.findElements(By.xpath("//div[@role=\"table\"]/div[1]/div/div"));
		System.out.println("headers size : " + table_headers_list.size());

		for (int i = 1; i < table_headers_list.size(); i++) {
			System.out.print(table_headers_list.get(i).getText() + " | " );
			
			
		}
		System.out.println(" ");

		List<WebElement> data_list = driver.findElements(By.xpath("//div[@role='table']/div[2]/div"));
		System.out.println(data_list.size());
		List<WebElement> data_row_list = driver.findElements(By.xpath("//div[@role='table']/div[2]/div[1]/div/div"));
		System.out.println(data_row_list.size());
		for (int i = 1; i < data_list.size(); i++) {

			for (int j = 1; j <6; j++) {

				String value = driver.findElement(By.xpath("//div[@role='table']/div[2]/div[" + i + "]/div/div[" + j + "]")).getText();
				System.out.print(value + " | ");

			}
			System.out.println(" ");
		}

//		
//		for (int i = 1; i < data_list.size(); i++) {
//
////			table_headers_list.get(i).getText();
//
////			System.out.print(data_list.get(i).getText() + "  |  ");
//		
//			List<WebElement> data_row_list = driver.findElements(By.xpath("//div[@role='table']/div["+i+"]/div[1]/div/div"));
//
//			
//			for(int j=1; j<data_row_list.size(); j++) {
//				System.out.print(data_row_list.get(j).getText() + " | ");
//				
//			}
//		}

//		select role

	}

	// click admin tab

	// click ADD

	// fill the form

	public void test23(List<WebElement> li, String tabName) {
		for (WebElement we : li) {
			if (we.getText().equalsIgnoreCase(tabName)) {
				we.click();
				break;
			}
		}
	}
}
