package TestScenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import Objects.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestElements {

	WebDriver driver;
	ElementsTab el;
	webTable wt;

	@BeforeClass
	public void beforetest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		el = new ElementsTab(driver);
		wt = new Objects.webTable(driver);
	}

	@Test
	public void test_textbox() throws InterruptedException 
	{
		Thread.sleep(2000);
		System.out.println(el.a);
		el.Text_box();

	}

	@Test
	public void testuAssertion() {
		
		System.out.print("assert block");

		el.verifydetails();
	}

	@Test
	public void Radiobox_test() {

		el.checkradiobox();
	}
	
	@Test
	public void webTable() throws InterruptedException {
		
		wt.add();
		wt.addDetails();
		Thread.sleep(3000);
		wt.searchDetails();

	}
	
	@Test
	public void webTable2() {
		
		wt.searchList();
		
		wt.update_details();
	}
	
	


	@AfterTest
	public void terminate() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}



}
