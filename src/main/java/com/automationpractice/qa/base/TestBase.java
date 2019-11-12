package com.automationpractice.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	static WebDriver driver;
	static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/com/automationpractice/qa/config/config.propeties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to get the config.properties file.");
		} catch (IOException e) {
			System.out.println("Unable to read config.properties file.");
		}
	}

	/**
	 * Initialization method
	 */
	public static void intitialization() {
		String browser = prop.getProperty("browser");
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\browser drivers\\geckodriver.exe");
		}
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	/**
	 * log to console
	 * @param info
	 */
	public void log(String info) {
		System.out.println(info);
	}

}
