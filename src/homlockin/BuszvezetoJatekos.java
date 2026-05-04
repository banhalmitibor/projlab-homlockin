package homlockin;

/**
 * A buszvezetőt reprezentáló játékososztály.
 * A {@link Jatekos} absztrakt osztályból öröklődik. A buszvezetőjátékos egy {@link Busz} járművet
 * vezet, és pontokat kap, ha a busszal eléri valamelyik végállomását. Az irányítás a busz útvonalát
 * befolyásolja.
 */
public class BuszvezetoJatekos extends Jatekos {

    /** A játékos által összegyűjtött pontszám. */
    private int pontszam;

    /** A játékos által vezetett {@link Busz}. */
    private Busz vezeti;

    /** Az egyik végállomás útszakasza, amelynek elérése pontot ér. */
    private Utszakasz vegallomas1;

    /** A másik végállomás útszakasza, amelynek elérése pontot ér. */
    private Utszakasz vegallomas2;

    /**
     * Létrehoz egy buszvezetőjátékost a megadott névvel és két végállomással.
     *
     * @param nev a játékos neve
     * @param v1  az egyik végállomás útszakasza
     * @param v2  a másik végállomás útszakasza
     */
    public BuszvezetoJatekos(String nev, Utszakasz v1, Utszakasz v2) {
        super(nev);
        this.pontszam = 0;
        this.vegallomas1 = v1;
        this.vegallomas2 = v2;
    }

    /**
     * Visszaadja az első végállomás útszakaszát.
     *
     * @return az első végállomás {@link Utszakasz}
     */
    public Utszakasz getVegallomas1() { return vegallomas1; }

    /**
     * Visszaadja a második végállomás útszakaszát.
     *
     * @return a második végállomás {@link Utszakasz}
     */
    public Utszakasz getVegallomas2() { return vegallomas2; }

    /**
     * Visszaadja a játékos aktuális pontszámát.
     *
     * @return a pontszám
     */
    public int getPontszam() { return pontszam; }

    /**
     * 5 pontot ad a játékosnak (végállomás elérésekor hívódik meg).
     */
    public void pontotKap() {
        this.pontszam += 5;
    }

    /**
     * Visszaadja a játékos által vezetett buszt.
     *
     * @return a {@link Busz}, vagy {@code null}, ha nincs beállítva
     */
    public Busz getVezeti() { return vezeti; }

    /**
     * Beállítja a játékos által vezetett buszt.
     *
     * @param b a vezető busz
     */
    public void setVezeti(Busz b) {
        this.vezeti = b;
    }

    /**
     * Irányítja a megadott járművet a megadott útszakasz felé.
     * Csak akkor van hatása, ha a megadott jármű megegyezik a játékos saját buszával.
     * Ez esetben az útszakaszt hozzáadja a busz útvonalához.
     *
     * @param jarmu     az irányítani kívánt jármű
     * @param utszakasz a célzott útszakasz
     */
    @Override
    public void iranyit(Jarmu jarmu, Utszakasz utszakasz) {
        if (this.vezeti == jarmu) {
            jarmu.getUtvonala().addUtszakasz(utszakasz);
        }
    }
}
