package pract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class sel {

	// static driver ;
	@Test
	public void testing() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Started");
		Properties prop = new Properties();
		FileInputStream objfile;
		WebDriver driver;

		try {

			objfile = new FileInputStream(System.getProperty("user.dir") + "/application.properties");

			prop.load(objfile);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver", "/home/monesh/Downloads/chromedriver_linux64/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(options);

		try {

			driver.get("https://www.spicejet.com/?utm_source=google&utm_medium=cpc&utm_"
					+ "campaign=spicejetbrandexact&gclid=CjwKCAiAjMHwBRAVEiwAzdLWGBzU1eJ-GUrL9uoX52EmC_LPMrmQqEritmL36bDSLTfCVNl-BP_7xRoC1uEQAvD_BwE");

			String pageheading = driver.getTitle();
			System.out.println(pageheading);
			Thread.sleep(3000);

			String[] exp = { "INR", "AED" };

			WebElement dropdown = driver
					.findElement(By.xpath("//label[contains(text(),'Currency')]/following :: select[1]"));
			Select select = new Select(dropdown);

			List<WebElement> opt = select.getOptions();

			for (WebElement item : opt) {

				for (int i = 0; i < exp.length; i++) {
					if (item.getText().contains(exp[i]))
						System.out.println("Dropdown values match " + item.getText());
				}
			}

			TakesScreenshot snap = (TakesScreenshot) driver;
			File src = snap.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("snapshot.jpg");
			Files.copy(src, DestFile);

			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception caught ");
		} finally {
			System.out.println("finally quitting webdriver");
			driver.quit();

		}

	}

}
