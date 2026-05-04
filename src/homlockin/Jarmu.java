package homlockin;

/**
 * Az összes jármű absztrakt alaposztálya.
 * Tartalmazza a járművek közös tulajdonságait: egyedi azonosító, az aktuális útszakasz amelyen áll,
 * és az útvonal amelyen haladnia kell. Meghatározza a mozgással, ütközéssel és csúszással kapcsolatos
 * absztrakt metódusokat, amelyeket az alosztályoknak kell implementálni.
 */
public abstract class Jarmu {

    /** A jármű egyedi azonosítója. */
    protected String id;

    /** Az az útszakasz, amelyen a jármű éppen áll. */
    protected Utszakasz allRajta;

    /** A jármű tervezett útvonala (útszakaszok sorozata). */
    protected Utvonal utvonala;

    /**
     * Létrehoz egy járművet a megadott azonosítóval és egy üres útvonallal.
     *
     * @param id a jármű egyedi azonosítója
     */
    public Jarmu(String id) {
        this.id = id;
        this.utvonala = new Utvonal();
    }

    /**
     * Visszaadja a jármű egyedi azonosítóját.
     *
     * @return a jármű azonosítója
     */
    public String getId() { return id; }

    /**
     * Visszaadja az útszakaszt, amelyen a jármű éppen áll.
     *
     * @return az aktuális {@link Utszakasz}, vagy {@code null}, ha nincs pályán
     */
    public Utszakasz getAllRajta() { return allRajta; }

    /**
     * Beállítja az útszakaszt, amelyen a jármű áll.
     * Az előző útszakaszról eltávolítja a jármű referenciát, az újra felveszi.
     *
     * @param u az új {@link Utszakasz}, vagy {@code null}, ha el kell távolítani a pályáról
     */
    public void setAllRajta(Utszakasz u) {
        if (this.allRajta != null) {
            this.allRajta.setJarmu(null);
        }
        this.allRajta = u;
        if (this.allRajta != null) {
            this.allRajta.setJarmu(this);
        }
    }

    /**
     * Visszaadja a jármű útvonalát.
     *
     * @return a {@link Utvonal} objektum
     */
    public Utvonal getUtvonala() { return utvonala; }

    /**
     * Beállítja a jármű útvonalát.
     *
     * @param u az új {@link Utvonal}
     */
    public void setUtvonala(Utvonal u) { this.utvonala = u; }

    /**
     * Lépteti az útvonal indexét (megtett lépés jelzése az útvonal felé).
     * Ha az útvonal nem null, meghívja az {@link Utvonal#leptet()} metódust.
     */
    public void leptetUtvonal() {
        if (utvonala != null) {
            utvonala.leptet();
        }
    }

    /**
     * Elvégzi a jármű egy mozgáslépését.
     * Az alosztályok implementálják a típusuktól függő mozgáslogikát.
     */
    public abstract void lep();

    /**
     * Ütközés bekövetkezésekor meghívódó metódus.
     * Az alosztályok implementálják az ütközés típustól függő hatását.
     */
    public abstract void utkozik();

    /**
     * Csúszás bekövetkezésekor meghívódó metódus (jégpáncélon való megcsúszás).
     * Az alosztályok implementálják a csúszás típustól függő hatását.
     */
    public abstract void csuszkal();
}
