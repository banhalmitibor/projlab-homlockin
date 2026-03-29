package homlockin;

import java.util.ArrayList;
import java.util.List;

public class Varos {
    private String name;
    private List<Jarmu> jarmuvek = new ArrayList<>();
    private List<Utszakasz> utszakaszok = new ArrayList<>();
    private List<Jatekos> jatekosok = new ArrayList<>();
    private int elakadtAutokSzama;
    private int maxElakadasokSzama = 3;

    public Varos() {}
    public Varos(String name) { this.name = name; }

    public void leptet() {
        Skeleton.methodCalled("v.leptet()");
        for (Utszakasz u : utszakaszok) {
            u.hoEsik();
        }
        for (Jarmu j : jarmuvek) {
            j.lep();
        }
        Skeleton.methodReturned();
    }

    public boolean jatekVegeEllenorzes() {
        Skeleton.methodCalled("v.jatekVegeEllenorzes()");
        int db = 0;
        for (Jarmu j : jarmuvek) {
            if (j instanceof Auto) {
                Auto a = (Auto) j;
                if (a.getElakadva()) {
                    db++;
                }
            }
        }
        boolean vege = Skeleton.askYesNo("Elérte a maximális elakadások számát?");
        Skeleton.methodReturned();
        return vege;
    }

    // Silent setters / adders
    public void addJarmu(Jarmu j) { jarmuvek.add(j); }
    public void addUtszakasz(Utszakasz u) { utszakaszok.add(u); }
    public void addJatekos(Jatekos j) { jatekosok.add(j); }
    public void removeJarmu(Jarmu j) { jarmuvek.remove(j); }
    public List<Jarmu> getJarmuvek() { return jarmuvek; }
    public List<Utszakasz> getUtszakaszok() { return utszakaszok; }
}
