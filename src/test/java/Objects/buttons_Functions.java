package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class buttons_Functions {
	
	WebDriver driver;
	
	By double_click_btn= By.id("doubleClickBtn");
	By right_click_btn = By.id("rightClickBtn");
	By Click_btn = By.xpath("//div[@class='mt-4'][2]");
	//By Click_btn = By.cssSelector(null)
	
	
	public buttons_Functions(WebDriver driver) {
		this.driver=driver;
	}

	public void double_Click() {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(double_click_btn)).perform();
		
	}
	
	public void right_Click() {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(right_click_btn)).build().perform();
	}

	public void click() {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(Click_btn));
		//js.executeScript("arguments[0].click();", driver.findElement(Click_btn));
		action.click(driver.findElement(Click_btn)).build().perform();
		System.out.print("click");
	}

}
