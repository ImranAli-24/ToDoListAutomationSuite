package com.automation.test;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.automation.base.CommonTestActions;
import com.automation.pages.ToDoListValidationPage;

public class ToDoListTest extends CommonTestActions {

	// First Scenario - Adding one TODO list value and asserting
	@Test
	public void addingFirstToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();

			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// second Scenario - Adding one or more TODO list value and asserting
	@Test
	public void addingMultiToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();

			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));

			toDoPage.enterKeyword(inputFile.getProperty("secondtodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("secondtodovalue"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Third Scenario - Adding one TODO list value and Verify text of All, Active
	// completed
	@Test
	public void verifyLinks(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();

			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));
			toDoPage.textVerification();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Fourth Scenario - Adding one TODO list value and perform completion changes
	@Test
	public void verifyCompletedToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));
			toDoPage.selectToDoList();
			toDoPage.completionChanges();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Fifth Scenario - Adding one TODO list value and perform All, Active and
	// completed function completion changes
	@Test
	public void verifyCompletionChanges(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);			
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));
			toDoPage.selectToDoList();
			toDoPage.validatingFunctionalLinks();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Sixth Scenario - Adding more than one TODO list value and perform completion
	 * changes
	 */
	@Test
	public void verifyMultiCompletedToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));

			toDoPage.enterKeyword(inputFile.getProperty("secondtodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("secondtodovalue"));

			toDoPage.selectToDoList();
			toDoPage.completionChanges();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Seventh Scenario - Adding one TODO list value and verify clearcompleted
	 * changes
	 */
	@Test
	public void verifyClearCompleteToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));

			toDoPage.selectToDoList();
			toDoPage.selectClearComplete();
			toDoPage.assertingClearCompletionToDo();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Eigth Scenario - Adding one TODO list value and verify clearcompleted
	 * changes
	 */
	@Test
	public void verifyMultiClearCompleteToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));
			
			toDoPage.enterKeyword(inputFile.getProperty("secondtodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("secondtodovalue"));

			toDoPage.selectToDoList();
			toDoPage.selectClearComplete();
			toDoPage.assertingClearCompletionToDo();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Ninth Scenario - Adding one TODO list value and performed clear cross mark button
	 * changes
	 */
	@Test
	public void verifyClearCrossMarkToDoList(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));

			toDoPage.selectToDoList();
			toDoPage.selectClearButton();
			toDoPage.assertingClearCompletionToDo();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Tenth Scenario - Adding one TODO list value and performed Edit function
	 * changes
	 */
	@Test
	public void verifyEditFunction(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));
			toDoPage.editToDoList();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Eleventh Scenario - Adding one TODO list value and verify item count
	 */
	@Test
	public void verifyCompletionCount(ITestContext context) {
		try {
			logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.set(logger);
			ToDoListValidationPage toDoPage = new ToDoListValidationPage();
			toDoPage.openToDoListURL();
			toDoPage.enterKeyword(inputFile.getProperty("firsttodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("firsttodovalue"));
			toDoPage.enterKeyword(inputFile.getProperty("secondtodovalue"));
			toDoPage.validatingToDoList(inputFile.getProperty("secondtodovalue"));
			toDoPage.selectSingleToDoList();
			toDoPage.itemCountValue();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
