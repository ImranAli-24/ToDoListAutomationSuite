# Project Title: 

TodoMVC Automation Suite

## Description:

Automated TodoMVC application using Data Driven TestNg Framework along with Page Object model Pattern.

List of below critical sanity scenarios identified as part of Automation code test and developed

* Adding one TODO list value and asserting.
* Adding one or more TODO list value and asserting.
* Adding one TODO list value and Verify text of All, Active, completed.
* Adding one TODO list value and perform completion changes.
* Adding one TODO list value and perform All, Active and completed function completion changes.
* Adding more than one TODO list value and perform completion changes.
* Adding one TODO list value and verify clearcompleted changes.
* Adding one or more TODO list value and verify clearcompleted changes.
* Adding one TODO list value and performed clear cross mark button changes.
* Adding one TODO list value and performed Edit function changes.
* Adding one or more TODO list value and verify item count

## Prerequisites:

* Required Eclipse or Intellij or any IDE
* Required TestNg Plugin for Eclipse.(For Intellij, TestNg plugin will install default).
* Required Java JDK 1.8 version.

## Softwares Used:

* Eclipse
* TestNg Plugin
* Extent Report
* Selenium Webdriver
* Java

## How to Run the project

Complete test scenarios suite is configure in below TestNg xml file.

Can execute the test cases in parallel by update the Thread-count in testng_web.xml.

Execute testng_Web.xml -> Run as TestNg suite.

After completion of execution ExtentReportResults_web.html file will generate to analyize report

Created screenshot folder to capture pass and failed screenshot.
