# STC TV Automation
This is an example project for doing web automation testing for "STC TV Web Application" to assert that the plan prices and currency are correct for (SA, Kuwait and Bahrain).

# Project Description:
- Project includes one test case that use data providers to run cases multiple times with data in excel files in (./Resuources).
- Project supports parallel execution for cases based on the given number in testng file.

# Project Specifications:
- Programming Language: Java
- Automation tool: Selenium WebDriver
- Framework: TestNG
- Design Pattern: Page Object Design Patern & DDT
- Project Management: Maven
- Reporting: Extent Report Manager
- Available browsers: Chrome, Firefox

# Environment & Project Setup:
- Import project as a Maven project to your compiler.
- Apply Maven Install build for this project.
- Run project as Maven Build/ TestNG build.
- Test cases will run using "Google Chrome" by default but it can be changed to "Firefox" from the test case.
- Reports will be created at directory: ./SavedExtentReports.
