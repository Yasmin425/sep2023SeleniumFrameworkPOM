package com.automation.tests.scripts;

import java.util.Properties;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.ForgotPW.ForgotPasswordPage;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.tests.base.BaseTest;
import com.automation.tests.utilities.PropertiesUtility;

public class SalesforceAutomationScript extends BaseTest {

	
@Test
	
	public static void LoginErrorMessage() {
		
		myLog.info("******login_to_Salesforce automation script started***********");
		
		String expected="Please enter your password.";
		
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.Empty.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
		
		String actual=loginPage.getTextFromEmptyPWLoginerrormessage();
		Assert.assertEquals(actual, expected,"Pass: testcase passed");
		
		myLog.info("******login_to_salesforce failed***********");
		myLog.info("******login_to_salesforce automation script ended***********");
	

	}
	
	@Test
	
public static void LoginToSalesforce(){
		
	    myLog.info("******login_to_Salesforce automation script started***********");
	    
		String expected="Home";
		myLog.info("url is entered");

		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
		
		HomePage homePage=new HomePage(driver);
		String actual=homePage.getTextFromHomePage();
		Assert.assertEquals(actual, expected, "Pass: testcase passed");
	
		
		myLog.info("******login_to_salesforce automation script ended***********");
		
		

	}
	@Test
public static void CheckRememberMe() {
	
	myLog.info("******login_to_Salesforce automation script started***********");
	
	String expected="Home";
	String expected2="Username";
	myLog.info("url is entered");

	PropertiesUtility pro=new PropertiesUtility();
	Properties p=pro.createPropertyObject();
	pro.loadFile("applicationDataProperties",p);
	String username=pro.getPropertyValue("login.valid.userid",p);
	String password=pro.getPropertyValue("login.valid.password",p);
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUserName(username);
	loginPage.enterPassword(password);
	loginPage.CheckRememberMeCheckbox();
	driver=loginPage.clickLoginButton();

	
	HomePage homePage=new HomePage(driver);
	String actual=homePage.getTextFromHomePage();
	Assert.assertEquals(actual, expected, "Pass: testcase passed");
	
	homePage.SelectYasminYassinTab();
	driver = homePage.clickLogoutButton();
	
	
	String actual2=loginPage.getLoginPage();
	Assert.assertEquals(actual2, expected2, "Pass: testcase passed");
	
	myLog.info("******login_to_salesforce automation script ended***********");

	

}
	
	@Test
	public static void Forgotpassword() {
		
		//myLog.info("******login_to_Salesforce automation script started***********");
		
		String expected="Forgot Your Password";
	
		//myLog.info("url is entered");
		
		
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		
        ForgotPasswordPage forgotpwPage= new ForgotPasswordPage(driver);
		forgotpwPage.ClickForgotPasswordLink();
		
		

		String actual=forgotpwPage.getTextFromForgotPasswordPageElement();
		Assert.assertEquals(actual, expected, "Pass: testcase passed");
		
		String username=pro.getPropertyValue("login.valid.userid",p);
		forgotpwPage.enterUserName(username);
		forgotpwPage.clickContinueButton();
	
		
		
		//myLog.info("******login_to_salesforce automation script ended***********");
		
		

	}
	@Test
	
public static void ForgotPasswordandUsername() {
		
		myLog.info("******Invalid login_to_Salesforce automation script started***********");
		
		String expected= "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		myLog.info("url is entered");

		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.invalid.userid",p);
		String password=pro.getPropertyValue("login.invalid.password",p);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		driver=loginPage.clickLoginButton();
		
    
		String actual= loginPage.getTextFrominvalidPWandUNLoginErrormessage();
		myLog.info("text is extracted from Login error element");
		
		Assert.assertEquals(actual, expected,"Pass: testcase passed");
		
		myLog.info("******login_to_salesforce failed***********");
		myLog.info("******login_to_salesforce automation script ended***********");
	

	}
	



}
