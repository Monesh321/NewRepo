package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		System.setProperty("webdriver.chrome.driver", "/home/monesh/Downloads/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("hello world tested");
		System.out.println("new changes ");
		assertTrue(true);
		driver.close();
	}
}
