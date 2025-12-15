import java.io.*;
import java.util.*;

public class JsonUtil {

    public static List<Urun> loadMenu(String filePath) {
        List<Urun> menu = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            String jsonStr = json.toString();
            int urunlerStart = jsonStr.indexOf("[");
            int urunlerEnd = jsonStr.lastIndexOf("]");

            if (urunlerStart != -1 && urunlerEnd != -1) {
                String urunlerStr = jsonStr.substring(urunlerStart + 1, urunlerEnd);
                String[] urunler = urunlerStr.split("\\},\\s*\\{");

                for (String urunStr : urunler) {
                    urunStr = urunStr.replace("{", "").replace("}", "").trim();
                    String ad = extractValue(urunStr, "ad");
                    double fiyat = Double.parseDouble(extractValue(urunStr, "fiyat"));
                    menu.add(new Urun(ad, fiyat));
                }
            }
        } catch (IOException e) {
            System.out.println("Menu file not found, using default menu.");
            return getDefaultMenu();
        }
        return menu;
    }

    public static void saveMenu(String filePath, List<Urun> menu) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("{");
            writer.println("  \"urunler\": [");

            for (int i = 0; i < menu.size(); i++) {
                Urun urun = menu.get(i);
                writer.println("    {");
                writer.println("      \"ad\": \"" + urun.getAd() + "\",");
                writer.println("      \"fiyat\": " + urun.getFiyat());
                writer.print("    }");
                if (i < menu.size() - 1) {
                    writer.println(",");
                } else {
                    writer.println();
                }
            }

            writer.println("  ]");
            writer.println("}");
        } catch (IOException e) {
            System.out.println("Error saving menu: " + e.getMessage());
        }
    }

    public static List<Masa> loadOrders(String filePath) {
        List<Masa> masalar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            String jsonStr = json.toString();
            int masalarStart = jsonStr.indexOf("[");
            int masalarEnd = jsonStr.lastIndexOf("]");

            if (masalarStart != -1 && masalarEnd != -1) {
                String masalarStr = jsonStr.substring(masalarStart + 1, masalarEnd);
                String[] masalarArray = splitMasalar(masalarStr);

                for (String masaStr : masalarArray) {
                    masaStr = masaStr.trim();
                    if (masaStr.isEmpty()) continue;

                    int masaNo = Integer.parseInt(extractValue(masaStr, "masaNo"));
                    boolean dolu = Boolean.parseBoolean(extractValue(masaStr, "dolu"));

                    Masa masa = new Masa(masaNo);
                    if (dolu) {
                        masa.setDolu(true);
                    }

                    int siparislerStart = masaStr.indexOf("\"siparisler\": [");
                    if (siparislerStart != -1) {
                        int siparislerArrayStart = masaStr.indexOf("[", siparislerStart);
                        int siparislerArrayEnd = masaStr.indexOf("]", siparislerArrayStart);

                        if (siparislerArrayEnd > siparislerArrayStart + 1) {
                            String siparislerStr = masaStr.substring(siparislerArrayStart + 1, siparislerArrayEnd);
                            String[] siparislerArray = siparislerStr.split("\\},\\s*\\{");

                            for (String siparisStr : siparislerArray) {
                                siparisStr = siparisStr.replace("{", "").replace("}", "").trim();
                                if (!siparisStr.isEmpty()) {
                                    String urunAd = extractValue(siparisStr, "urunAd");
                                    int adet = Integer.parseInt(extractValue(siparisStr, "adet"));
                                    double fiyat = Double.parseDouble(extractValue(siparisStr, "fiyat"));

                                    Urun urun = new Urun(urunAd, fiyat);
                                    masa.siparisEkle(new Siparis(urun, adet));
                                }
                            }
                        }
                    }

                    masalar.add(masa);
                }
            }
        } catch (IOException e) {
            System.out.println("Orders file not found, creating new tables.");
            return getDefaultMasalar();
        }
        return masalar;
    }

    public static void saveOrders(String filePath, List<Masa> masalar) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("{");
            writer.println("  \"masalar\": [");

            for (int i = 0; i < masalar.size(); i++) {
                Masa masa = masalar.get(i);
                writer.println("    {");
                writer.println("      \"masaNo\": " + masa.getMasaNo() + ",");
                writer.println("      \"dolu\": " + masa.isDolu() + ",");
                writer.println("      \"siparisler\": [");

                List<Siparis> siparisler = masa.getSiparisler();
                for (int j = 0; j < siparisler.size(); j++) {
                    Siparis siparis = siparisler.get(j);
                    writer.println("        {");
                    writer.println("          \"urunAd\": \"" + siparis.getUrun().getAd() + "\",");
                    writer.println("          \"adet\": " + siparis.getAdet() + ",");
                    writer.println("          \"fiyat\": " + siparis.getUrun().getFiyat());
                    writer.print("        }");
                    if (j < siparisler.size() - 1) {
                        writer.println(",");
                    } else {
                        writer.println();
                    }
                }

                writer.println("      ]");
                writer.print("    }");
                if (i < masalar.size() - 1) {
                    writer.println(",");
                } else {
                    writer.println();
                }
            }

            writer.println("  ]");
            writer.println("}");
        } catch (IOException e) {
            System.out.println("Error saving orders: " + e.getMessage());
        }
    }

    private static String extractValue(String json, String key) {
        int keyIndex = json.indexOf("\"" + key + "\":");
        if (keyIndex == -1) return "";

        int valueStart = json.indexOf(":", keyIndex) + 1;
        int valueEnd = json.indexOf(",", valueStart);
        if (valueEnd == -1) {
            valueEnd = json.length();
        }

        String value = json.substring(valueStart, valueEnd).trim();
        value = value.replace("\"", "").trim();
        return value;
    }

    private static String[] splitMasalar(String masalarStr) {
        List<String> result = new ArrayList<>();
        int braceCount = 0;
        int start = 0;

        for (int i = 0; i < masalarStr.length(); i++) {
            char c = masalarStr.charAt(i);
            if (c == '{') {
                if (braceCount == 0) start = i;
                braceCount++;
            } else if (c == '}') {
                braceCount--;
                if (braceCount == 0) {
                    result.add(masalarStr.substring(start, i + 1));
                }
            }
        }

        return result.toArray(new String[0]);
    }

    private static List<Urun> getDefaultMenu() {
        List<Urun> menu = new ArrayList<>();
        menu.add(new Urun("Turkish Coffee", 25.0));
        menu.add(new Urun("Cappuccino", 35.0));
        menu.add(new Urun("Latte", 38.0));
        menu.add(new Urun("Espresso", 30.0));
        menu.add(new Urun("Tea", 15.0));
        menu.add(new Urun("Hot Chocolate", 32.0));
        menu.add(new Urun("Croissant", 20.0));
        menu.add(new Urun("Cake", 45.0));
        menu.add(new Urun("Cookie", 12.0));
        return menu;
    }

    private static List<Masa> getDefaultMasalar() {
        List<Masa> masalar = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            masalar.add(new Masa(i));
        }
        return masalar;
    }
}
