package homlockin;

/**
 * A buszt reprezentáló osztály.
 * A {@link Jarmu} absztrakt osztályból öröklődik. A buszt egy {@link BuszvezetoJatekos} vezeti,
 * és meghatározott útvonalon közlekedik. Ütközés esetén a busz 3 körre kiesik a forgalomból,
 * majd automatikusan újra mozgóképes lesz. A busz csúszhat jégen, de nem válik végleg elakadttá.
 */
public class Busz extends Jarmu {

    /** Hány kör van még hátra, mielőtt az elakadt busz újra mozog (ütközés után). */
    private int elakadasVisszaszamlalo;

    /** A buszt vezető {@link BuszvezetoJatekos}. */
    private BuszvezetoJatekos vezeti;

    /**
     * Létrehoz egy buszt a megadott azonosítóval és buszvezetővel.
     *
     * @param id    a busz egyedi azonosítója
     * @param vezeti a buszvezetőjátékos, aki a buszt irányítja
     */
    public Busz(String id, BuszvezetoJatekos vezeti) {
        super(id);
        this.vezeti = vezeti;
        this.elakadasVisszaszamlalo = 0;
    }

    /**
     * Elvégzi a busz mozgáslépését.
     * Ha az elakadás-visszaszámláló nagyobb nullánál, csökkenti azt és nem lép.
     * Egyébként a következő útszakaszra lép, ha az járható. Lépés után ellenőrzi a végállomásokat
     * (pont a buszvezető játékosnak), valamint jégpáncélt (csúszás).
     */
    @Override
    public void lep() {
        if (elakadasVisszaszamlalo > 0) {
            elakadasVisszaszamlalo--;
            return;
        }

        Utszakasz kov = utvonala.getKivantUtszakasz();
        kov = allRajta.kovetkezoUtszakasz(kov);
        if (kov == null) {
            return; 
        }

        if (!kov.jarhato()) {
            System.out.println("Nem jarhato");
            return; 
        }

        Utszakasz regi = allRajta;
        if (regi != null) {
            regi.setJarmu(null);
            regi.letapos();
        }
        allRajta = kov;
        allRajta.setJarmu(this);
        
        leptetUtvonal();
        
        if (vezeti != null && (allRajta == vezeti.getVegallomas1() || allRajta == vezeti.getVegallomas2())) {
            vezeti.pontotKap();
        }

        if (allRajta != null && allRajta.getJeg() != null && allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        }
    }

    /**
     * Ütközés hatása a buszra: az elakadás-visszaszámláló 3-ra állítódik,
     * azaz a busz 3 kört kihagy, majd újra mozgóképes lesz.
     * A busz nem válik végleg járhatatlanná, és az útszakasz sem válik jáhatatlanná.
     */
    @Override
    public void utkozik() {
        // "olyan állapotba kerül, hogy a busz 3 körből kimarad és újra mozgóképes lesz"
        this.elakadasVisszaszamlalo = 3;
    }

    /**
     * A busz csúszik jégen: az aktuális útszakasz első következőjére csúszik.
     * Ha a célszakasz nem járható, ütközés következik be (és az esetleg ott lévő jármű is ütközik).
     * Ha szabadon csúszhat, a busz áthelyeződik és az útvonal is léptetődik.
     */
    @Override
    public void csuszkal() {
        //Utvonal u = getUtvonala();
        Utszakasz slipTo = allRajta.csuszvaKovetkezoUtszakasz(); //All rajta hopefully nem null
        /*if(slipTo == null){
            slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        }*/
        
        
        if (slipTo != null) {
            if (!slipTo.jarhato()) {
                this.utkozik();
                if (slipTo.getJarmu() != null) {
                    slipTo.getJarmu().utkozik();
                }
            } else {
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                    regi.letapos();
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                leptetUtvonal();
            }
        }
    }
}
