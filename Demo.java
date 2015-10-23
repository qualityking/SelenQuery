package test;

import com.selenquery.core.Driver;
import com.selenquery.core.Log;
import com.selenquery.core.Logger;
import com.selenquery.core.SelenDriver;
import com.selenquery.core.SupportedBrowsers;

public class Demo {

	
	public static void main(String args[]){
		//file:///C:/ManishBansal/personal/SamplePage.html
		
		Logger.setLogLevel("INFO");
		
				
		SelenDriver driver = new Driver(SupportedBrowsers.Chrome, false, "chromedriver32.exe");
		driver.get("file:///C:/ManishBansal/personal/SamplePage.html");
		
		//driver.$("#fname").clear();
		//driver.$("#fname").type("bansal");
		
		driver.$("#lname").shouldNot().readonly();
		
		
		
	}
	
}
