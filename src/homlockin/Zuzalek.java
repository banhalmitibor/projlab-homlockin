package homlockin;

/**
 * A zúzalékot reprezentáló csapadékosztály.
 * A {@link Csapadek} absztrakt osztályból öröklődik. A zúzalék egy speciális anyag,
 * amelyet a hókotró szórhat az útszakaszokra, hogy javítsa a tapadást.
 * Maximálisan 1 egységnyi zúzalék lehet egy útszakaszon. Ha hó temetni meg,
 * a zúzalék eltűnik (eltemeti a hó).
 */
public class Zuzalek extends Csapadek {

    /** Az útszakasz, amelyen a zúzalék van. */
    private Utszakasz utszakasz;

    /**
     * Létrehoz egy zúzalékobjektumot a megadott útszakaszhoz.
     * Kezdeti mennyiség 0, maximum 1.
     *
     * @param u az az útszakasz, amelyen a zúzalék van
     */
    public Zuzalek(Utszakasz u) {
        super();
        this.utszakasz = u;
        this.maxSzint = 1;
    }

    /**
     * A zúzalékot eltemeti (eltávolítja), ha hó fedi be.
     * Az {@link Csapadek#eltakarit()} metódust hívja.
     */
    public void eltemet() {
        this.eltakarit();
    }

    /**
     * Megvizsgálja, hogy van-e zúzalék az útszakaszon.
     *
     * @return {@code true}, ha a zúzalékmennyiség nagyobb mint 0; {@code false} egyébként
     */
    public boolean vanZuzalek() {
        return this.mennyiseg > 0;
    }
}
