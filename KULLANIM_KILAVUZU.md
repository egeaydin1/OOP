# Kafe Sipariş Yönetim Sistemi - Nasıl Kullanılır?

## 🚀 Hızlı Başlangıç Rehberi

### Adım 1: Programı Başlatma

#### Windows için:
1. Komut İstemi'ni (CMD) açın
2. Proje klasörüne gidin:
   ```
   cd C:\Users\...\KafeSiparisYonetimi
   ```
3. Programı derleyin:
   ```
   javac *.java
   ```
4. Programı çalıştırın:
   ```
   java KafeSiparisPaneli
   ```

#### Mac/Linux için:
1. Terminal'i açın
2. Proje klasörüne gidin:
   ```
   cd ~/Desktop/Claude/KafeSiparisYonetimi
   ```
3. Programı derleyin:
   ```
   javac *.java
   ```
4. Programı çalıştırın:
   ```
   java KafeSiparisPaneli
   ```

### Adım 2: İlk Kurulum

Program başladığında sırasıyla şu adımları tamamlayın:

**1. Masa Sayısını Belirleyin**
- Açılan pencerede kafeinizdeki toplam masa sayısını girin
- Örnek: `6` (altı masa)

**2. Her Masanın Kapasitesini Belirleyin**
- Her masa için kaç kişilik olduğunu girin
- Örnek dağılım:
  - Masa 1: `2` kişilik
  - Masa 2: `4` kişilik
  - Masa 3: `4` kişilik
  - Masa 4: `6` kişilik
  - Masa 5: `4` kişilik
  - Masa 6: `2` kişilik

### Adım 3: Ana Panel Kullanımı

Program açıldıktan sonra ana ekranda masalarınızı göreceksiniz.

#### Masa Renklerini Anlamak
- 🟢 **Yeşil Masa**: Boş masa, müşteri bekliyor
- 🟠 **Turuncu Masa**: Sipariş var, dolu masa

#### Her Masa Panelinde Neler Var?
- **Üst kısım**: Masa numarası ve kapasitesi
- **Orta kısım**: Sipariş listesi ve fiyatlar
- **Alt kısım**: İki buton
  - **Sipariş Ekle** (Mavi buton)
  - **Hesabı Öde** (Yeşil buton)

## 📝 Temel İşlemler

### Sipariş Ekleme

1. İlgili masanın **"Sipariş Ekle"** butonuna tıklayın
2. Açılan pencerede menüden ürün seçin
3. Adet miktarını ayarlayın (varsayılan: 1)
4. **"Ekle"** butonuna tıklayın
5. Sipariş otomatik olarak masaya eklenecektir

**Örnek Senaryo:**
```
Müşteri Masa 3'e geldi ve şunları sipariş etti:
- 2x Cappuccino
- 1x Cheesecake
- 2x Su

İşlem:
1. Masa 3'ün "Sipariş Ekle" butonuna tıkla
2. Cappuccino seç, adet: 2, Ekle
3. Masa 3'ün "Sipariş Ekle" butonuna tekrar tıkla
4. Cheesecake seç, adet: 1, Ekle
5. Masa 3'ün "Sipariş Ekle" butonuna tekrar tıkla
6. Su seç, adet: 2, Ekle

Toplam: 2x45 + 65 + 2x10 = 175 TL
```

### Hesap Ödeme

1. Müşteri hesabı istediğinde, ilgili masanın **"Hesabı Öde"** butonuna tıklayın
2. Açılan pencerede toplam tutarı görün
3. **"Evet"** diyerek ödemeyi onaylayın
4. Masa otomatik olarak temizlenecek ve yeşile dönecektir

**Uyarı:** Boş bir masanın hesabını ödemeye çalışırsanız, sistem sizi uyaracaktır.

## 🍽️ Menü ve Fiyatlar

### Sıcak İçecekler ☕
- Türk Kahvesi: 35 TL
- Espresso: 40 TL
- Cappuccino: 45 TL
- Latte: 45 TL
- Filtre Kahve: 38 TL

### Soğuk İçecekler 🥤
- Çay: 15 TL
- Su: 10 TL
- Kola: 25 TL
- Meyve Suyu: 30 TL

### Tatlılar 🍰
- Cheesecake: 65 TL
- Brownie: 55 TL
- Kurabiye: 40 TL

## 💡 İpuçları ve En İyi Uygulamalar

### Verimli Kullanım İçin
1. **Masa Numaralarını Hatırlayın**: Fiziksel masalarınızla programdaki numaraları eşleştirin
2. **Renkleri Takip Edin**: Yeşil masalar hızlıca doldurun, turuncu masaları takip edin
3. **Çoklu Sipariş**: Aynı üründen birden fazla sipariş için adet sayısını artırın
4. **Hızlı Ödeme**: Müşteri kalkmadan önce hesabı kapatın

### Yaygın Hatalardan Kaçının
- ❌ Ürün seçmeden "Ekle" butonuna tıklamayın
- ❌ Boş masaya ödeme yapmaya çalışmayın
- ❌ Programa aynı anda birden fazla pencereden erişmeyin

## 🔧 Sorun Giderme

### Program Açılmıyor
- Java'nın yüklü olduğundan emin olun (`java -version` komutu ile kontrol edin)
- Tüm dosyaların aynı klasörde olduğunu kontrol edin
- Derleme hatası varsa, hata mesajını okuyun

### Masalar Görünmüyor
- Masa sayısını doğru girdiğinizden emin olun
- Pencereyi yeniden boyutlandırmayı deneyin
- Kaydırma çubuğunu (scroll bar) kullanın

### Sipariş Eklenmiyor
- Listeden bir ürün seçtiğinizden emin olun
- Adet sayısının 1-50 arasında olduğunu kontrol edin

## 📊 Örnek Kullanım Senaryoları

### Senaryo 1: Sabah Mesaisi
```
09:00 - Masa 1: 2x Türk Kahvesi (70 TL)
09:15 - Masa 3: 1x Cappuccino, 2x Kurabiye (125 TL)
09:30 - Masa 1 ödeme yaptı
09:45 - Masa 2: 1x Filtre Kahve, 1x Cheesecake (103 TL)
```

### Senaryo 2: Öğle Yoğunluğu
```
12:00 - Masa 1: 4x Latte, 2x Brownie (290 TL)
12:05 - Masa 2: 2x Cappuccino, 2x Cheesecake (220 TL)
12:10 - Masa 3: 3x Çay, 1x Kurabiye (85 TL)
12:15 - Masa 4: 6x Su, 6x Kola (210 TL)
12:30 - Masa 1 ödeme yaptı
12:35 - Masa 2 ödeme yaptı
```

## 🎯 İlerletilmiş Kullanım

### Hızlı İşlem Kısayolları
- **Tab**: Ürün listesinde gezinme
- **Enter**: Seçili ürünü ekleme
- **Esc**: Dialog penceresini kapatma

### Çoklu Sipariş Yönetimi
Aynı anda birden fazla masa ile çalışırken:
1. Önce tüm masaların siparişlerini alın
2. Sonra hesap ödeme işlemlerini yapın
3. Masaları sırayla temizleyin

## 📞 Yardım ve Destek

### Sık Sorulan Sorular

**S: Menüyü değiştirebilir miyim?**
C: Evet! KafeSiparisPaneli.java dosyasındaki `menuHazirla()` metodunu düzenleyin.

**S: Daha fazla masa ekleyebilir miyim?**
C: Evet! Program başlangıcında istediğiniz kadar masa sayısı girebilirsiniz.

**S: Fiyatları değiştirebilir miyim?**
C: Evet! `menuHazirla()` metodundaki fiyatları düzenleyin ve programı yeniden derleyin.

---

**İyi Çalışmalar!** ☕✨

Herhangi bir sorunuz olursa, README.md dosyasını inceleyin veya kaynak kodundaki yorumları okuyun.