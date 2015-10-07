package com.selenquery.core;

import org.openqa.selenium.WebElement;

public class Should {

	private int timeout = 0;
	private boolean expect = true;
	private SelenWebElement selenWebElement = null;
	private SelenDriver driver = null;

	public Should(SelenDriver driver, SelenWebElement selenWebElement, boolean expect) {
		this.driver = driver;
		this.selenWebElement = selenWebElement;
		this.expect = expect;
	}

	public Should(SelenDriver driver, SelenWebElement selenWebElement, boolean expect, int timeoutInSec) {
		this.driver = driver;
		this.selenWebElement = selenWebElement;
		this.expect = expect;
		this.timeout = timeoutInSec;
	}

	public void haveText(String regex) {
		Assertion.test(expect, selenWebElement.getText().matches(regex), "Test for Text matching");

	}

	public void haveClass(String className) {
		String actualClassName = selenWebElement.getAttribute("class");
		Assertion.test(expect, actualClassName, className, "Test for Class Name matching");
		
	}

	public void haveAttr(String attrName) {
		try {
			selenWebElement.getAttribute(attrName);
			Assertion.test(expect, true, "Test for Attribute availability");
		} catch (Exception e) {
			Assertion.test(expect, false, "Test for Attribute availability");
		}

	}

	public void haveAttrVal(String attrName, String attrValue) {
		String attibValue = selenWebElement.getAttribute(attrName);
		Assertion.test(expect, attrValue, attibValue, "Test for Attribute value matching");

	}

	public void haveStyle(String styleProperty, String styleValue) {
		String val = selenWebElement.getCssValue(styleProperty);
		Assertion.test(expect, styleValue, val, "Test for css Style property matching");
	}

	public void displayed() {
		Assertion.test(expect,selenWebElement.isDisplayed(), "Test for elment displying"); 
	}

	public void enabled() {
		try {
			selenWebElement.getAttribute("readonly");
			Assertion.test(expect, true, "Readonly Test");
		} catch (Exception e) {
			Assertion.test(expect, false, "Readonly Test");
		}
	}
	
	
	public void focused() {
		WebElement elm = (WebElement) driver.executeScript("return document.activeElement");
	    if(elm != null && elm.equals(selenWebElement.getWebElement()))
	    {
	    	Assertion.test(expect,true, "Test for elment foucsed"); 
	    }
	    else{
	    	Assertion.test(expect,false, "Test for elment foucsed");
	    }
	}
	

	
}