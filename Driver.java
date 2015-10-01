package com.selenquery.core;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

	private static SelenDriver driver = null;

	
	public static SelenDriver get(String url, SupportedBrowsers BrowserName, boolean newSession, String driverpath) {
		return get(url, BrowserName, newSession, driverpath, "localhost");
	}

	private static SelenDriver get(String url, SupportedBrowsers BrowserName, boolean newSession, String driverpath, String hostname) {
		DesiredCapabilities capabilities = null;

		switch (BrowserName) {
		case InternetExplorer:
			System.setProperty("webdriver.ie.driver", driverpath);
			capabilities = DesiredCapabilities.internetExplorer();
			break;
		case Chrome:
			System.setProperty("webdriver.chrome.driver", driverpath);
			capabilities = DesiredCapabilities.chrome();
			
			
			ChromeOptions options = new ChromeOptions();
			String username = System.getProperty("user.name");
			String cacheDir = "C:/Users/" + username + "/AppData/Local/Google/Chrome/User Data/Default/Cache";
			options.addArguments("disk-cache-dir=" + cacheDir);
			options.addArguments("--disable-extensions");

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			break;
		case FireFox:
			try {
				throw new Exception("Browser is not supported yet : FireFox");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}

		capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		driver = new SelenDriver(BrowserName, capabilities, newSession, driverpath, hostname);
		driver.manage().window().maximize();
		if (driver.isNewSession()) {
			driver.get(url);
		}
		
		return driver;

	}

}
