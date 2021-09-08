package com.entebo.project;

import org.testng.annotations.Test;

import com.entebo.genericLib.FileLib;
import com.entebo.genericLib.baseTest;
import com.entebo.genericLib.webdrivercommomLib;
import com.entebo.pages.createaccountPage;
import com.entebo.pages.customviewPage;
import com.entebo.pages.homePage;
import com.entebo.pages.loginPage;

public class createaccountTest extends baseTest {
    
	@Test
	public void verify() throws Throwable
	{
	baseTest bt = new baseTest();
    bt.openBrowser();	
		loginPage lp = new loginPage();
		FileLib flib= new FileLib();
		lp.logintoappn(flib.readpropData(PROP_PATH, "username"), flib.readpropData(PROP_PATH, "password"));
		
		webdrivercommomLib wlib=new webdrivercommomLib();
	    wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "homeTitle"), "Home Page");
	    
	    homePage hp = new homePage();
	    hp.clickaccountsTab();
	    
	    wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "accountstab"), "Displaying Custom View Details");
	    customviewPage cv=new customviewPage();
	    cv.clicknewaccountsBtn();
	    
	    wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH,"createaccount"), "Create Accounts Page");
	    createaccountPage ca=new createaccountPage(); 
	    ca.createaccountwithmandatoryDetails(flib.readexcelData(EXCEL_PATH, "createaccount", 1, 0));
	    //wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "accountDetails"), "account");
	}
}
