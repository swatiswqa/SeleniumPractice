package TestScenarios;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Objects.GoogleSearch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods2 {


	WebDriver driver;

	GoogleSearch page;

	@BeforeTest
	public void beforetest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		driver.get("https://google.com/");
		
		page = new GoogleSearch(driver);
	}

	@Test
	public void test_keywords() {
		// TODO Auto-generated method stub

		page.keywordSearch("demoqa");

	}

	@AfterTest
	public void AfterTest()
	{
		driver.quit();
	}



}
