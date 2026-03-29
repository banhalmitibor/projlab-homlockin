package homlockin;

/**
 * A {@code BuszvezetoJatekos} osztály a buszvezető játékosok tárolására alkalmas.
 * Feladata a buszok irányítása a végállomások között. Felelős a sikeres fordulók
 * megtételéért, amivel pontokat generál. A {@link Jatekos} absztrakt osztályból
 * származik le.
 */
public class BuszvezetoJatekos extends Jatekos {

    /** Az a busz, amelyet ez a játékos vezet. Pontosan egy darab busz tartozik hozzá. */
    private Busz busz;

    /** A játékos által a sikeres buszfordulókért összegyűjtött pontok száma. */
    private int pontszam;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen buszvezető játékost.
     */
    public BuszvezetoJatekos() {}

    /**
     * Névvel ellátott buszvezető játékost hoz létre.
     *
     * @param name a játékos neve
     */
    public BuszvezetoJatekos(String name) { this.name = name; }

    /**
     * Pontot ad a játékosnak, amikor a busz sikeresen eljut a megfelelő végállomásra.
     * Minden sikeres fordulónál eggyel növeli a pontszámot.
     */
    public void pontotKap() {
        Skeleton.methodCalled(name + ".pontotKap()");
        pontszam++;
        Skeleton.methodReturned();
    }

    /**
     * Lehetővé teszi a játékos számára, hogy irányítsa a buszát. Új útvonalat rendel
     * a buszhoz, majd lépteti azt a következő útszakaszra. Ha a busz eléri a
     * végállomást, a játékos pontot kap.
     */
    @Override
    public void iranyit() {
        Skeleton.methodCalled(name + ".iranyit()");
        if (busz != null) {
            Utvonal ut = new Utvonal("utvonal");
            busz.utvonalBeallit(ut);
            busz.lep();
        }
        Skeleton.methodReturned();
    }

    /**
     * Hozzárendeli a buszt a buszvezető játékoshoz.
     *
     * @param b az irányítandó {@link Busz} objektum
     */
    public void addBusz(Busz b) { this.busz = b; }

    /**
     * Visszaadja a játékos által irányított buszt.
     *
     * @return a játékoshoz tartozó {@link Busz} objektum
     */
    public Busz getBusz() { return busz; }
}
