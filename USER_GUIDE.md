# Cafe Order Management System - How to Use?

## 🚀 Quick Start Guide

### Step 1: Starting the Program

#### For Windows:
1. Open Command Prompt (CMD)
2. Navigate to the project folder:
   ```
   cd C:\Users\...\KafeSiparisYonetimi
   ```
3. Compile the program:
   ```
   javac *.java
   ```
4. Run the program:
   ```
   java KafeSiparisPaneli
   ```

#### For Mac/Linux:
1. Open Terminal
2. Navigate to the project folder:
   ```
   cd ~/Desktop/Claude/KafeSiparisYonetimi
   ```
3. Compile the program:
   ```
   javac *.java
   ```
4. Run the program:
   ```
   java KafeSiparisPaneli
   ```

### Step 2: Initial Setup

When the program starts, complete the following steps in order:

**1. Determine the Number of Tables**
- Enter the total number of tables in your cafe in the window that opens
- Example: `6` (six tables)

**2. Determine the Capacity of Each Table**
- Enter how many people each table seats
- Example distribution:
  - Table 1: `2` seats
  - Table 2: `4` seats
  - Table 3: `4` seats
  - Table 4: `6` seats
  - Table 5: `4` seats
  - Table 6: `2` seats

### Step 3: Using the Main Panel

After the program opens, you will see your tables on the main screen.

#### Understanding Table Colors
- 🟢 **Green Table**: Empty table, waiting for customers
- 🟠 **Orange Table**: Has orders, occupied table

#### What's on Each Table Panel?
- **Top section**: Table number and capacity
- **Middle section**: Order list and prices
- **Bottom section**: Two buttons
  - **Add Order** (Blue button)
  - **Pay Bill** (Green button)

## 📝 Basic Operations

### Adding an Order

1. Click the **"Add Order"** button on the relevant table
2. Select a product from the menu in the window that opens
3. Adjust the quantity (default: 1)
4. Click the **"Add"** button
5. The order will be automatically added to the table

**Example Scenario:**
```
Customer came to Table 3 and ordered:
- 2x Cappuccino
- 1x Cheesecake
- 2x Water

Process:
1. Click Table 3's "Add Order" button
2. Select Cappuccino, quantity: 2, Add
3. Click Table 3's "Add Order" button again
4. Select Cheesecake, quantity: 1, Add
5. Click Table 3's "Add Order" button again
6. Select Water, quantity: 2, Add

Total: 2x45 + 65 + 2x10 = 175 TL
```

### Bill Payment

1. When the customer requests the bill, click the **"Pay Bill"** button on the relevant table
2. View the total amount in the window that opens
3. Confirm payment by clicking **"Yes"**
4. The table will automatically be cleaned and turn green

**Warning:** If you try to pay the bill for an empty table, the system will warn you.

## 🍽️ Menu and Prices

### Hot Beverages ☕
- Turkish Coffee: 35 TL
- Espresso: 40 TL
- Cappuccino: 45 TL
- Latte: 45 TL
- Filter Coffee: 38 TL

### Cold Beverages 🥤
- Tea: 15 TL
- Water: 10 TL
- Cola: 25 TL
- Fruit Juice: 30 TL

### Desserts 🍰
- Cheesecake: 65 TL
- Brownie: 55 TL
- Cookie: 40 TL

## 💡 Tips and Best Practices

### For Efficient Use
1. **Remember Table Numbers**: Match the numbers in the program with your physical tables
2. **Follow the Colors**: Fill green tables quickly, keep track of orange tables
3. **Multiple Orders**: Increase the quantity for multiple orders of the same product
4. **Quick Payment**: Close the bill before the customer leaves

### Avoid Common Mistakes
- ❌ Don't click the "Add" button without selecting a product
- ❌ Don't try to pay an empty table
- ❌ Don't access the program from multiple windows simultaneously

## 🔧 Troubleshooting

### Program Won't Open
- Make sure Java is installed (check with `java -version` command)
- Verify all files are in the same folder
- If there's a compilation error, read the error message

### Tables Not Showing
- Make sure you entered the table count correctly
- Try resizing the window
- Use the scroll bar

### Order Not Being Added
- Make sure you selected a product from the list
- Check that the quantity is between 1-50

## 📊 Example Usage Scenarios

### Scenario 1: Morning Shift
```
09:00 - Table 1: 2x Turkish Coffee (70 TL)
09:15 - Table 3: 1x Cappuccino, 2x Cookie (125 TL)
09:30 - Table 1 paid
09:45 - Table 2: 1x Filter Coffee, 1x Cheesecake (103 TL)
```

### Scenario 2: Lunch Rush
```
12:00 - Table 1: 4x Latte, 2x Brownie (290 TL)
12:05 - Table 2: 2x Cappuccino, 2x Cheesecake (220 TL)
12:10 - Table 3: 3x Tea, 1x Cookie (85 TL)
12:15 - Table 4: 6x Water, 6x Cola (210 TL)
12:30 - Table 1 paid
12:35 - Table 2 paid
```

## 🎯 Advanced Usage

### Quick Operation Shortcuts
- **Tab**: Navigate through the product list
- **Enter**: Add selected product
- **Esc**: Close dialog window

### Managing Multiple Orders
When working with multiple tables simultaneously:
1. First take orders for all tables
2. Then process bill payments
3. Clean tables one by one

## 📞 Help and Support

### Frequently Asked Questions

**Q: Can I change the menu?**
A: Yes! Edit the `menuHazirla()` method in the KafeSiparisPaneli.java file.

**Q: Can I add more tables?**
A: Yes! You can enter any number of tables at program startup.

**Q: Can I change the prices?**
A: Yes! Edit the prices in the `menuHazirla()` method and recompile the program.

---

**Happy Working!** ☕✨

If you have any questions, review the README.md file or read the comments in the source code.
