package homlockin;

/**
 * A sószóró típusú hókotrófej implementációja.
 * Ez a fej sót szór az útszakaszra, ami csökkenti a hó és a jég mennyiségét.
 * Minden takarítási lépésnél 1 egység sót fogyaszt a hókotró sókészletéből.
 * Ha a hókotróban nincs elegendő só, a fej nem végez munkát.
 * Implementálja a {@link HokotroFej} interfészt.
 */
public class Soszorofej implements HokotroFej {

    /** A hókotrófejhez tartozó {@link Hokotro} jármű. */
    private Hokotro hokotro;

    /**
     * Visszaadja a fej típusnevét.
     *
     * @return {@code "soszoro"}
     */
    @Override
    public String getName() { return "soszoro"; }

    /**
     * A sószóró fej munkája: 1 egység só felhasználásával sót szór az útszakaszra.
     * Ha nincs elegendő só, nem végez munkát.
     *
     * @param szakasz az útszakasz, amelyre a só kerül
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        if (hokotro != null && hokotro.soFogyasztas(1)) {
            szakasz.soSzoras();
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
