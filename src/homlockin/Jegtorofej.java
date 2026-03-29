package homlockin;

/**
 * A {@code Jegtorofej} osztály a jégtörőfejjel való hókotró takarítást valósítja meg.
 * Ha az útszakaszon jég van, akkor feltört jég állapotba viszi az útszakasz csapadékát –
 * azaz a jégből jégtörmeléket csinál, amely hóként viselkedik tovább. Megvalósítja a
 * {@link HokotroFej} interfészt.
 */
public class Jegtorofej implements HokotroFej {

    /** A jégtörőfej neve azonosítási célokra. */
    private String name;

    /** Az a hókotró, amelyre ez a jégtörőfej van felszerelve. */
    private Hokotro hokotro;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy alapértelmezett nevű jégtörőfejet.
     */
    public Jegtorofej() { this.name = "jegtorofej"; }

    /**
     * Névvel ellátott jégtörőfejet hoz létre.
     *
     * @param name a jégtörőfej neve
     */
    public Jegtorofej(String name) { this.name = name; }

    /**
     * Visszaadja a jégtörőfej nevét.
     *
     * @return a jégtörőfej neve
     */
    @Override
    public String getName() { return name; }

    /**
     * A jégtörőfejjel való takarítás elvégzése. Ha az útszakaszon jég van, akkor
     * feltört jég állapotba viszi az útszakasz csapadékát. A feltört jég hóként
     * viselkedik az útszakaszon, és további takarítással eltávolítható.
     *
     * @param szakasz az az {@link Utszakasz}, amelyen a jégtörést végzik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.jegTores();
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt a hókotró járművet, amelyre ez a jégtörőfej fel van szerelve.
     *
     * @param hk az a {@link Hokotro}, amelyre a jégtörőfej kerül
     */
    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}

