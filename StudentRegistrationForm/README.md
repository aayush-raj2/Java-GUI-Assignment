<div align="center">

# 🎓 Student Registration Form (Java Swing)

A **Java Swing-based GUI** application that allows users to enter student details, validate inputs, and store them securely in a **MySQL database**.

![Java](https://img.shields.io/badge/Language-Java-red?logo=java)
![Swing](https://img.shields.io/badge/Framework-Swing-blue)
![Database](https://img.shields.io/badge/Database-MySQL-orange)
![License](https://img.shields.io/badge/License-MIT-green)

</div>

---

## 🖥️ Project Overview

The **Student Registration Form** is a desktop-based Java application built using **Swing** for GUI and **JDBC** for database connectivity.  
It enables users to input student data, perform validation (such as email checks), and save information into a MySQL database for record management.

---

## ⚡ Features

✅ User-friendly **Graphical Interface** using Swing  
✅ Input validation for name, ID, and email fields  
✅ Data storage in **MySQL Database** using JDBC  
✅ “Clear” button to reset input fields  
✅ Modular design with separate database connection class  

---

## 🧠 Technologies Used

| Category | Technology |
|-----------|-------------|
| Programming Language | Java |
| GUI Framework | Java Swing |
| Database | MySQL |
| Connector | JDBC |
| IDE (Optional) | IntelliJ IDEA / Eclipse / VS Code |

---

## 🗂️ Folder Structure

     ```bash
     StudentRegistrationForm/
     │
     ├── src/
     │   ├── StudentRegistrationForm.java       # Main GUI file
     │   └── DBConnection.java                  # Database connection helper
     │
     ├── sql/
     │   └── studentdb.sql                      # SQL script to create DB & table
     │
     ├── README.md                              # Project documentation
     └── .gitignore                             # Ignored build/config files


---

## ⚙️ Setup Instructions

### 🧩 1. Install Prerequisites

Make sure the following are installed on your system:

- Java JDK 8 or later

- MySQL Server

- MySQL Connector JAR (Download here)

- Any Java IDE (Eclipse, IntelliJ, VS Code) or command-line setup

### 🧩 2. Create Database

Run this SQL script in MySQL Workbench or phpMyAdmin:

    ```sql
    CREATE DATABASE studentdb;
    USE studentdb;

    CREATE TABLE students (
    student_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
    );

### 🔌 3. Configure Database Connection

Open src/DBConnection.java and edit these lines:

    ```bash
    private static final String USER = "root";       // your MySQL username
    private static final String PASS = "password";   // your MySQL password
(Keep database name studentdb unless you renamed it.)


### 📦 4. Add MySQL Connector to Classpath

If using an IDE:

- Right-click your project → Build Path → Add External JARs

- Select the downloaded mysql-connector-j-<version>.jar

If using command line:

    ```bash
    javac -cp ".;path/to/mysql-connector.jar" src/*.java
    
### ▶️ 5. Run the Application

Run the following command:

    ```bash
    java -cp ".;path/to/mysql-connector.jar" src/StudentRegistrationForm
💡 Ensure MySQL is running before starting the app.

### 🧪 6. Test Functionality

- Fill in Name, ID, Email, and Course fields

- Click Submit → Data saved to database

- Click Clear → Form resets

---

## 🧩 Example GUI Preview


    ```bash
    ╔════════════════════════════════════════════╗
    ║         Student Registration Form          ║
    ╠════════════════════════════════════════════╣
    ║ Name:        [__________________________]  ║
    ║ Student ID:  [__________________________]  ║
    ║ Email:       [__________________________]  ║
    ║ Course:      [__________________________]  ║
    ╠════════════════════════════════════════════╣
    ║ [   Submit   ]             [   Clear   ]   ║
    ╚════════════════════════════════════════════╝

---

## 🧑‍💻 Author

👤 Aayush Raj

🎓 B.Tech CSE (Software Engineering), SRM University
