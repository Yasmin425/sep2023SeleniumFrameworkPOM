package com.automation.pages.base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.tests.utilities.ExtentReportsUtility;
import com.automation.tests.utilities.Log4JUtility;

public class BasePage {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected static Logger myLog;
	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		myLog.info("page tittle is returned");
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		myLog.info("page is refreshed");

	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		myLog.info("extracted the text from" + objectName);
		return data;
	}

	

	public void enterText(WebElement ele, String data, String objectName) {
		waitForVisibility(ele,30,objectName);
		if (ele.isDisplayed()) {
			clearElement(ele, objectName);
			ele.sendKeys(data);
			System.out.println("Pass:"+objectName+" is entered to the username filed");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(ObjectName + " is cleared");
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + "button is clicked");
			
		} else {
			System.out.println("button element is not enabled");
			
		}
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

	