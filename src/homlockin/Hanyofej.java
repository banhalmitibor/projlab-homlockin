package homlockin;

/**
 * A {@code Hanyofej} osztály a hányófejjel való hókotró takarítást valósítja meg.
 * A hányófej a havat a sávtól függetlenül az út jobb szélére söpri, és ha az
 * útszakaszon hó van, eltünteti azt az útszakaszról. Megvalósítja a
 * {@link HokotroFej} interfészt.
 */
public class Hanyofej implements HokotroFej {

    /** A hányófej neve azonosítási célokra. */
    private String name;

    /** Az a hókotró, amelyre ez a hányófej van felszerelve. */
    private Hokotro hokotro;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy alapértelmezett nevű hányófejet.
     */
    public Hanyofej() { this.name = "hanyofej"; }

    /**
     * Névvel ellátott hányófejet hoz létre.
     *
     * @param name a hányófej neve
     */
    public Hanyofej(String name) { this.name = name; }

    /**
     * Visszaadja a hányófej nevét.
     *
     * @return a hányófej neve
     */
    @Override
    public String getName() { return name; }

    /**
     * A hányófejjel való takarítás elvégzése. Eltünteti az útszakaszról a havat,
     * amennyiben azon hó van. A hányófej a sávtól függetlenül az út jobb szélére
     * söpri a havat, így a takarítás után az adott sávon nem marad hó.
     *
     * @param szakasz az az {@link Utszakasz}, amelyen a takarítást végzik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.hoLesopres();
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt a hókotró járművet, amelyre ez a hányófej fel van szerelve.
     *
     * @param hk az a {@link Hokotro}, amelyre a hányófej kerül
     */
    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
