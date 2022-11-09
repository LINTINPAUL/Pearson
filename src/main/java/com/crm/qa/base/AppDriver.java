package com.crm.qa.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.crm.qa.base.BaseDriver;


public class AppDriver {
	
	
	public static BaseDriver base;
	static Properties prop;
	
	public void sleep(int value) {
		base.sleep(value);
	}

	public void clickOverlap(String identifier) {
		base.clickOverlap(identifier.split(",")[1]);
	}
	public AppDriver(String propFileName) {
		prop = new Properties();
		setUp(propFileName);
	}
	public void setUp(String propFileName) {
		try {
			prop.load(new FileInputStream(propFileName));
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public AppDriver() {
		
	}

	public static String getElement(String element) {
		
		return prop.getProperty(element);
	}

	public String BrowserLaunch(String url) throws InterruptedException, IOException {
		
		base = new BaseDriver();
		base.BrowserLaunchwithcertf(url);
		return "True";
	}
		
	public void maximizeScreen() {
		base.maximizeScreen();
	}
	
		
	public void click(String identifier) throws InterruptedException {
	    base.click(identifier.split(",")[0], identifier.split(",")[1]);
	}
	
	
	public String getText(String identifier) {
		return base.getText(identifier.split(",")[0], identifier.split(",")[1]);
	}
	
	public String verifyHomePageTitle(){
		return base.verifyHomePageTitle();
	}
	
	public void clear(String identifier) {
		base.clear(identifier.split(",")[0], identifier.split(",")[1]);
	}
	
	
	public boolean isVisible(String identifier) {
		return base.isVisible(identifier.split(",")[0],
				identifier.split(",")[1]);
	}
	
	
	public void explicitWaitByID(String identifier) {
		base.explicitWaitByID(identifier.split(",")[0],
				identifier.split(",")[1]);
	}
		
	public String getcurrenturl() {
		return base.getcurrenturl();
	}
	
	public void url(String url) {
		base.url(url);
	}
	
	public void explicitWaitByxpath(String identifier) {
		
		base.explicitWaitByxpath(identifier.split(",")[1]);
	}
	
	public void sendEnter() {
		base.sendEnter();
	}
	
	public void tearDown() {
		base.tearDown();
		}
	public void refresh(){
		base.refresh();
	}

	public void sentText(String text,String identifier){
		 base.sentText(text,identifier.split(",")[0],identifier.split(",")[1]);
	}

	public void movetoELement(String identifier) throws IOException{
		
	 base.movetoELement(identifier.split(",")[0],identifier.split(",")[1]);
	}
	    
	
	
}