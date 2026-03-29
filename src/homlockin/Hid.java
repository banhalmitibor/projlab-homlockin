package homlockin;

/**
 * A {@code Hid} osztály egy speciális útszakaszt modellez, amely lehetővé teszi,
 * hogy alatta egy másik út haladjon át. A híd felületére esik a hó, de az alatta
 * lévő útszakaszt megvédi a havazástól. Ha egy hókotró letolja a hídról a havat,
 * az eltűnik. Az {@link Utszakasz} osztályból származik le.
 */
public class Hid extends Utszakasz {

    /**
     * Az az útszakasz, amely a híd alatt halad. Ha ilyen útszakasz létezik,
     * a híd megvédi a havazástól.
     */
    private Utszakasz alattaMego;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen hídszakaszt.
     */
    public Hid() {}

    /**
     * Névvel ellátott hídszakaszt hoz létre.
     *
     * @param name a híd neve
     */
    public Hid(String name) { super(name); }

    /**
     * A hóesés kezelését végző metódus. Az alatta lévő útszakasznál blokkolja
     * a hóesést, a felszíne pedig sima útszakaszként viselkedik: a híd tetejére
     * is esik hó (növeli a hómennyiséget), de az alatta haladó út védve van.
     */
    @Override
    public void hoEsik() {
        Skeleton.methodCalled(name + ".hoEsik()");
        // Híd védi az alatta lévő útszakaszt a hótól
        if (ho != null) {
            ho.novel(1);
        }
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt az útszakaszt, amely a híd alatt halad.
     *
     * @param u az alatta haladó {@link Utszakasz} objektum
     */
    public void setAlattaMego(Utszakasz u) { this.alattaMego = u; }

    /**
     * Visszaadja azt az útszakaszt, amely a híd alatt halad.
     *
     * @return az alatta haladó {@link Utszakasz} objektum
     */
    public Utszakasz getAlattaMego() { return alattaMego; }
}
