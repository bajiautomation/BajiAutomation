package ezyBill_Selfcare;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditCustomer {
	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\2021\\SelWorkSpace\\BrokenLinksChecking\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.quit();
	}

	@Test
	public void testCustomerEdit() throws Exception {
		System.out.println("I am  in testCreateSTB method");

		driver.get("http://192.168.1.16/ezybillreleases/1.4.13.2/rc1_MAY_07/selfcare/");
		driver.findElement(By.xpath("//span[contains(text(),'Account Login')]")).click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("logintype"))).selectByVisibleText("Serial Number");

		driver.findElement(By.id("serialnumber")).sendKeys("1111111");
		driver.findElement(By.id("pass")).sendKeys("1234");
		driver.findElement(By.id("subbutton")).click();
		//System.out.println("Login Done....");

		// Login validation
		boolean homePageDsplayed = driver.findElement(By.linkText("Customer Edit")).isDisplayed();
		if (homePageDsplayed) {
			System.out.println("Login Sucessful");
		} else {
			System.out.println("Login Failed");
		}

		driver.findElement(By.linkText("Customer Edit")).click();
		driver.findElement(By.xpath("//table[@id='simpleEditableTable']/tbody/tr[3]")).click();
		driver.findElement(By.id("mobile_no")).click();
		driver.findElement(By.id("mobile_no")).clear();
		driver.findElement(By.id("mobile_no")).sendKeys("8545263566"); 
		driver.findElement(By.xpath("//table[@id='simpleEditableTable']/tbody/tr[4]")).click();
		driver.findElement(By.id("email_id")).click();
		driver.findElement(By.id("email_id")).clear();
		driver.findElement(By.id("email_id")).sendKeys("padmavathi1227@gmail.com");
		driver.findElement(By.id("editCustomer")).click();
		Thread.sleep(2000);
		String actMessage = driver.findElement(By.xpath("//*[@id='message_1']")).getText();
		String expMessage = "Customer details are edit successfully";
		Thread.sleep(2000);
		// Validate confirmation message
		Assert.assertEquals(actMessage, expMessage);
	}

}
