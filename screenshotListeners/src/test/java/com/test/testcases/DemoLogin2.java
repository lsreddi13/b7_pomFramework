package com.test.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoLogin2 {

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
		String UserName = prop.getProperty("username");
		String Password = prop.getProperty("password");
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(UserName);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	
	@Test
	public void testLogin2() throws IOException, InterruptedException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//data.properties");
		prop.load(fis);
		String app_url = prop.getProperty("url");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(app_url);
		Thread.sleep(3000);
		String UserName = prop.getProperty("username1");
		String Password = prop.getProperty("password1");
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(UserName);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	

}
