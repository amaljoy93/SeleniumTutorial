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

public class SeleniunTestInGroups {

	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\prade\\git\\SeleniumTutorial\\testngtest6.xml");
		runner.setTestSuites(suitefiles);
		runner.run();

	}

}

class TestNgGroupDemoClass {
	WebDriver driver;
	@BeforeMethod(groups= {"group1", "group2"})
	public void setBrowserConfig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}
	@AfterMethod(groups= {"group1", "group2"})
	public void tearDownDriver() {
		driver.quit();
	}
	
	@Test(groups= {"group1", "group2"})
	public void testgoogleSearch_01() {
		driver.findElement(By.name("q")).sendKeys("Hello");
		System.out.println("from test 01");
	}
	
	@Test(groups= {"group1"})
	public void testgoogleSearch_02() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 02");
	}
	
	@Test(groups= {"group2"})
	public void testgoogleSearch_03() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 03");
	}
	@Test(groups= {"group2"})
	public void testgoogleSearch_04() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 04");
	}
	@Test(groups= {"group1"})
	public void testgoogleSearch_05() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 05");
	}
	@Test(groups= {"group1"})
	public void testgoogleSearch_06() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 06");
	}
	@Test(groups= {"group1"})
	public void testgoogleSearch_07() {
		driver.findElement(By.name("q")).sendKeys("Hi");
		System.out.println("from test 07");
	}
}