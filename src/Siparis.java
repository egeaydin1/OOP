public class Siparis {
    private Urun urun;
    private int adet;

    public Siparis(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }
    public Urun getUrun() {
        return urun;
    }
    public int getAdet() {
        return adet;
    }
    public double getToplamFiyat() {
        return urun.getFiyat() * adet;
    }
    @Override
    public String toString() {
        return adet + "x " + urun.getAd() + " = " + getToplamFiyat() + " TL";
    }
}
