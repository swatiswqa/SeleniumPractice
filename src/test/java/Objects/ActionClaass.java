package Objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ActionClaass {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("");
		
		
		@Test
		public void action() {
			
		}
		
		
	}
	

}
