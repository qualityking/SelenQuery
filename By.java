package com.selenquery.core;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;


public class By extends org.openqa.selenium.By {

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static By attribute(String attribName, String attribValue){
		 return (By) By.xpath(".//*[@" + attribName + "='" + attribValue + "']");
	}

}
