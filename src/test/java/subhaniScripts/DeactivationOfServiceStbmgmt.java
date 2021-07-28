package subhaniScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeactivationOfServiceStbmgmt {
	private WebDriver driver;
	// private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

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
	public void testUntitledTestCase() throws Exception {
		driver.get("http://192.168.1.16/ezybillreleases/1.4.13.2/rc1_JULY_08/app/");
		driver.findElement(By.id("uname")).sendKeys("ecd00040");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.id("proceed")).click();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search_stb"))));

		driver.findElement(By.id("search_stb")).sendKeys("24234234329");
		driver.findElement(By.xpath("//*[@type='image'][@id='SearchSTB']")).click();
		// boolean deactiveEnabled =
		// driver.findElement(By.xpath("//td[contains(text(),'Deactive')]")).isEnabled();
		String txt = driver.findElement(By.xpath("//td[1]")).getText();
		System.out.println(txt);
		// System.out.println("Button Status:"+deactiveEnabled);

		if (false) {
			System.out.println("STB is already Disabled");
		} else {
			if (driver.findElement(By.xpath("//*[@id='deactive']")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='deactive']")).click();
			} else {
				System.out.println("Moved to Else condition");

				Assert.assertFalse(true);
			}

			driver.findElement(By.id("deactivation_reason")).click();
			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search_stb"))));
			new Select(driver.findElement(By.id("deactivation_reason"))).selectByVisibleText("Non Payment");
			driver.findElement(By.id("deactivation_reason")).click();
			driver.findElement(By.id("remark_txt")).sendKeys("text not paid");
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=':'])[4]/following::span[1]"))
					.click();
			System.out.println(driver.findElement(By.className("alertify-dialog")).getText());
			driver.findElement(By.id("alertify-ok")).click();
			System.out.println(driver.findElement(By.className("alertify-dialog")).getText());
			driver.findElement(By.id("alertify-ok")).click();
		}

	}

	/*
	 * @AfterClass(alwaysRun = true) public void tearDown() throws Exception {
	 * driver.quit(); String verificationErrorString =
	 * verificationErrors.toString(); if (!"".equals(verificationErrorString)) {
	 * fail(verificationErrorString); }
	 */

	// }
}
