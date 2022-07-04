package selenium.ui.components10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testmatick.com/request-a-quote/");
		driver.manage().window().maximize();
		Select dropdownSelect = new Select(driver.findElement(By.id("nf-field-231")));
		List<WebElement> options = dropdownSelect.getOptions();
		for (WebElement option: options) {
			option.click();
		}
	}

}
// options has selectbyindex, slectbyvalue, selectvisibletext to select options