package homlockin;

/**
 * A {@code Soszorofej} osztály a sószórófejjel való hókotró takarítást valósítja meg.
 * Sót szór az útszakaszra, amelyen a hókotró éppen áll, ezzel felolvasztja a havat
 * és a jégpáncélt, illetve lassítja a hó újbóli lerakódását. Ha a hókotró
 * sókészlete kifogyott, a hókotró félreáll. Megvalósítja a {@link HokotroFej} interfészt.
 */
public class Soszorofej implements HokotroFej {

    /** A sószórófej neve azonosítási célokra. */
    private String name;

    /** Az a hókotró, amelyre ez a sószórófej van felszerelve. */
    public Hokotro hokotro;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy alapértelmezett nevű sószórófejet.
     */
    public Soszorofej() { this.name = "soszorofej"; }

    /**
     * Névvel ellátott sószórófejet hoz létre.
     *
     * @param name a sószórófej neve
     */
    public Soszorofej(String name) { this.name = name; }

    /**
     * Visszaadja a sószórófej nevét.
     *
     * @return a sószórófej neve
     */
    @Override
    public String getName() { return name; }

    /**
     * A sószórófejjel való takarítás elvégzése. Sót szór az útszakaszra, amin
     * éppen áll a hókotró. Ha a hókotróban van elegendő só, elvégzi a sószórást,
     * amely felolvasztja a havat és a jeget; ellenkező esetben a hókotró félreáll.
     *
     * @param szakasz az az {@link Utszakasz}, amelyen a sószórást végzik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        if(hokotro.soFogyasztas(1)){
            szakasz.soSzoras();
        }
        else{
            hokotro.felreall();
        }
        szakasz.soSzoras();
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt a hókotró járművet, amelyre ez a sószórófej fel van szerelve.
     * Szükséges a sókészlet ellenőrzéséhez takarítás előtt.
     *
     * @param hk az a {@link Hokotro}, amelyre a sószórófej kerül
     */
    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
