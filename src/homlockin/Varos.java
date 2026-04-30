package homlockin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Varos {
    private String name;
    private List<Jarmu> kozlekedikBenne = new ArrayList<>();
    private List<Utszakasz> felepiti = new ArrayList<>();
    private List<Jatekos> jatszikBenne = new ArrayList<>();

    private int elakadtAutokSzama = 0;
    private int maxElakadasokSzama = 3;

    public Varos(String name) { this.name = name; }
    public Varos() { this(""); }

    public void incrementElakadas() {
        this.elakadtAutokSzama++;
    }

    public void leptet() {
        // Sort vehicles by ID to ensure deterministic order (matching TreeMap in Main)
        List<Jarmu> sortedJarmuvek = new ArrayList<>(kozlekedikBenne);
        Collections.sort(sortedJarmuvek, (j1, j2) -> j1.getId().compareTo(j2.getId()));

        for (Jarmu j : sortedJarmuvek) {
            j.lep();
        }
        
        // Remove vehicles that left the track (Auto reaching target)
        Iterator<Jarmu> it = kozlekedikBenne.iterator();
        while (it.hasNext()) {
            Jarmu j = it.next();
            if (j instanceof Auto && j.getAllRajta() == null) {
                it.remove();
            }
        }
    }

    public void havazas() {
        for (Utszakasz u : felepiti) {
            u.hoEsik();
        }
    }

    public boolean jatekVegeEllenorzes() {
        return elakadtAutokSzama >= maxElakadasokSzama;
    }

    public void addJarmu(Jarmu j) { kozlekedikBenne.add(j); }
    public void addUtszakasz(Utszakasz u) { felepiti.add(u); }
    public void addJatekos(Jatekos j) { jatszikBenne.add(j); }
    public void removeJarmu(Jarmu j) { kozlekedikBenne.remove(j); }
    public List<Jarmu> getJarmuvek() { return kozlekedikBenne; }
    public List<Utszakasz> getUtszakaszok() { return felepiti; }
    public List<Jatekos> getJatekosok() { return jatszikBenne; }
}
