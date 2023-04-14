package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckHomePageTitlePage {
	  private WebDriver driver;

	    public CheckHomePageTitlePage (WebDriver driver) {
	        this.driver = driver;
	    }
	
	public String CheckTitle() {
		
		String data = driver.getTitle();
		return data;
	}

}
