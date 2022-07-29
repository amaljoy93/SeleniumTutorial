package seleniumtest.listerners;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenersExample {

	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\prade\\git\\SeleniumTutorial\\testngtest10.xml");
		runner.setTestSuites(suitefiles);
		runner.run();

	}

}

class TestNgListenersExample {
	WebDriver driver;
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
	@Test
	public void testgoogleSearch_01() {
		driver.findElement(By.name("q")).sendKeys("Hello");
		System.out.println("from test 01");
		Assert.assertEquals("", "a");
	}
}

// use can also use Listerner annotation in the class level
