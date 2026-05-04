package homlockin;

/**
 * A havat reprezentáló osztály.
 * A {@link Csapadek} absztrakt osztályból öröklődik.
 * A maximális hómennyiség 5, és ha az értéke eléri a 4-et, az útszakasz járhatatlanná válik az autók számára.
 */
public class Ho extends Csapadek {

    /**
     * Létrehoz egy hó-csapadék objektumot, ahol a kezdeti mennyiség 0 és a maximum 5.
     */
    public Ho() {
        super();
        this.maxSzint = 5;
    }

    /**
     * Megvizsgálja, hogy a hómennyiség eléri-e a kritikus (magas) szintet.
     * Ha a hómennyiség legalább 4, az útszakasz járhatatlannak minősül az autók számára.
     *
     * @return {@code true}, ha a hómennyiség legalább 4; {@code false} egyébként
     */
    public boolean magasHo() {
        return this.mennyiseg >= 4; 
    }
}
