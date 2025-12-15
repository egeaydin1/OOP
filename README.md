# ☕ Cafe Order Management System

A Java-based desktop application for managing cafe orders with persistent data storage using JSON.

## 🎯 Overview

Modern table management system for cafes that simplifies order tracking, billing, and table status monitoring. Orders and menu items are saved automatically and persist between sessions.

## ✨ Key Features

- **Dynamic Table Configuration** - Set number of tables on first launch
- **Visual Status Monitoring** - Green (empty) vs Orange (occupied) tables
- **Real-time Order Management** - Add/remove orders with live price calculation
- **Persistent Data Storage** - JSON-based database for orders and menu
- **Menu Management** - Add custom menu items during runtime
- **One-Click Payment** - Quick bill settlement and table reset

## 🏗️ Architecture

### Object-Oriented Design
- **Urun (Product)** - Menu item model with name and price
- **Siparis (Order)** - Order details with product and quantity
- **Masa (Table)** - Table state with order collection
- **KafeSiparisPaneli** - Main GUI application (JFrame)
- **JsonUtil** - Data persistence handler

### Technologies
- Java SE 8+
- Swing/AWT (GUI)
- JSON (Data Storage)
- Collections Framework

### OOP Principles
✓ Encapsulation - Private fields with getters/setters
✓ Abstraction - Business logic hidden in methods
✓ Inheritance - JFrame extension
✓ Polymorphism - Method overriding

## 📦 Installation

### Prerequisites
- JDK 8 or higher
- Eclipse IDE (recommended) or any Java IDE

### Setup with Eclipse

1. **Clone or download the project**
```bash
git clone <repository-url>
cd OOP
```

2. **Open in Eclipse**
   - File → Open Projects from File System
   - Select the `OOP` folder
   - Click Finish

3. **Run the application**
   - Right-click `src/KafeSiparisPaneli.java`
   - Select Run As → Java Application

### Setup with Command Line

```bash
# Navigate to project directory
cd OOP

# Compile
javac -d bin src/*.java

# Run
java -cp bin KafeSiparisPaneli
```

## 🚀 Usage

### First Launch
1. Enter the number of tables (e.g., 8)
2. Tables are created and saved to `data/orders.json`

### Adding Orders
1. Click "Sipariş Ekle" on any table
2. Select product from menu
3. Choose quantity
4. Click "Ekle"

### Payment
1. Click "Hesabı Öde" on occupied table
2. Confirm total amount
3. Table automatically resets

### Menu Management
1. Menu → Menü Yönetimi → Yeni Ürün Ekle
2. Enter product name and price
3. New item saved to `data/menu.json`

## 📁 Project Structure

```
OOP/
├── .classpath           # Eclipse classpath config
├── .project             # Eclipse project file
├── src/                 # Source files
│   ├── KafeSiparisPaneli.java
│   ├── Masa.java
│   ├── Siparis.java
│   ├── Urun.java
│   └── JsonUtil.java
├── bin/                 # Compiled classes
├── data/                # JSON database
│   ├── menu.json
│   └── orders.json
└── docs/                # Documentation
    └── README.md
```

## 🔄 Data Persistence

All data is automatically saved to JSON files:
- **menu.json** - Menu items with prices
- **orders.json** - Table states and active orders

Data saves on:
- Order addition
- Payment completion
- Menu modification
- Application exit

## 🎓 Learning Outcomes

- Java Swing GUI development
- Event-driven programming
- File I/O and JSON parsing
- Object-oriented design patterns
- Collections framework usage
- Application state management

## 📝 License

Educational project - Free to use and modify

---

**Version 2.0** - JSON Database Integration | 2025
