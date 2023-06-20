package TestScenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Objects.buttons_Functions;

public class test_button {

	WebDriver driver;
	buttons_Functions btn;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
 public void beforeTest() {
	
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		btn = new buttons_Functions(driver);
	}
	
	
	@Test
	public void test_doubleClick() {
		
		btn.double_Click();
		
		 WebElement msg = driver.findElement(By.id("doubleClickMessage"));
		 String Actual = msg.getText();
		softAssert.assertEquals(Actual, "You have done a double click", "message not matching");
		softAssert.assertAll();
	}
	
	@Test
	public void test_rightClick() {
		
		btn.right_Click();
		 WebElement msg = driver.findElement(By.id("rightClickMessage"));
		String Actual = msg.getText();
		softAssert.assertEquals(Actual, "You have done a right click", "message not matching");
		softAssert.assertAll();
	}
	
	@Test
	public void test_click() throws InterruptedException {
		Thread.sleep(5000);
		btn.click();
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		
        Thread.sleep(5000);  
		driver.quit();
	}
	
	
	
}
