# ISA Exam & Practice Programs — Java OOPS Lab

Question bank: [porgams.md](porgams.md)

---

## ISA1 — First Internal Test

**Even roll numbers**

| Program | Path |
|---------|------|
| Special Number | [ISA1/SpecialNumber](ISA1/SpecialNumber) |
| Laptop Store | [ISA1/LaptopStore](ISA1/LaptopStore) |

**Odd roll numbers**

| Program | Path |
|---------|------|
| First & Last Digit | [ISA1/FirstAndLastDigit](ISA1/FirstAndLastDigit) |
| Shopping Cart System | [ISA1/ShoppingCartSystem](ISA1/ShoppingCartSystem) |

```bash
cd ISA1/SpecialNumber
javac SpecialNumber.java
java SpecialNumber
```

---

## ISA2 — Abstract classes & polymorphism

See folders under [ISA2/](ISA2/).

## ISA3 — Interfaces, collections, files, exceptions

See folders under [ISA3/](ISA3/).

---

## GuiJDBC — Practice Programs for GUI with JDBC (1–40)

Folder: [GuiJDBC/](GuiJDBC/)

Shared files:

- `DBConnection.java` — MySQL connection (`localhost:3306/test`, user `root`)
- `schema.sql` — create all tables + sample users

### Setup

1. Start MySQL and create tables:

```bash
mysql -u root < GuiJDBC/schema.sql
```

2. Compile with the MySQL connector JAR (example from expt14):

```bash
cd GuiJDBC
javac -cp ".:../../expt14/mysql-connector-j-9.7.0.jar" *.java
java -cp ".:../../expt14/mysql-connector-j-9.7.0.jar" P01_LoginForm
```

Default login from schema: **admin / admin123**

### Program list

| # | Class | What it does |
|---|--------|----------------|
| 1 | `P01_LoginForm` | Login against `users` table |
| 2 | `P02_StudentRegistration` | Insert student |
| 3 | `P03_EmployeeInsert` | Insert employee |
| 4 | `P04_DisplayStudents` | Show all students in text area |
| 5 | `P05_SearchStudent` | Search by roll no |
| 6 | `P06_UpdateStudentCity` | Update city by roll |
| 7 | `P07_DeleteEmployee` | Delete employee by ID |
| 8 | `P08_BookInsert` | Insert book |
| 9 | `P09_DisplayProductNames` | List product names |
| 10 | `P10_CustomerRegistration` | Register customer |
| 11 | `P11_SumStore` | Sum two numbers, save to DB |
| 12 | `P12_LoginSuccessMessage` | Validate login + success message |
| 13 | `P13_MovieInsert` | Insert movie |
| 14 | `P14_StudentMarksEntry` | Save marks |
| 15 | `P15_SearchEmployeeSalary` | Search salary by ID |
| 16 | `P16_UpdateBookPrice` | Update book price |
| 17 | `P17_DisplayEmployees` | All employees via ResultSet |
| 18 | `P18_LibraryMemberReg` | Library member registration |
| 19 | `P19_DeleteStudent` | Delete student by roll |
| 20 | `P20_FeedbackForm` | Save feedback |
| 21 | `P21_MobileInsert` | Insert mobile |
| 22 | `P22_SearchProduct` | Search product by ID |
| 23 | `P23_UpdateCustomerPhone` | Update phone |
| 24 | `P24_DisplayProducts` | All products in text area |
| 25 | `P25_HotelBooking` | Room booking insert |
| 26 | `P26_CourseInsert` | Insert course |
| 27 | `P27_DisplayEmployeeNames` | Employee names only |
| 28 | `P28_UpdateStudentMarks` | Update marks by roll |
| 29 | `P29_DeleteProduct` | Delete product by ID |
| 30 | `P30_PatientInsert` | Hospital patient insert |
| 31 | `P31_AdminLogin` | Admin login validation |
| 32 | `P32_DisplayBookTitles` | Book titles |
| 33 | `P33_BankAccountInsert` | Bank account insert |
| 34 | `P34_SearchLibraryMember` | Search member by ID |
| 35 | `P35_UpdateEmployeeDept` | Update department |
| 36 | `P36_AttendanceInsert` | Attendance entry |
| 37 | `P37_DisplayCustomers` | All customers |
| 38 | `P38_DeleteBook` | Delete book by ID |
| 39 | `P39_ExamResultInsert` | Exam results insert |
| 40 | `P40_StudentCRUD` | Full CRUD on students |

If MySQL password is not empty, edit `GuiJDBC/DBConnection.java` (`PASS` field).
