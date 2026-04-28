package homlockin;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Varos varos = new Varos("Homlockin");
    private static Bolt bolt = new Bolt();
    
    // Névterek a teszteléshez (az ID alapú kereséshez a parancsokban)
    private static Map<String, Jarmu> jarmuvek = new HashMap<>();
    private static Map<String, Utszakasz> utszakaszok = new HashMap<>();
    private static Map<String, Jatekos> jatekosok = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Homlockin Hokotro Szimulator Tesztkonzol");
        System.out.println("A kilepeshez ird: exit");
        
        while (true) { 
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            
            processCommand(line);
        }
        
        scanner.close();
    }

    private static void processCommand(String line) {
        String[] parts = line.split("\\s+");
        String cmd = parts[0].toLowerCase();
        
        try {
            switch (cmd) {
                case "init":
                    // Inicializálja a játékot (üres város)
                    varos = new Varos("Homlockin");
                    jarmuvek.clear();
                    utszakaszok.clear();
                    jatekosok.clear();
                    bolt = new Bolt();
                    System.out.println("A varos inicializalva.");
                    break;
                    
                case "add":
                    handleAdd(parts);
                    break;
                    
                case "buy":
                    handleBuy(parts);
                    break;
                    
                case "route":
                    handleRoute(parts);
                    break;
                    
                case "step":
                    varos.leptet();
                    System.out.println("A varos lepett egyet.");
                    if (varos.jatekVegeEllenorzes()) {
                        System.out.println("Jatek vege: Tul sok auto akadt el.");
                    }
                    break;
                    
                case "snow":
                    varos.havazas();
                    System.out.println("Havazas tortent a varosban.");
                    break;
                    
                case "print":
                    handlePrint();
                    break;
                
                case "load":
                    // load from file
                    if (parts.length > 1) {
                        loadFromFile(parts[1]);
                    } else {
                        System.out.println("Hiba: add meg a fajlnevet.");
                    }
                    break;
                    
                default:
                    System.out.println("Ismeretlen parancs: " + cmd);
            }
        } catch (Exception e) {
            System.out.println("Hiba a parancs vegrehajtasakor: " + e.getMessage());
        }
    }
    
    private static void handleAdd(String[] parts) {
        if (parts.length < 3) {
            System.out.println("Hiba: nincsenek megadva az add parameterei. (pl. add -tj tj1)");
            return;
        }
        
        String type = parts[1];
        String idLine = parts[2];
        
        if (type.equals("-tj")) { // Takarító Játékos
            TakaritoJatekos tj = new TakaritoJatekos(idLine);
            tj.setBolt(bolt);
            varos.addJatekos(tj);
            jatekosok.put(idLine, tj);
            System.out.println("Takarito jatekos letrehozva: " + idLine);
        } else if (type.equals("-bj")) { // Buszvezető Játékos
            BuszvezetoJatekos bj = new BuszvezetoJatekos(idLine);
            varos.addJatekos(bj);
            jatekosok.put(idLine, bj);
            System.out.println("Buszvezeto jatekos letrehozva: " + idLine);
        } else if (type.equals("-u")) {   // Útszakasz
            Utszakasz u = new Utszakasz(idLine);
            varos.addUtszakasz(u);
            utszakaszok.put(idLine, u);
            System.out.println("Utszakasz letrehozva: " + idLine);
        } else if (type.equals("-hid")) { // Híd
            Hid h = new Hid(idLine);
            varos.addUtszakasz(h);
            utszakaszok.put(idLine, h);
            System.out.println("Hid letrehozva: " + idLine);
        } else if (type.equals("-alagut")) { // Alagút
            Alagut a = new Alagut(idLine);
            varos.addUtszakasz(a);
            utszakaszok.put(idLine, a);
            System.out.println("Alagut letrehozva: " + idLine);
        } else if (type.equals("-a")) { // Autó
            if (parts.length >= 4) {
                 Utszakasz pos = utszakaszok.get(parts[3]);
                 if (pos != null) {
                     Auto a = new Auto(idLine);
                     a.setAllRajta(pos);
                     pos.setJarmu(a);
                     varos.addJarmu(a);
                     jarmuvek.put(idLine, a);
                     System.out.println("Auto letrehozva es elhelyezve: " + idLine + " hely: " + parts[3]);
                 }
            } else {
                 System.out.println("Hiba: add -a autoId utszakaszId");
            }
        } else if (type.equals("-b")) { // Busz
            if (parts.length >= 4) {
                 Utszakasz pos = utszakaszok.get(parts[3]);
                 if (pos != null) {
                     Busz b = new Busz(idLine, null);
                     b.setAllRajta(pos);
                     pos.setJarmu(b);
                     varos.addJarmu(b);
                     jarmuvek.put(idLine, b);
                     System.out.println("Busz letrehozva es elhelyezve: " + idLine + " hely: " + parts[3]);
                 }
            } else {
                 System.out.println("Hiba: add -b buszId utszakaszId");
            }
        } else if (type.equals("-hk")) { // Hókotró null játékossal (üres hozzáadás tesztekhez)
             if (parts.length >= 4) {
                 Utszakasz pos = utszakaszok.get(parts[3]);
                 if (pos != null) {
                     Hokotro hk = new Hokotro(idLine, null); // alap hókotró, fej nélkül
                     hk.setAllRajta(pos);
                     pos.setJarmu(hk);
                     varos.addJarmu(hk);
                     jarmuvek.put(idLine, hk);
                     System.out.println("Hokotro letrehozva es elhelyezve: " + idLine + " hely: " + parts[3]);
                 }
             } else {
                 System.out.println("Hiba: add -hk hkId utszakaszId");
             }
        }
        else {
            System.out.println("Ismeretlen tipus: " + type);
        }
    }
    
    private static void handleBuy(String[] parts) {
        if (parts.length < 4) {
            System.out.println("Hiba: Parameterhiany (pl. buy -hk hk1 tj1 u1)");
            return;
        }
        String type = parts[1];
        
        if (type.equals("-hk")) {
            // buy -hk hokotroId takaritoId utszakaszId
            if (parts.length >= 5) {
                String hkId = parts[2];
                String tjId = parts[3];
                String uId  = parts[4];
                
                Jatekos j = jatekosok.get(tjId);
                Utszakasz u = utszakaszok.get(uId);
                
                if (j instanceof TakaritoJatekos && u != null) {
                    Hokotro hk = bolt.hokotrotVasarol(hkId, (TakaritoJatekos)j, u);
                    if (hk != null) {
                         varos.addJarmu(hk);
                         jarmuvek.put(hkId, hk);
                         u.setJarmu(hk);
                         System.out.println(tjId + " vasarolt egy Hokotrot ("+hkId+") a " + uId + " utszakaszra.");
                    } else {
                         System.out.println("Nem sikerult a vasarlas (nincs penz?).");
                    }
                } else {
                    System.out.println("Hiba: hibasjatekos ("+tjId+") vagy utszakasz ("+uId+").");
                }
            } else {
                System.out.println("Hiba: Parameterhiany buy -hk");
            }
        } else if (type.equals("-fej")) {
            // buy -fej tj1 hk1 <tipus> pl: buy -fej tj1 hk1 sopro
            if (parts.length >= 5) {
                String tjId = parts[2];
                String hkId = parts[3];
                String fejType = parts[4];

                Jatekos j = jatekosok.get(tjId);
                Jarmu jarmu = jarmuvek.get(hkId);

                if (j instanceof TakaritoJatekos && jarmu instanceof Hokotro) {
                    TakaritoJatekos tj = (TakaritoJatekos) j;
                    Hokotro hk = (Hokotro) jarmu;
                    HokotroFej fej = null;
                    if (fejType.equals("sopro")) fej = new Soprofej();
                    else if (fejType.equals("jegtoro")) fej = new Jegtorofej();
                    else if (fejType.equals("hanyo")) fej = new Hanyofej();
                    else if (fejType.equals("zuzalek")) fej = new Zuzalekfej();
                    else if (fejType.equals("soszoro")) fej = new Soszorofej();
                    else if (fejType.equals("sarkany")) fej = new Sarkanyfej();
                    
                    if (fej != null) {
                        bolt.hokotroFejetVasarol(tj, hk, fej);
                        System.out.println("Fej ("+fejType+") felszerelve a hk="+hkId+" szamara.");
                    } else {
                        System.out.println("Ismeretlen fej tipus: " + fejType);
                    }
                }
            }
        }
    }
    
    private static void handleRoute(String[] parts) {
        // route jarmuId utszakasz1 utszakasz2 ...
        // Ha utszakasz nem létezik, esetleg hagyjuk figyelmen kivul vagy hibat jelzunk
        if (parts.length < 3) {
            System.out.println("Hiba: Parameterhiany (pl. route j1 u1 u2)");
            return;
        }
        
        String jarmuId = parts[1];
        Jarmu j = jarmuvek.get(jarmuId);
        
        if (j != null) {
            Utvonal ut = new Utvonal();
            for (int i = 2; i < parts.length; i++) {
                Utszakasz u = utszakaszok.get(parts[i]);
                if (u != null) {
                    ut.addUtszakasz(u);
                } else {
                    System.out.println("Figyelmeztetes: Utszakasz nem elerheto vagy nincs: " + parts[i]);
                }
            }
            j.setUtvonala(ut);
            System.out.println(jarmuId + " utvonala frissitve.");
        } else {
            System.out.println("Hiba: Nincs ilyen jarmu: " + jarmuId);
        }
    }
    
    private static void handlePrint() {
        System.out.println("--- Jelenlegi allapot ---");
        System.out.println("Utszakaszok szama: " + varos.getUtszakaszok().size());
        for(Map.Entry<String, Utszakasz> entry : utszakaszok.entrySet()) {
             Utszakasz u = entry.getValue();
             String ho = (u.getHo() != null) ? "" + u.getHo().getMennyiseg() : "0";
             String jeg = (u.getJeg() != null) ? "" + u.getJeg().getMennyiseg() : "0";
             String zuz = (u.getZuzalek() != null) ? "" + u.getZuzalek().getMennyiseg() : "0";
             String jarmuNev = (u.getJarmu() != null) ? u.getJarmu().getId() : "-";
             
             System.out.println("  [" + entry.getKey() + "]: Ho=" + ho + " Jeg=" + jeg + " Zuzalek=" + zuz + " Jarmu=" + jarmuNev);
        }
        System.out.println("Jarmuvek szama: " + varos.getJarmuvek().size());
        System.out.println("Jatekosok szama: " + varos.getJatekosok().size());
        System.out.println("-------------------------");
    }

    private static void loadFromFile(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                System.out.println("> " + line);
                if (!line.isEmpty() && !line.startsWith("#")) {
                    processCommand(line);
                }
            }
            fileScanner.close();
            System.out.println("Fajl betoltese sikeres.");
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: Fajl nem talalhato (" + filename + ")");
        }
    }
}
