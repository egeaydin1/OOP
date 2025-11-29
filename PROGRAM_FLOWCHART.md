# CAFE ORDER MANAGEMENT SYSTEM - PROGRAM FLOWCHART

## 📊 Complete System Flow Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                        PROGRAM START                             │
│                      (main() method)                             │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│              Set System Look and Feel                            │
│         UIManager.setLookAndFeel()                              │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create KafeSiparisPaneli Instance                        │
│              (Constructor Called)                                │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│              Initialize Collections                              │
│         - ArrayList<Masa> masalar                               │
│         - ArrayList<Urun> menuUrunleri                          │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│                   menuHazirla()                                  │
│         Create and Add All Menu Items                            │
│    (Coffee, Drinks, Desserts - 12 items)                        │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│              Setup Main Window Properties                        │
│         - Title: "Kafe Sipariş Yönetim Sistemi"                │
│         - Size: 1200x800                                         │
│         - Center on screen                                       │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│                masaBilgileriniAl()                               │
│         Get Table Information from User                          │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
        ┌─────────────────────────────────┐
        │  Show Input Dialog:              │
        │  "How many tables in the cafe?"  │
        └─────────────┬───────────────────┘
                      │
                      ▼
              ┌───────────────┐
              │ User Canceled? │────Yes────> Exit Program
              └───────┬────────┘
                      │ No
                      ▼
        ┌─────────────────────────┐
        │  Parse Table Count      │
        │  (masaSayisi)           │
        └─────────┬───────────────┘
                  │
                  ▼
        ┌─────────────────────────────┐
        │  FOR i = 1 to masaSayisi    │
        └─────────┬───────────────────┘
                  │
                  ▼
        ┌─────────────────────────────┐
        │  Create Masa(i)             │
        │  Add to masalar list        │
        └─────────┬───────────────────┘
                  │
                  ▼
        ┌─────────────────────────────┐
        │  END FOR LOOP               │
        └─────────┬───────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────────────────────────┐
│              Create masaPaneli (Main Panel)                      │
│         Calculate Grid Layout (rows x columns)                   │
│         kolonSayisi = ceil(sqrt(masaSayisi))                    │
│         satirSayisi = ceil(masaSayisi / kolonSayisi)            │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         FOR each Masa in masalar                                 │
│              masaPaneliOlustur(masa)                             │
│              Add panel to masaPaneli                             │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Add masaPaneli to JFrame with JScrollPane                │
│              setVisible(true)                                    │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│                   MAIN WINDOW DISPLAYED                          │
│              (User can now interact)                             │
└─────────────────────────────────────────────────────────────────┘
```

---

## 🔄 Main Window User Interaction Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    MAIN WINDOW ACTIVE                            │
│              (Display all table panels)                          │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
           ┌──────────────────────────┐
           │  User Action?            │
           └──────────┬───────────────┘
                      │
        ┌─────────────┴─────────────┐
        │                           │
        ▼                           ▼
  ┌─────────────┐          ┌──────────────┐
  │ Sipariş Ekle│          │  Hesabı Öde  │
  │   Button    │          │   Button     │
  └──────┬──────┘          └──────┬───────┘
         │                        │
         ▼                        ▼
   (See Flow A)              (See Flow B)
```

---

## 📝 FLOW A: Add Order Process (siparisEkleDialog)

```
┌─────────────────────────────────────────────────────────────────┐
│         User Clicks "Sipariş Ekle" Button on Table X            │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create Modal Dialog Window                               │
│         Title: "Sipariş Ekle - Masa X"                          │
│         Size: 400x500                                            │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create JList with all menu items                         │
│         DefaultListModel<Urun> with menuUrunleri                │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create JSpinner for quantity                             │
│         Range: 1 to 50 (default: 1)                             │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create "Ekle" and "İptal" buttons                       │
│         Show Dialog (modal)                                      │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
           ┌──────────────────────────┐
           │  User Action?            │
           └──────────┬───────────────┘
                      │
        ┌─────────────┴──────────────┐
        │                            │
        ▼                            ▼
  ┌──────────┐              ┌──────────────┐
  │  "Ekle"  │              │   "İptal"    │
  │  Button  │              │   Button     │
  └────┬─────┘              └──────┬───────┘
       │                           │
       │                           ▼
       │                   ┌──────────────┐
       │                   │ Close Dialog │
       │                   │ Return       │
       │                   └──────────────┘
       │
       ▼
┌─────────────────────────┐
│ Check if product        │
│ is selected?            │
└────┬──────────────┬─────┘
     │ No           │ Yes
     ▼              ▼
┌──────────┐   ┌────────────────────┐
│ Show     │   │ Get selected Urun  │
│ Warning  │   │ Get quantity       │
│ Return   │   │ from spinner       │
└──────────┘   └─────────┬──────────┘
                         │
                         ▼
               ┌───────────────────────┐
               │ Create Siparis Object │
               │ siparis = new         │
               │ Siparis(urun, adet)   │
               └─────────┬─────────────┘
                         │
                         ▼
               ┌───────────────────────┐
               │ masa.siparisEkle()    │
               │ Add to table's order  │
               │ list                  │
               └─────────┬─────────────┘
                         │
                         ▼
               ┌───────────────────────┐
               │ Show Success Message  │
               │ "Xx Product added!"   │
               └─────────┬─────────────┘
                         │
                         ▼
               ┌───────────────────────┐
               │ Close Dialog          │
               └─────────┬─────────────┘
                         │
                         ▼
               ┌───────────────────────┐
               │ siparisGuncelle()     │
               │ Refresh table display │
               └─────────┬─────────────┘
                         │
                         ▼
               ┌───────────────────────┐
               │ Check if table empty? │
               └────┬──────────────────┘
                    │
        ┌───────────┴──────────┐
        │ No (has orders)      │ Yes
        ▼                      ▼
┌─────────────────┐   ┌───────────────┐
│ Change panel    │   │ Keep panel    │
│ background to   │   │ background    │
│ ORANGE          │   │ GREEN         │
│ (255,240,220)   │   │ (220,255,220) │
└────────┬────────┘   └───────┬───────┘
         │                    │
         └────────────┬───────┘
                      │
                      ▼
         ┌────────────────────────┐
         │ Return to Main Window  │
         └────────────────────────┘
```

---

## 💰 FLOW B: Payment Process (Hesabı Öde)

```
┌─────────────────────────────────────────────────────────────────┐
│         User Clicks "Hesabı Öde" Button on Table X              │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
           ┌──────────────────────┐
           │ Check if table       │
           │ has orders?          │
           │ masa.bosMu()         │
           └────┬─────────────────┘
                │
    ┌───────────┴──────────┐
    │ Yes (empty)          │ No (has orders)
    ▼                      ▼
┌──────────────┐   ┌─────────────────────────┐
│ Show Warning │   │ Calculate total amount  │
│ "No orders"  │   │ masa.getToplamTutar()   │
│ Return       │   └──────────┬──────────────┘
└──────────────┘              │
                              ▼
                   ┌────────────────────────────┐
                   │ Show Confirmation Dialog   │
                   │ "Total: XXX.XX TL"         │
                   │ "Pay the bill?"            │
                   │ [Yes] [No]                 │
                   └─────────┬──────────────────┘
                             │
                  ┌──────────┴──────────┐
                  │                     │
                  ▼                     ▼
           ┌─────────────┐      ┌─────────────┐
           │ User: NO    │      │ User: YES   │
           └──────┬──────┘      └──────┬──────┘
                  │                    │
                  ▼                    ▼
           ┌─────────────┐      ┌─────────────────┐
           │ Close Dialog│      │ masa.hesabiOde()│
           │ Return      │      │ Clear all orders│
           └─────────────┘      └──────┬──────────┘
                                       │
                                       ▼
                              ┌──────────────────┐
                              │ siparisGuncelle()│
                              │ Refresh display  │
                              └────────┬─────────┘
                                       │
                                       ▼
                              ┌──────────────────┐
                              │ Change panel     │
                              │ background to    │
                              │ GREEN            │
                              │ (220,255,220)    │
                              └────────┬─────────┘
                                       │
                                       ▼
                              ┌──────────────────┐
                              │ Show Success Msg │
                              │ "Bill paid!"     │
                              │ "Table cleaned!" │
                              └────────┬─────────┘
                                       │
                                       ▼
                              ┌──────────────────┐
                              │ Return to Main   │
                              │ Window           │
                              └──────────────────┘
```

---

## 🔄 Table Display Update Process (siparisGuncelle)

```
┌─────────────────────────────────────────────────────────────────┐
│              siparisGuncelle(Masa, JTextArea)                    │
│              Update table's order display                        │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
           ┌──────────────────────┐
           │ Check if table       │
           │ is empty?            │
           │ masa.bosMu()         │
           └────┬─────────────────┘
                │
    ┌───────────┴──────────┐
    │ Yes (empty)          │ No (has orders)
    ▼                      ▼
┌──────────────┐   ┌─────────────────────────┐
│ Display:     │   │ Display:                │
│ "Masa boş"   │   │ "SİPARİŞLER:"          │
│ "Toplam:     │   │ "─────────────"        │
│  0.00 TL"    │   │                         │
└──────┬───────┘   │ FOR each siparis in    │
       │           │ masa.getSiparisler():   │
       │           │   Add siparis.toString()│
       │           │   (e.g. "2x Latte =     │
       │           │          90.0 TL")      │
       │           │                         │
       │           │ Display separator       │
       │           │ "─────────────"        │
       │           │                         │
       │           │ Display total:          │
       │           │ "TOPLAM: XXX.XX TL"    │
       │           └──────────┬──────────────┘
       │                      │
       └──────────┬───────────┘
                  │
                  ▼
        ┌─────────────────────┐
        │ Set text to         │
        │ JTextArea           │
        │ siparisAlani.setText│
        └─────────┬───────────┘
                  │
                  ▼
        ┌─────────────────────┐
        │ Display updated     │
        │ on screen           │
        └─────────────────────┘
```

---

## 🏗️ Table Panel Creation Process (masaPaneliOlustur)

```
┌─────────────────────────────────────────────────────────────────┐
│              masaPaneliOlustur(Masa masa)                        │
│              Create visual panel for one table                   │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create JPanel with BorderLayout                          │
│         Add gray border (2px)                                    │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
           ┌──────────────────────┐
           │ Check table status   │
           │ masa.bosMu()         │
           └────┬─────────────────┘
                │
    ┌───────────┴──────────┐
    │ Empty               │ Has Orders
    ▼                     ▼
┌──────────────┐   ┌─────────────────┐
│ Set GREEN    │   │ Set ORANGE      │
│ background   │   │ background      │
│(220,255,220) │   │(255,240,220)    │
└──────┬───────┘   └──────┬──────────┘
       │                  │
       └────────┬─────────┘
                │
                ▼
┌─────────────────────────────────────────────────────────────────┐
│         NORTH: Create JLabel (Table Title)                       │
│         "Masa X"                                                 │
│         Font: Arial, BOLD, 18pt                                  │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         CENTER: Create JTextArea in JScrollPane                  │
│         - Non-editable                                           │
│         - Monospaced font, 12pt                                  │
│         - Call siparisGuncelle() to fill with orders             │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         SOUTH: Create Button Panel                               │
│         GridLayout(2, 1) - 2 buttons stacked                     │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create "Sipariş Ekle" Button                            │
│         - Blue background (100, 180, 255)                        │
│         - Black text, Bold, 14pt                                 │
│         - ActionListener: siparisEkleDialog(masa)               │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Create "Hesabı Öde" Button                              │
│         - Green background (100, 200, 100)                       │
│         - Black text, Bold, 14pt                                 │
│         - ActionListener: Payment process                        │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Add buttons to button panel                              │
│         Add button panel to main panel (SOUTH)                   │
└─────────────────────┬───────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│         Return completed JPanel                                  │
└─────────────────────────────────────────────────────────────────┘
```

---

## 🎯 Class Interaction Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                    KafeSiparisPaneli                             │
│                     (JFrame - Main UI)                           │
│                                                                  │
│  - ArrayList<Masa> masalar                                      │
│  - ArrayList<Urun> menuUrunleri                                 │
│  - JPanel masaPaneli                                            │
│                                                                  │
│  Methods:                                                        │
│  + main()                                                        │
│  + KafeSiparisPaneli() [constructor]                           │
│  + menuHazirla()                                                │
│  + masaBilgileriniAl()                                          │
│  + masaPaneliOlustur(Masa)                                      │
│  + siparisGuncelle(Masa, JTextArea)                            │
│  + siparisEkleDialog(Masa)                                      │
└──────────────┬──────────────┬───────────────────────────────────┘
               │              │
               │ uses         │ uses
               │              │
               ▼              ▼
   ┌───────────────┐    ┌──────────────┐
   │     Masa      │    │     Urun     │
   ├───────────────┤    ├──────────────┤
   │ - masaNo      │    │ - ad         │
   │ - siparisler  │◄───│ - fiyat      │
   ├───────────────┤ has├──────────────┤
   │+ getMasaNo()  │    │+ getAd()     │
   │+ siparisEkle()│    │+ getFiyat()  │
   │+ hesabiOde()  │    │+ toString()  │
   │+ bosMu()      │    └──────────────┘
   │+ getToplamTutar()                  │
   └───────┬───────┘                    │
           │                            │
           │ contains                   │
           ▼                            │
   ┌──────────────┐                    │
   │   Siparis    │                    │
   ├──────────────┤                    │
   │ - urun       │────────uses────────┘
   │ - adet       │
   ├──────────────┤
   │+ getUrun()   │
   │+ getAdet()   │
   │+ getToplamFiyat()
   │+ toString()  │
   └──────────────┘
```

---

## 📦 Object Lifecycle

```
PROGRAM STARTUP:
├─ Create KafeSiparisPaneli
│  ├─ Create ArrayList<Urun>
│  │  └─ Add 12 Urun objects (menu items)
│  │
│  ├─ Get table count from user
│  │
│  ├─ Create ArrayList<Masa>
│  │  └─ Add N Masa objects (1 to N)
│  │
│  └─ Create UI components
│     └─ For each Masa, create JPanel

RUNTIME (User adds order):
├─ User clicks "Sipariş Ekle"
├─ Select Urun from list
├─ Set quantity
├─ Create new Siparis(Urun, adet)
├─ Call masa.siparisEkle(Siparis)
│  └─ Add to Masa's siparisler ArrayList
└─ Update display

RUNTIME (User pays bill):
├─ User clicks "Hesabı Öde"
├─ Calculate total from all Siparis objects
├─ User confirms
├─ Call masa.hesabiOde()
│  └─ Clear siparisler ArrayList
└─ Update display (GREEN background)

PROGRAM END:
└─ All objects destroyed
   (No persistence - data lost)
```

---

## 🔐 State Management

```
TABLE STATES:
┌─────────────────────────────────────────────────────────────────┐
│                                                                  │
│  ┌─────────────┐                                                │
│  │   EMPTY     │  Initial state / After payment                 │
│  │  (GREEN)    │                                                 │
│  └──────┬──────┘                                                │
│         │                                                        │
│         │ [User adds order]                                      │
│         │ siparisEkle()                                         │
│         ▼                                                        │
│  ┌─────────────┐                                                │
│  │ HAS ORDERS  │  Active state with orders                      │
│  │  (ORANGE)   │                                                 │
│  └──────┬──────┘                                                │
│         │                                                        │
│         │ [Can add more orders]                                  │
│         │ siparisEkle()                                         │
│         │ ◄──────────┘                                          │
│         │                                                        │
│         │ [User pays bill]                                       │
│         │ hesabiOde()                                           │
│         ▼                                                        │
│  ┌─────────────┐                                                │
│  │   EMPTY     │  Return to initial state                       │
│  │  (GREEN)    │                                                 │
│  └─────────────┘                                                │
│                                                                  │
└─────────────────────────────────────────────────────────────────┘

DIALOG STATES:
┌────────────┐
│   CLOSED   │ ◄──────┐
└──────┬─────┘        │
       │              │
       │ [User clicks button]
       │              │
       ▼              │
┌────────────┐        │
│   OPEN     │        │
│  (Modal)   │        │
└──────┬─────┘        │
       │              │
       │ [User confirms/cancels]
       └──────────────┘
```

---

## 🎨 UI Event Flow Summary

```
USER INTERACTION POINTS:

1. STARTUP:
   Input Dialog → Enter table count → Main window opens

2. MAIN WINDOW:
   ├─ Click "Sipariş Ekle" → Order Dialog opens
   │  ├─ Select product from list
   │  ├─ Set quantity
   │  ├─ Click "Ekle" → Order added, dialog closes
   │  └─ Click "İptal" → Dialog closes, no change
   │
   └─ Click "Hesabı Öde" → Confirmation Dialog
      ├─ Click "Yes" → Payment processed, table cleared
      └─ Click "No" → Dialog closes, no change

3. ANY TIME:
   └─ Close window (X button) → Program exits
```

---

## 📈 Data Flow Summary

```
INPUT → PROCESS → OUTPUT

User Input:
└─ Table count
   └─ Stored in: ArrayList<Masa> masalar

User Input:
└─ Product selection + quantity
   └─ Creates: new Siparis(Urun, adet)
      └─ Stored in: masa.siparisler (ArrayList)
         └─ Displayed: JTextArea in table panel

User Action:
└─ Pay bill
   └─ Process: masa.hesabiOde()
      └─ Clears: masa.siparisler
         └─ Updates: Display (GREEN), "Masa boş"
```

---

**END OF FLOWCHART DOCUMENTATION**

*This flowchart provides a complete overview of the Cafe Order Management System's program flow, including all major processes, decision points, and state transitions.*

