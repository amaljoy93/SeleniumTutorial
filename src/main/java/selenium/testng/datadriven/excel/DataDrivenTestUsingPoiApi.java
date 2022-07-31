package selenium.testng.datadriven.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTestUsingPoiApi {

	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\prade\\git\\SeleniumTutorial\\testngtest11.xml");
		runner.setTestSuites(suitefiles);
		runner.run();

	}

}


class TestNGSeleniumDataDriven {
	WebDriver driver;
	Iterator<Object[]> newI;
	
	@BeforeTest
	public void configData() throws IOException{
	newI = 	new HelperClass("C:\\Users\\prade\\git\\SeleniumTutorial\\src\\main\\java\\selenium\\testng\\datadriven\\excel\\atutomation_test.xls").loadFeatureTestCases();
    }
	
	@DataProvider(name = "data")
	public Iterator<Object[]> loadData() {
		return newI;
	}
	
	@BeforeMethod
	public void setBrowserConfig() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDownDriver() {
		driver.quit();
	}
	
	@Test(dataProvider = "data")
	public void sampleTest(Map<String,String> map)  {
		String[] arr = map.get("testcase 01").split("@");
		String[] authArr = arr[1].split(",");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(authArr[0]);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(authArr[1]);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
	}
}