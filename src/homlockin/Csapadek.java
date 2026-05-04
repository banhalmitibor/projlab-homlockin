package homlockin;

/**
 * A csapadékot (hó, jég, zúzalék) absztrakt módon reprezentáló osztály.
 * Az összes csapadéktípus (pl. {@link Ho}, {@link Jeg}, {@link Zuzalek}) ebből öröklődik.
 * Tartalmazza a mennyiség kezelésének általános logikáját: növelés, csökkentés, takarítás és sózás.
 */
public abstract class Csapadek {

    /** Az aktuális csapadékmennyiség. */
    protected int mennyiseg;

    /** A maximálisan tárolható csapadékmennyiség. */
    protected int maxSzint;

    /** A csapadék leolvasásához tartozó idő (tartalék mező, jelenleg nem aktívan használt). */
    protected int olvadasIdo;

    /**
     * Alapértelmezett konstruktor: a mennyiséget és az olvasási időt nullára inicializálja.
     */
    public Csapadek() {
        this.mennyiseg = 0;
        this.olvadasIdo = 0;
    }

    /**
     * Visszaadja az aktuális csapadékmennyiséget.
     *
     * @return a csapadék mennyisége
     */
    public int getMennyiseg() {
        return mennyiseg;
    }

    /**
     * Beállítja a csapadékmennyiséget, értékét a [0, maxSzint] tartományra korlátozza.
     *
     * @param mennyiseg az új kívánt mennyiség
     */
    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
        if (this.mennyiseg > maxSzint) {
            this.mennyiseg = maxSzint;
        } else if (this.mennyiseg < 0) {
            this.mennyiseg = 0;
        }
    }

    /**
     * Növeli a csapadékmennyiséget a megadott értékkel, legfeljebb {@code maxSzint}-ig.
     *
     * @param mennyiseg az hozzáadandó mennyiség
     */
    public void novel(int mennyiseg) {
        this.mennyiseg += mennyiseg;
        if (this.mennyiseg > maxSzint) {
            this.mennyiseg = maxSzint;
        }
    }

    /**
     * Csökkenti a csapadékmennyiséget a megadott értékkel, de legalább 0-ra korlátozva.
     *
     * @param mennyiseg a levonandó mennyiség
     */
    public void csokkent(int mennyiseg) {
        this.mennyiseg -= mennyiseg;
        if (this.mennyiseg < 0) {
            this.mennyiseg = 0;
        }
    }

    /**
     * Teljesen eltakarítja a csapadékot (mennyiséget nullára állítja).
     */
    public void eltakarit() {
        this.mennyiseg = 0;
    }

    /**
     * Sózás hatása: ha van csapadék, eggyel csökkenti a mennyiséget.
     * Ezzel modellezi, hogy a sózás folyamatosan csökkenti a jeget/havat.
     */
    public void felsoz() {
        if (this.mennyiseg > 0) {
            this.csokkent(1); // Sózás folyamatosan csökkenti a jeget/havat
        }
    }
}
