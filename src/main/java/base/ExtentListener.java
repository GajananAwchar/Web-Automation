package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener extends BaseClass implements ITestListener {
	private ExtentReports extent = Extent.getInstance();
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Test started: " + context.getName());
		ExtentTest extentTest = extent.createTest(context.getName());
		test.set(extentTest);
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());
		ExtentTest extentTest = test.get().createNode(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		try {
			TakingFullPageScreenshot.takescreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test passed: " + result.getName());
		test.get().pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		try {
			TakingFullPageScreenshot.takescreenshot(driver, TakingFullPageScreenshot.getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testName = result.getName();
        System.out.println("Test '" + testName + "' has failed.");
		test.get().fail(result.getThrowable());
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
		test.get().skip(result.getThrowable());
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println("Test suite finished: " + context.getName());
		extent.flush();
	} 

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed but within success percentage: " + result.getName());

	}
}
