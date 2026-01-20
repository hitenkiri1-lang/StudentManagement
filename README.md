# Student Management System

A Java Swing desktop application developed using **NetBeans 17** for managing students, courses, scores, and marksheets with **MySQL database** support.

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

## Project Structure

StudentManagement  
│  
├── src  
│   ├── student  
│   │   ├── Home.java  
│   │   ├── login.java  
│   │   ├── Student.java  
│   │   ├── Course.java  
│   │   ├── Score.java  
│   │   └── MarkSheet.java  
│   │  
│   ├── db  
│   │   └── MyConnection.java  
│   │  
│   └── icon  
│       ├── visible.png  
│       └── invisible.png  
│  
├── student_management.sql  
├── nbproject  
├── build.xml  
├── manifest.mf  
└── README.md  

---

## Database Setup

### Create Database
    ```sql
    CREATE DATABASE student_management;

##Import SQL File:-
student_management.sql

Tables Used

admin

student

course

score

## 🔑 Admin Login (Default)

    ```sql
    INSERT INTO admin (id,username, password)
    VALUES (1,'admin', '123');

## 🔌 Database Configuration

Edit the file:

src/db/MyConnection.java

Example configuration:

    ```java
    String url = "jdbc:mysql://localhost:3306/student_management";
    String user = "root";
    String password = "your_password";

## ▶ How to Run the Project

1. Open **NetBeans 17**
2. Click **File → Open Project**
3. Select the project folder
4. Add required libraries
5. Right-click the project → **Run:login.java**
6. Login using admin credentials

## 📦 Required Libraries

- **MySQL Connector/J**  
  https://dev.mysql.com/downloads/connector/j/

- **JCalendar (JDateChooser)**  
  https://toedter.com/jcalendar/

- add JCalender and mysql connector in netbeans

## 📄 License

This project is for **educational purposes only**.
