package selenium.testng.test12;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocatingTestMethods {
	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\prade\\git\\SeleniumTutorial\\testngtest8.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
	}
}


class TestInvocationMethods{
	WebDriver driver;
	static int countMethod1 = 0;
	static int countMethod2 = 0;
	@BeforeMethod
	public void setBrowserConfig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}
	@AfterMethod
	public void tearDownDriver() {
		driver.quit();
	}
	@AfterTest
	public void showMethodInvocationCount() {
		System.out.println("method1 count: "+countMethod1+"\n"+"method2 count: "+countMethod2);
	}
	@Test(invocationCount = 3)
	public void testMethod1() {
		driver.findElement(By.name("q")).sendKeys("Hello");
		countMethod1++;
	}
	@Test(invocationCount = 2)
	public void testMethod2() {
		driver.findElement(By.name("q")).sendKeys("Hello");
		countMethod2++;
	}
}
