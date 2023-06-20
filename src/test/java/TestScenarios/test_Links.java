package TestScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.tabLinks;



public class test_Links {
	
	WebDriver driver;
	tabLinks lk;
	

@BeforeTest
 public void beforeTest() {
	
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/links");
		lk = new tabLinks(driver);
	}

@Test
public void newTab() throws InterruptedException {
	lk.newTab();
}

@AfterTest
public void teardown() {
	driver.quit();
}


}
