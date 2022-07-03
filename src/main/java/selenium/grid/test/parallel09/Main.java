package selenium.grid.test.parallel09;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main {

	public static void main(String[] args) {
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("/home/pradeek/git/SeleniumTutorial/testngtest.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
	}

}

class TestParallel {
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public Capabilities cap;
	public WebDriver getDriver() {
		return driver.get();
	}
	@Parameters({"browser"})
	@Test
	public void doSearch(String browser) throws MalformedURLException, InterruptedException {
		if (browser.equals("edge")) {
			cap = new EdgeOptions();
		} else if (browser.equals("chrome")) {
			cap = new ChromeOptions();
		}
		driver.set(new RemoteWebDriver(new URL("http://192.168.1.70:4444"), cap));
		getDriver().get("https://google.com");
		Thread.sleep(3000);
		getDriver().quit();
	}
}

// same process for selenium grid hub and distributed
