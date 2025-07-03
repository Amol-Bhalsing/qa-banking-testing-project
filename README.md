
# QA Banking Testing Project

This repository contains both manual and automation testing artifacts for a sample online banking application.

---

## 📁 Project Structure

```
qa-banking-testing-project/
├── manual/
│   ├── TestPlan.docx
│   ├── QA_Banking_Manual_Artifacts.xlsx # Scenarios, Test Cases, Bugs (3 sheets)
│   └── TestSummary.docx
│
├── automation/
│   ├── src/
│   │   ├── main/
│   │        └── java/
│   │        │       └── utilities/
│   │        │    	     ├── DataProviders.java
│   │        │    	     ├── ExcelUtils.java
│   │        │    	     ├── ExtentManager.java
│   │        │    	     └── ScreenshotUtil.java
│   │        │── resources/
│   │   └── test/
│   │       └── java/
│   │             ├── pageObjects/
│	│			  ├── testBase/
│   │             └── testCases/
│   │       └── resources/
│   │            └── testData/
│   │            ├── log4j2.xml
│   │            └── testng.xml
│   │
│   ├── pom.xml
│   ├── logs/
│   ├── reports/
│   │   └── index.html
│   ├── screenshots/
│
│
├── jira/
│   ├── BugScreenshot1.png
│   └── JiraCycle.png
│
├── .gitignore
└── README.md
```

---


## ✅ Manual Artifacts

- **Test Plan** – High-level testing strategy.
- **QA_Banking_Manual_Artifacts.xlsx** – Contains:
  - `Test_Scenarios` sheet
  - `Test_Cases` sheet
  - `Bug_Report` sheet
- **Test Summary Report** – Final test result summary.

📁 **All files located in**: `manual/`

---

## 🤖 Automation Framework

- **Language**: Java
- **Build Tool**: Maven
- **Framework**: TestNG
- **Logging**: Log4j2
- **Reporting**: ExtentReports
- **Excel Utility**: Apache POI

### 📦 To Execute Tests

```bash
mvn clean test
```

### 📄 TestNG Suite File
Located at: `automation/src/test/resources/testng.xml`

---

## 📌 Reports & Logs

- **Extent Reports**: Generated in `/reports/index.html`
- **Logs**: Stored in `/logs/` directory

> Note: These folders are excluded from Git using `.gitignore`

---

## 🌐 Author

- Created by Amol Bhalsing as part of QA learning program.

---

## 📄 License

This project is for educational/demo purposes only.
