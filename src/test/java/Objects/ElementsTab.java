package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;

public class ElementsTab {

	WebDriver driver;


	public ElementsTab(WebDriver driver) {

		this.driver = driver;


	}


	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
	}

	By Eltab = By.xpath("//div[@class='header-text'][1]");
	By Textbox = By.xpath("//span[text()='Text Box']");
	By fullName = By.xpath("//input[@id='userName']");
	By email = By.xpath("//input[@id='userEmail']");
	By address = By.xpath("//textarea[@id='currentAddress']");
	By paddress = By.xpath("//textarea[@id='permanentAddress']");
	By submitbtn = By.xpath("//button[@id='submit']");
	public int a=10;

	@Test
	public void Text_box() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		driver.findElement(Eltab).click();
		driver.findElement(Textbox).click();
		driver.findElement(fullName).sendKeys("test data");
		driver.findElement(email).sendKeys("Test@email.com");
		driver.findElement(address).sendKeys("test current address");
		driver.findElement(paddress).sendKeys("test permanent address");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(submitbtn));
		driver.findElement(submitbtn).click();
	}

	@Test
	public void verifydetails() {

		SoftAssert softassert = new SoftAssert();

		// Compare the inserted and printed details
		String name = driver.findElement(fullName).getText();
		System.out.println(name);
		String vname = driver.findElement(By.xpath("//p[@id='name']")).getText().split(":")[1].trim();
		softassert.assertEquals(vname, name, "full name mismatched");
	}
	
	
	By noRadio = By.xpath("//input[@id='noRadio']");
	By Radioboxtab = By.xpath("//div[@class='header-text'][3]");

	@Test
	public void checkradiobox() {

         System.out.println("insside checkradioboc");
		driver.findElement(Radioboxtab).click();
		
//		driver.findElement(noRadio).click();


	}
}


