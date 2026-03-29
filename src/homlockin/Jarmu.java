package homlockin;

/**
 * A {@code Jarmu} absztrakt osztály az összes jármű általános mozgásáért,
 * helyének tárolásáért és az útvonalának tárolásáért felelős. Itt van kezelve
 * az ütközés és a megcsúszás is. Az {@link Auto}, {@link Busz} és {@link Hokotro}
 * osztályok ebből az osztályból származnak le.
 */
public abstract class Jarmu {

    /** A jármű neve azonosítási célokra. */
    protected String name;

    /** Az az útszakasz, amelyen a jármű jelenleg tartózkodik. */
    protected Utszakasz jelenlegiUtszakasz;

    /**
     * A jármű haladási útvonala. Az útvonal tartalmazza a célállomás felé vezető
     * útszakaszok sorrendjét.
     */
    protected Utvonal utvonal;

    /**
     * A következő útszakaszra lépteti a járművet. Az {@link Utvonal} segítségével
     * határozza meg a következő lépés irányát. Minden leszármazott osztálynak saját
     * implementációt kell megadnia, mivel az autók, buszok és hókotrók eltérő
     * viselkedést mutatnak.
     */
    public abstract void lep();

    /**
     * Kezeli a járművek közötti ütközést. Egyes járműtípusoknál eltér az
     * implementáció: az autóknál az útszakasz járhatatlanná válik, a buszoknál
     * a busz mozgásképtelenné válik.
     *
     * @param j2 az a másik jármű, amellyel az ütközés bekövetkezett
     */
    public void utkozes(Jarmu j2) {
        Skeleton.methodCalled(name + ".utkozik()");
        Skeleton.methodReturned();
    }

    /**
     * Kezeli a jármű megcsúszását jégpáncélos útszakaszon. Ha a csúszás irányában
     * jármű áll, ütközés következik be. Az autóknál és buszoknál ez mozgásképtelenséget
     * vagy útlezárást okozhat.
     */
    public void csuszkal() {
        Skeleton.methodCalled(name + ".csuszkal()");
        boolean utkozesVan = Skeleton.askYesNo("Ütközés van?");
        if (utkozesVan) {
            //utkozes();
        }
        Skeleton.methodReturned();
    }

    /**
     * Megvizsgálja, hogy a jármű elérte-e a célállomást (végállomást). Autók esetén
     * ez azt jelenti, hogy megérkeztek a munkahelyre vagy az otthonra; buszoknál
     * az egyik végállomásra.
     *
     * @return {@code true}, ha a jármű elérte a végállomást; {@code false} egyébként
     */
    public boolean beertAVegallomasba(){
        Skeleton.methodCalled(name + ".beertAVegallomasba()");
        boolean result = Skeleton.askYesNo("Elért az autó a végállomásra?");
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Beállítja a jármű útvonalát.
     *
     * @param u az új {@link Utvonal} objektum
     */
    public void setUtvonal(Utvonal u) { this.utvonal = u; }

    /**
     * Beállítja azt az útszakaszt, amelyen a jármű jelenleg tartózkodik.
     *
     * @param u az aktuális {@link Utszakasz} objektum
     */
    public void setJelenlegiUtszakasz(Utszakasz u) { this.jelenlegiUtszakasz = u; }

    /**
     * Visszaadja a jármű nevét.
     *
     * @return a jármű neve
     */
    public String getName() { return name; }
}
