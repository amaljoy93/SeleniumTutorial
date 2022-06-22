package explicitwait.dont.use.thread.sleep05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("hello");
		
		/*
		 * if a webelement exists in DOM but cannot be accessed and this exception will throw. 
		 * 
		 */
		
		/*
		 *  one way is to use elementToBeClickable method.
		 *  possible exception is org.openqa.selenium.ElementNotInteractableException 
		 */
		
		 wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//input[@name='btnK']")));
		
		/*
		 * another method is to use invisibilityOfElementLocated. 
		 * possible exception NoSuchElementException | StaleElementReferenceException
		 */ 
		
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='btnK']")));
		driver.findElement(By.xpath("//input[@name='btnI']")).click();
		
		/*
		 * last method is to inject javascript to the page using JavaExecuter api
		 */
		
//		WebElement m = driver.findElement(By.xpath("//input[@name='btnK']"));
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click();", m);
		driver.close();
	}

}
