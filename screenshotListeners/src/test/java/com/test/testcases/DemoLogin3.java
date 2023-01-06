package com.test.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoLogin3 {

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
		login2("sandeep", "sandeep123");
		Thread.sleep(3000);
		login2("Ajaz", "Ajaz123");
		
	}

	public void login() {
		String UserName = prop.getProperty("username");
		String Password = prop.getProperty("password");
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(UserName);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}
	
	public void login2(String uname, String pwd) {
		
		WebElement uName_input_ele = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		
		uName_input_ele.clear();
		uName_input_ele.sendKeys(uname);
		
		
		driver.findElement(By.cssSelector("input[type='password']")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
//		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

}
