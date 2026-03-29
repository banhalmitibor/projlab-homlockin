package homlockin;

/**
 * A {@code Ho} osztály felelős a hó viselkedésének megvalósításáért. Itt van
 * eltárolva a hó magassága, olvadási ideje és a maximum szintje. Ebben az osztályban
 * találhatók a hó letaposásának és eltakarításának kezelő metódusai, valamint a
 * magas hó állapotának megállapítása. A {@link Csapadek} absztrakt osztályból
 * származik le.
 */
public class Ho extends Csapadek {

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen hó objektumot.
     */
    public Ho() {}

    /**
     * Névvel ellátott hó objektumot hoz létre.
     *
     * @param name a hó objektum neve
     */
    public Ho(String name) { super(name); }

    /**
     * Megállapítja, hogy a hó mennyisége alapján magas hónak számít-e az adott
     * útszakaszon lévő hó. Ha igen, az autók elakadnak benne, és az útszakasz
     * járhatatlanná válik.
     *
     * @return {@code true}, ha a hó magassága eléri a maximális szintet és az autók
     *         elakadnak benne; {@code false} egyébként
     */
    public boolean magasHo() {
        Skeleton.methodCalled(name + ".magasHo()");
        boolean result = Skeleton.askYesNo("Magas hó?");
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Eltakarítja a havat az útszakaszról. Hókotró takarításakor (pl. hányófejjel
     * vagy söprőfejjel) hívódik meg, és a hó mennyiségét nullára csökkenti.
     */
    @Override
    public void eltakarit() {
        Skeleton.methodCalled(name + ".eltakarit()");
        Skeleton.methodReturned();
    }

    /**
     * Az adott mennyiséggel növeli a hó szintjét az útszakaszon. Hóeséskor
     * vagy söprőfejjel való áthelyezéskor hívódik meg.
     *
     * @param mennyiseg a növelés mértéke
     */
    @Override
    public void novel(int mennyiseg) {
        Skeleton.methodCalled(name + ".novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    /**
     * Az adott mennyiséggel csökkenti a hó szintjét az útszakaszon. Letaposáskor
     * hívódik meg, mivel az autók áthaladása tömöríti és csökkenti a hó mennyiségét.
     *
     * @param mennyiseg a csökkentés mértéke
     */
    @Override
    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled(name + ".csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    /**
     * Felsózza a havat az útszakaszon. A só olvasztja a havat és lassítja a hó
     * újbóli lerakódását. A sószórófej és a sárkányfej is ezt a folyamatot
     * indíthatja el.
     */
    @Override
    public void felsoz() {
        Skeleton.methodCalled(name + ".felsoz()");
        Skeleton.methodReturned();
    }
}
