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
