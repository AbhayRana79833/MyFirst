package Test;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base;
import Page.AmazonHomePage;

public class AmazonSearchTest extends Base {
	
	public static final Logger logger = LogManager.getLogger(AmazonSearchTest.class);


	public AmazonSearchTest() {
		PropertyConfigurator.configure(".\\Resources\\Log4j.properties");
	}
	
    @Test
    public void searchForLaptops() {
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.searchForProduct(homePage.searchBox);
        logger.info("Searching on the Page");
        String data = driver.getTitle();
        
        if (data.equals("searchForLaptops")) {
        	test.log(LogStatus.PASS, "Expected Title matched " + data);
        }else {
        	test.log(LogStatus.FAIL, "Expected title is " + data + " but got " + data );
        }
    }
}