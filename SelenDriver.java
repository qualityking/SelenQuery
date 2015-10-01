package com.selenquery.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.AssertionFailedError;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelenDriver extends ReusableRemoteWebDriver implements WebDriver, ISelenDriver {

	private int globalTimeOut = 30;
	private int pageloadTimeout = 120;

	public SelenDriver(SupportedBrowsers browsers, DesiredCapabilities capabilities, boolean NewSession, String driverPath, String host) {
		super(browsers, capabilities, NewSession, driverPath, host);
		this.manage().timeouts().pageLoadTimeout(globalTimeOut, TimeUnit.SECONDS);
		this.manage().timeouts().implicitlyWait(pageloadTimeout, TimeUnit.SECONDS);

	}

	@Override
	public SelenWebElement $(String selector) {
		return $(selector, 0);
	}

	@Override
	public SelenWebElement $(By by) {
		return $(by, 0);
	}

	@Override
	public SelenWebElement $x(String xpath) {
		return $x(xpath, 0);
	}

	@Override
	public List<SelenWebElement> $$(String selector) {
		return $$(selector, 0);
	}

	@Override
	public List<SelenWebElement> $$(By by) {
		return $$(by, 0);
	}

	@Override
	public List<SelenWebElement> $$x(String xpath) {
		return $$x(xpath, 0);
	}

	@Override
	public boolean exists(String selector) {
		// TODO Auto-generated method stub
		return exists(selector, 0);
	}

	@Override
	public boolean exists(By by) {
		// TODO Auto-generated method stub
		return exists(by, 0);
	}

	@Override
	public boolean exists(String selector, int timeoutInSec) {
		try {
			setTimeout(timeoutInSec);
			$(selector);
			resetTimeout();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean exists(By by, int timeoutInSec) {
		// TODO Auto-generated method stub
		try {
			setTimeout(timeoutInSec);
			$(by);
			resetTimeout();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public SelenWebElement $(String selector, int timeoutInSec) {
		return $$(selector, timeoutInSec).get(0);
	}

	@Override
	public SelenWebElement $(By by, int timeoutInSec) {
		return $$(by, timeoutInSec).get(0);
	}

	@Override
	public SelenWebElement $x(String xpath, int timeoutInSec) {
		return $$x(xpath, timeoutInSec).get(0);
	}

	@Override
	public List<SelenWebElement> $$(String selector, int timeoutInSec) {
		return findElement("SELECTOR", selector, timeoutInSec, null);
	}

	@Override
	public List<SelenWebElement> $$(By by, int timeoutInSec) {
		return findElement("BY", null, timeoutInSec, by);
	}

	@Override
	public List<SelenWebElement> $$x(String xpath, int timeoutInSec) {
		return findElement("XPATH", xpath, timeoutInSec, null);
	}

	@Override
	public int getGlobalTimeout() {
		// TODO Auto-generated method stub
		return globalTimeOut;
	}

	@Override
	public void setGlobalTimeout(int timeoutInSec) {
		try {
			this.globalTimeOut = timeoutInSec;
			this.manage().timeouts().implicitlyWait(timeoutInSec, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Driver is null - " + e.getMessage());
		}

	}

	@Override
	public int getPageLoadTimeout() {
		// TODO Auto-generated method stub
		return pageloadTimeout;
	}

	@Override
	public void setPageLoadTimeout(int timeoutInSec) {
		try {
			this.pageloadTimeout = timeoutInSec;
			this.manage().timeouts().pageLoadTimeout(timeoutInSec, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Driver is null - " + e.getMessage());
		}

	}

	@Override
	public void shouldExists(String selector) {
		if (!Assertion.test(true, exists(selector))) {
			System.err.println("Element Not Found - " + selector);
			sleep(100);
		}

	}

	@Override
	public void shouldNotExists(String selector) {
		if (!Assertion.test(false, exists(selector))) {
			System.err.println("Element Found - " + selector);
			sleep(100);
		}
	}

	@Override
	public void shouldExists(By by) {
		if (!Assertion.test(true,exists(by))) {
			System.err.println("Element Not Found - " + by.toString());
			sleep(100);
		}
	}

	@Override
	public void shouldNotExists(By by) {
		if (!Assertion.test(false, exists(by))) {
			System.err.println("Element Found - " + by.toString());
			sleep(100);
		}
	}

	@Override
	public void shouldExists(String selector, int timeoutInSec) {
		if (!Assertion.test(true, exists(selector, timeoutInSec))) {
			System.err.println("Element Not Found, Timeout Reached - " + selector);
			sleep(100);
		}
	}

	@Override
	public void shouldNotExists(String selector, int timeoutInSec) {
		if (!Assertion.test(false, exists(selector, timeoutInSec))) {
			System.err.println("Element Found, Timeout Reached - " + selector);
			sleep(100);
		}
	}

	@Override
	public void shouldExists(By by, int timeoutInSec) {
		if (!Assertion.test(true, exists(by, timeoutInSec))) {
			System.err.println("Element Not Found, Timeout Reached - " + by.toString());
			sleep(100);
		}

	}

	@Override
	public void shouldNotExists(By by, int timeoutInSec) {
		if (!Assertion.test(false, exists(by, timeoutInSec))) {
			System.err.println("Element Found, Timeout Reached - " + by.toString());
			sleep(100);
		}

	}

	private void setTimeout(int sec) {
		this.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	private void resetTimeout() {
		try {
			this.manage().timeouts().implicitlyWait(getGlobalTimeout(), TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Driver is null - " + e.getMessage());
		}
	}
	
	
	public void sleep(long milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	  
	  

	private List<SelenWebElement> findElement(String searchType, String searchData, int timeoutInSec, By by) {
		List<WebElement> elements = null;
		try {
			setTimeout(timeoutInSec);

			switch (searchType) {
			case "SELECTOR":
				elements = this.findElementsByCssSelector(searchData);
				break;
			case "XPATH":
				elements = this.findElementsByXPath(searchData);
				break;
			case "BY":
				elements = this.findElements(by);
				break;
			default:
				break;
			}

			List<SelenWebElement> list = new ArrayList<SelenWebElement>();
			for (WebElement webElement : elements) {
				list.add(new SelenWebElement(this, webElement));
			}
			resetTimeout();
			return list;
		} catch (Exception e) {
			resetTimeout();
			throw e; // Breaking if there is exception
		}

	}

}
