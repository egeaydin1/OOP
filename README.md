# CAFE ORDER MANAGEMENT SYSTEM

## 📋 Project Overview

The Cafe Order Management System is a Java-based desktop application developed to simplify table-based order tracking for small and medium-sized cafes. This system enables cafe staff to manage order taking, bill tracking, and payment processes quickly and efficiently from a single screen.

## 🎯 Project Purpose

In modern cafes, table management and order tracking can become challenging tasks, especially during peak hours. This project is designed to solve the following problems:

- **Difficulty with Manual Record Keeping**: Manually kept records can lead to errors and customer dissatisfaction
- **Time Loss**: Paper-based order tracking is time-consuming and inefficient
- **Lack of Visibility**: Understanding which tables are occupied/empty and tracking bills can be complex
- **Communication Problems**: Confusion can occur in order communication between kitchen and service staff

The Cafe Order Management System solves these problems through digitalization and automation, enabling staff to make fewer errors, provide faster service, and increase customer satisfaction.

## 🌟 Key Features

### 1. Dynamic Table Configuration
- At program startup, cafe owners can define the number of tables and each table's seating capacity specific to their establishment
- The system automatically creates an aesthetic table layout based on the entered information
- Customizable, flexible structure for each cafe

### 2. Visual Table Status Monitoring
- **Green tables**: Empty tables waiting for customers
- **Orange tables**: Occupied tables with active orders
- Real-time order list and total bill displayed on each table panel
- Ability to monitor the entire cafe at a glance

### 3. Quick Order Management
- User-friendly order addition interface
- Rich predefined menu (coffees, beverages, desserts)
- Multiple product ordering with quantity selection
- Real-time price calculation and updates

### 4. Secure Payment Transactions
- Confirmation of total amount before payment
- One-click bill settlement
- Automatic table cleanup and reset

### 5. Professional Menu System
The system includes a typical cafe menu:
- **Hot Beverages**: Turkish Coffee, Espresso, Cappuccino, Latte, Filter Coffee
- **Cold Beverages**: Tea, Water, Cola, Fruit Juice
- **Desserts**: Cheesecake, Brownie, Cookie

## 🏗️ Technical Architecture and Object-Oriented Design

The project has a **fully object-oriented** architecture following modern software development principles:

### Class Structure

#### 1. **Urun (Product) Class**
- Represents each item on the menu
- Protects name and price information with encapsulation principle
- toString() method is overridden for string representation

#### 2. **Siparis (Order) Class**
- Contains order details for a product
- Product object, quantity information, and automatic total calculation
- Encapsulates business logic (total price calculation)

#### 3. **Masa (Table) Class**
- Fully models a table in the cafe
- Manages table number, capacity, and order collection
- Performs order addition, bill calculation, and payment operations
- Uses Collection framework (ArrayList)

#### 4. **KafeSiparisPaneli (Cafe Order Panel) Class**
- Main application class and user interface
- MVC (Model-View-Controller) like structure
- Event-driven programming (Swing event listeners)
- Dynamic UI creation and updates

### Technologies and Libraries Used

- **Java SE**: Core Java features
- **Swing**: Graphical user interface (GUI) library
- **AWT**: Layout managers and event handling
- **Collections Framework**: Dynamic data management with ArrayList

### Object-Oriented Programming Principles

The project implements the four fundamental principles of OOP:

1. **Encapsulation**:
   - Private variables and public getter/setter methods in all classes
   - Data hiding and controlled access

2. **Abstraction**:
   - Complex business logic is hidden through simple method calls
   - Users can use the system without knowing implementation details

3. **Inheritance**:
   - KafeSiparisPaneli class derived from JFrame
   - Utilizing the inheritance structure of Swing components

4. **Polymorphism**:
   - Overriding of toString() method
   - Event listener interface implementations

## 👥 Target Users

- Small and medium-sized cafe businesses
- Restaurants and cafeterias
- School and corporate canteens
- Tea gardens and patisseries

## 💡 Project Benefits

### For the Business
- ✅ Increased operational efficiency
- ✅ Reduced error rate
- ✅ Faster table turnover
- ✅ Shortened staff training time

### For Staff
- ✅ Easy-to-use, intuitive interface
- ✅ Freedom from manual calculation burden
- ✅ Less stress, more customer-focused work

### For Customers
- ✅ Faster service
- ✅ Minimization of billing errors
- ✅ Professional service experience

## 🚀 Future Development Ideas

The project can be expanded with the following features:

1. **Database Integration**: Order history and reporting
2. **User Authorization**: Different roles (waiter, cashier, manager)
3. **Daily/Monthly Reports**: Sales analytics and statistics
4. **Kitchen Notification System**: Order automation
5. **Mobile Application**: Tablet or phone support
6. **Online Reservation**: Table reservation system
7. **Inventory Tracking**: Product inventory management
8. **Customer Loyalty Program**: Customer profiles and discounts

## 📦 Installation and Running

### Requirements
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Compilation and Running

#### Via Command Line:
```bash
# Compile the project
javac *.java

# Run the program
java KafeSiparisPaneli
```

#### Via IDE:
1. Import all .java files into your IDE
2. Open KafeSiparisPaneli.java file
3. Click the Run button

### First Use
1. Enter the number of tables when the program opens (e.g., 6)
2. Determine the seating capacity for each table (e.g., 2, 4, 4, 6, 4, 2)
3. The main panel will open
4. Click on tables to add orders
5. Complete the transaction with "Pay Bill"

## 📂 Project File Structure

```
KafeSiparisYonetimi/
│
├── Urun.java              # Product model class
├── Siparis.java           # Order model class
├── Masa.java              # Table model class
├── KafeSiparisPaneli.java # Main application and GUI
└── README.md              # This file
```

## 🎓 Educational Value

This project is an excellent example for learning and applying the following concepts:

- Object-oriented programming principles
- GUI development with Java Swing
- Event-driven programming
- Collection framework usage
- Layout managers (GridLayout, BorderLayout)
- Dialog windows and user interaction
- Model-View design approach

## 🤝 Contributing

This project has been developed for object-oriented programming education. For developments and improvements:

1. You can add new features
2. You can perform code optimization
3. You can improve documentation
4. You can make bug fixes

## 📝 License

This project has been developed for educational purposes and can be used freely.

## 👨‍💻 Developer Notes

### Code Quality
- Each class has a single responsibility (Single Responsibility Principle)
- Methods are kept small and focused
- Meaningful variable and method names are used
- Comprehensive JavaDoc comments have been added

### Performance
- Lightweight Swing components are used
- Unnecessary object creation is minimized
- Event listeners are managed efficiently

### Usability
- Intuitive user interface
- Clear error messages
- Visual feedback (colored table states)
- Confirmation dialogs prevent accidental actions

## 📞 Contact and Support

For questions or suggestions:
- Review the project documentation
- Read code comments
- Refer to Java Swing documentation

---

**Cafe Order Management System** - Modern Cafe Management with Object-Oriented Programming 🍵☕🍰

*Version 1.0 - 2025*
