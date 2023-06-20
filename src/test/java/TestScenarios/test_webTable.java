package TestScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.webTable;

public class test_webTable {
	
	WebDriver driver;
	webTable wt;
	
	@BeforeTest
 public void beforeTest() {
	
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		wt = new webTable(driver);
		
}
	
	@Test
	public void test_add() throws InterruptedException {
		
		wt.add();
		wt.addDetails();
		wt.searchDetails();
		wt.searchList();
		wt.update_details();
		
	}
	
	@AfterTest
	public void terminate() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}