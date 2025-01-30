## CAR SERVICE MANAGEMENT SYSTEM
Car Service Management System is a Java-based application to manage customer profiles and car services. The system enables CRUD (Create, Read, Update, Delete) operations on customer data and provides robust validation for user inputs such as email and phone numbers.
This was an experimental project to learn how to integrate Java with JDBC.

The database consists of 6 tables:
* Customers
* Vehicles
* Appointments
* Services
* Employees
* Invoices

CRUD operations on Customer Table (excluding Update) is implemented. The rest will be implemented using SpringBoot in another project.

## Technologies Used
* Programming Language: Java
* Architecture:
  * Service Layer: Encapsulates business logic.
  * DAO Layer: Handles database operations.
  * Validation Layer: Ensures data integrity.
* Database: Supports integration with relational databases

## How to run
Clone this repository and update it with your database connection details after creating your own database. 
Run `Main.java` file.