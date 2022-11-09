package com.crm.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.crm.qa.base.AppDriver;
import com.crm.qa.constants.ElementConstants;

public class HomePage extends AppDriver{
	AppDriver ApDrv=new AppDriver();
	static String propFileName ="src\\main\\java\\com\\crm\\qa\\elements\\Locators.properties";
	
	public HomePage() throws IOException, InterruptedException{
		super(propFileName);
		
	}
	public List<String> home_pagetest() throws InterruptedException, IOException{
		
		List<String>hme_dtls=new ArrayList<String>();
		
		if(isVisible(getElement(ElementConstants.COOKIE_BTN))){
			click(getElement(ElementConstants.COOKIE_BTN));
			if(isVisible(getElement(ElementConstants.CLOSE_BTN))){
				click(getElement(ElementConstants.CLOSE_BTN));
			}
		}
		String bodyTextActual=getText(getElement(ElementConstants.HME_TXT));
		hme_dtls.add(bodyTextActual);
				
		

		return hme_dtls;
	}
	
}
