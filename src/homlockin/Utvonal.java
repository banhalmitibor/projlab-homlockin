package homlockin;

import java.util.List;

/**
 * Az {@code Utvonal} osztály kezeli az egyes járművek haladásának útvonalát.
 * Eltárolja, hogy hova megy a jármű (célállomás), és ennek megfelelően meghatározza
 * a haladási útvonalat. A jármű le tudja kérdezni tőle, hogy melyik útszakaszon
 * folytassa az útját a célállomás felé. Segít eldönteni, hogy az adott jármű merre
 * haladjon tovább a kereszteződésekben.
 */
public class Utvonal {

    /** Az útvonal neve azonosítási célokra. */
    private String name;

    /** Az útszakaszok listája, amelyeken a jármű halad a célállomás felé. */
    private List<Utszakasz> vonal;

    /** Az a célállomás, ahova a jármű el kíván jutni. */
    private Utszakasz cel;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen útvonal objektumot.
     */
    public Utvonal() {}

    /**
     * Névvel ellátott útvonal objektumot hoz létre.
     *
     * @param name az útvonal neve
     */
    public Utvonal(String name) { this.name = name; }

    /**
     * Visszaadja a következő útszakaszt a célállomás felé. A jármű ezt hívja meg,
     * hogy megtudja, melyik útszakaszra lépjen következőnek a célállomás irányába.
     *
     * @return a következő {@link Utszakasz} a célállomás felé, vagy {@code null},
     *         ha nincs meghatározott célállomás
     */
    public Utszakasz getKivantUtszakasz() {
        Skeleton.methodCalled(name + ".getKivantUtszakasz()");
        Skeleton.methodReturned();
        return cel;
    }

    /**
     * Beállítja az útvonal célállomását.
     *
     * @param u a célállomásként beállítandó {@link Utszakasz} objektum
     */
    public void setCel(Utszakasz u) { this.cel = u; }

    /**
     * Visszaadja az útvonal célállomását.
     *
     * @return a célállomás {@link Utszakasz} objektuma
     */
    public Utszakasz getCel() { return cel; }

    /**
     * Visszaadja az útvonal nevét.
     *
     * @return az útvonal neve
     */
    public String getName() { return name; }
}
