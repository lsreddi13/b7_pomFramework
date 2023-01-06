package com.test.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;
import com.pages.ErrorLoginPage;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Local;

public class Base {
	public static WebDriver driver;
	Properties prop;

	public Base() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//data.properties");
		prop.load(fis);
	}

	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterMethod
	public void methodTestCompletd(ITestResult result) throws IOException {
		
		int s = result.getStatus();
		System.out.println(s);
		takeScreenshot(result);
	}
	
	public static String dateFormat() {
		DateTimeFormatter today = DateTimeFormatter.ofPattern("YYYY_MM_DD-hh_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return today.format(now);
		
	}
	 public static void takeScreenshot(ITestResult result) throws IOException{
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String currentDir = System.getProperty("user.dir");
		 Files.copy(srcFile, new File(currentDir+"/Screenshots/"+result.getName()+"_"+dateFormat()+".png"));
	 }
	@BeforeClass
	public void testSuite() throws InterruptedException, IOException {
		String app_url = prop.getProperty("url");
		setUp();
		driver.get(app_url);
		Thread.sleep(3000);

		LoginPage LP = new LoginPage();
		// enter username
		LP.enterEmailID(prop.getProperty("email1"));
		LP.enterPassword(prop.getProperty("pass1"));
		LP.clickLogin();
		Thread.sleep(5000);
		// capture error message
		ErrorLoginPage ELP = new ErrorLoginPage();
		String error_message = ELP.verifyError();
		System.out.println("print displayed error : " + error_message);
	}

	public static Object[][] getData() throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(".\\src\\test\\java\\testdata\\logintestdata.xlsx");

		Workbook book = WorkbookFactory.create(file);

		Sheet sheet = book.getSheet("login");

		System.out.println("Number of rows : " + sheet.getLastRowNum());

		System.out.println("Number of Columns : " + sheet.getRow(0).getLastCellNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				System.out.println(sheet.getRow(i + 1).getCell(j).toString());

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

			}
			System.out.println("++++++++++++");

		}
		return data;

	}

}
