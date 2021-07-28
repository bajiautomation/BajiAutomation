package ezyBillV1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class STBTransfer002 {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\2021\\SelWorkSpace\\BrokenLinksChecking\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSTBTransfer02() throws Exception {

		// Load Properties
		FileInputStream file = new FileInputStream("./Config/config.properties");
		Properties property = new Properties();
		property.load(file);
		String appURL = (String) (property.get("applicationURL"));
		String serialNum = (String) (property.get("serialNum"));
		// String VCNum = (String) (property.get("vcNum"));
		driver.get(appURL);

		// driver.get("http://192.168.1.16/ezybillreleases/1.4.13.2/rc1_JUNE_24/app/");
		driver.findElement(By.id("uname")).sendKeys("ECD00040");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("proceed")).click();

		// Login Validation
		String expPageTitle = "Ezybill.net | Control Panel";
		String actPageTitle = driver.getTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);

		// Transfer STB
		driver.findElement(By.linkText("STB")).click();
		driver.findElement(By.linkText("Transfer STB")).click();
		driver.findElement(By.id("transfer_Type")).click();
		driver.findElement(By.id("sip")).click();
		new Select(driver.findElement(By.id("sip"))).selectByVisibleText("CONAX");
		driver.findElement(By.id("selSourceUser")).click();
		new Select(driver.findElement(By.id("selSourceUser"))).selectByVisibleText("MSO");
		driver.findElement(By.id("stock_location")).click();
		new Select(driver.findElement(By.id("stock_location"))).selectByVisibleText("HO");
		driver.findElement(By.name("serial[]")).sendKeys(serialNum);
		driver.findElement(By.xpath("//form[@id='myForm']/table/tbody/tr[4]/td")).click();
		driver.findElement(By.id("selDestinationUser")).click();
		new Select(driver.findElement(By.id("selDestinationUser"))).selectByVisibleText("Business Partner(LCO)");
		driver.findElement(By.id("destEmployeeCode")).sendKeys("itpjundjunsjunl");
		driver.findElement(By.id("dest_generic_search")).click();
		driver.findElement(By.id("remarks")).sendKeys("STB Transfer Automation Katalon Recorder");
		Thread.sleep(3000);
		driver.findElement(By.id("single_transfer")).click();
		Thread.sleep(3000);
		//Accept Alert
		driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
		System.out.println("After Click");
		
		//Validation required to place below......
		boolean blnResult =driver.findElement(By.xpath("//div[contains(text(),'transferred successfully')]")).isDisplayed();
				
		if(blnResult=true)
		{
			System.out.println("STB transffered sucessfully - PASS");
		}
		else
		{
			System.out.println("STB transfer not sucessful - FAIL");
		}
		
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
