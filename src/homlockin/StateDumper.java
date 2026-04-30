package homlockin;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StateDumper {
    public static void dumpAll() {
        // 1. Takarító játékosok (betűrendben)
        Map<String, TakaritoJatekos> tjs = new TreeMap<>();
        for (Map.Entry<String, Jatekos> entry : Main.jatekosok.entrySet()) {
            if (entry.getValue() instanceof TakaritoJatekos) {
                tjs.put(entry.getKey(), (TakaritoJatekos) entry.getValue());
            }
        }

        for (Map.Entry<String, TakaritoJatekos> entry : tjs.entrySet()) {
            TakaritoJatekos tj = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append(" ").append(tj.getPenz());
            
            List<Hokotro> hks = new ArrayList<>(tj.getHokotroi());
            Collections.sort(hks, (h1, h2) -> h1.getId().compareTo(h2.getId()));
            
            for (Hokotro hk : hks) {
                sb.append(" ").append(hk.getId());
            }
            System.out.println(sb.toString());
            
            for (Hokotro hk : hks) {
                System.out.println("\t" + hk.getId() + " " + hk.getFelrakottFeje().getName() + " " + hk.getSo() + " " + hk.getKerozin() + " " + hk.getZuzalek());
            }
        }

        // 2. Buszvezetők (betűrendben)
        Map<String, BuszvezetoJatekos> bjs = new TreeMap<>();
        for (Map.Entry<String, Jatekos> entry : Main.jatekosok.entrySet()) {
            if (entry.getValue() instanceof BuszvezetoJatekos) {
                bjs.put(entry.getKey(), (BuszvezetoJatekos) entry.getValue());
            }
        }
        for (Map.Entry<String, BuszvezetoJatekos> entry : bjs.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getPontszam());
        }

        // 3. Pálya állapota
        for (Map.Entry<String, Utszakasz> entry : Main.utszakaszok.entrySet()) {
            Utszakasz u = entry.getValue();
            String jmId = "-";
            if (u.getJarmu() != null) {
                jmId = u.getJarmu().getId();
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append(" ").append(jmId).append(" : ");
            
            List<String> conditions = new ArrayList<>();
            Ho ho = u.getHo();
            if (ho != null && ho.getMennyiseg() > 0) {
                conditions.add("ho" + ho.getMennyiseg());
            }
            Jeg jeg = u.getJeg();
            if (jeg != null && jeg.getMennyiseg() > 0) {
                String js = "jeg" + jeg.getMennyiseg();
                if (jeg.isFeltort()) js += "t";
                conditions.add(js);
            }
            Zuzalek zuz = u.getZuzalek();
            if (zuz != null && zuz.vanZuzalek()) {
                conditions.add("zuzalek");
            }
            
            for (int i = 0; i < conditions.size(); i++) {
                sb.append(conditions.get(i));
                if (i < conditions.size() - 1) sb.append(" ");
            }
            
            System.out.println(sb.toString());
        }
    }
}
