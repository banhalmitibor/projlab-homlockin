package homlockin;

/**
 * A {@code Jatekos} absztrakt osztály a játékosok általános modelljét valósítja meg.
 * A kétféle játékos – a buszvezető és a takarító játékos – ebből az osztályból
 * származik le. Tárolja a játékos nevét, és definiálja az irányítási metódust,
 * amelyet mindkét játékostípus saját maga implementál.
 */
public abstract class Jatekos {

    /** A játékos neve azonosítási célokra. */
    protected String name;

    /**
     * Visszaadja a játékos nevét.
     *
     * @return a játékos neve
     */
    public String getName() { return name; }

    /**
     * Lehetővé teszi a játékos számára, hogy irányítsa a járművét. A buszvezető
     * játékos a buszát, a takarító játékos a hókotróját irányítja ezzel a metódussal.
     * Minden leszármazott osztálynak saját implementációt kell megadnia.
     */
    public abstract void iranyit();
}
