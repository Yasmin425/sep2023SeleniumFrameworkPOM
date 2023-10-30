package com.automation.pages.ForgotPW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.base.BasePage;

public class ForgotPasswordPage extends BasePage{
	

	
	@FindBy(id="forgot_password_link") WebElement ForgotPasswordLinkElement;
	@FindBy(xpath="//*[@id=\"header\"]") WebElement ForgotPasswordPageElement;
	@FindBy(id="un") WebElement userNameElement;
	@FindBy(id="continue") WebElement ContinueButtonElement;

	
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		enterText(userNameElement, data, "Username textbox");
	}
	
	

	public WebDriver ClickForgotPasswordLink() {
		clickElement(ForgotPasswordLinkElement,"Forgot your Password link");
		return driver;
		
	}
	
	public WebDriver clickContinueButton() {
		clickElement(ContinueButtonElement,"continue button");
		return driver;
		
	}
	public String getTitleOfThePAge() {
		//waitUntilPageLoads();
		return getPageTitle();
	}
	public String getTextFromForgotPasswordPageElement() {
		waitForVisibility(ForgotPasswordPageElement, 5,"Forgot Password Page");
		String data= getTextFromElement(ForgotPasswordPageElement, "Forgot Password Page");
		myLog.info("text extracted from registartion page="+data);
		return data;
	}

	

	
}
