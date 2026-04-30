package homlockin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestParser {

    public static void loadPalya(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                
                // pl: a U - b : ho3 jeg3t
                String[] split = line.split(":");
                String[] routePart = split[0].trim().split("\\s+");
                
                if (routePart.length < 3) continue;
                String id = routePart[0];
                String tipus = routePart[1];
                String jobb = routePart[2];
                
                Utszakasz u;
                if (tipus.equals("A")) u = new Alagut(id);
                else if (tipus.equals("H")) u = new Hid(id);
                else u = new Utszakasz(id);
                
                Main.utszakaszok.put(id, u);
                Main.varos.addUtszakasz(u);
            }
            sc.close();
            
            // Masodik kor az osszekottetesekhez
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                
                String[] split = line.split(":");
                String[] routePart = split[0].trim().split("\\s+");
                
                String id = routePart[0];
                Utszakasz u = Main.utszakaszok.get(id);
                
                String jobb = routePart[2];
                if (!jobb.equals("-")) {
                     Utszakasz jobbU = Main.utszakaszok.get(jobb);
                     if (jobbU != null) u.setJobbUt(jobbU);
                }
                
                for (int i = 3; i < routePart.length; i++) {
                     String kov = routePart[i];
                     if (!kov.equals("-")) {
                         Utszakasz kovU = Main.utszakaszok.get(kov);
                         if (kovU != null) u.addKovetkezo(kovU);
                     }
                }
                
                // Boritas
                if (split.length > 1) {
                    String[] items = split[1].trim().split("\\s+");
                    for (String sz : items) {
                        if (sz.startsWith("ho")) {
                            if (sz.length() > 2) {
                                int val = Integer.parseInt(sz.substring(2));
                                Ho ho = new Ho(); ho.setMennyiseg(val);
                                u.setHo(ho);
                            }
                        } else if (sz.startsWith("jeg")) {
                            int val = Integer.parseInt(sz.substring(3, 4));
                            boolean feltort = sz.endsWith("t");
                            Jeg jeg = new Jeg(u); jeg.setMennyiseg(val);
                            if (feltort) jeg.setFeltort(true);
                            u.setJeg(jeg);
                        } else if (sz.startsWith("zuzalek")) {
                            Zuzalek z = new Zuzalek(u); z.setMennyiseg(1);
                            u.setZuzalek(z);
                        }
                    }
                }
            }
            sc.close();
            
        } catch (Exception e) {}
    }
}
