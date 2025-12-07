import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KafeSiparisPaneli extends JFrame {
    private ArrayList<Masa> masalar;
    private ArrayList<Urun> menuUrunleri;
    private JPanel masaPaneli;

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

    private void masaBilgileriniAl() {
        String masaSayisiStr = JOptionPane.showInputDialog(this, 
            "Kafede kaç masa var?", "Masa Sayısı", JOptionPane.QUESTION_MESSAGE);
        
        if (masaSayisiStr == null || masaSayisiStr.trim().isEmpty()) {
            System.exit(0);
        }
        
        int masaSayisi = Integer.parseInt(masaSayisiStr.trim());
        
        for (int i = 1; i <= masaSayisi; i++) {
            masalar.add(new Masa(i));
        }
    }

    private JPanel masaPaneliOlustur(Masa masa) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        if (masa.bosMu()) {
            panel.setBackground(new Color(220, 255, 220));
        } else {
            panel.setBackground(new Color(255, 240, 220));
        }

        JLabel baslik = new JLabel("Masa " + masa.getMasaNo(), SwingConstants.CENTER);
        baslik.setFont(new Font("Arial", Font.BOLD, 18));
        baslik.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        panel.add(baslik, BorderLayout.NORTH);

        JTextArea siparisAlani = new JTextArea();
        siparisAlani.setEditable(false);
        siparisAlani.setFont(new Font("Monospaced", Font.PLAIN, 12));
        siparisAlani.setMargin(new Insets(5, 5, 5, 5));
        siparisGuncelle(masa, siparisAlani);
        
        JScrollPane scrollPane = new JScrollPane(siparisAlani);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel butonPaneli = new JPanel(new GridLayout(2, 1, 8, 8));
        butonPaneli.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton siparisEkleBtn = new JButton("Sipariş Ekle");
        siparisEkleBtn.setFont(new Font("Arial", Font.BOLD, 14));
        siparisEkleBtn.setPreferredSize(new Dimension(150, 40));
        siparisEkleBtn.setBackground(new Color(100, 180, 255));
        siparisEkleBtn.setForeground(Color.BLACK);
        siparisEkleBtn.setFocusPainted(false);
        siparisEkleBtn.setBorderPainted(true);
        siparisEkleBtn.setOpaque(true);
        siparisEkleBtn.addActionListener(e -> {
            siparisEkleDialog(masa);
            siparisGuncelle(masa, siparisAlani);
            if (!masa.bosMu()) {
                panel.setBackground(new Color(255, 240, 220));
            }
        });

        JButton hesapOdeBtn = new JButton("Hesabı Öde");
        hesapOdeBtn.setFont(new Font("Arial", Font.BOLD, 14));
        hesapOdeBtn.setPreferredSize(new Dimension(150, 40));
        hesapOdeBtn.setBackground(new Color(100, 200, 100));
        hesapOdeBtn.setForeground(Color.BLACK);
        hesapOdeBtn.setFocusPainted(false);
        hesapOdeBtn.setBorderPainted(true);
        hesapOdeBtn.setOpaque(true);
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

        JPanel adetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        adetPanel.add(new JLabel("Adet:"));
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 50, 1);
        JSpinner adetSpinner = new JSpinner(spinnerModel);
        adetSpinner.setPreferredSize(new Dimension(70, 25));
        adetPanel.add(adetSpinner);
        altPanel.add(adetPanel, BorderLayout.NORTH);

        JPanel butonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton ekleBtn = new JButton("Ekle");
        ekleBtn.setFont(new Font("Arial", Font.BOLD, 13));
        ekleBtn.setBackground(new Color(100, 180, 255));
        ekleBtn.setForeground(Color.BLACK);
        ekleBtn.setFocusPainted(false);
        ekleBtn.setBorderPainted(true);
        ekleBtn.setOpaque(true);
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
        iptalBtn.setFont(new Font("Arial", Font.BOLD, 13));
        iptalBtn.setBackground(new Color(220, 220, 220));
        iptalBtn.setForeground(Color.BLACK);
        iptalBtn.setFocusPainted(false);
        iptalBtn.setBorderPainted(true);
        iptalBtn.setOpaque(true);
        iptalBtn.addActionListener(e -> dialog.dispose());
        
        butonPanel.add(ekleBtn);
        butonPanel.add(iptalBtn);
        altPanel.add(butonPanel, BorderLayout.CENTER);
        
        icerikPanel.add(altPanel, BorderLayout.SOUTH);
        dialog.add(icerikPanel);
        
        dialog.setVisible(true);
    }

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
