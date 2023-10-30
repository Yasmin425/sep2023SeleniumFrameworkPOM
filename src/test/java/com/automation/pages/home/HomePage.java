package com.automation.pages.home;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath ="/html/body/div/div[1]/div[1]/div/nav/ul/li[1]/a") WebElement HomePageEle;
	@FindBy(id ="userNavLabel") WebElement MenuEle;
	@FindBy(xpath ="//*[@id='userNav-menuItems']/a[5]") WebElement LogoutEle;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextFromHomePage() {
		waitForVisibility(HomePageEle, 5,"Salesforce Home Page");
		String data= getTextFromElement(HomePageEle, "Salesforce Home Page");
		myLog.info("text extracted from registartion page="+data);
		return data;
	}
	
	public WebDriver SelectYasminYassinTab() {
		clickElement(MenuEle,"Selecting Yasmin Yassin Tab");
		return driver;
		
	}
	
	public WebDriver clickLogoutButton() {
		clickElement(LogoutEle,"Logout button");
		return driver;
		
	}
	
	public static void waitForVisibility(WebElement ele,int time, int pollingtime, String ObjectName) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time))
		.pollingEvery(Duration.ofSeconds(pollingtime))
		.ignoring(ElementNotInteractableException.class);
			
	}
	
	public static void waitForVisibility(WebElement ele,int time, String objectName) {
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
