package homlockin;

/**
 * A sárkányfej típusú hókotrófej implementációja.
 * Ez a fej bio-kerozint éget el, hogy felolvassza a hót és a jeget az útszakaszon.
 * Minden takarítási lépésnél 1 egység bio-kerozint fogyaszt.
 * Ha a hókotróban nincs elegendő kerozin, a fej nem végez munkát.
 * Implementálja a {@link HokotroFej} interfészt.
 */
public class Sarkanyfej implements HokotroFej {

    /** A hókotrófejhez tartozó {@link Hokotro} jármű. */
    private Hokotro hokotro;

    /**
     * Visszaadja a fej típusnevét.
     *
     * @return {@code "sarkany"}
     */
    @Override
    public String getName() { return "sarkany"; }

    /**
     * A sárkányfej munkája: 1 egység bio-kerozin felhasználásával felolvasztja a hót és a jeget
     * az útszakaszon. Ha nincs elegendő kerozin, nem végez munkát.
     *
     * @param szakasz az útszakasz, amelyen az olvasztás történik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        if (hokotro != null && hokotro.biokerozinFogyasztas(1)) {
            szakasz.olvasztas();
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
