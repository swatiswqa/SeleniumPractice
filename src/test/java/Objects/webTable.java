package Objects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Test
public class webTable {

	WebDriver driver;
	WebDriverWait wait;
	
	public webTable(WebDriver driver) {

		this.driver = driver;
		


	}


//	@BeforeTest
//	public void setup() {
//		driver = new ChromeDriver();
//	
//	}

	By webTab =By.xpath("//*[@class='menu-list']//descendant::li[4]");
	By add = By.id("addNewRecordButton");
	By firstname =By.xpath("//input[@id=\"firstName\"]");
	By lastname = By.xpath("//input[@id=\"lastName\"]");
	By email = By.xpath("//input[@id=\"userEmail\"]");
	By age = By.xpath("//input[@id=\"age\"]");
	By salary =By.xpath("//input[@id=\"salary\"]");
	By dept = By.xpath("//input[@id=\"department\"]");
	By submitbtn = By.xpath("//button[@id=\"submit\"]");
	By search_txtbox = By.xpath("//input[@id=\"searchBox\"]");
	By search_btn = By.xpath("//div[@class=\"input-group-append\"]");


	public void add() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		System.out.println("add");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(webTab));
		driver.findElement(webTab).click();
		driver.findElement(add).click();

	}


	public void addDetails() {

		driver.findElement(firstname).sendKeys("first name ");
		driver.findElement(lastname).sendKeys("last name");
		driver.findElement(email).sendKeys("test@gmail.com");
		driver.findElement(age).sendKeys("20");
		driver.findElement(salary).sendKeys("1000000");
		driver.findElement(dept).sendKeys("IT");
		driver.findElement(submitbtn).click();
	}


	public void searchDetails() {

		driver.findElement(search_txtbox).sendKeys("IT");
		driver.findElement(search_btn).click();

	}

	public void searchList() {

		By grp = By.className("rt-tr-group");
		WebElement oddgrp = driver.findElement(By.cssSelector("div[class='rt-tr -odd']"));
		List<WebElement> tablegrp = driver.findElements(grp);
		String expectedText = driver.findElement(search_txtbox).getText();	
		System.out.println(expectedText);


		System.out.println(tablegrp.size());
		for (WebElement element : tablegrp) {
			System.out.println("group name "+element.getText()); 
		}
		System.out.println("odd "+oddgrp.getText().contains("IT"));

	}

	
	@Test
	public void update_details(){
		System.out.println("update");
		String new_Name="Updated first name";
		SoftAssert softassert = new SoftAssert();
		WebElement edit = driver.findElement(By.xpath("//*[@title='Edit']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement edit_wait = wait.until(ExpectedConditions.elementToBeClickable(edit));
		edit_wait.click();
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys(new_Name);
		driver.findElement(submitbtn).click();
		String Actual = driver.findElement(firstname).getText(); //locator is not proper
		System.out.println(Actual);
		softassert.assertEquals(Actual, new_Name, "String not matching");
        softassert.assertAll();

	}





}
