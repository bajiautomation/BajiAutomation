package ezyBillV1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ezyBillV1.ListenerTest.class)
public class STBCreation001 {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		//########################  Driver In initialization  ############################
		
		  System.setProperty("webdriver.chrome.driver",
		  "E:\\2021\\SelWorkSpace\\BrokenLinksChecking\\Driver\\chromedriver.exe");
		  driver = new ChromeDriver();	 
		
			/*
			 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
			 */
		//############################## END ############################
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testUntitledTestCase() throws Exception {

		// Load Properties
		FileInputStream file = new FileInputStream("./Config/config.properties");
		Properties property = new Properties();
		property.load(file);
		String appURL = (String) (property.get("applicationURL"));
		String serialNum = (String) (property.get("serialNum"));
		String VCNum = (String) (property.get("vcNum"));
		driver.get(appURL);

		// driver.get("http://192.168.1.16/ezybillreleases/1.4.13.2/rc1_JUNE_24/app/");
		driver.findElement(By.id("uname")).sendKeys("ECD00040");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("proceed")).click();

		// Login Validation
		String expPageTitle = "Ezybill.net | Control Panel";
		String actPageTitle = driver.getTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);

		// Create STB
		driver.findElement(By.linkText("STB")).click();
		driver.findElement(By.linkText("Create STB/Edit STB")).click();
		driver.findElement(By.id("location")).click();
		new Select(driver.findElement(By.id("location"))).selectByVisibleText("HO");
		new Select(driver.findElement(By.id("supplier"))).selectByVisibleText("BUndle");
		new Select(driver.findElement(By.id("make"))).selectByVisibleText("Bundle");
		driver.findElement(By.id("make")).click();
		driver.findElement(By.id("model")).click();
		new Select(driver.findElement(By.id("model"))).selectByVisibleText("Bundle");
		driver.findElement(By.id("is_month")).click();
		new Select(driver.findElement(By.id("is_month"))).selectByVisibleText("Months");
		driver.findElement(By.id("period")).sendKeys("6");
		driver.findElement(By.name("inventory_item")).click();
		driver.findElement(By.id("sip")).click();
		new Select(driver.findElement(By.id("sip"))).selectByVisibleText("CONAX");
		driver.findElement(By.id("sip")).click();
		driver.findElement(By.id("stb_type")).click();
		new Select(driver.findElement(By.id("stb_type"))).selectByVisibleText("Normal");
		driver.findElement(By.id("stb_type")).click();
		driver.findElement(By.id("not_paired")).click();
		driver.findElement(By.name("inventory_item")).click();
		driver.findElement(By.id("create_individual")).click();
		driver.findElement(By.id("manual_serials")).sendKeys(serialNum);// Unique
		driver.findElement(By.id("manual_vcs")).sendKeys(VCNum); // Unique
		driver.findElement(By.id("filesave")).click();

		// Alert Handle
		handleAlert();

		// Validation to check the STB is created or not

		String actSTBConfirmation = driver
				.findElement(By.xpath(
						"//body/center[@id='my_id']/div[@id='wrapper']/div[@id='content-container']/div[2]/div[1]"))
				.getText();
		String expSTBConfirmation = "1 STB(s) Inserted !";

		Assert.assertEquals(actSTBConfirmation, expSTBConfirmation);
		System.out.println("STB Created Sucessfully");

	}

	/*
	 * @Test public void sampleTest() {
	 * System.out.println("I am a failed sample Test"); Assert.assertTrue(false);
	 * 
	 * }
	 */

	public void handleAlert() {
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}
	@AfterClass(alwaysRun = true)
	public void tearDown1() throws Exception {
		driver.quit();
		
	}
}
