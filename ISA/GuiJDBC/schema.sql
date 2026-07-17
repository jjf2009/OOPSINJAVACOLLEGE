-- Create database and tables for ISA GuiJDBC practice programs
-- Run: mysql -u root < schema.sql

CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(50),
    city VARCHAR(50),
    marks INT
);

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DOUBLE,
    department VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS books (
    id INT PRIMARY KEY,
    title VARCHAR(150),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS calculations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    num1 DOUBLE,
    num2 DOUBLE,
    sum_result DOUBLE
);

CREATE TABLE IF NOT EXISTS movies (
    id INT PRIMARY KEY,
    title VARCHAR(150),
    year INT
);

CREATE TABLE IF NOT EXISTS feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    message TEXT
);

CREATE TABLE IF NOT EXISTS mobiles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(50),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_no VARCHAR(20),
    guest_name VARCHAR(100),
    days INT
);

CREATE TABLE IF NOT EXISTS courses (
    code VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    credits INT
);

CREATE TABLE IF NOT EXISTS patients (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    disease VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS library_members (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS accounts (
    acc_no INT PRIMARY KEY,
    holder_name VARCHAR(100),
    balance DOUBLE
);

CREATE TABLE IF NOT EXISTS attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no INT,
    status VARCHAR(20),
    att_date DATE
);

CREATE TABLE IF NOT EXISTS exam_results (
    roll_no INT,
    subject VARCHAR(50),
    marks INT
);

-- Sample login user
INSERT IGNORE INTO users (username, password) VALUES ('admin', 'admin123');
INSERT IGNORE INTO users (username, password) VALUES ('student', 'pass');
