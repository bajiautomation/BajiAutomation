package ezyBillV1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserCreation {
	private WebDriver driver;
	//private String baseUrl;
	//private boolean acceptNextAlert = true;
	//private StringBuffer verificationErrors = new StringBuffer();

	
	  @BeforeMethod(alwaysRun = true) public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver",
	  "E:\\2021\\SelWorkSpace\\BrokenLinksChecking\\Driver\\chromedriver.exe");
	  driver = new ChromeDriver(); 
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  }
	 
	 

	@Test
	public void testUserCreation() throws Exception {
		
		 driver.get("http://192.168.1.16/ezybillreleases/1.4.13.2/rc1_JUNE_28/app/");
		  driver.findElement(By.id("uname")).sendKeys("ecd00040");
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys("1234");
		  driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
		 
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("Create User")).click();
		driver.findElement(By.id("firstname")).sendKeys("Subhani");
		driver.findElement(By.id("lastname")).sendKeys("Shaik");
		driver.findElement(By.id("mobile_no")).sendKeys("5345345347"); // Unique
		driver.findElement(By.id("city")).click();
		new Select(driver.findElement(By.id("city"))).selectByVisibleText("Darsi");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("address1")).sendKeys("Srinagar colony");
		driver.findElement(By.id("pin_code")).sendKeys("353453");
		driver.findElement(By.id("email")).sendKeys("ki@gmail.com");
		driver.findElement(By.id("users_type")).click();
		new Select(driver.findElement(By.id("users_type"))).selectByVisibleText("LCO( BUSINESS PARTNER)");
		driver.findElement(By.id("users_type")).click();
		driver.findElement(By.id("business_name")).sendKeys("Subhani one comunications2");//Unique
		driver.findElement(By.id("lco_code")).clear();
		driver.findElement(By.id("lco_code")).sendKeys("sub1");//Unique
		driver.findElement(
				By.xpath("//div[@id='content-container']/div/div[3]/form/div/fieldset[7]/section[14]/label[2]/i"))
				.click();
		driver.findElement(By.id("tax_paid_by")).click();
		new Select(driver.findElement(By.id("tax_paid_by"))).selectByVisibleText("LCO");
		driver.findElement(By.id("tax_paid_by")).click();
		driver.findElement(By.id("distributors_subdistributor")).click();
		new Select(driver.findElement(By.id("distributors_subdistributor")))
				.selectByVisibleText("Shafi Comunications(Shafi)SUBDISTRIBUTOR");
		new Select(driver.findElement(By.name("tax_paid_by_subdistributor"))).selectByVisibleText("Yes");
		driver.findElement(By.name("tax_paid_by_subdistributor")).click();
		driver.findElement(By.name("tax_paid_by_distributor")).click();
		new Select(driver.findElement(By.name("tax_paid_by_distributor"))).selectByVisibleText("Yes");
		driver.findElement(By.name("tax_paid_by_distributor")).click();
		driver.findElement(By.id("createEmployee")).click();
		System.out.println(driver.findElement(By.id("alertify")).getText());
		driver.findElement(By.id("alertify")).click();
		driver.findElement(By.id("alertify-ok")).click();
	}

}
