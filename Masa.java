import java.util.ArrayList;
import java.util.List;

/**
 * Masa sınıfı - Kafedeki bir masayı temsil eder
 * Masa numarası ve sipariş listesini içerir
 */
public class Masa {
    private int masaNo;
    private List<Siparis> siparisler;
    
    /**
     * Yeni bir masa oluşturur
     * @param masaNo Masanın numarası
     */
    public Masa(int masaNo) {
        this.masaNo = masaNo;
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
