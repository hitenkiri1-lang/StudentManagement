# Student Management System

A Java Swing desktop application developed using NetBeans 17 for managing students, courses, scores, and marksheets with MySQL database support.

---

## Features
- Admin login system
- Student add, update, delete, and search
- Course management (semester-wise)
- Score management
- CGPA calculation
- Marksheet generation
- Student image upload
- MySQL database integration

---

## Technologies Used
- Java (JDK 17)
- Java Swing
- NetBeans IDE 17
- MySQL
- JDBC
- JCalendar (JDateChooser)
  
---

## 🗄 Database Setup

### 1️⃣ Create Database
```sql
CREATE DATABASE student_management;

2️⃣ Import SQL File
db/student_management.sql

3️⃣ Tables Used

admin

student

course

score

-----
🔑 Admin Login (Default)
INSERT INTO admin (username, password)
VALUES ('admin', 'admin123');


------
🔌 Database Configuration

Edit the file:

src/db/MyConnection.java


Example:

String url = "jdbc:mysql://localhost:3306/student_management";
String user = "root";
String password = "your_password";

------
▶ How to Run the Project
  Using NetBeans 17
  Open NetBeans
  Click File → Open Project
  Select the project folder
  Right-click project → Run
  Login using admin credentials
-------

📦 Required Libraries
  Add these libraries to NetBeans:

  MySQL Connector/J
  https://dev.mysql.com/downloads/connector/j/
    
  JCalendar (JDateChooser)
  https://toedter.com/jcalendar/
--------
📄 License

This project is for educational purposes only.

