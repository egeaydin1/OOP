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
