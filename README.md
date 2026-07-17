# Java OOPS / OOP Lab Programs — College Practicals & ISA Exam Codes

**Object-Oriented Programming Systems (OOPS) in Java** — a complete collection of **college lab experiments**, **ISA exam programs**, practice sets, GUI, JDBC, multithreading, and mini systems.

> **What is this repo?**  
> Free, beginner-friendly **Java OOP source code** for BCA, BSc CS, BE/BTech, and diploma students. Use it for lab submissions, viva prep, and internal assessments (ISA).

[![Java](https://img.shields.io/badge/Java-OOP%20Lab-orange?logo=openjdk)](https://github.com/jjf2009/java-oops-oop-lab-programs)
[![Education](https://img.shields.io/badge/Education-College%20Lab-blue)](https://github.com/jjf2009/java-oops-oop-lab-programs)
[![License](https://img.shields.io/badge/License-Educational-green)](https://github.com/jjf2009/java-oops-oop-lab-programs)

---

## Table of contents

- [Quick start](#quick-start)
- [What you will learn](#what-you-will-learn)
- [Repository structure](#repository-structure)
- [ISA exam programs](#isa-exam-programs)
- [Lab experiments (expt1–expt15)](#lab-experiments-expt1expt15)
- [Practice packs](#practice-packs)
- [How to compile and run](#how-to-compile-and-run)
- [FAQ](#faq)
- [Keywords](#keywords)
- [Who this is for](#who-this-is-for)
- [License](#license)

---

## Quick start

```bash
git clone https://github.com/jjf2009/java-oops-oop-lab-programs.git
cd java-oops-oop-lab-programs

# Example: compile and run an ISA program
cd ISA/ISA3/StudentMarksSaver
javac StudentMarksSaver.java
java StudentMarksSaver
```

---

## What you will learn

This repository teaches **core Object-Oriented Programming concepts in Java** with short, exam-style programs:

| Concept | Covered in |
|--------|------------|
| Classes & objects | expt4, expt5 |
| Inheritance & abstract classes | ISA2, expt6–expt8 |
| Polymorphism (overloading / overriding / dynamic dispatch) | expt7, ISA2 |
| Interfaces | ISA3, expt8, expt9, Pratice/Interfaces |
| Exception handling (custom exceptions) | ISA3, expt10, Pratice/ExceptionHandling |
| Collections (`ArrayList`, `LinkedList`, `Vector`, `Stack`) | ISA3, expt11 |
| File handling (`FileWriter`, text I/O) | ISA3, expt12, Pratice/FileHandling |
| GUI (Swing) | expt13, GP, Pratice/GUI |
| JDBC / MySQL | expt14, Pratice/GuiDB |
| Multithreading | expt15, Pratice/Multithreading |

---

## Repository structure

```
java-oops-oop-lab-programs/
├── ISA/                  # Internal assessment (ISA2 + ISA3) exam codes
│   ├── ISA2/             # Abstract classes + polymorphism
│   ├── ISA3/             # Interfaces + collections + files + exceptions
│   └── porgams.md        # Question bank
├── expt1/ … expt15/      # Full OOPS lab experiments
├── Pratice/              # Topic-wise practice (Collections, GUI, etc.)
├── Pratice2/             # Extra practice set
├── GP/                   # GUI demos (Swing frames)
├── Personal_Project/     # Inventory mini project
└── README.md
```

---

## ISA exam programs

Ready-to-write, **simple and to the point** implementations matching common OOPS lab ISA questions.

### ISA3 — Interfaces · Collections · File I/O · Custom exceptions

| Program | Folder | Concepts |
|---------|--------|----------|
| Student Marks Saver | `ISA/ISA3/StudentMarksSaver` | `Printable`, `ArrayList`, `students.txt`, `InvalidMarksException` |
| Attendance Tracker | `ISA/ISA3/AttendanceTracker` | `Trackable`, `LinkedList`, `attendance.txt`, `StudentNotFoundException` |
| Product Inventory | `ISA/ISA3/ProductInventory` | `Manageable`, `Vector`, `inventory.txt`, `ProductNotFoundException` |
| Browser History | `ISA/ISA3/BrowserHistory` | `Navigable`, `Stack`, `history.txt`, `NoHistoryException` |
| Bus Seat Booking | `ISA/ISA3/BusSeatBooking` | `Bookable`, `Vector`, capacity 40, `SeatFullException` |
| Contact Book | `ISA/ISA3/ContactBook` | `Saveable`, `Vector`, `contacts.txt`, `DuplicateContactException` |
| Simple Task Manager | `ISA/ISA3/SimpleTaskManager` | `Taskable`, `LinkedList`, `NoTasksException` |
| Quiz Score Board | `ISA/ISA3/QuizScoreBoard` | `Scorable`, `ArrayList` sort, `scores.txt`, `NegativeScoreException` |

### ISA2 — Abstract classes · Inheritance · Polymorphism

| Program | Folder |
|---------|--------|
| Employee Payroll System | `ISA/ISA2/EmployeePayrollSystem` |
| Vehicle Rental Service | `ISA/ISA2/VehicleRentalService` |
| Shape Area Calculator | `ISA/ISA2/ShapeAreaCalculator` |
| Pet Adoption Center | `ISA/ISA2/PetAdoptionCenter` |
| Supermarket Billing | `ISA/ISA2/SupermarketBilling` |
| Student Result Management | `ISA/ISA2/StudentResultManagement` |
| Hospital Patient Tracker | `ISA/ISA2/HospitalPatientTracker` |
| Library Book Manager | `ISA/ISA2/LibraryBookManager` |
| Bank Account Manager | `ISA/ISA2/BankAccountManager` |
| School Course Enrollment | `ISA/ISA2/SchoolCourseEnrollment` |
| Product Inventory Tracker | `ISA/ISA2/ProductInventoryTracker` |
| Hotel Room Booking System | `ISA/ISA2/HotelRoomBookingSystem` |
| Music Playlist Manager | `ISA/ISA2/MusicPlaylistManager` |
| Fitness Tracker | `ISA/ISA2/FitnessTracker` |
| Food Order System | `ISA/ISA2/FoodOrderSystem` |
| Student Grade Tracker | `ISA/ISA2/StudentGradeTracker` |

Each program lives in **its own folder** so class names do not clash. Open the folder, compile, run.

---

## Lab experiments (expt1–expt15)

### expt1 — Basic Java programs
`BinToOct`, `FirstAndLast`, `FloydsTriangle`, `Palindrome`, `Table`

### expt2 — Arrays and matrices
`DisplayDulicates`, `IdentityMatrix`, `MedianofArray`, `MergeSortofArray`, `SymmetricMatrix`

### expt3 — String handling
`LongestWord`, `LowerToUpper`, `PalindromeString`, `RemoveDuplicateWords`, `SortStrings`

### expt4 — Mini OOP systems
`CourseEnrollment`, `CricketStats`, `HotelBooking`, `SavingsAccountSystem`, `ShoppingCartSystem`

### expt5 — OOP case studies
`BankAccountSystem`, `BookInventorySystem`, `CircleSystem`, `EmployeeSystem`, `TemperatureConverterSystem`

### expt6 — Inheritance & payment / device models
Course management, device hierarchy, logger, payments, savings account

### expt7 — Polymorphism
Method overloading, overriding, dynamic dispatch, interface polymorphism

### expt8 — Advanced OOP systems
Media system, smart home, order processing, game characters

### expt9 — Interfaces (smart energy grid)
Multiple interfaces, hybrid systems, power/load abstractions

### expt10 — Exceptions
ATM, student marks processing, custom exceptions

### expt11 — Collections
Contact manager, order manager, pair finder, stack sorter

### expt12 — File handling
Courses, cricket stats, savings system with text files

### expt13 — Swing GUI
Employee profile viewer, student dashboard (MVC-style)

### expt14 — JDBC + GUI forms
Student registration, view, update, delete with MySQL

### expt15 — Multithreading
Thread examples, printer sync, thread count

---

## Practice packs

- **`Pratice/`** — Collections, Exception Handling, File Handling, GUI, GuiDB, Interfaces, Multithreading  
- **`Pratice2/`** — Second practice set for the same topics  
- **`GP/`** — Swing frame demos  
- **`Personal_Project/`** — Inventory add / view / delete

---

## How to compile and run

### Lab experiment file

```bash
javac expt1/Palindrome.java
java -cp expt1 Palindrome
```

### ISA program (own folder)

```bash
cd ISA/ISA2/EmployeePayrollSystem
javac EmployeePayrollSystem.java
java EmployeePayrollSystem
```

### JDBC programs (expt14)

Requires MySQL and the connector JAR on the classpath (see `expt14/mysql-connector-j-*.jar`).

---

## FAQ

### What is OOPS in Java?
**OOPS (Object-Oriented Programming System)** in Java means building software with **classes, objects, encapsulation, inheritance, polymorphism, and abstraction**. This repo shows each idea with short lab-style programs.

### Is this useful for ISA / internal exams?
Yes. The **`ISA/`** folder has exam-style solutions for abstract classes, interfaces, collections, file I/O, and custom exceptions — written simply for 60-minute paper/lab tests.

### Can beginners use this?
Yes. Programs are **simple and to the point**, with clear class names and demo `main` methods. Start from `expt1` and move up, or open any ISA folder and run it.

### Which Java version do I need?
Any modern JDK (8+) works for most programs. GUI and JDBC need a desktop JDK and MySQL where noted.

### How do I search for a topic?
Use the tables above, or search the repo for keywords like `interface`, `abstract`, `ArrayList`, `Exception`, `FileWriter`, `Swing`, `Thread`.

---

## Keywords

Java OOPS programs, Java OOP lab experiments, object oriented programming Java college, Java inheritance polymorphism interface examples, Java collections ArrayList LinkedList Vector Stack, Java custom exception handling, Java file handling FileWriter, Java Swing GUI lab, Java JDBC MySQL student forms, Java multithreading examples, ISA Java exam programs, BCA BTech BSc CS practical Java source code, abstract class polymorphism Java assignment.

---

## Who this is for

- **College students** (BCA, BSc Computer Science, BE/BTech CSE/IT, diploma)
- Learners preparing **OOPS practical notebooks** and **viva**
- Anyone who needs **copy-run-learn** Java OOP examples for assignments

---

## Citation (for AI search & study tools)

If you reference this material:

> Java OOPS / OOP Lab Programs — college practicals and ISA exam codes.  
> Repository: https://github.com/jjf2009/java-oops-oop-lab-programs  
> Topics: Object-Oriented Programming, Java, lab experiments, ISA assessments.

---

## License

Educational use. Feel free to study, modify for assignments, and share with classmates. Keep attribution if you republish the collection.

---

**Star this repo** if it helps your Java OOPS lab or ISA prep — it makes the collection easier for other students to find on GitHub and search engines.
