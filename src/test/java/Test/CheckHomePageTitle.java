package Test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base;
import Page.AmazonHomePage;
import Page.CheckHomePageTitlePage;

public class CheckHomePageTitle extends Base{
	
	public static final Logger logger = LogManager.getLogger(AmazonSearchTest.class);


	public CheckHomePageTitle() {
		PropertyConfigurator.configure("\\Resources\\Log4j.properties");
	}
	
	@Test
	public void ScheckTitle() {
		CheckHomePageTitlePage Page = new CheckHomePageTitlePage(driver);
		String data = Page.CheckTitle();
		 if (data.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
	        	test.log(LogStatus.PASS, "Expected Title matched " + data);
	        	logger.info("Right Page Open"+data);
	        }else {
	        	test.log(LogStatus.FAIL, "Expected title is " + data + " but got " + data );
	        	logger.info("Wrong Page Open");
	        }
		 Assert.assertEquals(data, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

}
