package ezyBillV2;

import static org.testng.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testUserCreation {
	private WebDriver driver;
	// private String baseUrl;
	// private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\2021\\SelWorkSpace\\BrokenLinksChecking\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get("http://192.168.1.16/ezybill_2.0/2021/june22/app/");
		driver.findElement(By.id("uname")).sendKeys("general");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("proceed")).click();
		Thread.sleep(5000);
		System.out.println("Login functionality Done....");

		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("Create User")).click();
		driver.findElement(By.id("firstname")).sendKeys("sruthi priyaa");
		driver.findElement(By.id("lastname")).sendKeys("tota");
		driver.findElement(By.id("year")).click();
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1980");
		driver.findElement(By.id("year")).click();
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("6");
		driver.findElement(By.id("month")).click();
		driver.findElement(By.id("date")).click();
		new Select(driver.findElement(By.id("date"))).selectByVisibleText("8");
		driver.findElement(By.id("date")).click();
		driver.findElement(By.id("ayear")).click();
		new Select(driver.findElement(By.id("ayear"))).selectByVisibleText("2016");
		driver.findElement(By.id("ayear")).click();
		new Select(driver.findElement(By.id("amonth"))).selectByVisibleText("6");
		driver.findElement(By.id("amonth")).click();
		driver.findElement(By.id("adate")).click();
		new Select(driver.findElement(By.id("adate"))).selectByVisibleText("11");
		driver.findElement(By.id("adate")).click();
		driver.findElement(By.id("city")).click();
		new Select(driver.findElement(By.id("city"))).selectByVisibleText("AAlocation");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("pin_code")).sendKeys("786543");
		driver.findElement(By.id("email")).sendKeys("sruthi122@gmail.com");
		driver.findElement(By.id("mobile_no")).click();
		driver.findElement(By.id("mobile_no")).clear();
		driver.findElement(By.id("mobile_no")).sendKeys("8899663322");
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys("warangal");
		new Select(driver.findElement(By.id("users_type"))).selectByVisibleText("LCO( BUSINESS PARTNER)");
		driver.findElement(By.id("users_type")).click();
		driver.findElement(By.id("business_name")).sendKeys("Sruthi_LCOTwo");//Unique
		driver.findElement(By.id("lco_code")).sendKeys("itp6197");
		driver.findElement(By.id("txtFolioNumber")).sendKeys("867676869"); //Unique
		new Select(driver.findElement(By.id("tax_paid_by"))).selectByVisibleText("MSO");
		driver.findElement(By.id("tax_paid_by")).click();
		driver.findElement(By.id("tax_numbers[1]")).sendKeys("536");
		driver.findElement(By.id("tax_numbers[2]")).sendKeys("4747");
		driver.findElement(By.id("tax_numbers[3]")).sendKeys("5225");
		driver.findElement(By.id("tax_numbers[4]")).sendKeys("644");
		driver.findElement(By.id("tax_numbers[5]")).sendKeys("4646");
		driver.findElement(By.id("tax_numbers[6]")).sendKeys("6464");
		driver.findElement(By.id("tax_numbers[7]")).sendKeys("533");
		driver.findElement(By.id("tax_numbers[8]")).sendKeys("6363");
		driver.findElement(By.id("tax_numbers[9]")).sendKeys("636363");
		driver.findElement(By.id("createEmployee")).click();
		// assertEquals(closeAlertAndGetItsText(), "User age should be greater than or
		// equal to 18 Yeras");
		driver.findElement(By.id("year")).click();
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1980");
		driver.findElement(By.id("year")).click();
		driver.findElement(By.id("createEmployee")).click();
		driver.findElement(By.id("alertify-ok")).click();
	}

	/*
	 * @AfterClass(alwaysRun = true) public void tearDown() throws Exception {
	 * driver.quit(); String verificationErrorString =
	 * verificationErrors.toString(); if (!"".equals(verificationErrorString)) {
	 * fail(verificationErrorString); } }
	 */

}
