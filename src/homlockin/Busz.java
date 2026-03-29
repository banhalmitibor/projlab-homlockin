package homlockin;

/**
 * A {@code Busz} osztály a buszvezető játékosok által irányított járművet modellez.
 * A busz célja, hogy két végállomás között közlekedjen. Ha sikeresen elér egy
 * végállomást, pontot generál a vezető játékosnak. Ha csúszós úton egy másik jármű
 * (autó vagy busz) beleütközik, egy ideig mozgásképtelenné válik. Az {@link Jarmu}
 * absztrakt osztályból származik le.
 */
public class Busz extends Jarmu {

    /** Az a buszvezető játékos, aki ezt a buszt vezeti. */
    private BuszvezetoJatekos vezeto;

    /** Az egyik végállomás, amelyek között a busz közlekedik. */
    private Utszakasz vegallomas1;

    /** A másik végállomás, amelyek között a busz közlekedik. */
    private Utszakasz vegallomas2;

    /**
     * Visszaszámláló, amely méri, hogy az adott busz meddig volt mozgásképtelen
     * egy ütközés következtében.
     */
    private int elakadasVisszaszamlalo;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen buszt.
     */
    public Busz() {}

    /**
     * Névvel ellátott buszt hoz létre.
     *
     * @param name a busz neve
     */
    public Busz(String name) { this.name = name; }

    /**
     * A következő útszakaszra lépteti a buszt az útvonal alapján. Ha a busz
     * eléri valamelyik végállomást, a vezető játékos pontot kap. A busz
     * az {@link Utvonal} segítségével határozza meg a következő lépés irányát.
     */
    @Override
    public void lep() {
        Skeleton.methodCalled(name + ".lep()");
        if (utvonal != null) {
            Utszakasz cel = utvonal.getKivantUtszakasz();
            if (cel != null) {
                jelenlegiUtszakasz.kovetkezoUtszakasz(cel);
                boolean vegallomas = Skeleton.askYesNo("Elérte a végállomást?");
                if (vegallomas && vezeto != null) {
                    vezeto.pontotKap();
                }
            }
        }
        Skeleton.methodReturned();
    }

    /**
     * Kezeli az ütközés következményeit. Amikor két busz vagy egy busz és egy autó
     * összeütközik csúszós útszakaszon, a busz mozgásképtelenné válik. Az elakadás
     * visszaszámláló segítségével mérhető, hogy a busz meddig volt mozgásképtelen.
     *
     * @param j2 az a másik jármű, amellyel az ütközés bekövetkezett
     */
    @Override
    public void utkozes(Jarmu j2) {
        Skeleton.methodCalled(name + ".utkozik()");
        Skeleton.methodReturned();
    }

    /**
     * Beállítja a busz útvonalát. Az útvonal meghatározza, hogy a busz melyik
     * útszakaszokon haladjon a két végállomás között.
     *
     * @param u az új {@link Utvonal} objektum, amelyet a buszhoz rendelünk
     */
    public void utvonalBeallit(Utvonal u) {
        Skeleton.methodCalled(name + ".utvonalBeallit(" + (u != null ? u.getName() : "null") + ")");
        this.utvonal = u;
        Skeleton.methodReturned();
    }

    /**
     * Beállítja a buszt vezető játékost.
     *
     * @param v a buszt vezető {@link BuszvezetoJatekos}
     */
    public void setVezeto(BuszvezetoJatekos v) { this.vezeto = v; }

    /**
     * Beállítja az első végállomást.
     *
     * @param u az első végállomás {@link Utszakasz} objektuma
     */
    public void setVegallomas1(Utszakasz u) { this.vegallomas1 = u; }

    /**
     * Beállítja a második végállomást.
     *
     * @param u a második végállomás {@link Utszakasz} objektuma
     */
    public void setVegallomas2(Utszakasz u) { this.vegallomas2 = u; }
}
