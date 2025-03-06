# Inheritance
## What is Inheritance?
In object-oriented programming (OOP), Inheritance allows one class (child class or subclass) to inherit fields and 
methods from another class (parent class or superclass). 
This helps in code reuse, allowing the child class to use the functionality of the parent class, and modify or extend 
it as needed.
In Java, we use the keyword extends to establish inheritance.

## Key Concepts:
**Parent Class (Superclass)**: This is the class that provides the fields and methods to be inherited.
**Child Class (Subclass)**: This is the class that inherits from the parent class. It can add its own fields and 
methods or override inherited methods.
**Method Overriding**: This allows the child class to provide its specific implementation of a method that is already 
defined in the parent class.
**super Keyword**: Used to access parent class methods or constructors from the child class.
**this Keyword**: Refers to the current instance of the class.

## Step-by-Step Example with Detailed Explanations
### 1. Define the Parent Class
The parent class is the Employee class. It has basic properties such as name and position, as well as a method 
displayDetails() to print these details.
```bash
// Parent class
class Employee {
    String name;
    String position;

    // Constructor for the parent class (Employee)
    Employee(String name, String position) {
        this.name = name;  // `this.name` refers to the instance variable of the class
        this.position = position; // `this.position` refers to the instance variable of the class
    }

    // Method to display details of the employee
    void displayDetails() {
        System.out.println("Employee: " + name);
        System.out.println("Position: " + position);
    }
}
```
Explanation:
The Employee class is the parent class.
Constructor: This is used to initialize the name and position of the employee. The constructor uses this to refer to the
instance variables of the class.
Method displayDetails(): This prints the name and position of the employee.

### 2. Define the Child Class (Doctor)
Now, we define the Doctor class that inherits from Employee. The Doctor class has an additional property: 
specialization. It also overrides the displayDetails() method 
to add more specific information.

```bash
// Child class (Doctor inherits from Employee)
class Doctor extends Employee {
    String specialization;

    // Constructor for Doctor class
    Doctor(String name, String position, String specialization) {
        super(name, position);  // Calling the parent constructor to initialize name and position
        this.specialization = specialization; // Initializing the specialization of the doctor
    }

    // Overriding the displayDetails method for Doctor
    @Override
    void displayDetails() {
        super.displayDetails(); // Calling the parent method (Employee's displayDetails)
        System.out.println("Specialization: " + specialization); // Adding doctor's specialization
    }
}
```

## Changing Method Behavior in Overriding
```bash
// Parent class
class Employee {
    String name;
    String position;

    // Constructor
    Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Position: " + position);
    }
}

// Child class (Doctor inherits from Employee)
class Doctor extends Employee {
    String specialization;

    // Constructor
    Doctor(String name, String specialization) {
        super(name, "Doctor"); // Position is always "Doctor"
        this.specialization = specialization;
    }

    // Overriding the displayDetails method to completely change its behavior
    @Override
    void displayDetails() {
        System.out.println("👨‍⚕️ Meet Dr. " + name + "!");
        System.out.println("Specialty: " + specialization);
        System.out.println("Dr. " + name + " is an expert in " + specialization + ".");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", "Manager");
        emp.displayDetails();

        System.out.println(); // Line break for clarity

        Doctor doc = new Doctor("Smith", "Cardiology");
        doc.displayDetails(); // Calls the overridden method
    }
}

```
Explanation:
The Doctor class is the child class that extends Employee. It inherits name and position from Employee and adds a 
specialization field.
Constructor: The Doctor constructor calls the parent class constructor using super(name, position), passing the name 
and position parameters. 
This ensures that the Employee class is initialized first.
Method Overriding: The Doctor class overrides the displayDetails() method. By calling super.displayDetails(), the child 
class uses the Employee class’s displayDetails() method to print 
the common details, and then adds its own details like the doctor's specialization.

### 3. Using super and this
**super():** Refers to the parent class’s constructor and is used to initialize the parent class's fields.
**super.displayDetails()**: Calls the parent class's method. In this case, we want to reuse the displayDetails() method 
from Employee, and then we add more functionality 
specific to the Doctor class.

### 4. Testing in the Main Class
Finally, we use the Doctor class in the Main class to create a new Doctor object and display the details.
```bash
public class Main {
    public static void main(String[] args) {
        // Creating a Doctor object
        Doctor doc = new Doctor("Dr. Smith", "Doctor", "Surgeon");
        doc.displayDetails(); // Calling the displayDetails method
    }
}
```
Explanation:
Creating the Doctor object: We create an instance of the Doctor class and pass the name, position, and specialization 
as arguments.
Calling displayDetails(): We call the displayDetails() method, which will first display the common details from the 
Employee class and then the specific details from the Doctor class.

### Expected Output:
```bash
Employee: Dr. Smith
Position: Doctor
Specialization: Surgeon
```

### BReakdown of what happened
The Doctor object is created, which calls the Doctor constructor.
The Doctor constructor calls the Employee constructor via super(name, position), initializing name and position for the 
employee.
The displayDetails() method in Doctor is called. It first invokes super.displayDetails() to print the employee details, 
then prints the doctor’s specialization.

### Summary of Key Concepts in Inheritance
Inheritance allows a subclass (child class) to inherit properties and methods from a superclass (parent class).
The super keyword is used to refer to the parent class, either to call a constructor or a method.
The this keyword is used within the class to refer to the current instance.
Method Overriding allows the child class to modify or extend the functionality of a method inherited from the parent 
class.
Constructors ensure that both parent and child classes are properly initialized.

## 🚀 Exercise Time
Now that you understand inheritance, let’s do some real-world exercises!

### 🛒 Easy: Exercise 1 - The Online Store
🔹 Scenario: You’re designing a shopping website like Amazon.
Every product has a name and a price.
Electronics have a warranty period.
Clothes have a size.
Books have an author.

📌 Task:
Create a Product class with name and price.
Create Electronics, Clothing, and Book subclasses.
Give each subclass a unique attribute.
Create some objects and print their details.

### Medium: Exercise 2 - The Hospital System
🔹 Scenario: A hospital has different types of workers.

All employees have a name and ID number.
Doctors can diagnose patients.
Nurses can administer medication.
Receptionists can schedule appointments.
📌 Task:

Create an Employee class with name and ID.
Create Doctor, Nurse, and Receptionist subclasses.
Each subclass should have a special action (e.g., diagnose(), administer_meds()).
Create objects and test their actions.

### 🚕 Hard: Exercise 3 - The Rideshare App (Uber/Lyft)
🔹 Scenario: You’re building a rideshare app.

All vehicles have a license plate and driver name.
Regular taxis have a metered fare.
Ride-sharing cars (like Uber) have dynamic pricing.
Electric cars have a battery level.
📌 Task:

Create a Vehicle class with license_plate and driver_name.
Create Taxi, UberCar, and ElectricCar subclasses.
Give each subclass a unique method (e.g., calculate_fare(), check_battery()).
Simulate a trip by creating objects and calling methods.

### 🏦 Harder: Exercise 4 - The Bank System
🔹 Scenario: You work at a bank designing an account system.

All bank accounts have an account number and balance.
A SavingsAccount has interest rates.
A CheckingAccount has overdraft protection.
A BusinessAccount can request loans.
📌 Task:

Create a BankAccount class.
Create SavingsAccount, CheckingAccount, and BusinessAccount subclasses.
Each subclass should have its own unique function.
Simulate deposits, withdrawals, and loans.

### 🛰️ Hardest: Exercise 5 - The Smart City System
🔹 Scenario: You’re working on a smart city project.

Every building has an address and a number of floors.
Smart Homes can control appliances remotely.
Smart Offices can track employee attendance.
Smart Factories can automate production.
📌 Task:

Create a Building class with address and floors.
Create SmartHome, SmartOffice, and SmartFactory subclasses.
Each subclass should have one advanced feature.
Simulate different activities in the city!


