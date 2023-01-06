package com.test.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.CraeteAccountPage;
import com.pages.ErrorLoginPage;
import com.pages.LoginPage;

public class FB_1 extends Base {
	LoginPage LP;
	CraeteAccountPage CAP;
	ErrorLoginPage ELP;

	public FB_1() throws IOException {
		super();

	}

	

	@Test(enabled = false, priority = 1, dataProvider = "fb_loginData")
	public void testCreateAccount(String firstNameValue, String lastNameValue, String t1)
			throws IOException, InterruptedException {

		Thread.sleep(3000);
		driver.navigate().to("https://www.facebook.com/");
		LP = new LoginPage();

		// click create account
		LP.clickCreateAccount();
		CAP = new CraeteAccountPage();
		Thread.sleep(3000);
		CAP.enterFirstName(firstNameValue);
		CAP.enterLasttName(lastNameValue);

	}
	
	@Test(enabled = true, priority = 1, dataProvider = "getXlsFileData")
	public void testCreateAccountsXLSDATA(String firstNameValue, String lastNameValue)
			throws IOException, InterruptedException {

		Thread.sleep(3000);
		driver.navigate().to("https://www.facebook.com/");
		LP = new LoginPage();

		// click create account
		LP.clickCreateAccount();
		CAP = new CraeteAccountPage();
		Thread.sleep(3000);
		CAP.enterFirstName(firstNameValue);
		CAP.enterLasttName(lastNameValue);

	}

	@DataProvider(name = "getXlsFileData")
	public Object[][] readDataFromXLS() throws EncryptedDocumentException, IOException {

		Object[][] str3 = getData();

		return str3;
	}

	@DataProvider(name = "fb_loginData")
	public Object[][] createData1() {

		Object[][] str3 = { { "ram1", "ram2", "ram3" }, { "sasi1", "sasi2", "sasi3" },
				{ "ssi123", "sasi234", "sasi456" } };

		return str3;
	}
}
