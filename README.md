# QA Banking Testing Project

This repository contains both manual and automation testing artifacts for a sample online banking application.

---

## 📁 Project Structure

```
qa-banking-testing-project/
├── manual/
│   ├── TestPlan.docx
│   ├── QA_Banking_Manual_Artifacts.xlsx     # Contains: Scenarios, Test Cases, Bugs
│   └── TestSummary.docx
│
├── automation/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── utilities/
│   │   │   │       ├── DataProviders.java
│   │   │   │       ├── ExcelUtils.java
│   │   │   │       ├── ExtentManager.java
│   │   │   │       └── ScreenshotUtil.java
│   │   │   └── resources/
│   │   └── test/
│   │       ├── java/
│   │       │   ├── pageObjects/
│   │       │   ├── testBase/
│   │       │   └── testCases/
│   │       └── resources/
│   │           ├── testData/
│   │           ├── log4j2.xml
│   │           └── testng.xml
│   ├── pom.xml
│   ├── logs/
│   ├── reports/
│   │   └── index.html
│   ├── screenshots/
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

📁 Located in the `manual/` folder:

- **Test Plan** – High-level testing strategy and scope
- **QA_Banking_Manual_Artifacts.xlsx** – Contains 3 sheets:
  - `Test_Scenarios`
  - `Test_Cases`
  - `Bug_Report`
- **Test Summary Report** – Final test result summary after execution

---

## 🤖 Automation Framework

- **Language**: Java
- **Build Tool**: Maven
- **Testing Framework**: TestNG
- **Logging**: Log4j2
- **Reporting**: ExtentReports
- **Excel Integration**: Apache POI

### ✅ To Run Tests

```bash
mvn clean test
```

### 📄 TestNG Suite File

Located at: `automation/src/test/resources/testng.xml`

---

## 📌 Reports & Logs

- **Extent Reports**: Auto-generated at `/reports/index.html`
- **Logs**: Saved in `/logs/`
- **Screenshots**: Captured on test failure in `/screenshots/`

> ⚠️ These folders are excluded from Git using `.gitignore`

---

## 🧠 Author

**Amol Bhalsing** – Created as part of the QA learning program.

---

## 📄 License

This project is for **educational/demo purposes only**. No commercial use intended.