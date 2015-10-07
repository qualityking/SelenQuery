package com.selenquery.core;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelenWebElement implements WebElement {

	private WebElement element;
	private SeleniumDriver driver;
	private String name="";
	
	
	public SelenWebElement(SeleniumDriver driver, WebElement element){
		this.driver = driver;
		this.element = element;
	}

	public SelenWebElement(SeleniumDriver driver, String name, WebElement element){
		this.driver = driver;
		this.element = element;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public WebElement getWebElement(){
		return element;
	}
	
	
	public boolean Assert(boolean condition){
		return condition;
	}
	
	public Should should(){
		return new Should(driver, this, true);
	}
	
	public Should shouldNot(){
		return new Should(driver, this, false);
	}
	
	public Should should(int timeoutInSec){
		return new Should(driver, this, true, timeoutInSec);
	}
	
	public Should shouldNot(int timeoutInSec){
		return new Should(driver, this, false, timeoutInSec);
	}
	
	public Select toSelect(){
		return (Select) element;
	}
	
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> target)
			throws WebDriverException {
		// TODO Auto-generated method stub
		return element.getScreenshotAs(target);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		element.click();
	}

	
	public void dblClick() {
		//Actions action = new Actions(element.);
		
		//action.doubleClick(elm).perform();
		
	}
	
	@Override
	public void submit() {
		// TODO Auto-generated method stub
		element.submit();
	}

	//@Override
	public SpecialKeys type(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		element.sendKeys(keysToSend);
		return new  SpecialKeys(element);
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		element.sendKeys(keysToSend);
		
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		element.clear();
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return element.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return element.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return element.isSelected(); 
				
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return element.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return element.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return element.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return element.getSize();
	}

	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return element.getCssValue(propertyName);
	}



	
	
	
}
