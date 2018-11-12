package TestProject.OnlineProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cart {

	WebDriver driver;
	
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void initialize()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//driver/geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://store.demoqa.com/");
		
	}
	
	@AfterMethod(enabled=true)
	
	public void end()
	{
		driver.close();
		//driver.quit();
	}
		

	
	@Test(priority=3, enabled=false)
	public void selectItem() throws InterruptedException
	{
		Actions act = new Actions(driver);
		WebElement ee = driver.findElement(By.linkText("Product Category"));
		act.moveToElement(ee).build().perform();
		WebElement eee = driver.findElement(By.linkText("iPhones"));
		eee.click();
		
		driver.findElement(By.xpath("//div[@id='imagecol_98']/following-sibling::div/form/div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("header_cart")).click();
		
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
	}

	@Test(priority=2, enabled=false)
	
	public void loginval() throws InterruptedException
	{
		WebElement ele = driver.findElement(By.partialLinkText("My Account"));
		ele.click();
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='log']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='pwd']"));
		
		uname.sendKeys("Amit2052");
		Thread.sleep(5000);
		pass.sendKeys("Amit_2052");
		Thread.sleep(5000);
		driver.findElement(By.id("login")).click();
	}
	
	
	@Test(priority=5)
	
	public void finalcheckout() throws InterruptedException
	{
		loginval();
		selectItem();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(".//*[@id='current_country']/option[5]")).click();
		
		Thread.sleep(4000);
		
		
//		wait = new WebDriverWait(driver, 9000);
//		Select sct = new Select(driver.findElement(By.xpath("//select[@id='current_country']")));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id='current_country']")))).click();
//		sct.selectByVisibleText("India");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uniform-current_country']//following::input[1]"))).sendKeys("Bihar");
		//Thread.sleep(4000);
		//driver.get("http://store.demoqa.com/products-page/checkout/");
		
		//
		//sct.selectByVisibleText("India");	
		
	    //wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//select[@id='current_country']"))));
		//sct.selectByVisibleText("India");
	}
	
	
}
