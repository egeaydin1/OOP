# KAFE SİPARİŞ YÖNETİM SİSTEMİ - TAM PROJE CONTEXT FILE

## PROJE GENEL BİLGİLERİ

**Proje Adı:** Kafe Sipariş Yönetim Sistemi
**Versiyon:** 1.0
**Dil:** Java
**GUI Framework:** Java Swing
**Tarih:** 2025
**Proje Türü:** Nesne Tabanlı Programlama Eğitim Projesi

---

## PROJE MİMARİSİ

### Sınıf Diyagramı
```
┌─────────────┐
│    Urun     │
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

## KAYNAK KOD DOSYALARI

### 1. Urun.java

```java
/**
 * Ürün sınıfı - Kafedeki menü ürünlerini temsil eder
 * Her ürünün bir adı ve fiyatı vardır
 */
public class Urun {
    private String ad;
    private double fiyat;
    
    /**
     * Yeni bir ürün oluşturur
     * @param ad Ürünün adı
     * @param fiyat Ürünün fiyatı (TL)
     */
    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }
    
    /**
     * Ürün adını döndürür
     * @return Ürün adı
     */
    public String getAd() {
        return ad;
    }
    
    /**
     * Ürün fiyatını döndürür
     * @return Ürün fiyatı
     */
    public double getFiyat() {
        return fiyat;
    }
    
    /**
     * Ürünü string olarak gösterir
     * @return "Ürün Adı - Fiyat TL" formatında string
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
 * Sipariş sınıfı - Bir ürünün sipariş bilgisini tutar
 * Ürün, adet ve toplam fiyat bilgilerini içerir
 */
public class Siparis {
    private Urun urun;
    private int adet;
    
    /**
     * Yeni bir sipariş oluşturur
     * @param urun Sipariş edilen ürün
     * @param adet Ürün adedi
     */
    public Siparis(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }
    
    /**
     * Sipariş edilen ürünü döndürür
     * @return Ürün nesnesi
     */
    public Urun getUrun() {
        return urun;
    }
    
    /**
     * Sipariş adedini döndürür
     * @return Ürün adedi
     */
    public int getAdet() {
        return adet;
    }
    
    /**
     * Siparişin toplam fiyatını hesaplar
     * @return Toplam fiyat (adet x birim fiyat)
     */
    public double getToplamFiyat() {
        return urun.getFiyat() * adet;
    }
    
    /**
     * Siparişi string olarak gösterir
     * @return "Adet x Ürün Adı = Toplam Fiyat TL" formatında string
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
 * Masa sınıfı - Kafedeki bir masayı temsil eder
 * Masa numarası, kapasite ve sipariş listesini içerir
 */
public class Masa {
    private int masaNo;
    private int kapasite;
    private List<Siparis> siparisler;
    
    /**
     * Yeni bir masa oluşturur
     * @param masaNo Masanın numarası
     * @param kapasite Masanın kişi kapasitesi
     */
    public Masa(int masaNo, int kapasite) {
        this.masaNo = masaNo;
        this.kapasite = kapasite;
        this.siparisler = new ArrayList<>();
    }
    
    /**
     * Masa numarasını döndürür
     * @return Masa numarası
     */
    public int getMasaNo() {
        return masaNo;
    }
    
    /**
     * Masa kapasitesini döndürür
     * @return Kişi kapasitesi
     */
    public int getKapasite() {
        return kapasite;
    }
    
    /**
     * Masanın sipariş listesini döndürür
     * @return Sipariş listesi
     */
    public List<Siparis> getSiparisler() {
        return siparisler;
    }
    
    /**
     * Masaya yeni bir sipariş ekler
     * @param siparis Eklenecek sipariş
     */
    public void siparisEkle(Siparis siparis) {
        siparisler.add(siparis);
    }
    
    /**
     * Masanın toplam hesabını hesaplar
     * @return Toplam tutar (TL)
     */
    public double getToplamTutar() {
        double toplam = 0;
        for (Siparis siparis : siparisler) {
            toplam += siparis.getToplamFiyat();
        }
        return toplam;
    }
    
    /**
     * Hesabı öder ve masayı temizler
     * Tüm siparişleri siler
     */
    public void hesabiOde() {
        siparisler.clear();
    }
    
    /**
     * Masanın boş olup olmadığını kontrol eder
     * @return Masa boşsa true, doluysa false
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
 * KafeSiparisPaneli - Ana uygulama sınıfı
 * Kafe sipariş yönetim sisteminin grafik arayüzünü ve işlevselliğini sağlar
 * 
 * Özellikler:
 * - Dinamik masa oluşturma
 * - Sipariş ekleme ve yönetme
 * - Hesap ödeme işlemleri
 * - Görsel masa durumu gösterimi
 */
public class KafeSiparisPaneli extends JFrame {
    private ArrayList<Masa> masalar;
    private ArrayList<Urun> menuUrunleri;
    private JPanel masaPaneli;
    
    /**
     * Ana uygulama penceresi oluşturucusu
     * Menüyü hazırlar, masa bilgilerini alır ve arayüzü oluşturur
     */
    public KafeSiparisPaneli() {
        masalar = new ArrayList<>();
        menuUrunleri = new ArrayList<>();
        menuHazirla();
        
        setTitle("Kafe Sipariş Yönetim Sistemi");
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
     * Kafe menüsünü hazırlar
     * Önceden tanımlanmış ürünleri menüye ekler
     */
    private void menuHazirla() {
        menuUrunleri.add(new Urun("Türk Kahvesi", 35.0));
        menuUrunleri.add(new Urun("Espresso", 40.0));
        menuUrunleri.add(new Urun("Cappuccino", 45.0));
        menuUrunleri.add(new Urun("Latte", 45.0));
        menuUrunleri.add(new Urun("Filtre Kahve", 38.0));
        menuUrunleri.add(new Urun("Çay", 15.0));
        menuUrunleri.add(new Urun("Su", 10.0));
        menuUrunleri.add(new Urun("Kola", 25.0));
        menuUrunleri.add(new Urun("Meyve Suyu", 30.0));
        menuUrunleri.add(new Urun("Cheesecake", 65.0));
        menuUrunleri.add(new Urun("Brownie", 55.0));
        menuUrunleri.add(new Urun("Kurabiye", 40.0));
    }
    
    /**
     * Kullanıcıdan masa bilgilerini alır
     * Masa sayısı ve her masanın kapasitesini sorar
     */
    private void masaBilgileriniAl() {
        String masaSayisiStr = JOptionPane.showInputDialog(this, 
            "Kafede kaç masa var?", "Masa Sayısı", JOptionPane.QUESTION_MESSAGE);
        
        if (masaSayisiStr == null || masaSayisiStr.trim().isEmpty()) {
            System.exit(0);
        }
        
        int masaSayisi = Integer.parseInt(masaSayisiStr.trim());
        
        for (int i = 1; i <= masaSayisi; i++) {
            String kapasiteStr = JOptionPane.showInputDialog(this, 
                "Masa " + i + " için kapasite (kişi sayısı)?", 
                "Masa Kapasitesi", JOptionPane.QUESTION_MESSAGE);
            
            if (kapasiteStr == null || kapasiteStr.trim().isEmpty()) {
                System.exit(0);
            }
            
            int kapasite = Integer.parseInt(kapasiteStr.trim());
            masalar.add(new Masa(i, kapasite));
        }
    }
    
    /**
     * Belirli bir masa için görsel panel oluşturur
     * @param masa Panel oluşturulacak masa
     * @return Masa paneli
     */
    private JPanel masaPaneliOlustur(Masa masa) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        
        // Masa durumuna göre renk ayarla
        if (masa.bosMu()) {
            panel.setBackground(new Color(220, 255, 220)); // Açık yeşil - Boş
        } else {
            panel.setBackground(new Color(255, 240, 220)); // Açık turuncu - Dolu
        }
        
        // Başlık (Masa numarası ve kapasite)
        JLabel baslik = new JLabel("Masa " + masa.getMasaNo() + 
            " (Kapasite: " + masa.getKapasite() + " kişi)", SwingConstants.CENTER);
        baslik.setFont(new Font("Arial", Font.BOLD, 16));
        baslik.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(baslik, BorderLayout.NORTH);
        
        // Sipariş gösterim alanı
        JTextArea siparisAlani = new JTextArea();
        siparisAlani.setEditable(false);
        siparisAlani.setFont(new Font("Monospaced", Font.PLAIN, 12));
        siparisAlani.setMargin(new Insets(5, 5, 5, 5));
        siparisGuncelle(masa, siparisAlani);
        
        JScrollPane scrollPane = new JScrollPane(siparisAlani);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Butonlar paneli
        JPanel butonPaneli = new JPanel(new GridLayout(2, 1, 5, 5));
        butonPaneli.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // Sipariş Ekle butonu
        JButton siparisEkleBtn = new JButton("Sipariş Ekle");
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
        
        // Hesabı Öde butonu
        JButton hesapOdeBtn = new JButton("Hesabı Öde");
        hesapOdeBtn.setFont(new Font("Arial", Font.BOLD, 12));
        hesapOdeBtn.setBackground(new Color(100, 200, 100));
        hesapOdeBtn.setForeground(Color.WHITE);
        hesapOdeBtn.setFocusPainted(false);
        hesapOdeBtn.addActionListener(e -> {
            if (masa.bosMu()) {
                JOptionPane.showMessageDialog(this, 
                    "Bu masada sipariş yok!", 
                    "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int cevap = JOptionPane.showConfirmDialog(this, 
                "Toplam tutar: " + String.format("%.2f", masa.getToplamTutar()) + 
                " TL\n\nHesap ödensin mi?", 
                "Hesap Ödeme", JOptionPane.YES_NO_OPTION);
            
            if (cevap == JOptionPane.YES_OPTION) {
                masa.hesabiOde();
                siparisGuncelle(masa, siparisAlani);
                panel.setBackground(new Color(220, 255, 220));
                JOptionPane.showMessageDialog(this, 
                    "Hesap ödendi. Masa temizlendi!", 
                    "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        butonPaneli.add(siparisEkleBtn);
        butonPaneli.add(hesapOdeBtn);
        panel.add(butonPaneli, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * Masanın sipariş gösterim alanını günceller
     * @param masa Güncellenecek masa
     * @param siparisAlani Sipariş gösterim text area
     */
    private void siparisGuncelle(Masa masa, JTextArea siparisAlani) {
        StringBuilder sb = new StringBuilder();
        
        if (masa.bosMu()) {
            sb.append("Masa boş\n\n");
            sb.append("Toplam: 0.00 TL");
        } else {
            sb.append("SİPARİŞLER:\n");
            sb.append("─────────────────────\n");
            for (Siparis siparis : masa.getSiparisler()) {
                sb.append(siparis.toString()).append("\n");
            }
            sb.append("─────────────────────\n");
            sb.append(String.format("TOPLAM: %.2f TL", masa.getToplamTutar()));
        }
        
        siparisAlani.setText(sb.toString());
    }
    
    /**
     * Sipariş ekleme dialog penceresini açar
     * @param masa Sipariş eklenecek masa
     */
    private void siparisEkleDialog(Masa masa) {
        JDialog dialog = new JDialog(this, "Sipariş Ekle - Masa " + masa.getMasaNo(), true);
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        
        JPanel icerikPanel = new JPanel(new BorderLayout(10, 10));
        icerikPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel baslik = new JLabel("Ürün Seçin:", SwingConstants.LEFT);
        baslik.setFont(new Font("Arial", Font.BOLD, 14));
        icerikPanel.add(baslik, BorderLayout.NORTH);
        
        // Ürün listesi
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
        
        // Adet seçimi
        JPanel adetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        adetPanel.add(new JLabel("Adet:"));
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 50, 1);
        JSpinner adetSpinner = new JSpinner(spinnerModel);
        adetSpinner.setPreferredSize(new Dimension(70, 25));
        adetPanel.add(adetSpinner);
        altPanel.add(adetPanel, BorderLayout.NORTH);
        
        // Butonlar
        JPanel butonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton ekleBtn = new JButton("Ekle");
        ekleBtn.setBackground(new Color(100, 180, 255));
        ekleBtn.setForeground(Color.WHITE);
        ekleBtn.setFocusPainted(false);
        ekleBtn.addActionListener(e -> {
            Urun secilenUrun = urunListesi.getSelectedValue();
            if (secilenUrun == null) {
                JOptionPane.showMessageDialog(dialog, 
                    "Lütfen bir ürün seçin!", 
                    "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int adet = (Integer) adetSpinner.getValue();
            Siparis siparis = new Siparis(secilenUrun, adet);
            masa.siparisEkle(siparis);
            
            JOptionPane.showMessageDialog(dialog, 
                adet + "x " + secilenUrun.getAd() + " eklendi!", 
                "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        
        JButton iptalBtn = new JButton("İptal");
        iptalBtn.addActionListener(e -> dialog.dispose());
        
        butonPanel.add(ekleBtn);
        butonPanel.add(iptalBtn);
        altPanel.add(butonPanel, BorderLayout.CENTER);
        
        icerikPanel.add(altPanel, BorderLayout.SOUTH);
        dialog.add(icerikPanel);
        
        dialog.setVisible(true);
    }
    
    /**
     * Uygulamanın başlangıç noktası
     * @param args Komut satırı argümanları
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

## ÖZELLIKLER VE KULLANIM

### Ana Özellikler

1. **Dinamik Masa Yönetimi**
   - Kullanıcı başlangıçta masa sayısını belirler
   - Her masa için ayrı kapasite tanımlanabilir
   - Masalar grid layout ile düzenlenir

2. **Sipariş Yönetimi**
   - Menüden ürün seçimi
   - Adet belirleme (1-50 arası)
   - Anlık fiyat hesaplama
   - Sipariş listesinin görüntülenmesi

3. **Görsel Durum Gösterimi**
   - Yeşil renk: Boş masa
   - Turuncu renk: Dolu masa
   - Her masada sipariş listesi ve toplam tutar

4. **Ödeme İşlemleri**
   - Onay dialogu ile güvenli ödeme
   - Otomatik masa temizleme
   - Hesap özeti gösterimi

### Menü İçeriği

**Sıcak İçecekler:**
- Türk Kahvesi: 35 TL
- Espresso: 40 TL
- Cappuccino: 45 TL
- Latte: 45 TL
- Filtre Kahve: 38 TL

**Soğuk İçecekler:**
- Çay: 15 TL
- Su: 10 TL
- Kola: 25 TL
- Meyve Suyu: 30 TL

**Tatlılar:**
- Cheesecake: 65 TL
- Brownie: 55 TL
- Kurabiye: 40 TL

---

## KURULUM VE ÇALIŞTIRMA

### Gereksinimler
- Java Development Kit (JDK) 8+
- Komut satırı veya IDE

### Derleme
```bash
javac *.java
```

### Çalıştırma
```bash
java KafeSiparisPaneli
```

### İlk Kullanım
1. Masa sayısını girin (örn: 6)
2. Her masanın kapasitesini belirleyin
3. Ana panel açılır
4. Masalara sipariş ekleyin
5. Ödeme işlemlerini gerçekleştirin

---

## TEKNİK DETAYLAR

### Nesne Yönelimli Prensipler

**Encapsulation:**
- Tüm sınıflarda private değişkenler
- Public getter/setter metodları
- Veri gizleme

**Abstraction:**
- Karmaşık iş mantığı gizlenir
- Basit API sunulur

**Inheritance:**
- JFrame'den türetme
- Swing component hiyerarşisi

**Polymorphism:**
- toString() override
- Interface implementasyonları

### Kullanılan Teknolojiler
- Java Swing (GUI)
- Java AWT (Layout managers)
- Collections Framework (ArrayList)
- Event-driven programming

---

## PROJE YAPISI

```
KafeSiparisYonetimi/
├── Urun.java              (Model - Ürün)
├── Siparis.java           (Model - Sipariş)
├── Masa.java              (Model - Masa)
├── KafeSiparisPaneli.java (View + Controller)
├── README.md              (Proje dokümantasyonu)
├── KULLANIM_KILAVUZU.md   (Kullanım rehberi)
└── PROJE_CONTEXT.md       (Bu dosya)
```

---

## GELİŞTİRME FİKİRLERİ

### Öncelikli Eklemeler
1. Özel menü tanımlama ekranı
2. Veritabanı entegrasyonu
3. Raporlama sistemi
4. Kullanıcı yetkilendirmesi

### Gelecek Versiyonlar
- Web arayüzü
- Mobil uygulama
- Mutfak bildirim sistemi
- Stok yönetimi
- Müşteri CRM

---

## EĞİTSEL DEĞER

Bu proje şunları öğretir:
- OOP prensipleri
- Java Swing GUI
- Event handling
- Collections kullanımı
- Layout managers
- Dialog yönetimi
- MVC pattern

---

## LİSANS VE KULLANIM

**Lisans:** Eğitim amaçlı, açık kaynak
**Kullanım:** Özgürce kullanılabilir ve geliştirilebilir
**Katkı:** Her türlü katkı ve iyileştirme kabul edilir

---

## İLETİŞİM VE DESTEK

**Dokümantasyon:** README.md ve KULLANIM_KILAVUZU.md dosyalarını inceleyin
**Kaynak Kod:** Tüm sınıflar detaylı JavaDoc yorumları içerir
**Java Dokümantasyonu:** https://docs.oracle.com/javase/

---

**Son Güncelleme:** 2025
**Versiyon:** 1.0
**Durum:** Aktif Geliştirme

---

# SONUÇ

Bu proje, nesne tabanlı programlama prensiplerini kullanarak gerçek dünya problemlerini çözen, tam fonksiyonel bir Java Swing uygulamasıdır. Eğitim amaçlı olarak tasarlanmış olup, OOP kavramlarını öğrenmek ve uygulamak için mükemmel bir örnektir.

Kafe işletmelerinin günlük operasyonlarını kolaylaştırmayı hedefleyen bu sistem, genişletilebilir mimarisi sayesinde sürekli geliştirmeye açıktır.

**İyi Çalışmalar!** ☕🍰✨
