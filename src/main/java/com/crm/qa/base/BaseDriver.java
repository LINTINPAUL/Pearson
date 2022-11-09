package com.crm.qa.base;


import java.util.List;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.qa.constants.ElementConstants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseDriver {
	WebDriver driver ;
	
	public String BrowserLaunchwithcertf(String url) throws IOException {
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		url(url);
		maximizeScreen();
		sleep(2000);	
		return "True";
	}

	protected void sleep(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
	public void maximizeScreen() {
		driver.manage().window().maximize();
	}
	
	protected void click(String key, String value) {
		
		WebElement element = find(key, value);
		if (null != element) {
			sleep(3000);
			element.click();
		}
	}
	protected void explicitWaitByxpath( String value) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(value)));
	}
	public String getText(String key, String value) {
		// TODO Auto-generated method stub
		WebElement element = find(key, value);
		String text = null;
		if (null != element) {
			text = element.getText();
		}
		return text;
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	protected void clear(String key, String value) {
		WebElement element = find(key, value);
		if (null != element) {
			element.clear();
		}
	}

	protected boolean isVisible(String key, String value) {
		boolean visible = false;
		try{
		WebElement element = find(key, value);

		if (null != element) {
			visible = element.isDisplayed();
		}

		}catch(NoSuchElementException e){
			
		}
		return visible;
	}
	
	protected WebElement find(String key, String value) {

		if (ElementConstants.ID.equalsIgnoreCase(key)) {
			return driver.findElement(By.id(value));
		}
		if (ElementConstants.XPATH.equalsIgnoreCase(key)) {
			return driver.findElement(By.xpath(value));
		}
		if (ElementConstants.NAME.equalsIgnoreCase(key)) {
			return driver.findElement(By.name(value));
		}

		if (ElementConstants.CLASS_NAME.equalsIgnoreCase(key)) {
			return driver.findElement(By.cssSelector(value));
		}
		if (ElementConstants.CSS_NAME.equalsIgnoreCase(key)) {
			return driver.findElement(By.tagName(value));
		}
		if (ElementConstants.LINK_TEXT.equalsIgnoreCase(key)) {
			return driver.findElement(By.linkText(value));
		}
		if (ElementConstants.PARTIAL_LINK_TEXT.equalsIgnoreCase(key)) {
			return driver.findElement(By.partialLinkText(value));
		}
		
		return null;		
	}
	
	protected List<WebElement> findElements(String key, String value) {

		if (ElementConstants.ID.equalsIgnoreCase(key)) {
			return driver.findElements(By.id(value));
		}
		if (ElementConstants.XPATH.equalsIgnoreCase(key)) {
			return driver.findElements(By.xpath(value));
		}
		if (ElementConstants.NAME.equalsIgnoreCase(key)) {
			return driver.findElements(By.name(value));
		}

		if (ElementConstants.CLASS_NAME.equalsIgnoreCase(key)) {
			return driver.findElements(By.cssSelector(value));
		}
		if (ElementConstants.CSS_NAME.equalsIgnoreCase(key)) {
			return driver.findElements(By.tagName(value));
		}
		if (ElementConstants.LINK_TEXT.equalsIgnoreCase(key)) {
			return driver.findElements(By.linkText(value));
		}
		if (ElementConstants.PARTIAL_LINK_TEXT.equalsIgnoreCase(key)) {
			return driver.findElements(By.partialLinkText(value));
		}
		System.out.println("BD  FIND -- IF not matchin");
		return null;		
	}
	
	protected void explicitWaitByID(String key, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if (value.equals("xpath")){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		}else{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
		}
	}

	public String getcurrenturl() {
		return driver.getCurrentUrl();
	}

	public void url(String url) {
		driver.get(url);
	}

	public void waitByXPATH(String key, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
	}

	public void sendEnter() {
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	}

	public void tearDown() {
		driver.quit();
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}

	public void sentText(String text,String key,String value){
		WebElement element = find(key, value);
		element.sendKeys(text);
	}

	protected void clickOverlap( String value) {

		 WebElement element=driver.findElement(By.xpath(value));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}

    public void movetoELement(String key, String Value) throws IOException{
    	   WebElement element = find(key, Value);
   		   if (null != element) {
    	   JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView();", element);
   		   }
    	   
       }

}

