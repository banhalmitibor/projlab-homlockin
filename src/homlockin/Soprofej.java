package homlockin;

/**
 * A söprőfej típusú hókotrófej implementációja.
 * Ez az alapértelmezett hókotrófej, amellyel a hókotró alapból rendelkezik.
 * A söprőfej az aktuális útszakaszról lesöpri a havat, a feltört jeget és a zúzalékot,
 * majd a szomszédos (jobbra lévő) útszakaszra söpri őket. Ha nincs jobbra lévő útszakasz
 * (pl. híd esetén), a söpört anyag eltűnik.
 * Implementálja a {@link HokotroFej} interfészt.
 */
public class Soprofej implements HokotroFej {

    /** A hókotrófejhez tartozó {@link Hokotro} jármű. */
    private Hokotro hokotro;

    /**
     * Visszaadja a fej típusnevét.
     *
     * @return {@code "sopro"}
     */
    @Override
    public String getName() { return "sopro"; }

    /**
     * A söprőfej munkája: az aktuális útszakaszról lesöpri a havat, feltört jeget és zúzalékot,
     * majd a jobbra lévő szomszédos útszakaszra söpri azokat.
     * Ha nincs jobbra lévő útszakasz, az anyagok eltűnnek.
     *
     * @param szakasz az útszakasz, amelyen a söprés történik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Utszakasz jobb = szakasz.getJobbraLevoSzakasz();
        
        // Először megnézzük van-e hó vagy zúzalék amit söpörhetünk
        int hoMennyiseg = (szakasz.getHo() != null) ? szakasz.getHo().getMennyiseg() : 0;
        int zuzMennyiseg = (szakasz.getZuzalek() != null && szakasz.getZuzalek().vanZuzalek()) ? 1 : 0;
        int jegMennyiseg = (szakasz.getJeg() != null && szakasz.getJeg().isFeltort()) ? szakasz.getJeg().getMennyiseg() : 0;

        // Lesöpörjük az aktuális szakaszról
        szakasz.hoLesopres();
        
        // Ha van jobbra szakasz, rásöpörjük
        if (jobb != null) {
            if (hoMennyiseg > 0) jobb.hoRasopres(hoMennyiseg);
            if (zuzMennyiseg > 0) jobb.zuzalekRasopres(zuzMennyiseg);
            if (jegMennyiseg > 0) {
                jobb.getJeg().novel(jegMennyiseg);
                jobb.getJeg().setFeltort(true);
            }
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
