package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@code Varos} osztály a játékvilág keretrendszere. Felelőssége az útszakaszok,
 * a játékosok és a járművek összefogása. A város intézi a hóesést, számon tartja az
 * autókat és elindítja őket az otthonokról a munkahelyekre. Kezeli a játék állását
 * is: ellenőrzi, hogy vége van-e a játéknak, ami az elakadt autók számán múlik.
 */
public class Varos {

    /** A város neve azonosítási célokra. */
    private String name;

    /** A városban közlekedő összes jármű (autók, buszok, hókotrók) listája. */
    private List<Jarmu> jarmuvek = new ArrayList<>();

    /** A város útszakaszainak listája, amelyekből az úthálózat épül fel. */
    private List<Utszakasz> utszakaszok = new ArrayList<>();

    /** A városban játszó összes játékos (buszvezető és takarító játékosok) listája. */
    private List<Jatekos> jatekosok = new ArrayList<>();

    /**
     * A játékban jelenleg elakadt autók száma. Ha ez a szám eléri a maximumot,
     * a játék véget ér.
     */
    private int elakadtAutokSzama;

    /**
     * Az elakadt autók maximális száma, amely felett a játéknak vége.
     * Alapértelmezetten 3.
     */
    private int maxElakadasokSzama = 3;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen várost.
     */
    public Varos() {}

    /**
     * Névvel ellátott várost hoz létre.
     *
     * @param name a város neve
     */
    public Varos(String name) { this.name = name; }

    /**
     * Lépteti a játék idejét eggyel, és az ezzel kapcsolatos történéseket intézi.
     * Minden lépésnél hóesés következhet be az útszakaszokon, majd a járművek is
     * lépnek. Ha egy autó eléri a végállomást, eltávolítja a városból.
     */
    public void leptet() {
        Skeleton.methodCalled(name + ".leptet()");
        for (Utszakasz u : utszakaszok) {
            u.hoEsik();
        }
        for (Jarmu j : jarmuvek) {
            j.lep();
            if(j.getClass() == Auto.class)
                if(j.beertAVegallomasba()) {
                    Skeleton.methodCalled("v.autok.remove(j)");
                    jarmuvek.remove(j);
                    Skeleton.methodReturned();
                }
        }
        Skeleton.methodReturned();
    }

    /**
     * Ellenőrzi, hogy a játéknak vége van-e. Ha az elakadt autók száma eléri a
     * maximumot ({@code maxElakadasokSzama}), a játék véget ér és ez a metódus
     * {@code true} értékkel tér vissza.
     *
     * @return {@code true}, ha a játéknak vége (elakadások száma elérte a maximumot);
     *         {@code false}, ha a játék még folytatódik
     */
    public boolean jatekVegeEllenorzes() {
        Skeleton.methodCalled(name + ".jatekVegeEllenorzes()");
        int elakadtDb = 0;
        for (Jarmu j : jarmuvek) {
            if (j instanceof Auto) {
                Auto a = (Auto) j;
                if (a.getElakadva()) {
                    elakadtDb++;
                }
            }
        }
        
        boolean vege = Skeleton.askYesNo("Elérte a maximális elakadások számát?");
        
        Skeleton.methodReturned();
        return vege;
    }

    /**
     * Hozzáad egy járművet a városhoz (autó, busz vagy hókotró).
     *
     * @param j a városhoz hozzáadandó {@link Jarmu} objektum
     */
    public void addJarmu(Jarmu j) { jarmuvek.add(j); }

    /**
     * Hozzáad egy útszakaszt a város útszakaszainak listájához.
     *
     * @param u a hozzáadandó {@link Utszakasz} objektum
     */
    public void addUtszakasz(Utszakasz u) { utszakaszok.add(u); }

    /**
     * Hozzáad egy játékost a városhoz.
     *
     * @param j a hozzáadandó {@link Jatekos} objektum
     */
    public void addJatekos(Jatekos j) { jatekosok.add(j); }

    /**
     * Eltávolít egy járművet a városból (pl. amikor az autó célba ér).
     *
     * @param j az eltávolítandó {@link Jarmu} objektum
     */
    public void removeJarmu(Jarmu j) { jarmuvek.remove(j); }

    /**
     * Visszaadja a városban közlekedő összes jármű listáját.
     *
     * @return a járművek listája
     */
    public List<Jarmu> getJarmuvek() { return jarmuvek; }

    /**
     * Visszaadja a város összes útszakaszának listáját.
     *
     * @return az útszakaszok listája
     */
    public List<Utszakasz> getUtszakaszok() { return utszakaszok; }
}
