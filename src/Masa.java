import java.util.ArrayList;
import java.util.List;

public class Masa {
    private int masaNo;
    private List<Siparis> siparisler;

    public Masa(int masaNo) {
        this.masaNo = masaNo;
        this.siparisler = new ArrayList<>();
    }
    public int getMasaNo() {
        return masaNo;
    }
    public List<Siparis> getSiparisler() {
        return siparisler;
    }
    public void siparisEkle(Siparis siparis) {
        siparisler.add(siparis);
    }
    public double getToplamTutar() {
        double toplam = 0;
        for (Siparis siparis : siparisler) {
            toplam += siparis.getToplamFiyat();
        }
        return toplam;
    }
    public void hesabiOde() {
        siparisler.clear();
    }
    public boolean bosMu() {
        return siparisler.isEmpty();
    }
}
