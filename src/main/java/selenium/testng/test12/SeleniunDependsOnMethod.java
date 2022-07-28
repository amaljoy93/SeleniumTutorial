package selenium.testng.test12;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniunDependsOnMethod {
	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("C:\\Users\\prade\\git\\SeleniumTutorial\\testngtest7.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
	}
}


class TestNgDependsOnMethod {
	WebDriver driver;
	String keyword;
	@BeforeTest()
	public void setBrowserConfig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}
	@AfterTest()
	public void tearDownDriver() {
		driver.quit();
	}
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
		WebElement searchBarElement = driver.findElement(By.name("q"));
		searchBarElement.sendKeys("hello lionel richie");
		searchBarElement.submit();
	}
	
	@Test(dependsOnMethods = {"testGoogleSearch"})
	public void clickSongWiki() {
		driver.findElement(By.xpath("//h3[normalize-space()='Hello (Lionel Richie song) - Wikipedia']")).click();
	}
}
