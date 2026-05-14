package homlockin;

/**
 * Az autót (személyautót) reprezentáló osztály.
 * Az {@link Jarmu} absztrakt osztályból öröklődik. Az autó képes mozogni, megcsúszni jégen,
 * és ütközhet más járművekkel vagy hóval teli útszakasszal, ami után jáhatatlanná teszi
 * az útszakaszt, és az elakadások számát növeli a városban.
 */
public class Auto extends Jarmu {

    /** Jelzi, hogy az autó ütközött-e már (elakadt-e). */
    private boolean utkozott;

    /**
     * Létrehoz egy autót a megadott azonosítóval.
     * Alapállapotban az autó nem ütközött.
     *
     * @param id az autó egyedi azonosítója
     */
    public Auto(String id) {
        super(id);
        this.utkozott = false;
    }

    /**
     * Elvégzi az autó mozgáslépését.
     * Ha az autó már ütközött, nem lép. Ha az aktuális útszakaszon 4 vagy több egység hó van,
     * az autó megakad. Egyébként a következő útszakaszra próbál lépni az útvonal alapján.
     * Ha a következő szakasz foglalt vagy havas, az autó vár. Lépés után ellenőrzi,
     * hogy jégpáncél van-e az új szakaszon (ha igen, csúszik), majd hogy célba ért-e.
     */
    @Override
    public void lep() {
        if (utkozott) return;
        if (allRajta != null && allRajta.getHo().getMennyiseg() >= 4) {
            return; // Stuck
        }

        Utszakasz kov = utvonala.getKivantUtszakasz();
        kov = allRajta.kovetkezoUtszakasz(kov);
        if (kov == null) {
            checkCelbaEres();
            return;
        }

        if (kov.getJarmu() != null || kov.getHo().getMennyiseg() >= 4) {
            return; // Wait or Stop Before
        }

        Utszakasz regi = allRajta;
        if (regi != null) {
            regi.setJarmu(null);
        }
        allRajta = kov;
        allRajta.setJarmu(this);
        leptetUtvonal();

        allRajta.letapos();

        if (allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        }
        
        checkCelbaEres();
    }

    /**
     * Ellenőrzi, hogy az autó elérte-e az útvonal végét.
     * Ha igen, eltávolítja az autót az útszakaszról (az autó eltűnik a pályáról).
     */
    private void checkCelbaEres() {
        if (allRajta != null && utvonala.isVege()) {
            allRajta.setJarmu(null);
            allRajta = null;
        }
    }

    /**
     * Az autó csúszik jégen: a következő útszakaszra csúszik az útvonal figyelembe vétele nélkül.
     * Ha a célszakasz foglalt vagy havas, ütközés következik be.
     * Ha az autó és az ott lévő jármű is ütközik, mindkettő jelzése megtörténik.
     */
    @Override
    public void csuszkal() {
        //Utvonal u = getUtvonala();
        Utszakasz slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        /*if(slipTo == null){
            slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        }*/
        
        if (slipTo != null) {
            if (slipTo.getJarmu() != null || slipTo.getHo().getMennyiseg() >= 4) {
                this.utkozik();
                if (slipTo.getJarmu() != null) {
                    slipTo.getJarmu().utkozik();
                }
            } else {
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                // DO NOT leptetUtvonal here!
                if (allRajta != null) {
                    allRajta.letapos();
                }
            }
        }
    }

    /**
     * Az autó ütközésekor: az autó elakad, a város elakadásszámlálója nő,
     * és az aktuális útszakasz járhatatlanná válik.
     * Csak egyszer számít be az ütközés.
     */
    @Override
    public void utkozik() {
        if (!utkozott) {
            this.utkozott = true;
            Main.varos.incrementElakadas();
            if (this.allRajta != null) {
                this.allRajta.jarhatatlannaValik();
            }
        }
    }

    /**
     * Visszaadja, hogy az autó ütközött-e már (elakadt-e).
     *
     * @return {@code true}, ha az autó ütközött; {@code false} egyébként
     */
    public boolean isUtkozott() { return utkozott; }
}
