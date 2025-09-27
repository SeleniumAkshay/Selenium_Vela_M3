package com.ShoppersStack_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShoppersStack_POM.Home_Page;
import com.ShoppersStack_POM.Login_Page;
import com.ShoppersStack_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sDriver;
	public FileUtility fileUtility = new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriverWait wait;
	public WebDriverUtility webDriverUtility = new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite ---------- DataBase Connected");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest ----------- ExtentReports Started");
		spark = new ExtentSparkReporter(FrameWorkConstants.reportPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Demo");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass ----------- Browser Launched");

//		String browser = fileUtility.readDataFromPropertyFile("browserName");
//		String url = fileUtility.readDataFromPropertyFile("url");

		String browser = System.getProperty("browserName");
		String url = System.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(url);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("@BeforeMethod ---------- Login");
		welcomePage = new Welcome_Page(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(welcomePage.getLoginBtn()));
		Thread.sleep(3000);
		welcomePage.getLoginBtn().click();
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();
		homePage = new Home_Page(driver);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite --------- Disconnected To DataBase");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest ---------- ExtentReports Ended");
		reports.flush();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass ----------- Browser Closed");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod ------------ Logout");
		homePage.getAccountSettingsBtn().click();
		homePage.getLogOutBtn().click();
	}

}
