package homlockin;

/**
 * A {@code Sarkanyfej} osztály a sárkányfejjel való hókotró takarítást valósítja meg.
 * Biokerozin égetésével azonnal elolvasztja a havat és a jégpáncélt az útszakaszról.
 * Ha a hókotró biokerozin készlete kifogyott, a hókotró félreáll. Megvalósítja a
 * {@link HokotroFej} interfészt.
 */
public class Sarkanyfej implements HokotroFej {

    /** A sárkányfej neve azonosítási célokra. */
    private String name;

    /** Az a hókotró, amelyre ez a sárkányfej van felszerelve. */
    private Hokotro hokotro;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy alapértelmezett nevű sárkányfejet.
     */
    public Sarkanyfej() { this.name = "sarkanyfej"; }

    /**
     * Névvel ellátott sárkányfejet hoz létre.
     *
     * @param name a sárkányfej neve
     */
    public Sarkanyfej(String name) { this.name = name; }

    /**
     * Visszaadja a sárkányfej nevét.
     *
     * @return a sárkányfej neve
     */
    @Override
    public String getName() { return name; }

    /**
     * A sárkányfejjel való takarítás elvégzése. Biokerozin égetésével azonnal
     * olvasztja el a havat és a jégpáncélt az útszakaszról. Ha a hókotróban van
     * elegendő biokerozin, elvégzi az olvasztást; ellenkező esetben a hókotró félreáll.
     *
     * @param szakasz az az {@link Utszakasz}, amelyen az olvasztást végzik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        if(hokotro.biokerozinFogyasztas(1)){
            szakasz.olvasztas();
        }
        else{
            hokotro.felreall();
        }
        
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt a hókotró járművet, amelyre ez a sárkányfej fel van szerelve.
     * Szükséges a biokerozin készlet ellenőrzéséhez takarítás előtt.
     *
     * @param hk az a {@link Hokotro}, amelyre a sárkányfej kerül
     */
    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
