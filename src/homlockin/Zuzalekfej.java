package homlockin;

/**
 * A zúzalékszóró típusú hókotrófej implementációja.
 * Ez a fej zúzalékot szór az útszakaszra, ami javítja a tapadást és segíthet
 * megakadályozni a járművek csúszását. Minden szórási lépésnél 1 egység zúzalékot fogyaszt.
 * Ha a hókotróban nincs elegendő zúzalék, a fej nem végez munkát.
 * Implementálja a {@link HokotroFej} interfészt.
 */
public class Zuzalekfej implements HokotroFej {

    /** A hókotrófejhez tartozó {@link Hokotro} jármű. */
    private Hokotro hokotro;

    /**
     * Visszaadja a fej típusnevét.
     *
     * @return {@code "zuzalek"}
     */
    @Override
    public String getName() { return "zuzalek"; }

    /**
     * A zúzalékszóró fej munkája: 1 egység zúzalék felhasználásával zúzalékot szór az útszakaszra.
     * Ha nincs elegendő zúzalék, nem végez munkát.
     *
     * @param szakasz az útszakasz, amelyre a zúzalék kerül
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        if (hokotro != null && hokotro.zuzalekFogyasztas(1)) {
            szakasz.zuzalekSzoras(); 
        }
    }

    /**
     * Beállítja a hókotrófejhez tartozó hókotrót.
     *
     * @param hk a gazda {@link Hokotro}
     */
    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
