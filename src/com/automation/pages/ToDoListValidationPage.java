package com.automation.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.base.CommonTestActions;
import com.relevantcodes.extentreports.LogStatus;


public class ToDoListValidationPage extends CommonTestActions {

	public ToDoListValidationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//*[@class='todo-count']/strong")
	private WebElement itemCount;
	
	@FindBy(xpath = "//*[@class='edit']")
	private WebElement editText;
	
	@FindBy(xpath = "//*[@class='clear-completed']")
	private WebElement clearComplete;
	
	@FindBy(xpath = "//*[@class='destroy']")
	private WebElement clearButton;

	@FindBy(xpath = "//*[@class='todo completed']")
	private WebElement completedToDoList;
	
	@FindBy(xpath = "//*[@class='todo completed']")
	private List<WebElement> multiCompletedToDoList;

	@FindBy(xpath = "//*[@class='filters']/li")
	private List<WebElement> verifyLinks;

	@FindBy(xpath = "//*[@class='todo']//*[@type='checkbox']")
	private List<WebElement> clickingCompletionCheckBox;
	
	@FindBy(xpath = "(//*[@class='todo']//*[@type='checkbox'])[1]")
	private WebElement clickingSingleCompletionCheckBox;

	@FindBy(xpath = "//*[@class='todo']/*/label")
	private List<WebElement> todoValueAssertion;

	@FindBy(xpath = "//*[@class='new-todo']")
	private WebElement validateToDoPage;

	public void openToDoListURL() {
		getDriver().get("https://todomvc.com/examples/vue/");
		waitForElementWeb(validateToDoPage);
	}

	public void enterKeyword(String value) {
		sendText(validateToDoPage, value, "Entered todo list: " + value);
		validateToDoPage.sendKeys(Keys.ENTER);

	}
	
	public void itemCountValue() {
		int itemToDoListCount = Integer.parseInt(itemCount.getText());
		Assert.assertEquals(itemToDoListCount, clickingCompletionCheckBox.size());
		getThreadLogger().log(LogStatus.PASS, "Item count validation successful: "+itemToDoListCount);
	}
	
	public void editToDoList() {
		Actions action = new Actions(getDriver());
		for (WebElement webElement : todoValueAssertion) {
			action.doubleClick(webElement).perform();
			action.click(editText).perform();
			editText.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			editText.sendKeys("value");
			editText.sendKeys(Keys.TAB);
			logger.log(LogStatus.INFO, "Edit and replaced new value");
		}
	}

	public void validatingToDoList(String value) {
		boolean expectedValue = false;
		for (WebElement element : todoValueAssertion) {
			if (element.getText().equals(value)) {
				Assert.assertTrue(true, "to do list added : " + element.getText());
				getThreadLogger().log(LogStatus.PASS, "Asserted to do list added : " + element.getText());
				expectedValue = true;
			}
		}
		if (!expectedValue) {
			Assert.assertFalse(false, "to do list not added : " + value);
			getThreadLogger().log(LogStatus.FAIL, "Asserted to do list not added : " + value);
		}
	}

	public void textVerification() {
		for (WebElement webElement : verifyLinks) {

			switch (webElement.getText()) {
			case "All":
				Assert.assertTrue(true, "All text is verified");
				getThreadLogger().log(LogStatus.PASS, "Asserted All text is verified");
				break;
			case "Active":
				Assert.assertTrue(true, "Active text is verified");
				getThreadLogger().log(LogStatus.PASS, "Asserted Active text is verified");
				break;
			case "Completed":
				Assert.assertTrue(true, "Completed text is verified");
				getThreadLogger().log(LogStatus.PASS, "Asserted Completed text is verified");
				break;
			default:
				break;
			}
		}

	}
	
	

	public void selectToDoList() {
		for (WebElement webElement : clickingCompletionCheckBox) {
			customizeClick(webElement, "selected check box");
		}
		
	}
	
	public void selectSingleToDoList() {
			customizeClick(clickingSingleCompletionCheckBox, "selected single check box");
	}
	
	public void selectClearButton() {
		Actions action = new Actions(getDriver());
		action.moveToElement(clearButton);
		customizeClick(clearButton, "Mouse hover and clicking the Cross mark to clear");
	}
	
	public void selectClearComplete() {
		customizeClick(clearComplete, "Selecting clear complete button");
	}
	
	public void assertingClearCompletionToDo() {
		if (!isWebElementDisplayedBrowser(completedToDoList))
			Assert.assertTrue(true);
		else
			Assert.assertFalse(false, "Todo completed list is displayed");
	}

	public void validatingFunctionalLinks() {
		for (WebElement webElement : verifyLinks) {

			switch (webElement.getText()) {
			case "All":
				customizeClick(webElement, "Clicking All link");
				if (isWebElementDisplayedBrowser(completedToDoList))
					Assert.assertTrue(true);
				else
					Assert.assertFalse(false, "Todo completed list is not displayed");
				break;
			case "Active":
				customizeClick(webElement, "Clicking Active link");
				if (!isWebElementDisplayedBrowser(completedToDoList))
					Assert.assertTrue(true);
				else
					Assert.assertFalse(false, "Todo completed list is displayed");
				break;
			case "Completed":
				customizeClick(webElement, "Clicking completed link");
				if (isWebElementDisplayedBrowser(completedToDoList))
					Assert.assertTrue(true);
				else
					Assert.assertFalse(false, "Todo completed list is not displayed");
				break;
			default:
				break;
			}
		}
	}

	public void completionChanges() {
		for (WebElement webElement : multiCompletedToDoList) {
		if (isWebElementDisplayedBrowser(webElement))
			Assert.assertTrue(true);
		else
			Assert.assertFalse(false, "Todo completed list is not displayed");
	}
	}
}
