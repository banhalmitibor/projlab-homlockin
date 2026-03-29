package homlockin;

/**
 * A {@code Csapadek} absztrakt osztály az egyes útszakaszokon lévő csapadék
 * (hó és jég) kezeléséért felelős. Eltárolja a csapadék mennyiségét, a maximális
 * szintet és az olvadási időt. Kezeli a letaposást, a különböző takarítási
 * folyamatokat (olvasztás, törés) és a felsózást. A {@link Ho} és {@link Jeg}
 * osztályok ebből az osztályból származnak le.
 */
public abstract class Csapadek {

    /** A csapadék (hó vagy jég) azonosítási neve. */
    protected String name;

    /** Megadja, hogy az adott útszakaszon mennyi csapadék (hó vagy jég) található. */
    protected int mennyiseg;

    /**
     * Megadja az adott csapadéktípus maximális szintjét, amely felett az útszakasz
     * járhatatlanná válik.
     */
    protected int maxSzint;

    /**
     * Számon tartja, hogy egy felsózott útszakasz mennyi ideje olvad. A só lassítja
     * a hó újbóli lerakódását és felgyorsítja az olvadást.
     */
    protected int olvadasIdo;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen csapadék objektumot.
     */
    public Csapadek() {}

    /**
     * Névvel ellátott csapadék objektumot hoz létre.
     *
     * @param name a csapadék neve
     */
    public Csapadek(String name) { this.name = name; }

    /**
     * Visszaadja a csapadék nevét.
     *
     * @return a csapadék neve
     */
    public String getName() { return name; }

    /**
     * Az adott mennyiséggel növeli a csapadék mennyiségét az útszakaszon.
     * Hóeséskor vagy hórásopréskor hívódik meg.
     *
     * @param mennyiseg a növelés mértéke
     */
    public void novel(int mennyiseg) {
        Skeleton.methodCalled(name + ".novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    /**
     * Az adott mennyiséggel csökkenti a csapadék mennyiségét az útszakaszon.
     * Letaposáskor hívódik meg, mivel az autók áthaladása csökkenti a hó szintjét.
     *
     * @param mennyiseg a csökkentés mértéke
     */
    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled(name + ".csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    /**
     * Ha egy hókotró takarítja az útszakaszt, a csapadék mennyisége csökken vagy
     * megszűnik. Ez a metódus kezeli az eltakarítást.
     */
    public void eltakarit() {
        Skeleton.methodCalled(name + ".eltakarit()");
        Skeleton.methodReturned();
    }

    /**
     * Az útszakasz felsózására alkalmas metódus. A só olvasztja a havat és a jeget,
     * illetve lassítja a hó újbóli lerakódását. A sószórófej és a sóvásárlás révén
     * alkalmazható.
     */
    public void felsoz() {
        Skeleton.methodCalled(name + ".felsoz()");
        Skeleton.methodReturned();
    }
}
