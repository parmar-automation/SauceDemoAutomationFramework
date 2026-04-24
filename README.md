# SauceDemo Automation Framework

This is a professional Java-based *Data-Driven Automation Framework* developed for the *SauceDemo* (Swag Labs) application. The framework is built using best practices like Page Object Model (POM) and modular architecture to ensure high maintainability and scalability.

---

## 🚀 Key Features
- *Page Object Model (POM):* Designed for clean code separation and high maintainability.
- *Data-Driven Testing:* Fully integrated with *Apache POI* to execute test cases using multiple data sets from Excel.
- *Professional Reporting:* Generates detailed, interactive HTML reports using *Extent Reports*.
- *Automated Screenshots:* Automatically captures application state screenshots on test failure for rapid debugging.
- *TestNG Listeners:* Custom listeners implemented to monitor execution and trigger real-time reporting events.
- *Log Integration:* Integrated logging for better tracking of test execution flow.

---

## 🛠️ Tech Stack
- *Language:* Java (JDK 8+)
- *Automation Engine:* Selenium WebDriver
- *Test Management:* TestNG
- *Reporting Tool:* Extent Reports (Spark Reporter)
- *Build Management:* Maven
- *Data Management:* Apache POI (Excel)

---

## 📁 Project Structure
- src/main/java: Contains Page Classes (POM) and Utility functions.
- src/test/java: Contains functional Test Cases and Base Setup.
- Reports/: Execution reports generated in HTML format.
- Screenshots/: Failed test evidence captured during execution.
- testng.xml: Centralized file to manage and trigger the test suite.

---

## 🏃 How to Run
1. *Clone the Repository:* git clone https://github.com/parmar-automation/SauceDemoAutomationFramework.git
2. *Import Project:* Import as a 'Maven Project' into Eclipse or IntelliJ.
3. *Update Data:* Modify the Excel data sheets located in the resources folder.
4. *Execution:* Right-click on testng.xml -> *Run As > TestNG Suite*.
