# CAFE ORDER MANAGEMENT SYSTEM - COMPLETE PROJECT CONTEXT FILE

## GENERAL PROJECT INFORMATION

**Project Name:** Cafe Order Management System
**Version:** 1.0
**Language:** Java
**GUI Framework:** Java Swing
**Date:** 2025
**Project Type:** Object-Oriented Programming Educational Project

---

## PROJECT ARCHITECTURE

### Class Diagram
```
┌─────────────┐
│    Urun     │
│  (Product)  │
├─────────────┤
│ - ad        │
│ - fiyat     │
├─────────────┤
│ + getAd()   │
│ + getFiyat()│
└─────────────┘
       ▲
       │ uses
       │
┌─────────────┐
│  Siparis    │
│   (Order)   │
├─────────────┤
│ - urun      │
│ - adet      │
├─────────────┤
│ + getUrun() │
│ + getAdet() │
│ + getToplamFiyat()│
└─────────────┘
       ▲
       │ uses
       │
┌─────────────┐
│    Masa     │
│   (Table)   │
├─────────────┤
│ - masaNo    │
│ - kapasite  │
│ - siparisler│
├─────────────┤
│ + siparisEkle()│
│ + hesabiOde()  │
│ + getToplamTutar()│
└─────────────┘
       ▲
       │ uses
       │
┌──────────────────┐
│ KafeSiparisPaneli│
│   (JFrame)       │
├──────────────────┤
│ - masalar        │
│ - menuUrunleri   │
├──────────────────┤
│ + main()         │
└──────────────────┘
```

---

## SOURCE CODE FILES

### 1. Urun.java

```java
/**
 * Product class - Represents menu items in the cafe
 * Each product has a name and price
 */
public class Urun {
    private String ad;
    private double fiyat;

    /**
     * Creates a new product
     * @param ad Product name
     * @param fiyat Product price (TL)
     */
    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    /**
     * Returns product name
     * @return Product name
     */
    public String getAd() {
        return ad;
    }

    /**
     * Returns product price
     * @return Product price
     */
    public double getFiyat() {
        return fiyat;
    }

    /**
     * Displays product as string
     * @return String in "Product Name - Price TL" format
     */
    @Override
    public String toString() {
        return ad + " - " + fiyat + " TL";
    }
}
```

---

### 2. Siparis.java

```java
/**
 * Order class - Holds order information for a product
 * Contains product, quantity and total price information
 */
public class Siparis {
    private Urun urun;
    private int adet;

    /**
     * Creates a new order
     * @param urun Ordered product
     * @param adet Product quantity
     */
    public Siparis(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }

    /**
     * Returns ordered product
     * @return Product object
     */
    public Urun getUrun() {
        return urun;
    }

    /**
     * Returns order quantity
     * @return Product quantity
     */
    public int getAdet() {
        return adet;
    }

    /**
     * Calculates total price of the order
     * @return Total price (quantity x unit price)
     */
    public double getToplamFiyat() {
        return urun.getFiyat() * adet;
    }

    /**
     * Displays order as string
     * @return String in "Quantity x Product Name = Total Price TL" format
     */
    @Override
    public String toString() {
        return adet + "x " + urun.getAd() + " = " + getToplamFiyat() + " TL";
    }
}
```

---

### 3. Masa.java

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Table class - Represents a table in the cafe
 * Contains table number, capacity and order list
 */
public class Masa {
    private int masaNo;
    private int kapasite;
    private List<Siparis> siparisler;

    /**
     * Creates a new table
     * @param masaNo Table number
     * @param kapasite Seating capacity of table
     */
    public Masa(int masaNo, int kapasite) {
        this.masaNo = masaNo;
        this.kapasite = kapasite;
        this.siparisler = new ArrayList<>();
    }

    /**
     * Returns table number
     * @return Table number
     */
    public int getMasaNo() {
        return masaNo;
    }

    /**
     * Returns table capacity
     * @return Seating capacity
     */
    public int getKapasite() {
        return kapasite;
    }

    /**
     * Returns table's order list
     * @return Order list
     */
    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    /**
     * Adds a new order to the table
     * @param siparis Order to be added
     */
    public void siparisEkle(Siparis siparis) {
        siparisler.add(siparis);
    }

    /**
     * Calculates table's total bill
     * @return Total amount (TL)
     */
    public double getToplamTutar() {
        double toplam = 0;
        for (Siparis siparis : siparisler) {
            toplam += siparis.getToplamFiyat();
        }
        return toplam;
    }

    /**
     * Pays the bill and cleans the table
     * Clears all orders
     */
    public void hesabiOde() {
        siparisler.clear();
    }

    /**
     * Checks if table is empty
     * @return true if table is empty, false if occupied
     */
    public boolean bosMu() {
        return siparisler.isEmpty();
    }
}
```

---

### 4. KafeSiparisPaneli.java

```java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * KafeSiparisPaneli - Main application class
 * Provides graphical interface and functionality for cafe order management system
 *
 * Features:
 * - Dynamic table creation
 * - Order addition and management
 * - Bill payment operations
 * - Visual table status display
 */
public class KafeSiparisPaneli extends JFrame {
    private ArrayList<Masa> masalar;
    private ArrayList<Urun> menuUrunleri;
    private JPanel masaPaneli;

    /**
     * Main application window constructor
     * Prepares menu, gets table information and creates interface
     */
    public KafeSiparisPaneli() {
        masalar = new ArrayList<>();
        menuUrunleri = new ArrayList<>();
        menuHazirla();

        setTitle("Cafe Order Management System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        masaBilgileriniAl();

        masaPaneli = new JPanel();
        int masaSayisi = masalar.size();
        int kolonSayisi = (int) Math.ceil(Math.sqrt(masaSayisi));
        int satirSayisi = (int) Math.ceil((double) masaSayisi / kolonSayisi);
        masaPaneli.setLayout(new GridLayout(satirSayisi, kolonSayisi, 10, 10));
        masaPaneli.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Masa masa : masalar) {
            masaPaneli.add(masaPaneliOlustur(masa));
        }

        add(new JScrollPane(masaPaneli));
    }

    /**
     * Prepares cafe menu
     * Adds predefined products to menu
     */
    private void menuHazirla() {
        menuUrunleri.add(new Urun("Turkish Coffee", 35.0));
        menuUrunleri.add(new Urun("Espresso", 40.0));
        menuUrunleri.add(new Urun("Cappuccino", 45.0));
        menuUrunleri.add(new Urun("Latte", 45.0));
        menuUrunleri.add(new Urun("Filter Coffee", 38.0));
        menuUrunleri.add(new Urun("Tea", 15.0));
        menuUrunleri.add(new Urun("Water", 10.0));
        menuUrunleri.add(new Urun("Cola", 25.0));
        menuUrunleri.add(new Urun("Fruit Juice", 30.0));
        menuUrunleri.add(new Urun("Cheesecake", 65.0));
        menuUrunleri.add(new Urun("Brownie", 55.0));
        menuUrunleri.add(new Urun("Cookie", 40.0));
    }

    /**
     * Gets table information from user
     * Asks for number of tables and each table's capacity
     */
    private void masaBilgileriniAl() {
        String masaSayisiStr = JOptionPane.showInputDialog(this,
            "How many tables are in the cafe?", "Table Count", JOptionPane.QUESTION_MESSAGE);

        if (masaSayisiStr == null || masaSayisiStr.trim().isEmpty()) {
            System.exit(0);
        }

        int masaSayisi = Integer.parseInt(masaSayisiStr.trim());

        for (int i = 1; i <= masaSayisi; i++) {
            String kapasiteStr = JOptionPane.showInputDialog(this,
                "Capacity for Table " + i + " (number of seats)?",
                "Table Capacity", JOptionPane.QUESTION_MESSAGE);

            if (kapasiteStr == null || kapasiteStr.trim().isEmpty()) {
                System.exit(0);
            }

            int kapasite = Integer.parseInt(kapasiteStr.trim());
            masalar.add(new Masa(i, kapasite));
        }
    }

    /**
     * Creates visual panel for a specific table
     * @param masa Table to create panel for
     * @return Table panel
     */
    private JPanel masaPaneliOlustur(Masa masa) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        // Set color based on table status
        if (masa.bosMu()) {
            panel.setBackground(new Color(220, 255, 220)); // Light green - Empty
        } else {
            panel.setBackground(new Color(255, 240, 220)); // Light orange - Occupied
        }

        // Title (Table number and capacity)
        JLabel baslik = new JLabel("Table " + masa.getMasaNo() +
            " (Capacity: " + masa.getKapasite() + " seats)", SwingConstants.CENTER);
        baslik.setFont(new Font("Arial", Font.BOLD, 16));
        baslik.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(baslik, BorderLayout.NORTH);

        // Order display area
        JTextArea siparisAlani = new JTextArea();
        siparisAlani.setEditable(false);
        siparisAlani.setFont(new Font("Monospaced", Font.PLAIN, 12));
        siparisAlani.setMargin(new Insets(5, 5, 5, 5));
        siparisGuncelle(masa, siparisAlani);

        JScrollPane scrollPane = new JScrollPane(siparisAlani);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel butonPaneli = new JPanel(new GridLayout(2, 1, 5, 5));
        butonPaneli.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Add Order button
        JButton siparisEkleBtn = new JButton("Add Order");
        siparisEkleBtn.setFont(new Font("Arial", Font.BOLD, 12));
        siparisEkleBtn.setBackground(new Color(100, 180, 255));
        siparisEkleBtn.setForeground(Color.WHITE);
        siparisEkleBtn.setFocusPainted(false);
        siparisEkleBtn.addActionListener(e -> {
            siparisEkleDialog(masa);
            siparisGuncelle(masa, siparisAlani);
            if (!masa.bosMu()) {
                panel.setBackground(new Color(255, 240, 220));
            }
        });

        // Pay Bill button
        JButton hesapOdeBtn = new JButton("Pay Bill");
        hesapOdeBtn.setFont(new Font("Arial", Font.BOLD, 12));
        hesapOdeBtn.setBackground(new Color(100, 200, 100));
        hesapOdeBtn.setForeground(Color.WHITE);
        hesapOdeBtn.setFocusPainted(false);
        hesapOdeBtn.addActionListener(e -> {
            if (masa.bosMu()) {
                JOptionPane.showMessageDialog(this,
                    "This table has no orders!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int cevap = JOptionPane.showConfirmDialog(this,
                "Total amount: " + String.format("%.2f", masa.getToplamTutar()) +
                " TL\n\nPay the bill?",
                "Bill Payment", JOptionPane.YES_NO_OPTION);

            if (cevap == JOptionPane.YES_OPTION) {
                masa.hesabiOde();
                siparisGuncelle(masa, siparisAlani);
                panel.setBackground(new Color(220, 255, 220));
                JOptionPane.showMessageDialog(this,
                    "Bill paid. Table cleaned!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        butonPaneli.add(siparisEkleBtn);
        butonPaneli.add(hesapOdeBtn);
        panel.add(butonPaneli, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Updates table's order display area
     * @param masa Table to update
     * @param siparisAlani Order display text area
     */
    private void siparisGuncelle(Masa masa, JTextArea siparisAlani) {
        StringBuilder sb = new StringBuilder();

        if (masa.bosMu()) {
            sb.append("Table empty\n\n");
            sb.append("Total: 0.00 TL");
        } else {
            sb.append("ORDERS:\n");
            sb.append("─────────────────────\n");
            for (Siparis siparis : masa.getSiparisler()) {
                sb.append(siparis.toString()).append("\n");
            }
            sb.append("─────────────────────\n");
            sb.append(String.format("TOTAL: %.2f TL", masa.getToplamTutar()));
        }

        siparisAlani.setText(sb.toString());
    }

    /**
     * Opens order addition dialog window
     * @param masa Table to add order to
     */
    private void siparisEkleDialog(Masa masa) {
        JDialog dialog = new JDialog(this, "Add Order - Table " + masa.getMasaNo(), true);
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));

        JPanel icerikPanel = new JPanel(new BorderLayout(10, 10));
        icerikPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel baslik = new JLabel("Select Product:", SwingConstants.LEFT);
        baslik.setFont(new Font("Arial", Font.BOLD, 14));
        icerikPanel.add(baslik, BorderLayout.NORTH);

        // Product list
        DefaultListModel<Urun> listModel = new DefaultListModel<>();
        for (Urun urun : menuUrunleri) {
            listModel.addElement(urun);
        }

        JList<Urun> urunListesi = new JList<>(listModel);
        urunListesi.setFont(new Font("Arial", Font.PLAIN, 13));
        urunListesi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(urunListesi);
        icerikPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel altPanel = new JPanel(new BorderLayout(5, 5));

        // Quantity selection
        JPanel adetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        adetPanel.add(new JLabel("Quantity:"));
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 50, 1);
        JSpinner adetSpinner = new JSpinner(spinnerModel);
        adetSpinner.setPreferredSize(new Dimension(70, 25));
        adetPanel.add(adetSpinner);
        altPanel.add(adetPanel, BorderLayout.NORTH);

        // Buttons
        JPanel butonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton ekleBtn = new JButton("Add");
        ekleBtn.setBackground(new Color(100, 180, 255));
        ekleBtn.setForeground(Color.WHITE);
        ekleBtn.setFocusPainted(false);
        ekleBtn.addActionListener(e -> {
            Urun secilenUrun = urunListesi.getSelectedValue();
            if (secilenUrun == null) {
                JOptionPane.showMessageDialog(dialog,
                    "Please select a product!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int adet = (Integer) adetSpinner.getValue();
            Siparis siparis = new Siparis(secilenUrun, adet);
            masa.siparisEkle(siparis);

            JOptionPane.showMessageDialog(dialog,
                adet + "x " + secilenUrun.getAd() + " added!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });

        JButton iptalBtn = new JButton("Cancel");
        iptalBtn.addActionListener(e -> dialog.dispose());

        butonPanel.add(ekleBtn);
        butonPanel.add(iptalBtn);
        altPanel.add(butonPanel, BorderLayout.CENTER);

        icerikPanel.add(altPanel, BorderLayout.SOUTH);
        dialog.add(icerikPanel);

        dialog.setVisible(true);
    }

    /**
     * Application entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            KafeSiparisPaneli panel = new KafeSiparisPaneli();
            panel.setVisible(true);
        });
    }
}
```

---

## FEATURES AND USAGE

### Main Features

1. **Dynamic Table Management**
   - User determines number of tables at startup
   - Separate capacity can be defined for each table
   - Tables arranged with grid layout

2. **Order Management**
   - Product selection from menu
   - Quantity determination (between 1-50)
   - Real-time price calculation
   - Display of order list

3. **Visual Status Display**
   - Green color: Empty table
   - Orange color: Occupied table
   - Order list and total amount on each table

4. **Payment Operations**
   - Secure payment with confirmation dialog
   - Automatic table cleanup
   - Bill summary display

### Menu Contents

**Hot Beverages:**
- Turkish Coffee: 35 TL
- Espresso: 40 TL
- Cappuccino: 45 TL
- Latte: 45 TL
- Filter Coffee: 38 TL

**Cold Beverages:**
- Tea: 15 TL
- Water: 10 TL
- Cola: 25 TL
- Fruit Juice: 30 TL

**Desserts:**
- Cheesecake: 65 TL
- Brownie: 55 TL
- Cookie: 40 TL

---

## INSTALLATION AND RUNNING

### Requirements
- Java Development Kit (JDK) 8+
- Command line or IDE

### Compilation
```bash
javac *.java
```

### Running
```bash
java KafeSiparisPaneli
```

### First Use
1. Enter number of tables (e.g., 6)
2. Determine capacity of each table
3. Main panel opens
4. Add orders to tables
5. Process payment transactions

---

## TECHNICAL DETAILS

### Object-Oriented Principles

**Encapsulation:**
- Private variables in all classes
- Public getter/setter methods
- Data hiding

**Abstraction:**
- Complex business logic is hidden
- Simple API provided

**Inheritance:**
- Derivation from JFrame
- Swing component hierarchy

**Polymorphism:**
- toString() override
- Interface implementations

### Technologies Used
- Java Swing (GUI)
- Java AWT (Layout managers)
- Collections Framework (ArrayList)
- Event-driven programming

---

## PROJECT STRUCTURE

```
KafeSiparisYonetimi/
├── Urun.java              (Model - Product)
├── Siparis.java           (Model - Order)
├── Masa.java              (Model - Table)
├── KafeSiparisPaneli.java (View + Controller)
├── README.md              (Project documentation)
├── USER_GUIDE.md          (User guide)
└── PROJECT_CONTEXT.md     (This file)
```

---

## DEVELOPMENT IDEAS

### Priority Additions
1. Custom menu definition screen
2. Database integration
3. Reporting system
4. User authorization

### Future Versions
- Web interface
- Mobile application
- Kitchen notification system
- Inventory management
- Customer CRM

---

## EDUCATIONAL VALUE

This project teaches:
- OOP principles
- Java Swing GUI
- Event handling
- Collections usage
- Layout managers
- Dialog management
- MVC pattern

---

## LICENSE AND USAGE

**License:** Educational purpose, open source
**Usage:** Can be freely used and developed
**Contribution:** All contributions and improvements are welcome

---

## CONTACT AND SUPPORT

**Documentation:** Review README.md and USER_GUIDE.md files
**Source Code:** All classes contain detailed JavaDoc comments
**Java Documentation:** https://docs.oracle.com/javase/

---

**Last Update:** 2025
**Version:** 1.0
**Status:** Active Development

---

# CONCLUSION

This project is a fully functional Java Swing application that solves real-world problems using object-oriented programming principles. Designed for educational purposes, it is an excellent example for learning and applying OOP concepts.

This system, which aims to facilitate the daily operations of cafe businesses, is open to continuous development thanks to its extensible architecture.

**Happy Working!** ☕🍰✨
