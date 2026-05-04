package homlockin;

/**
 * A jeget reprezentáló csapadékosztály.
 * A {@link Csapadek} absztrakt osztályból öröklődik. A jégnek van egy "feltört" állapota,
 * amely jelzi, hogy a jégtörőfej már megdolgozta-e. Ha a jégmennyiség eléri a 4-et,
 * jégpáncélnak minősül, ami csúszást okoz a járműveknek.
 */
public class Jeg extends Csapadek {

    /** Jelzi, hogy a jeget feltörték-e már (jégtörőfejjel). */
    private boolean feltort;

    /** Az az útszakasz, amelyen a jég található. */
    private Utszakasz vanRajta;

    /**
     * Létrehoz egy jég-csapadék objektumot az adott útszakaszhoz.
     * Kezdetben a jégmennyiség 0, a feltört állapot hamis, és a maximum 5.
     *
     * @param vanRajta az útszakasz, amelyen a jég van
     */
    public Jeg(Utszakasz vanRajta) {
        super();
        this.vanRajta = vanRajta;
        this.maxSzint = 5;
        this.feltort = false;
    }

    /**
     * Feltöri a jeget: jelzi, hogy jégtörő-művelet végrehajtódott ezen a jégen.
     */
    public void jegetTor() {
        this.feltort = true;
    }

    /**
     * Visszaadja, hogy a jeget feltörték-e már.
     *
     * @return {@code true}, ha a jég fel van törve; {@code false} egyébként
     */
    public boolean isFeltort() {
        return feltort;
    }

    /**
     * Beállítja a jég feltört állapotát.
     *
     * @param feltort {@code true}, ha feltört; {@code false}, ha nem
     */
    public void setFeltort(boolean feltort) {
        this.feltort = feltort;
    }

    /**
     * Megvizsgálja, hogy a jég jégpáncélnak minősül-e.
     * Ha a jégmennyiség eléri a 4-et, jégpáncélnak minősül, ami csúszást okoz a járműveknek.
     *
     * @return {@code true}, ha a jégmennyiség legalább 4; {@code false} egyébként
     */
    public boolean jegPancel() {
        return this.mennyiseg >= 4;
    }
}
