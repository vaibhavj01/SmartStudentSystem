# 🎓 Smart Student Management System

## 📌 Project Description

Smart Student Management System is a Java-based console application developed using JDBC and MySQL. It allows users to manage student records, courses, and enrollments efficiently.

---

## 🚀 Features

* Add Student
* View All Students
* Update Student Information
* Delete Student
* Search Students:
* Course Management
* Enrollment Management

---

## 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE

---

## 📁 Project Structure

SmartStudentSystem/
│
├── dao/
├── model/
├── util/
├── ConsoleUI.java
├── Main.java
├── smartstudent.sql

---

## ⚙️ Database Setup

Run the following SQL:

```sql
CREATE DATABASE smartstudent;
USE smartstudent;

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    
   
);

CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100),
    duration INT
);

CREATE TABLE enrollment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE
);
```

---

## ▶️ How to Run

1. Clone the repository:
   git clone https://github.com/vaibhavj01/SmartStudentSystem.git

2. Open in Eclipse or IntelliJ

3. Configure database connection in your project

4. Run `Main.java`

---
## 👨‍💻 Author

Vaibhav Jondhale

---
