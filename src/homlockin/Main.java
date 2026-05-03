package homlockin;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
                        System.out.println("a pálya beállítva, forrás: " + parts[1]);
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
                    System.out.println("leptetve");
                    break;
                case "snow":
                    varos.havazas();
                    break;
                case "print":
                    StateDumper.dumpAll();
                    break;
                case "save":
                    handleSave(parts);
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
            if (jatekosok.containsKey(id)) {
                System.out.println("\"" + id + "\" nevű takarítójátékos már létezik");
            } else {
                TakaritoJatekos tj = new TakaritoJatekos(id);
                tj.setBolt(bolt);
                varos.addJatekos(tj);
                jatekosok.put(id, tj);
                System.out.println("\"" + id + "\" nevű takarítójátékos hozzáadva");
            }
        } else if (type.equals("-bj")) {
            if (jatekosok.containsKey(id)) {
                System.out.println("\"" + id + "\" nevű buszvezető játékos már létezik");
            } else if (parts.length >= 5) {
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
                System.out.println("\"" + id + "\" nevű buszvezető játékos hozzáadva");
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
            if (fej != null) {
                hk.fejetCserel(fej);
                System.out.println(hkId + " azonosítójú hókotrónak a " + type + " típusú fej sikeresen beállítva");
            }
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
                        System.out.println("\"" + tj.getNev() + "\" nevű takarítójátékosnak új hókotró megvéve, a hókotró azonosítója: " + hkId);
                    } else {
                        System.out.println("\"" + tj.getNev() + "\" nevű takarítójátékosnak nincs elég pénze egy új hókotróra");
                    }
                }
            }
        } else if (type.equals("-fej")) {
            if (parts.length >= 4) {
                Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
                TakaritoJatekos tj = findOwner(hk);
                if (hk != null && tj != null) {
                    HokotroFej fej = createFej(parts[3]);
                    if (fej == null) {
                        System.out.println("\"" + parts[3] + "\" típusú hókotrófej nem létezik, az opciók: \"sarkany\", \"soszoro\", \"zuzalek\", \"jegtoro\", \"hanyo\", \"sopro\"");
                    } else {
                        int before = tj.getPenz();
                        bolt.setVasarol(tj);
                        bolt.hokotroFejetVasarol(hk, fej);
                        int after = tj.getPenz();
                        if (after < before) {
                            System.out.println(parts[2] + " azonosítójú hókotrónak új, \"" + parts[3] + "\" típusú fej megvéve");
                        } else {
                            System.out.println("\"" + tj.getNev() + "\" nevű takarítójátékosnak nincs elég pénze erre a típusú fejre");
                        }
                    }
                }
            }
        } else if (type.equals("-so")) {
            Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
            TakaritoJatekos tj = findOwner(hk);
            if (hk != null && tj != null) {
                int before = tj.getPenz();
                bolt.setVasarol(tj);
                bolt.sotVasarol(hk);
                int after = tj.getPenz();
                if (after < before) {
                    System.out.println(parts[2] + " azonosítójú hókotrónak só megvéve");
                } else {
                    System.out.println("\"" + tj.getNev() + "\" nevű takarítójátékosnak nincs elég pénze sóra");
                }
            }
        } else if (type.equals("-kerozin")) {
            Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
            TakaritoJatekos tj = findOwner(hk);
            if (hk != null && tj != null) {
                int before = tj.getPenz();
                bolt.setVasarol(tj);
                bolt.biokerozinVasarol(hk);
                int after = tj.getPenz();
                if (after < before) {
                    System.out.println(parts[2] + " azonosítójú hókotrónak biokerozin megvéve");
                } else {
                    System.out.println("\"" + tj.getNev() + "\" nevű takarítójátékosnak nincs elég pénze biokerozinra");
                }
            }
        } else if (type.equals("-zuzalek")) {
            Hokotro hk = (Hokotro) jarmuvek.get(parts[2]);
            TakaritoJatekos tj = findOwner(hk);
            if (hk != null && tj != null) {
                int before = tj.getPenz();
                bolt.setVasarol(tj);
                bolt.zuzalekotVasarol(hk);
                int after = tj.getPenz();
                if (after < before) {
                    System.out.println(parts[2] + " azonosítójú hókotrónak zúzalék megvéve");
                } else {
                    System.out.println("\"" + tj.getNev() + "\" nevű takarítójátékosnak nincs elég pénze zúzalékra");
                }
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
            System.out.println(id + " azonosítójú hókotrónak új cél beállítva, a cél útszakasz azonosítója: " + parts[2]);
            return;
        }

        System.out.println("\"" + id + "\" nevű buszvezető játékos nem létezik");
    }

    private static void handleList(String[] parts) {
        if (parts.length < 2) return;
        String type = parts[1];
        if (type.equals("-tj")) {
            for (Jatekos j : jatekosok.values()) {
                if (j instanceof TakaritoJatekos) {
                    TakaritoJatekos tj = (TakaritoJatekos) j;
                    System.out.print(tj.getNev());
                    // try to print owned hokotrok ids
                    for (Hokotro hk : tj.getHokotroi()) {
                        System.out.print(" " + hk.getId());
                    }
                    System.out.println();
                }
            }
        } else if (type.equals("-bj")) {
            for (Jatekos j : jatekosok.values()) {
                if (j instanceof BuszvezetoJatekos) {
                    System.out.println(j.getNev());
                }
            }
        } else if (type.equals("-palya")) {
            for (Utszakasz u : utszakaszok.values()) {
                System.out.println(u.getName());
            }
        }
    }

    private static TakaritoJatekos findOwner(Hokotro hk) {
        for (Jatekos j : jatekosok.values()) {
            if (j instanceof TakaritoJatekos) {
                if (((TakaritoJatekos)j).getHokotroi().contains(hk)) return (TakaritoJatekos)j;
            }
        }
        return null;
    }

    private static void handleSave(String[] parts) {
        String filename = "jatekallas.txt";
        if (parts != null && parts.length >= 2 && parts[1] != null && !parts[1].isEmpty()) {
            filename = parts[1];
        }

        PrintStream oldOut = System.out;
        PrintStream fos = null;
        try {
            fos = new PrintStream(new java.io.FileOutputStream(filename));
            System.setOut(fos);
            StateDumper.dumpAll();
            System.out.flush();
            // restore and print success
            System.setOut(oldOut);
            if (fos != null) fos.close();
            System.out.println("a játékállás sikeresen el lett mentve a " + filename + " nevű fájlba");
        } catch (Exception e) {
            // restore and report failure
            System.setOut(oldOut);
            if (fos != null) try { fos.close(); } catch (Exception ex) {}
            System.out.println("a mentés sikertelen volt");
        }
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
