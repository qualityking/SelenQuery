package com.selenquery.core;

import java.util.List;


import org.openqa.selenium.WebDriver;

public interface ISelenDriver extends WebDriver {

	public SelenWebElement $(String selector);	
	public SelenWebElement $(By by);
	public SelenWebElement $x(String xpath);
	
	public List<SelenWebElement> $$(String selector);
	public List<SelenWebElement> $$(By by);
	public List<SelenWebElement> $$x(String xpath);
	
	public boolean exists(String selector);
	public boolean exists(By by);
	
	public void shouldExists(String selector);
	public void shouldNotExists(String selector);
	
	public void shouldExists(By by);
	public void shouldNotExists(By by);
	
	
	
	//With timeout
	public SelenWebElement $(String selector,int TimeoutInSec);	
	public SelenWebElement $(By by,int TimeoutInSec);
	public SelenWebElement $x(String xpath,int TimeoutInSec);
	
	public List<SelenWebElement> $$(String selector,int TimeoutInSec);
	public List<SelenWebElement> $$(By by,int TimeoutInSec);
	public List<SelenWebElement> $$x(String xpath,int TimeoutInSec);
	
	public boolean exists(String selector, int TimeoutInSec);
	public boolean exists(By by, int TimeoutInSec);
	
	public int getGlobalTimeout();
	public void setGlobalTimeout(int TimeoutInSec);
	public int getPageLoadTimeout();
	public void setPageLoadTimeout(int TimeoutInSec);
	
	
	public void shouldExists(String selector, int TimeoutInSec);
	public void shouldNotExists(String selector, int TimeoutInSec);
	
	public void shouldExists(By by,int TimeoutInSec);
	public void shouldNotExists(By by,int TimeoutInSec);
	
	
	
}
