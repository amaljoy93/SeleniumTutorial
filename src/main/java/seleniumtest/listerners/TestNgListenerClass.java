package seleniumtest.listerners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListenerClass implements ITestListener {
	public void onTestStart(ITestResult result) {
	   System.out.println("Test started!");
	  }
	
	public void onTestSuccess(ITestListener result) {
		System.out.println("Test passed!");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed!");
	  }
	
	public void onTestSkipped(ITestResult result) {
	    
	  }
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
}
