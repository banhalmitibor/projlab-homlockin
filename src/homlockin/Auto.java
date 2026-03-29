package homlockin;

/**
 * Az {@code Auto} osztály egy járművet modellez, amely egy otthon és egy munkahely
 * között tud haladni a legrövidebb lehetséges módon. Ha minden út a két helyszín
 * között járhatatlan, vagy ha a közlekedés során az út, amin haladna, járhatatlanná
 * válik, az autó elakad. Ha egy szomszédos sáv mégis járhatóvá válik (pl. a hókotró
 * letakarítja), az autó képes sávot váltani. Az {@link Jarmu} absztrakt osztályból
 * származik le.
 */
public class Auto extends Jarmu {

    /** Jelzi, hogy az autó el van-e akadva (pl. magas hó vagy járhatatlan útszakasz miatt). */
    private boolean elakadva;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen autót.
     */
    public Auto() {}

    /**
     * Névvel ellátott autót hoz létre.
     *
     * @param name az autó neve
     */
    public Auto(String name) { this.name = name; }

    /**
     * A következő útszakaszra lépteti az autót az útvonal alapján. Ha a következő
     * útszakasz járhatatlan (pl. magas hó miatt), az autó elakad. Ha a célállomásra
     * ért, eltávolítható az útszakaszról. Az autó áthaladáskor letapossa a havat,
     * ami jégpáncél kialakulásához vezethet.
     */
    @Override
    public void lep() {
        Skeleton.methodCalled(name + ".lep()");
        if (utvonal != null) {
            Utszakasz cel = utvonal.getKivantUtszakasz();
            if (cel != null) {
                Utszakasz kovetkezo = jelenlegiUtszakasz.kovetkezoUtszakasz(cel);
                if (kovetkezo != null) {
                    boolean jarhatoE = kovetkezo.jarhato();
                    if (!jarhatoE) {
                        elakadva = true;
                    }
                    else{
                        this.setJelenlegiUtszakasz(kovetkezo);
                        kovetkezo.stepOn(this);
                        jelenlegiUtszakasz.letapos();
                    }
                }
            }
        } /*else if (jelenlegiUtszakasz != null) {
            boolean jarhatoE = jelenlegiUtszakasz.jarhato();
            if (!jarhatoE) {
                elakadva = true;
            }
        }*/
        
        Skeleton.methodReturned();
    }

    /**
     * Kezeli az autó megcsúszását jégpáncélos útszakaszon. Ha a csúszás irányában
     * egy másik jármű áll, ütközés következik be, és mindkét érintett útszakasz
     * járhatatlanná válik. Ha szabad az útszakasz, az autó oda csúszik.
     */
    @Override
    public void csuszkal() {
        Skeleton.methodCalled(name + ".csuszkal()");
        //boolean utkozesVan = Skeleton.askYesNo("Ütközés van?");
        Utszakasz csuszkalvaKov = jelenlegiUtszakasz.csuszvaKovetkezoUtszakasz();
        Jarmu szomJarmu = csuszkalvaKov.getJarmu();
        if (szomJarmu !=null) {
            szomJarmu.utkozes(this);
            utkozes(szomJarmu);
        }
        else {
            jelenlegiUtszakasz = csuszkalvaKov;

            csuszkalvaKov.setJarmu(this);
            Skeleton.methodCalled(csuszkalvaKov.getName()+".setJarmu()");
            Skeleton.methodReturned();
        }
        Skeleton.methodReturned();
    }

    /**
     * Kezeli az ütközés következményeit. Amikor két autó vagy egy busz és egy autó
     * összeütközik egy csúszós útszakaszon, az adott útszakaszokat, ahol álltak,
     * le kell zárni – járhatatlanná válnak.
     *
     * @param j2 az a másik jármű, amellyel az ütközés bekövetkezett
     */
    @Override
    public void utkozes(Jarmu j2) {
        Skeleton.methodCalled(name + ".utkozik()");
        if (jelenlegiUtszakasz != null) {
            jelenlegiUtszakasz.jarhatatlannaValik();
        }
        Skeleton.methodReturned();
    }

    /**
     * Visszaadja, hogy az autó el van-e akadva. Az autó elakad, ha minden út
     * a két helyszín között járhatatlan, vagy ha a közlekedés során az út,
     * amin haladna, járhatatlanná válik.
     *
     * @return {@code true}, ha az autó el van akadva; {@code false} egyébként
     */
    public boolean getElakadva() {
        Skeleton.methodCalled(name + ".getElakadva()");
        boolean result = Skeleton.askYesNo("El van akadva az autó?");
        Skeleton.methodReturned();
        return result;
    }

    
}
