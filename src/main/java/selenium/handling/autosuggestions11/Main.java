package selenium.handling.autosuggestions11;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Ind");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String keyTtext = "India";
		WebElement option = driver.findElement(By.xpath("//span[normalize-space()='"+keyTtext+"']"));
		option.click();
	}

}
