package homlockin;

/**
 * A jégtörő típusú hókotrófej implementációja.
 * Ez a fej az útszakaszon lévő jeget töri fel, azaz "feltört" állapotba hozza,
 * ami lehetővé teszi, hogy a söprőfej (vagy hányófej) később eltakarítsa.
 * Implementálja a {@link HokotroFej} interfészt.
 */
public class Jegtorofej implements HokotroFej {

    /** A hókotrófejhez tartozó {@link Hokotro} jármű. */
    private Hokotro hokotro;

    /**
     * Visszaadja a fej típusnevét.
     *
     * @return {@code "jegtoro"}
     */
    @Override
    public String getName() { return "jegtoro"; }

    /**
     * A jégtörő fej munkája: az útszakaszon lévő jeget feltöri.
     *
     * @param szakasz az útszakasz, amelyen a jégtörés történik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        szakasz.jegTores();
    }

    /**
     * Beállítja a hókotrófejhez tartozó hókotrót.
     *
     * @param hk a gazda {@link Hokotro}
     */
    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
