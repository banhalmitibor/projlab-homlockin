package homlockin;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;

import tests.RunTests;

import java.util.Map;

public class Main {
    public static Varos varos = new Varos("Homlockin");
    public static Bolt bolt = new Bolt();
    
    public static Map<String, Jarmu> jarmuvek = new TreeMap<>();
    public static Map<String, Utszakasz> utszakaszok = new TreeMap<>();
    public static Map<String, Jatekos> jatekosok = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.equalsIgnoreCase("exit")) break;
            processCommand(line);
        }
        scanner.close();
    }

    public static void processCommand(String line) {
        String[] parts = line.split("\\s+");
        String cmd = parts[0].toLowerCase();
        
        try {
            switch (cmd) {
                case "init":
                    varos = new Varos("Homlockin");
                    jarmuvek.clear();
                    utszakaszok.clear();
                    jatekosok.clear();
                    bolt = new Bolt();
                    if (parts.length > 1) {
                        TestParser.loadPalya(parts[1]);
                    }
                    break;
                case "palya":
                    if (parts.length > 1) {
                        TestParser.loadPalya(parts[1]);
                    }
                    break;
                case "add":
                    handleAdd(parts);
                    break;
                case "swap":
                    handleSwap(parts);
                    break;
                case "car":
                    handleCar(parts);
                    break;
                case "buy":
                    handleBuy(parts);
                    break;
                case "route":
                    handleRoute(parts);
                    break;
                case "step":
                    varos.leptet();
                    break;
                case "snow":
                    varos.havazas();
                    break;
                case "print":
                    StateDumper.dumpAll();
                    break;
                case "save":
                    // RunTests and RestoreTests handle this or we can implement it
                    StateDumper.dumpAll();
                    break;
                case "list":
                    handleList(parts);
                    break;
                case "tests":
                    RunTests.runTest(parts);;
                    break;
                default:
                    // ignore or error
            }
        } catch (Exception e) {}
    }

    private static void handleAdd(String[] parts) {
        if (parts.length < 3) return;
        String type = parts[1];
        String id = parts[2];
        if (type.equals("-tj")) {
            TakaritoJatekos tj = new TakaritoJatekos(id);
            tj.setBolt(bolt);
            varos.addJatekos(tj);
            jatekosok.put(id, tj);
        } else if (type.equals("-bj")) {
            if (parts.length >= 5) {
                Utszakasz v1 = utszakaszok.get(parts[3]);
                Utszakasz v2 = utszakaszok.get(parts[4]);
                BuszvezetoJatekos bj = new BuszvezetoJatekos(id, v1, v2);
                varos.addJatekos(bj);
                jatekosok.put(id, bj);
                Busz b = new Busz(id, bj);
                b.setAllRajta(v1);
                bj.setVezeti(b);
                varos.addJarmu(b);
                jarmuvek.put(id, b);
            }
        }
    }

    private static void handleSwap(String[] parts) {
        if (parts.length < 3) return;
        String hkId = parts[1];
        String type = parts[2];
        Hokotro hk = (Hokotro) jarmuvek.get(hkId);
        if (hk != null) {
            HokotroFej fej = createFej(type);
            if (fej != null) hk.fejetCserel(fej);
        }
    }

    private static void handleCar(String[] parts) {
        if (parts.length < 3) return;
        String id = parts[1];
        String startId = parts[2];
        Utszakasz pos = utszakaszok.get(startId);
        if (pos != null) {
            Auto a = new Auto(id);
            a.setAllRajta(pos);
            varos.addJarmu(a);
            jarmuvek.put(id, a);
            for (int i = 3; i < parts.length; i++) {
                Utszakasz u = utszakaszok.get(parts[i]);
                if (u != null) a.getUtvonala().addUtszakasz(u);
            }
        }
    }

    private static void handleBuy(String[] parts) {
        if (parts.length < 3) return;
        String type = parts[1];
        if (type.equals("-hk")) {
            if (parts.length >= 5) {
                String hkId = parts[2];
                String tjId = parts[3];
                String uId = parts[4];
                TakaritoJatekos tj = (TakaritoJatekos) jatekosok.get(tjId);
                Utszakasz u = utszakaszok.get(uId);
                if (tj != null && u != null) {
                    Hokotro hk = bolt.hokotrotVasarol(hkId, tj, u);
                    if (hk != null) {
                        varos.addJarmu(hk);
                        jarmuvek.put(hkId, hk);
                    }
                }
            }
        } else if (type.equals("-fej")) {
            if (parts.length >= 4) {
                Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
                TakaritoJatekos tj = findOwner(hk);
                if (hk != null && tj != null) {
                    bolt.setVasarol(tj);
                    HokotroFej fej = createFej(parts[3]);
                    if (fej != null) bolt.hokotroFejetVasarol(hk, fej);
                }
            }
        } else if (type.equals("-so")) {
            Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
            TakaritoJatekos tj = findOwner(hk);
            if (hk != null && tj != null) {
                bolt.setVasarol(tj);
                bolt.sotVasarol(hk);
            }
        } else if (type.equals("-kerozin")) {
            Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
            TakaritoJatekos tj = findOwner(hk);
            if (hk != null && tj != null) {
                bolt.setVasarol(tj);
                bolt.biokerozinVasarol(hk);
            }
        } else if (type.equals("-zuzalek")) {
            Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
            TakaritoJatekos tj = findOwner(hk);
            if (hk != null && tj != null) {
                bolt.setVasarol(tj);
                bolt.zuzalekotVasarol(hk);
            }
        }
    }

    private static void handleRoute(String[] parts) {
        if (parts.length < 3) return;
        String id = parts[1];
        Jarmu j = jarmuvek.get(id);
        if (j == null) {
            // Buszvezető név alapján?
            Jatekos jat = jatekosok.get(id);
            if (jat instanceof BuszvezetoJatekos) {
                j = ((BuszvezetoJatekos)jat).getVezeti();
            }
        }
        if (j != null) {
            Utvonal u = new Utvonal();
            for (int i = 2; i < parts.length; i++) {
                Utszakasz s = utszakaszok.get(parts[i]);
                if (s != null) u.addUtszakasz(s);
            }
            j.setUtvonala(u);
        }
    }

    private static void handleList(String[] parts) {
        // Optional implementation
    }

    private static TakaritoJatekos findOwner(Hokotro hk) {
        for (Jatekos j : jatekosok.values()) {
            if (j instanceof TakaritoJatekos) {
                if (((TakaritoJatekos)j).getHokotroi().contains(hk)) return (TakaritoJatekos)j;
            }
        }
        return null;
    }

    private static HokotroFej createFej(String type) {
        switch (type) {
            case "sopro": return new Soprofej();
            case "hanyo": return new Hanyofej();
            case "jegtoro": return new Jegtorofej();
            case "sarkany": return new Sarkanyfej();
            case "zuzalek": return new Zuzalekfej();
            case "soszoro": return new Soszorofej();
        }
        return null;
    }
}
