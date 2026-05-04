package homlockin;

/**
 * A hányó típusú hókotrófej implementációja.
 * Ez a fej az aktuális útszakasz havát (és egyéb csapadékát) lesöpri,
 * de nem söpri a szomszédos útszakaszra – a hó egyszerűen eltűnik (pl. a folyóba kerül).
 * Implementálja a {@link HokotroFej} interfészt.
 */
public class Hanyofej implements HokotroFej {

    /** A hókotrófejhez tartozó {@link Hokotro} járű. */
    private Hokotro hokotro;

    /**
     * Visszaadja a fej típusnevét.
     *
     * @return {@code "hanyo"}
     */
    @Override
    public String getName() { return "hanyo"; }

    /**
     * A hányó fej munkája: lesöpri az aktuális útszakaszról a havat.
     * A hó eltűnik (nem söpri szomszédos útszakaszra).
     *
     * @param szakasz az útszakasz, amelyen a takarítás történik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        szakasz.hoLesopres(); 
    }

    /**
     * Beállítja a hókotrófejhez tartozó hókotrót.
     *
     * @param hk a gazda {@link Hokotro}
     */
    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
