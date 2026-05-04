package homlockin;

/**
 * A játékost absztrakt módon reprezentáló osztály.
 * Minden játékostípus (pl. {@link TakaritoJatekos}, {@link BuszvezetoJatekos}) ebből öröklődik.
 * Tartalmazza a játékos nevét és az irányítási logika absztrakt metódusát.
 */
public abstract class Jatekos {

    /** A játékos neve. */
    protected String nev;

    /**
     * Létrehoz egy játékost a megadott névvel.
     *
     * @param nev a játékos neve
     */
    public Jatekos(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja a játékos nevét.
     *
     * @return a játékos neve
     */
    public String getNev() { return nev; }

    /**
     * Irányítja a megadott járművet a megadott útszakasz felé.
     * Az alosztályok implementálják a típusuktól függő irányítási logikát.
     *
     * @param jarmu     az irányítani kívánt {@link Jarmu}
     * @param utszakasz a célzott {@link Utszakasz}
     */
    public abstract void iranyit(Jarmu jarmu, Utszakasz utszakasz);
}
