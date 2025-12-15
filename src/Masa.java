import java.util.ArrayList;
import java.util.List;

public class Masa {
    private int masaNo;
    private List<Siparis> siparisler;
    private boolean dolu;

    public Masa(int masaNo) {
        this.masaNo = masaNo;
        this.siparisler = new ArrayList<>();
        this.dolu = false;
    }
    public int getMasaNo() {
        return masaNo;
    }
    public List<Siparis> getSiparisler() {
        return siparisler;
    }
    public void siparisEkle(Siparis siparis) {
        siparisler.add(siparis);
        dolu = true;
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
        dolu = false;
    }
    public boolean bosMu() {
        return siparisler.isEmpty();
    }
    public boolean isDolu() {
        return dolu;
    }
    public void setDolu(boolean dolu) {
        this.dolu = dolu;
    }
}
