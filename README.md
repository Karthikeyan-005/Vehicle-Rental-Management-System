# Vehicle-Rental-Management-System 🚗 🏍️ 🚚 🔑 💰 📋

## Overview

The Vehicle Rental Management System is a Java-based application designed to streamline the process of renting vehicles. It offers role-based access for admins and users, enabling efficient management of vehicles and rental transactions. The application uses MySQL Workbench as its database backend for reliable data storage and retrieval.

This project demonstrates essential software development practices, including object-oriented programming, role-based access control, database integration, and modular design.

## Features

### Admin Role
**Admins can perform the following actions:**

#### Add Vehicles:
Add new vehicles to the system, specifying type, number, rental price, and total availability.
#### Update Vehicles:
Update details of existing vehicles.
#### Delete Vehicles:
Remove vehicles from the system.
#### View All Vehicles:
View the complete list of vehicles, including details like type, number, price per day, and availability.
### User Role

**Users can perform the following actions:**

#### Rent a Vehicle:
Select an available vehicle, specify the rental duration, and make payments.
#### Return a Vehicle:
Return a rented vehicle and update the system inventory.
#### View Available Vehicles:
Browse through the list of vehicles available for rent.

## Technology Stack
### Frontend
**Java Console:** 
The application uses a simple console interface for interactions.
### Backend
**Java:** 
Core programming language used for business logic and role management.

**MySQL:** 
Database used to store vehicle information and transaction details.

### Tools and Libraries
**JDBC:** 
Java Database Connectivity for database operations.

**MySQL Workbench:** 
Used for database creation and management.

### Database Structure
The database vehicle_rental contains a table named vehicles with the following structure:

**id:** Primary key, unique identifier for each vehicle.

**type:** Type of the vehicle (e.g., Car, Bike, Truck).

**number:** Unique vehicle number.

**price_per_day:** Rental price per day.

**total_count:** Number of vehicles available for rent.


## Object-Oriented Programming (OOP) Concepts Used
This application is designed with a strong focus on Object-Oriented Programming (OOP) principles. Below are the key OOP concepts applied in the project:

### 1. Abstraction
**Description:**
Abstracting high-level functionalities through abstract classes.

**Usage:**
The Role class is defined as an abstract class to generalize the behaviors of both admin and user roles. Concrete implementations (AdminRole and UserRole) provide specific functionalities.

### 2. Encapsulation
**Description:**
Wrapping data and methods that operate on data within a single unit to protect the data.

**Usage:**
 The DatabaseConnection class encapsulates database connection logic, ensuring it is reusable and secure.
Admin and user operations are modularized in the AdminOperations and UserOperations classes, hiding implementation details from the main program.

### 3. Inheritance
**Description:**
 Enabling one class to acquire the properties and methods of another class.

**Usage:**
 The AdminRole and UserRole classes inherit from the Role class, allowing common role-based functionalities to be defined once and extended by specific roles.

### 4. Polymorphism
**Description:**
 Allowing methods to be overridden or objects to take on multiple forms.

**Usage:**
 Method overriding is used in AdminRole and UserRole to provide specific implementations of the showMenu() method.
Polymorphism is demonstrated in the main program by treating objects of AdminRole and UserRole as instances of the Role superclass.

### 5. Modularity (Supporting Concept)
**Description:**
 Structuring the application into independent modules for better organization and maintenance.

**Usage:**
 Different functionalities like authentication, role-specific operations, and database interactions are separated into distinct classes.

By leveraging these OOP principles, the application is modular, reusable, and easier to maintain.

## How to Run the Application

### Prerequisites

Java Development Kit (JDK) installed on your system.

MySQL Workbench installed and configured.

MySQL JDBC Driver added to your project's classpath.


### Steps

Clone the repository:

bash

Copy code

git clone https://github.com/Karthikeyan-005/Vehicle-Rental-Management-System.git

Import the project into your favorite IDE (IntelliJ IDEA).


## Set up the database:

### Setup Instructions
1. Clone the Repository
bash
Copy code
git clone https://github.com/Karthikeyan-005/Vehicle-Rental-Management-System.git

2. Set Up the Database

 Open MySQL Workbench or your preferred database tool.

 Create a new database (vehicle_rental).

Import the SQL file located in the /database folder:

Navigate to the database/vehicle_rental.sql file.

Execute the script to set up the schema and populate the tables.

3. Update Database Configuration

In the application code, update the database connection details in the Java file handling the database connection (DatabaseConnection.java):

java

Copy code

String url = "jdbc:mysql://localhost:3306/vehicle_rental";

String user = "your-username";

String password = "your-password";

4. Run the Application

Open the project in your Java IDE.

Build and run the application.

## Usage

### Login:

**Admins:** 
Use the username admin and password admin123.

**Users:** 
Simply select "no" when prompted for admin access.
Follow the menus to perform desired actions.

## Future Enhancements

**Enhanced User Interface:** 
Upgrade from console-based input to a graphical user interface (GUI).

**Reservation History:** 
Add a feature to track rental history for users.

**Analytics:** 
Provide reports on vehicle usage and revenue generation.

**Online Payment Integration:** 
Implement online payment systems for seamless transactions.
