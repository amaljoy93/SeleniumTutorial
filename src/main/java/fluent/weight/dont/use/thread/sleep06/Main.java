package fluent.weight.dont.use.thread.sleep06;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		/*
		 * In Fluent wait we can add the polling time of some seconds.
		 * in implicit and explicit wait the function will keep on polling to the
		 * DOM to check whether the element is present or not.
		 * this hammering process of implicit wait and explicit is giving the main thread 
		 * a extra load.
		 * to avoid this we can give a interval of time to poll using fluent wait.
		 */
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		driver.findElement(By.name("q")).sendKeys("hello");	
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//input[@name='btnK']")));
		driver.findElement(By.xpath("//input[@name='btnI']")).click();
		driver.close();
	}

}
