package Objects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class switchingFrame {
	
	
	WebDriver driver;
	
	@BeforeTest
 public void beforeTest() {
	
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");
	}
	
	@Test
	public void SingleFrame() throws InterruptedException {
	
		
		//driver.findElement(By.cssSelector("a[href='#single']")).click();	
		driver.switchTo().frame("SingleFrame");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void multipleFrame() {
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		int countofframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("number of iframe "+ countofframes);
		
		WebElement parentframe = driver.findElement(By.cssSelector("div#Multiple iframe"));
		driver.switchTo().frame(parentframe);
		String parentText = driver.findElement(By.tagName("h5")).getText();
		System.out.println("text of parents iframe "+parentText);
		
		int numberofiframes = driver.findElements(By.tagName("iFrame")).size();
		System.out.println("size of the iframe inside nested iframe :"+numberofiframes);
		driver.switchTo().frame(0);
		String childtext = driver.findElement(By.tagName("h5")).getText();
		System.out.println(childtext);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("child frame");
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void teardown() {
	driver.quit();
	}

}
