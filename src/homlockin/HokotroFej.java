package homlockin;

/**
 * A hókotró fejéhez tartozó interfész.
 * Minden hókotrófej-típus (pl. {@link Soprofej}, {@link Hanyofej}, {@link Jegtorofej},
 * {@link Sarkanyfej}, {@link Soszorofej}, {@link Zuzalekfej}) implementálja ezt az interfészt.
 * A fej meghatározza, hogy a hókotró milyen takarítási műveletet végez az útszakaszon.
 */
public interface HokotroFej {

    /**
     * Elvégzi a fej típusának megfelelő munkát a megadott útszakaszon.
     *
     * @param szakasz az útszakasz, amelyen a takarítás/kezelés történik
     */
    void munkatVegez(Utszakasz szakasz);

    /**
     * Visszaadja a fej típusnevét (pl. {@code "sopro"}, {@code "jegtoro"}, stb.).
     *
     * @return a fej azonosító neve
     */
    String getName();

    /**
     * Beállítja a hókotrófejhez tartozó gazda hókotrot.
     * Ez szükséges azon fejeknél, amelyek anyagkészletet (só, kerozin, zúzalék) használnak.
     *
     * @param hk a gazda {@link Hokotro}
     */
    void setHokotro(Hokotro hk);
}
