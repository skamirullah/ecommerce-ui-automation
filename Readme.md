# **E-commerce Test Automation Framework**  
A robust Java-based test automation framework designed for efficient, scalable, and maintainable web automation testing using the latest Selenium WebDriver (4.X.X).

---

## 📌 **Overview**  
This framework integrates various tools and libraries to enable **data-driven testing, logging, reporting, and cloud-based execution** with **LambdaTest**.

---

## 👨‍💻 **About the Author**  
Hi, My Name is Sk Amir Ullah and I have 7 years of experience in Automation Testing using technologies like Selenium Webdriver, RestAssured, Appium and many others.

My primary expertise is in Java Programming Language.

📧 **Email**: [amirthoughts@gmail.com](mailto:amirthoughts@gmail.com)  

🔗 **Connect with me:**  
- 🔗 **Portfolio:** [GitHub Profile](https://github.com/skamirullah)  
- 🔗 **LinkedIn:** [LinkedIn Profile](https://linkedin.com/in/skamirullah)
-  🔗 **Youtube:** [LinkedIn Profile](https://linkedin.com/in/skamirullah)

---

## ⚡ **Key Features**  
➡️ **Data-Driven Testing**: Reads test data from **CSV, Excel, JSON and Properties** file using **OpenCSV, Apache POI, and Gson and Properties**.  
➡️ **Cross-Browser Testing**: Supports execution on **multiple browsers**.  
➡️ **Headless Execution**: Faster test execution with **headless mode**.  
➡️ **Cloud Testing**: Seamlessly integrates with **LambdaTest** for scalable cloud-based testing.  
➡️ **Robust Logging**: Uses **Log4j** for detailed test execution logs.  
➡️ **Comprehensive Reporting**: Generates **interactive HTML reports** using **Extent Reports**.  
➡️ **GitHub Actions CI/CD**: Automated test execution **daily at 11:30 PM IST** with archived reports.  

---

## 🔧 **Technology Stack**  
| **Technology**  | **Version** | **Purpose** |
|-----------------|------------|-------------|
| **Java**        | 17         | Core Programming Language |
| **TestNG**      | Latest     | Test Execution & Assertions |
| **Selenium WebDriver**    | 4.X.X      | Web Automation |
| **Apache POI**  | Latest     | Excel File Handling |
| **OpenCSV**     | Latest     | CSV Data Handling |
| **Gson**        | Latest     | JSON Data Parsing |
| **Faker**       | Latest     | Test Data Generation |
| **Log4j**       | Latest     | Logging |
| **ExtentReports** | Latest   | Test Reporting |
| **LambdaTest**  | Cloud      | Cross-Browser Cloud Testing |

---

## 🛠 **Setup Instructions**  
### **1️⃣ Prerequisites**  
Ensure the following software is installed:  
- ** Java (Java 17 Recommended)** → [Download & Setup](https://adoptium.net/)  
- **Maven** → [Download & Setup](https://maven.apache.org/download.cgi)  

### **2️⃣ Clone the Repository**  
```sh
git clone https://github.com/skamirullah/ecommerce-ui-automation.git
cd ecommerce-ui-automation
```

## 3️⃣ Run Tests  

### 🔹 Run Tests on LambdaTest  
```sh
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```
### 🔹 Running Tests on Chrome browser on Local Machine in Headless Mode:
```sh
mvn test  -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

## Reports & Logs
Reports: After execution, a detailed HTML report will be generated at ./report.html.

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots of failed tests.

## Logs:
Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project GitHub Actions
This automation framework is integrated with GitHub actions. The tests will be executed at 11:30 PM IST every single day.

The reports will be achieved in the gh-pages branch You can view the HTML reports at: https://skamirullah.github.io/ecommerce-ui-automation/report.html

     
