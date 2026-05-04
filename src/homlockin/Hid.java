package homlockin;

/**
 * A hidat reprezentáló útszakasz-osztály.
 * A {@link Utszakasz} osztályból öröklődik. A hídra esik a hó,
 * de az alatta lévő útszakaszt megvédi a havazástól (hóvédett állapot).
 * Ha egy hókotró a hókat a hídról letolja, a hó eltűnik (pl. a folyóba kerül),
 * mivel a jobbra lévő szakasz {@code null}-t ad vissza.
 */
public class Hid extends Utszakasz {

    /** Az az útszakasz, amelyik a híd alatt halad át (hóvédelmet kap). */
    private Utszakasz alattaMegy;

    /**
     * Létrehoz egy névtelen hidat.
     */
    public Hid() {
        super();
    }

    /**
     * Létrehoz egy hidat a megadott névvel.
     *
     * @param name a híd azonosítója/neve
     */
    public Hid(String name) {
        super(name);
    }

    /**
     * Beállítja, hogy melyik útszakasz halad a híd alatt.
     * Az előző alatta lévő útszakaszt megszünteti a hóvédelemtől,
     * az újat pedig hóvédetté teszi.
     *
     * @param u az új, híd alatti {@link Utszakasz}; {@code null} esetén nincs alatta menő útszakasz
     */
    public void setAlattaMegy(Utszakasz u) {
        if (this.alattaMegy != null) {
            this.alattaMegy.setHovedett(false);
        }
        this.alattaMegy = u;
        if (this.alattaMegy != null) {
            this.alattaMegy.setHovedett(true);
        }
    }

    /**
     * Visszaadja a híd alatt haladó útszakaszt.
     *
     * @return a híd alatt lévő {@link Utszakasz}, vagy {@code null}, ha nincs ilyen
     */
    public Utszakasz getAlattaMegy() {
        return alattaMegy;
    }

    /**
     * A híd esetén a jobbra lévő útszakasz mindig {@code null}.
     * Ez azt jelenti, hogy ha egy hókotró letolja a hídról a havat, az egyszerűen eltűnik
     * (pl. a folyóba kerül), nem kerül szomszédos útszakaszra.
     * <p>
     * A feladat kikötése: "A híd felületére esik a hó, de az alatta lévő útszakaszt megvédi a havazástól.
     * Ha egy hókotró letolja a hídról a havat az eltűnik."
     *
     * @return mindig {@code null}
     */
    // A feladat köv. kikötése van: "A híd felületére esik a hó, de az alatta lévő útszakaszt megvédi a havazástól.
    // Ha egy hókotró letolja a hídról a havat az eltűnik."
    // Tehát ha valaki lekéri a jobbra lévőt, hogy rásöpröljön hókotróval, itt null-t adunk vissza, 
    // így el fog tűnni (mint az igazi letolásnál a folyóba vagy a semmibe)
    @Override
    public Utszakasz getJobbraLevoSzakasz() {
        return null;
    }
}
