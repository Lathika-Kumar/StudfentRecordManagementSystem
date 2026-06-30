# 🎓 Student Record Management System (SRMS)

A console-based **Student Record Management System** developed in **Core Java** to demonstrate the implementation of **Object-Oriented Programming (OOP)** concepts. The application manages student information, academic records, and attendance using a modular architecture and custom exception handling.

---

## 📌 Project Objective

The objective of this project is to apply Core Java concepts by building a real-world application that demonstrates:

- Object-Oriented Programming
- Encapsulation
- Abstraction
- Exception Handling
- Collections Framework
- Modular Programming

---

# ✨ Features

### 👨‍🎓 Student Management
- Add Student
- View Student Details
- Search Student
- Display All Students

### 📚 Academic Records
- Store academic information
- View student academic records
- Generate student summary

### 📅 Attendance Management
- Maintain attendance records
- View attendance details

### ⚠ Exception Handling
- Duplicate student validation
- Invalid student validation
- Record not found handling

---

# 🛠 Technologies Used

- Java
- Eclipse IDE
- Object-Oriented Programming (OOP)
- Java Collections Framework

---

# 📂 Project Structure

```
StudentRecordManagementSystem
│
├── src
│
├── com.wipro.srms
│   │
│   ├── entity
│   │     ├── Student.java
│   │     ├── AcademicRecord.java
│   │     └── AttendanceRecord.java
│   │
│   ├── service
│   │     └── StudentRecordService.java
│   │
│   ├── util
│   │     ├── DuplicateRecordException.java
│   │     ├── InvalidStudentException.java
│   │     └── RecordNotFoundException.java
│   │
│   └── main
│         └── Main.java
│
└── module-info.java
```

---

# 🏗 Project Architecture

```
               Main.java
                    │
                    ▼
       StudentRecordService.java
                    │
      ┌─────────────┼──────────────┐
      ▼             ▼              ▼
 Student     AcademicRecord   AttendanceRecord
                    │
                    ▼
          Custom Exception Classes
```

---

# 📚 OOP Concepts Demonstrated

### Encapsulation
- Data members are declared private.
- Access is provided through getters and setters.

### Abstraction
- Business logic is separated into the service layer.

### Association
- Student objects are associated with academic and attendance records.

### Exception Handling
- Custom exceptions improve error handling and validation.

### Modular Programming
- Code is organized into separate packages for better maintainability.

---

# 📋 Packages

## entity
Contains the model classes:
- Student
- AcademicRecord
- AttendanceRecord

## service
Contains the business logic for managing student records.

## util
Contains custom exception classes.

## main
Contains the entry point (`Main.java`) and the menu-driven interface.

---

# ▶ How to Run

1. Clone the repository.

```bash
git clone https://github.com/Lathika-Kumar/StudentRecordManagementSystem.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Run `Main.java`.

---

# 🖥 Sample Menu

```
========== Student Record Management System ==========

1. Add Student
2. Search Student
3. View All Students
4. Academic Records
5. Attendance Records
6. Generate Student Summary
7. Exit

Enter your choice:
```

---

# 🎯 Learning Outcomes

This project helped in understanding:

- Core Java Programming
- Object-Oriented Programming
- Collections Framework
- Exception Handling
- Modular Code Organization
- Console Application Development

---

# 🚀 Future Enhancements

- JDBC Integration
- Database Support
- File Handling
- Login Authentication
- GUI using JavaFX or Swing
- Report Generation
- REST API using Spring Boot

---

# 👩‍💻 Author

**Lathika Kumar**

B.Tech – Artificial Intelligence and Data Science

Passionate about Java, AI/ML, and Software Development.

---

⭐ If you found this project useful, consider giving it a star on GitHub!
