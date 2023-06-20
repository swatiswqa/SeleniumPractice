package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearch {

	WebDriver driver;

	public GoogleSearch(WebDriver driver)
	{
		this.driver = driver;
		driver = new ChromeDriver();
	}
	
//    @BeforeClass
//    public void setUp() {
//        // initialize the WebDriver instance here
//        driver = new ChromeDriver();
//    }

	By search = By.xpath("//textarea[@name='q']");
	By search_btn = By.xpath("//input[@value='Google Search'][1]");

	@Test
	public void keywordSearch(String test)
	{



		driver.findElement(search).click();
		driver.findElement(search).sendKeys(test);
		driver.findElement(search_btn).click();



	}

}


