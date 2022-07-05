package selenium.testng.test12;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgGroupDemo {

	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\prade\\git\\SeleniumTutorial\\testngtest4.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
	}

}


class TestNgTest02 {
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
	
	@Test(priority = 4)
	public void testgoogleSearch_01() {
		driver.findElement(By.name("q")).sendKeys("Hello");
		System.out.println("from test 01");
	}
	
	@Test(priority = 5)
	public void testgoogleSearch_02() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 02");
	}
	@Test(priority = 1)
	public void testgoogleSearch_03() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 03");
	}
	@Test(priority = 3)
	public void testgoogleSearch_04() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 04");
	}
	@Test(priority = 0)
	public void testgoogleSearch_05() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 05");
	}
	@Test(priority = 2)
	public void testgoogleSearch_06() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 06");
	}
	@Test(priority = -1)
	public void testgoogleSearch_07() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 07");
	}
}
