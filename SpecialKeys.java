package com.selenquery.core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SpecialKeys {
	WebElement element;
	public SpecialKeys(WebElement element) {
		this.element = element;
	}

	public void pressEnter(){
		this.element.sendKeys(Keys.ENTER);
	}
	
}
