package homlockin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Varos {
    private String name;
    private List<Jarmu> jarmuvek = new ArrayList<>();
    private List<Utszakasz> utszakaszok = new ArrayList<>();
    private List<Jatekos> jatekosok = new ArrayList<>();

    private int maxElakadasokSzama = 3;

    public Varos(String name) { this.name = name; }
    public Varos() { this(""); }

    public void leptet() {
        Iterator<Jarmu> it = jarmuvek.iterator();
        while (it.hasNext()) {
            Jarmu j = it.next();
            j.lep();
            
            // Célba ért Autó (allRajta == null a lep után)
            if (j instanceof Auto && j.getAllRajta() == null) {
                it.remove();
            }
        }
    }

    public void havazas() {
        for (Utszakasz u : utszakaszok) {
            u.hoEsik();
        }
    }

    public boolean jatekVegeEllenorzes() {
        int elakadtDb = 0;
        for (Jarmu j : jarmuvek) {
            if (j instanceof Auto) {
                Auto a = (Auto) j;
                if (a.isUtkozott()) {
                    elakadtDb++;
                }
            }
        }
        return elakadtDb >= maxElakadasokSzama;
    }

    public void addJarmu(Jarmu j) { jarmuvek.add(j); }
    public void addUtszakasz(Utszakasz u) { utszakaszok.add(u); }
    public void addJatekos(Jatekos j) { jatekosok.add(j); }
    public void removeJarmu(Jarmu j) { jarmuvek.remove(j); }
    public List<Jarmu> getJarmuvek() { return jarmuvek; }
    public List<Utszakasz> getUtszakaszok() { return utszakaszok; }
    public List<Jatekos> getJatekosok() { return jatekosok; }
}
