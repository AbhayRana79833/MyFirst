package Base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.ExtentManager;
import Utils.ScreenShot;

public class Base {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static final Logger logger = LogManager.getLogger(Base.class);

	public Base() {
		PropertyConfigurator.configure(".\\Resources\\Log4j.properties");
	}

	@BeforeClass
	public void driverInitialization() {
		logger.info("Starting the Driver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		extent = ExtentManager.getInstance("report/AmazonReport.html");
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test = extent.startTest(method.getName());
	}

	@AfterMethod
	public void saveResult(ITestResult result) throws Exception {
		logger.info("Inside the After Test");
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test case passed");
		} else {
			test.log(LogStatus.FAIL, "Test case failed");
			ScreenShot.takeSnapShot(driver, "./Screenshot/" + result.getName() + ".png");
		}
		extent.endTest(test);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
    public void ClosingAll() {
        extent.flush();
        extent.close();
    }
}