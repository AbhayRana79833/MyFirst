package Utils;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public static synchronized ExtentReports getInstance(String fileName) {
		if (extent == null) {
			extent = new ExtentReports(fileName, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "//reportconfig.xml"));
			extent.addSystemInfo("Selenium version", "4.6.0").addSystemInfo("Environment", "QA");
		}
		return extent;
	}
}