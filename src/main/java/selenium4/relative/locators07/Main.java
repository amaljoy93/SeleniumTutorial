package selenium4.relative.locators07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement userElement = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("password")));
		userElement.sendKeys("standard_user");
		WebElement passwordElement = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("user-name")));
		passwordElement.sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement sauceLabsBoltTShirt = driver.findElement(RelativeLocator.with(By.id("item_4_title_link")).toLeftOf(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")));
		sauceLabsBoltTShirt.click();
		driver.findElement(By.id("back-to-products")).click();
		WebElement sauseLabBackPack = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")));
		sauseLabBackPack.click();
		driver.quit();
		// also you can chain these method for targeting a element.
		// you can fetch a group of elements with findElements
	}

}
