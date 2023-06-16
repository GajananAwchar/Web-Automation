package base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent {
	private static ExtentReports extent;
	private static String timeStamp;
	private static String reportFileName;
	private static String reportFileLocation;
	private static String fileSeperator;
	private static ExtentSparkReporter sparkReporter;
	private static String reportFilepath;
	static String filePath;
	private static String reportPath_File;

	public static ExtentReports getInstance() {
		timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());// time stamp
		fileSeperator = System.getProperty("file.separator");
		reportFilepath = System.getProperty("user.dir") + fileSeperator + "TestReport";
		filePath = getReportPath(reportFilepath);
		reportFileName = "TestAutomatonReport-" + timeStamp + ".html"; 
		reportPath_File = reportFilepath + fileSeperator + reportFileName;  
//		
//		fileName = getReportPath(System.getProperty("user.dir")+fileSeperator+"/ExtentReport/TestAutomatonReport" + timeStamp + ".html");
		if (extent == null) {
			extent = new ExtentReports();
//			sparkReporter = new ExtentSparkReporter(
//					fileName+"test-output/ExtentReport/TestAutomatonReport_" + timeStamp + ".html");
			sparkReporter = new ExtentSparkReporter(reportPath_File);
			sparkReporter.config().setTheme(Theme.STANDARD); 
			sparkReporter.config().setDocumentTitle(reportFileName);
			sparkReporter.config().setEncoding("utf-8");
			sparkReporter.config().setReportName(reportFileName);
			sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Platform", "Web Application");
			extent.setSystemInfo("Automation QA", "Gajanan");
			extent.setSystemInfo("User", "Gajanan");
		}
		return extent;
	}

	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}
}
