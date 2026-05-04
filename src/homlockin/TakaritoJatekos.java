package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * A takarítójátékost reprezentáló osztály.
 * A {@link Jatekos} absztrakt osztályból öröklődik. A takarítójátékos hókotrókat vásárolhat
 * és irányíthat, pénzt kap takarításért, és pénzt költ eszközök vásárlására a boltban.
 * Kezdő pénze 1000 egység.
 */
public class TakaritoJatekos extends Jatekos {

    /** A játékos által irányított hókotrok listája. */
    private List<Hokotro> vezeti;

    /** A bolt, ahol a játékos vásárolhat. */
    private Bolt vasarol;

    /** A játékos aktuális pénzegyenlege. */
    private int penz;

    /**
     * Létrehoz egy takarítójátékost a megadott névvel.
     * Kezdő pénzegyenlege 1000 egység, hókotrolistája üres.
     *
     * @param nev a játékos neve
     */
    public TakaritoJatekos(String nev) {
        super(nev);
        this.vezeti = new ArrayList<>();
        this.penz = 1000; // As per doc: "játékosok kezdő pénze: 1000"
    }

    /**
     * Visszaadja a játékos által irányított hókotrok listáját.
     *
     * @return a hókotrok {@link List}je
     */
    public List<Hokotro> getHokotroi() { return vezeti; }

    /**
     * Hozzáad egy hókotrot a játékos irányítása alá.
     *
     * @param hk a hozzáadandó {@link Hokotro}
     */
    public void hokotroHozzaadas(Hokotro hk) {
        this.vezeti.add(hk);
    }

    /**
     * Beállítja a bolt referenciát, ahol a játékos vásárolhat.
     *
     * @param bolt a {@link Bolt} objektum
     */
    public void setBolt(Bolt bolt) {
        this.vasarol = bolt;
    }

    /**
     * Visszaadja a játékos aktuális pénzegyenlegét.
     *
     * @return a pénzegyenleg
     */
    public int getPenz() { return penz; }

    /**
     * Növeli a játékos pénzegyenlegét a megadott összeggel.
     *
     * @param osszeg a jóváírandó pénzösszeg
     */
    public void penztKap(int osszeg) {
        this.penz += osszeg;
    }

    /**
     * Csökkenti a játékos pénzegyenlegét a megadott összeggel.
     *
     * @param osszeg a levonandó pénzösszeg
     */
    public void penztLevon(int osszeg) {
        this.penz -= osszeg;
    }

    /**
     * Irányítja a megadott hókotró járművet a megadott útszakasz felé.
     * Csak akkor van hatása, ha a megadott jármű a játékos saját hókotroinak listájában szerepel.
     * Ez esetben az útszakaszt hozzáadja a jármű útvonalához.
     *
     * @param jarmu     az irányítani kívánt {@link Jarmu}
     * @param utszakasz a célzott {@link Utszakasz}
     */
    @Override
    public void iranyit(Jarmu jarmu, Utszakasz utszakasz) {
        if (vezeti.contains(jarmu)) {
            jarmu.getUtvonala().addUtszakasz(utszakasz);
        }
    }
}
