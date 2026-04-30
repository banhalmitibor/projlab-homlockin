package homlockin;

import java.util.Map;

public class StateDumper {
    public static void dumpAll() {
        for (Map.Entry<String, Jatekos> mapEntry : Main.jatekosok.entrySet()) {
Jatekos j = mapEntry.getValue();
String jId = mapEntry.getKey();
            if (j instanceof TakaritoJatekos) {
                TakaritoJatekos tj = (TakaritoJatekos) j;
                String jmId = "-";
                // find jarmu by iterating Main.jarmuvek?
                Hokotro hk = tj.getHokotroje();
                if (hk != null) {
                    for (Map.Entry<String, Jarmu> entry : Main.jarmuvek.entrySet()) {
                        if (entry.getValue() == hk) {
                            jmId = entry.getKey();
                            break;
                        }
                    }
                }
                System.out.println(jId + " " + tj.getPenz() + (jmId.equals("-") ? "" : " " + jmId));
                if (hk != null) {
                    String fejId = "-";
                    HokotroFej fej = hk.getFelszereltFej();
                    if (fej instanceof Soprofej) fejId = "sopro";
                    else if (fej instanceof Hanyofej) fejId = "hanyo";
                    else if (fej instanceof Jegtorofej) fejId = "jegtoro";
                    else if (fej instanceof Sarkanyfej) fejId = "sarkany";
                    else if (fej instanceof ZuzalekSzoFej) fejId = "zuzalek";
                    else if (fej instanceof Soszorofej) fejId = "soszoro";
                    System.out.println("\t" + jmId + " " + fejId + " " + hk.getSoRaktar() + " " + hk.getBiokerozinRaktar() + " " + hk.getZuzalekRaktar());
                }
            } else if (j instanceof BuszvezetoJatekos) {
                BuszvezetoJatekos bj = (BuszvezetoJatekos) j;
                System.out.println(jId + " " + bj.getPontszam());
            }
        }
        for (Map.Entry<String, Utszakasz> entry : Main.utszakaszok.entrySet()) {
            String uId = entry.getKey();
            Utszakasz u = entry.getValue();
            String jmId = "-";
            Jarmu jm = u.getRajtaAll();
            if (jm != null) {
                for (Map.Entry<String, Jarmu> jentry : Main.jarmuvek.entrySet()) {
                    if (jentry.getValue() == jm) {
                        jmId = jentry.getKey();
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            Ho ho = u.getHo();
            Jeg jeg = u.getJeg();
            Zuzalek zuz = u.getZuzalek();
            if (ho != null && ho.getMennyiseg() > 0) sb.append("ho").append(ho.getMennyiseg()).append(" ");
            if (jeg != null && jeg.getMennyiseg() > 0) {
                sb.append("jeg").append(jeg.getMennyiseg());
                if (jeg.isFeltort()) sb.append("t");
                sb.append(" ");
            }
            if (zuz != null && zuz.getMennyiseg() > 0) {
                 // in the tests, it only says "zuzalek" when it's present, wait... let me check "test5_expected.txt".
                 sb.append("zuzalek").append(" ");
            }
            System.out.println(uId + " " + jmId + " : " + sb.toString().trim());
        }
    }
}
