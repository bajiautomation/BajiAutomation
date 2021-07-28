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

public class CustomerCreation003 {
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
	public void testCustomerCreation() throws Exception {

		// Load Properties
		FileInputStream file = new FileInputStream("./Config/config.properties");
		Properties property = new Properties();
		property.load(file);
		String appURL = (String) (property.get("applicationURL"));
		String serialNum = (String) (property.get("serialNum"));
		String cafNum = ("CAF" + serialNum).toString();
		// System.out.println("CAF Number is:"+cafNum);
		// String VCNum = (String) (property.get("vcNum"));
		try {
			driver.get(appURL);

			// driver.get("http://192.168.1.16/ezybillreleases/1.4.13.2/rc1_JUNE_24/app/");
			driver.findElement(By.id("uname")).sendKeys("ECD00040");
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("proceed")).click();

			// Login Validation
			String expPageTitle = "Ezybill.net | Control Panel";
			String actPageTitle = driver.getTitle();
			Assert.assertEquals(actPageTitle, expPageTitle);

			driver.findElement(By.id("search_stb")).sendKeys(serialNum);

			driver.findElement(By.id("SearchSTB")).click();
			driver.findElement(By.xpath("//a[@id='search_link']/span[2]")).click();
			driver.navigate().refresh();
			System.out.println("Before CAF");
			driver.findElement(By.id("caf_no")).sendKeys(cafNum);

			// JavascriptExecutor js = (JavascriptExecutor)driver;
			// js.executeScript(actPageTitle, null)
			System.out.println("Before CAF");
			try {
				new Select(driver.findElement(By.id("cus_type"))).selectByVisibleText("test type");
				driver.findElement(By.id("First_Name")).sendKeys("ManamCAF");
				driver.findElement(By.id("Last_Name")).sendKeys("MLast");
				driver.findElement(By.xpath("//form[@id='create_customer']/div[2]/div[3]/div/fieldset")).click();
				driver.findElement(By.id("group")).click();
				new Select(driver.findElement(By.id("group"))).selectByVisibleText("jun01");
				new Select(driver.findElement(By.id("customersla"))).selectByVisibleText("STANDARD");
				driver.findElement(By.id("bill_type")).click();
				driver.findElement(By.id("city")).click();
				new Select(driver.findElement(By.id("state"))).selectByVisibleText("Telangana");
				new Select(driver.findElement(By.id("district"))).selectByVisibleText("Rangareddy");
				Thread.sleep(3000);
				new Select(driver.findElement(By.id("city"))).selectByVisibleText("hyderabad");
				driver.findElement(By.id("Pin_Code")).sendKeys("500050");
				driver.findElement(By.id("Address1")).sendKeys("Miyapur");
				driver.findElement(By.id("package_3")).click();
				driver.findElement(By.id("hidden_addCustomer")).click();
				// assertEquals(closeAlertAndGetItsText(), "Please select customer type.");
				/*
				 * driver.findElement(By.id("cus_type")).click(); new
				 * Select(driver.findElement(By.id("cus_type"))).selectByVisibleText("Residence"
				 * ); Thread.sleep(3000);
				 * driver.findElement(By.id("hidden_addCustomer")).click();
				 */

				Thread.sleep(3000);
				// Handling 1st pop-up

				if (driver.findElement(By.id("alertify-ok")).isDisplayed()) {
					System.out.println(
							"Alert Message1 :" + driver.findElement(By.className("alertify-dialog")).getText());
					driver.findElement(By.id("alertify-ok")).click();
					Thread.sleep(3000);
				} else {
					System.out.println("Customer creation failed");
				}

				// Handling 2nd pop-up if
				if (driver.findElement(By.id("alertify-ok")).isDisplayed()) {
					System.out.println(
							"Alert Message2 :" + driver.findElement(By.className("alertify-message")).getText());
					driver.findElement(By.id("alertify-ok")).click();
					Thread.sleep(3000);
				}

				Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println(e);
			}

			// alertify-ok
		} catch (Exception e) {
			// e.getStackTrace();

			System.out.println("Object:" + e);
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
