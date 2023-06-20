package Objects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class tabLinks {

WebDriver driver;

public tabLinks(WebDriver driver) {
	this.driver = driver;
}

public void newTab() throws InterruptedException {
	String originalWindow = driver.getWindowHandle();
	assert driver.getWindowHandles().size() == 1;
	driver.findElement(By.id("simpleLink")).click();
	Thread.sleep(5000);
	for (String windowHandle : driver.getWindowHandles()) {
	    if(!originalWindow.contentEquals(windowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}
	System.out.print(driver.getCurrentUrl());

}
}