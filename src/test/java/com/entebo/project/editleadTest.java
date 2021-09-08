package com.entebo.project;

import org.testng.annotations.Test;

import com.entebo.genericLib.FileLib;
import com.entebo.genericLib.baseTest;
import com.entebo.genericLib.webdrivercommomLib;
import com.entebo.pages.createleadPage;
import com.entebo.pages.customviewPage;
import com.entebo.pages.editleadDetails;
import com.entebo.pages.editleadPage;
import com.entebo.pages.homePage;
import com.entebo.pages.loginPage;

public class editleadTest extends baseTest{
	
	@Test
    public void verify() throws Throwable {
		
		baseTest bt=new baseTest();
		bt.openBrowser();
		
		loginPage lp=new loginPage();
		FileLib flib=new FileLib();
		lp.logintoappn(flib.readpropData(PROP_PATH, "username"), flib.readpropData(PROP_PATH, "password"));
		      
		webdrivercommomLib wlib=new webdrivercommomLib();
		wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "homeTitle"), "Home Page");
		
		homePage hp=new homePage();
		hp.clickleadsTab();
		
		wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "leadsTab"), "module page");
		
		customviewPage cv=new customviewPage();
		cv.clicknewleadsBtn();
		
		wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "createtitle"), "create lead page");
	    createleadPage cl=new createleadPage();
	   
        cl.createleadswithmandatoryFields(flib.readexcelData(EXCEL_PATH, "createlead", 0, 0), flib.readexcelData(EXCEL_PATH, "createlead", 1, 0), flib.readexcelData(EXCEL_PATH, "createlead", 2, 0));

        wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "leaddetails"), "customer details page");
        editleadDetails ed= new editleadDetails();
        ed.clickeditBtn();
        
        wlib.verify(wlib.getpageTitle(), flib.readpropData(PROP_PATH, "editdetails"), "edit details");
        editleadPage el=new editleadPage();
        
        el.editleadswithmandatoryFields(flib.readexcelData(EXCEL_PATH, "createlead", 1, 0), flib.readexcelData(EXCEL_PATH, "createlead", 0, 0), flib.readexcelData(EXCEL_PATH, "createlead", 2, 0));
        
}
}