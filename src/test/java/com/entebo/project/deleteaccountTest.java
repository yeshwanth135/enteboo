package com.entebo.project;

import org.testng.annotations.Test;

import com.entebo.genericLib.FileLib;
import com.entebo.genericLib.baseTest;
import com.entebo.genericLib.webdrivercommomLib;
import com.entebo.pages.Deleteaccount;
import com.entebo.pages.customviewPage;
import com.entebo.pages.editAccount;
import com.entebo.pages.editaccountDetails;
import com.entebo.pages.homePage;
import com.entebo.pages.loginPage;

public class deleteaccountTest extends baseTest{
 
	@Test
	public void verify() throws Throwable {
		baseTest bt=new baseTest();
		bt.openBrowser();
		
		loginPage lp=new loginPage();
		FileLib flib=new FileLib();
		lp.logintoappn(flib.readpropData(PROP_PATH, "username"), flib.readpropData(PROP_PATH, "password"));
		
		webdrivercommomLib wlib=new webdrivercommomLib();
		
		wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "homeTitle"), "home page is displayed");
		homePage hp=new homePage();
		hp.clickaccountsTab();
		
		wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "accountstab"), "displaying custom view details");
		customviewPage cv=new customviewPage();
		cv.clickrescentitemslink();
		
		wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "accountDetails"), "Account Details Page");
	    editaccountDetails ed=new editaccountDetails();
	     ed.editbtn();
	     
	     wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "editaccount"), "edit account details");
	     editAccount ea=new editAccount();
	     ea.accountnametB(flib.readexcelData(EXCEL_PATH, "createlead", 1, 0));
	     
	     wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "accountDetails"), "Account Details");
	      Deleteaccount da=new Deleteaccount();
	      da.deleteAccount();
	    	
	    
	}
}
