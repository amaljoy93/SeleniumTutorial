package implicit.wait.not.thread.sleep04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://colorlib.com/etc/bwiz/colorlib-wizard-1/index.html");

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("charles");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("babage");
		driver.findElement(By.xpath("//input[@placeholder='Your Email']")).sendKeys("someone@somewhere.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("4234234234");
		driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("23");
		driver.findElement(By.xpath("//a[normalize-space()='Forward']")).click();
		/*
		 * next page load will take some milli second delay how ever driver will surpass its execution 
		 * before that so we need to say to driver to wait for the page loading
		 * dont use Thread.sleep()// this will cause explicit wait and it will slower the code
		 * execution
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("some address");
		driver.quit();
	}

}
