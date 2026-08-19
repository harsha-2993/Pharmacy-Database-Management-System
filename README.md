# 💊 Pharmacy Database Management System

A **Java and MySQL-based Pharmacy Database Management System** designed to manage pharmacy operations such as medicine records, inventory, customer information, and database transactions efficiently.

---

## 📌 Project Overview

The **Pharmacy Database Management System (Pharmacy DBMS)** is a desktop-based application developed using **Java** and **MySQL**.

The system provides a simple and organized way to manage pharmacy-related information through a centralized database. It helps reduce manual record keeping and improves the efficiency and accuracy of pharmacy data management.

---

## 🎯 Objectives

* Manage medicine information efficiently.
* Store and retrieve pharmacy records using MySQL.
* Reduce manual data entry and record-keeping.
* Provide a simple Java-based interface for pharmacy operations.
* Maintain organized and consistent database records.
* Demonstrate the integration of Java with MySQL.

---

## ✨ Features

* 💊 Medicine record management
* 📦 Inventory management
* 🔍 Search and retrieve medicine information
* 🗄️ MySQL database integration
* 🔌 Java-MySQL database connectivity using JDBC
* 📝 Database queries for pharmacy operations
* ⚡ Efficient data retrieval and management
* 🖥️ Simple Java-based application

---

## 🛠️ Technologies Used

| Technology       | Purpose                             |
| ---------------- | ----------------------------------- |
| **Java**         | Application development             |
| **MySQL**        | Database management                 |
| **JDBC**         | Java-MySQL connectivity             |
| **Eclipse IDE**  | Java development                    |
| **Git & GitHub** | Version control and project hosting |

---

## 🏗️ Project Structure

```text
Pharmacy-Database-Management-System/
│
├── src/
│   └── pharmacy/
│       ├── DBConnection.java
│       ├── PharmacySystem.java
│       └── TestConnection.java
│
├── pharmacy_db_queries.sql
├── .classpath
├── .gitignore
├── .project
└── README.md
```

### 📂 Important Files

**`DBConnection.java`**
Handles the connection between the Java application and MySQL database using JDBC.

**`PharmacySystem.java`**
Contains the main application logic and pharmacy management functionality.

**`TestConnection.java`**
Used to test whether the Java application can successfully connect to the MySQL database.

**`pharmacy_db_queries.sql`**
Contains the SQL queries required for creating and managing the pharmacy database.

---

## 🗄️ Database

The project uses **MySQL** as its relational database management system.

The SQL file contains the queries required to create and manage the pharmacy database.

### Database Setup

1. Install **MySQL Server** and **MySQL Workbench**.
2. Open MySQL Workbench.
3. Open:

```text
pharmacy_db_queries.sql
```

4. Execute the SQL queries.
5. Verify that the required database and tables have been created.
6. Update the database connection details in `DBConnection.java`.

---

## 🔌 Database Connection

The Java application connects to MySQL using **JDBC**.

The connection generally follows this structure:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/your_database",
    "your_username",
    "your_password"
);
```

> ⚠️ **Security Note:** Do not upload real database passwords or other sensitive credentials to a public GitHub repository.

---

## ▶️ How to Run the Project

### Step 1 — Clone the Repository

```bash
git clone https://github.com/harsha-2993/Pharmacy-Database-Management-System.git
```

### Step 2 — Open the Project

Open the project in **Eclipse IDE**.

Select:

```text
File → Import → Existing Projects into Workspace
```

Select the cloned project folder.

### Step 3 — Configure MySQL

* Start MySQL Server.
* Open MySQL Workbench.
* Execute `pharmacy_db_queries.sql`.
* Verify that the database has been created.

### Step 4 — Configure Database Credentials

Open:

```text
src/pharmacy/DBConnection.java
```

Update the MySQL:

* Database name
* Username
* Password
* Port, if required

### Step 5 — Run the Application

Run:

```text
PharmacySystem.java
```

from Eclipse.

---

## 🔄 System Workflow

```text
User
  ↓
Java Pharmacy Application
  ↓
JDBC Database Connection
  ↓
MySQL Database
  ↓
Store / Retrieve / Manage Pharmacy Data
  ↓
Display Results
```

---

## 📊 Key Benefits

* Centralized pharmacy data management
* Reduced manual record keeping
* Faster data retrieval
* Better organization of medicine records
* Improved data consistency
* Easy integration between Java and MySQL
* Suitable for academic demonstration of DBMS concepts

---

## 🚀 Future Enhancements

The system can be further improved by adding:

* 🔐 User authentication and role-based access
* 📊 Sales and purchase reports
* 🧾 Billing and invoice generation
* ⚠️ Low-stock alerts
* 📅 Medicine expiry-date alerts
* 👥 Customer and supplier management
* 📈 Dashboard and analytics
* 🖥️ Improved graphical user interface
* ☁️ Cloud database integration

---

## 🎓 Academic Project

This project demonstrates practical implementation of:

* Database Management Systems
* Relational databases
* SQL
* JDBC
* Java programming
* CRUD operations
* Database connectivity
* Git and GitHub version control

---

## 👨‍💻 Contributors

**A V Harshit Sai**

Additional team members can be added here:

```text
- A V Harshit Sai
```

---

## 📜 License

This project was developed for **educational and academic purposes**.

---

## ⭐ Acknowledgements

This project was developed as part of an academic project to demonstrate the practical application of **Java, MySQL, JDBC, and Database Management System concepts**.
