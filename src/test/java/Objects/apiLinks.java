package Objects;

import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;

public class apiLinks {
	
	WebDriver driver;
	
	
	public apiLinks(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void apiButton() {
		
		HttpURLConnection c=(HttpURLConnection)new URL("https://www.tutorialspoint.com/index.htm").
				.openConnection();
				c.setRequestMethod("HEAD");
				c.connect();
				int r = c.getResponseCode();
	}

}
