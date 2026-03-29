package homlockin;

/**
 * A {@code Jeg} osztály felelős a jég viselkedésének megvalósításáért. Itt van
 * eltárolva a jég mennyisége, olvadási ideje és a maximum szintje. Ebben az
 * osztályban található a jég feltörését kezelő metódus. Ha elegendő jég van az
 * útszakaszon, jégpáncél alakul ki, amely megcsúsztatja az ott áthaladó járműveket.
 * A {@link Csapadek} absztrakt osztályból származik le.
 */
public class Jeg extends Csapadek {

    /**
     * Igaz értékkel jelzi, hogy a jég állapota feltört-e (jégtörőfejjel való
     * takarítás után). Feltört állapotban a jég hóként viselkedik az útszakaszon.
     */
    private boolean feltort;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen jég objektumot.
     */
    public Jeg() {}

    /**
     * Névvel ellátott jég objektumot hoz létre.
     *
     * @param name a jég objektum neve
     */
    public Jeg(String name) { super(name); }

    /**
     * A jégtörőfejjel való jégtörést kezeli. A jég mennyiségét lenullázza,
     * viszont az útszakaszon lévő hó mennyiségét növeli, mert a feltört jég
     * hóként viselkedik. A {@code feltort} jelzőt igazra állítja.
     */
    public void jegetTor() {
        Skeleton.methodCalled(name + ".jegetTor()");
        feltort = true;
        Skeleton.methodReturned();
    }

    /**
     * Meghatározza, hogy elég jég van-e az adott útszakaszon ahhoz, hogy
     * jégpáncélnak lehessen minősíteni. Ha igen, az ott áthaladó járművek
     * megcsúszhatnak.
     *
     * @return {@code true}, ha az útszakaszon jégpáncél alakult ki; {@code false} egyébként
     */
    public boolean jegPancel() {
        Skeleton.methodCalled(name + ".jegPancel()");
        boolean result = Skeleton.askYesNo("Jégpáncél alakult ki?");
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Eltakarítja a jeget az útszakaszról. Hókotró takarításakor (pl. sószórófejjel
     * vagy sárkányfejjel) hívódik meg, és a jég mennyiségét nullára csökkenti.
     */
    @Override
    public void eltakarit() {
        Skeleton.methodCalled(name + ".eltakarit()");
        Skeleton.methodReturned();
    }

    /**
     * Az adott mennyiséggel növeli a jég szintjét az útszakaszon. Letaposáskor
     * hívódik meg, mivel az autók áthaladása tömöríti a havat és jéggé alakítja.
     *
     * @param mennyiseg a növelés mértéke
     */
    @Override
    public void novel(int mennyiseg) {
        Skeleton.methodCalled(name + ".novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    /**
     * Az adott mennyiséggel csökkenti a jég szintjét az útszakaszon.
     *
     * @param mennyiseg a csökkentés mértéke
     */
    @Override
    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled(name + ".csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    /**
     * Felsózza a jeget az útszakaszon. A só olvasztja a jégpáncélt és lassítja
     * a hó és jég újbóli kialakulását. A sószórófej ezt a folyamatot indítja el.
     */
    @Override
    public void felsoz() {
        Skeleton.methodCalled(name + ".felsoz()");
        Skeleton.methodReturned();
    }
}
