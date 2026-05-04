package homlockin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A várost reprezentáló osztály, amely a játék fő konténere.
 * Tartalmazza az összes közlekedő járművet, útszakaszt és játékost.
 * A város kezeli a körönkénti léptetést, a havazást, és nyilvántartja az elakadt autók számát.
 * A játék akkor ér véget, ha az elakadt autók száma eléri a maximumot.
 */
public class Varos {

    /** A város neve. */
    private String name;

    /** A városban közlekedő járművek listája. */
    private List<Jarmu> kozlekedikBenne = new ArrayList<>();

    /** A várost felépítő útszakaszok listája. */
    private List<Utszakasz> felepiti = new ArrayList<>();

    /** A városban játszó játékosok listája. */
    private List<Jatekos> jatszikBenne = new ArrayList<>();

    /** Az elakadt (ütközött) autók száma. */
    private int elakadtAutokSzama = 0;

    /** A maximálisan megengedett elakadások száma (ennyi felett a játék véget ér). */
    private int maxElakadasokSzama = 3;

    /**
     * Létrehoz egy várost a megadott névvel.
     *
     * @param name a város neve
     */
    public Varos(String name) { this.name = name; }

    /**
     * Létrehoz egy névtelen várost.
     */
    public Varos() { this(""); }

    /**
     * Növeli az elakadt autók számlálóját eggyel (ütközés bekövetkezésekor hívódik meg).
     */
    public void incrementElakadas() {
        this.elakadtAutokSzama++;
    }

    /**
     * Elvégzi a városban egy kör léptetését: minden járművet lépteti,
     * majd eltávolítja azokat az autókat, amelyek célba értek (nincs útszakaszuk).
     */
    public void leptet() {
        // Sort vehicles by ID to ensure deterministic order (matching TreeMap in Main)
        List<Jarmu> sortedJarmuvek = new ArrayList<>(kozlekedikBenne);
        //Collections.sort(sortedJarmuvek, (j1, j2) -> j1.getId().compareTo(j2.getId()));

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

    /**
     * Szimulálja a havazást: minden útszakaszra esik hó (ha nem hóvédett).
     */
    public void havazas() {
        for (Utszakasz u : felepiti) {
            u.hoEsik();
        }
    }

    /**
     * Ellenőrzi, hogy a játéknak vége van-e (az elakadt autók száma elérte a maximumot).
     *
     * @return {@code true}, ha a játéknak vége; {@code false} egyébként
     */
    public boolean jatekVegeEllenorzes() {
        return elakadtAutokSzama >= maxElakadasokSzama;
    }

    /**
     * Hozzáad egy járművet a városhoz.
     *
     * @param j a hozzáadandó {@link Jarmu}
     */
    public void addJarmu(Jarmu j) { kozlekedikBenne.add(j); }

    /**
     * Hozzáad egy útszakaszt a városhoz.
     *
     * @param u a hozzáadandó {@link Utszakasz}
     */
    public void addUtszakasz(Utszakasz u) { felepiti.add(u); }

    /**
     * Hozzáad egy játékost a városhoz.
     *
     * @param j a hozzáadandó {@link Jatekos}
     */
    public void addJatekos(Jatekos j) { jatszikBenne.add(j); }

    /**
     * Eltávolít egy járművet a városból.
     *
     * @param j az eltávolítandó {@link Jarmu}
     */
    public void removeJarmu(Jarmu j) { kozlekedikBenne.remove(j); }

    /**
     * Visszaadja a városban közlekedő járművek listáját.
     *
     * @return a járművek {@link List}je
     */
    public List<Jarmu> getJarmuvek() { return kozlekedikBenne; }

    /**
     * Visszaadja a várost felépítő útszakaszok listáját.
     *
     * @return az útszakaszok {@link List}je
     */
    public List<Utszakasz> getUtszakaszok() { return felepiti; }

    /**
     * Visszaadja a városban játszó játékosok listáját.
     *
     * @return a játékosok {@link List}je
     */
    public List<Jatekos> getJatekosok() { return jatszikBenne; }
}
