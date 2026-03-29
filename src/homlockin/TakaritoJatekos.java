package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@code TakaritoJatekos} osztály a hókotrókat vezető és üzemeltető játékosokat
 * modellezi. Feladata a hókotrók mozgatása és a kotrófejek menedzselése. Felelős az
 * úthálózat tisztán tartásáért és a stratégiai vásárlásokért (új segédeszközök,
 * üzemanyag). A takarításból szerzett pénzéből tud vásárolni a boltban. A
 * {@link Jatekos} absztrakt osztályból származik le.
 */
public class TakaritoJatekos extends Jatekos {

    /** Az irányított hókotrók listája. A takarító játékos több hókotrot is irányíthat. */
    private List<Hokotro> hokotrok = new ArrayList<>();

    /** Az a bolt, ahol a takarító játékos vásárolhat hókotrókat és segédeszközöket. */
    private Bolt bolt;

    /**
     * A takarító játékos által az utak takarításából összegyűjtött pénz. Ezzel képes
     * hókotrókat és segédeszközöket (só, biokerozin, hókotrófejek) venni a boltban.
     */
    private int penz = 1000;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen takarító játékost.
     */
    public TakaritoJatekos() {}

    /**
     * Névvel ellátott takarító játékost hoz létre.
     *
     * @param name a takarító játékos neve
     */
    public TakaritoJatekos(String name) { this.name = name; }

    /**
     * A játékos pénzt kap egy sikeresen letakarított útszakaszért. A megadott
     * összeggel növeli a játékos pénzegyenlegét.
     *
     * @param osszeg a kapott pénzösszeg
     */
    public void penztKap(int osszeg) {
        Skeleton.methodCalled(name + ".penztKap(" + osszeg + ")");
        penz += osszeg;
        Skeleton.methodReturned();
    }

    /**
     * A boltból való vásárlásokat végzi el. Ha a játékos rendelkezik hókotróval és
     * a bolthoz is hozzáfér, sót vásárol; ha nincs hókotró, akkor újat vásárol.
     * A vásárlás csak akkor megy végbe, ha elegendő pénz áll rendelkezésre.
     */
    public void vasarol() {
        Skeleton.methodCalled(name + ".vasarol()");
        if (bolt != null && !hokotrok.isEmpty()) {
            bolt.sotVasarol(this, hokotrok.get(0));
        } else if (bolt != null) {
            bolt.hokotrotVasarol(this);
        }
        Skeleton.methodReturned();
    }

    /**
     * Visszaadja a takarító játékos aktuális pénzegyenlegét. A bolt ellenőrzi ezt
     * a vásárlások előtt, hogy elegendő pénz áll-e rendelkezésre.
     *
     * @return a játékos pénzegyenlege
     */
    public int getPenz() {
        Skeleton.methodCalled(name + ".getPenz()");
        Skeleton.methodReturned();
        return penz;
    }

    /**
     * Levonja a megadott összeget a takarító játékos pénzéből. Vásárláskor
     * hívódik meg a bolt által.
     *
     * @param ar a levonandó pénzösszeg
     */
    public void penztLevon(int ar) {
        Skeleton.methodCalled(name + ".penztLevon(" + ar + ")");
        penz -= ar;
        Skeleton.methodReturned();
    }

    /**
     * Lehetővé teszi a játékos számára, hogy irányítsa a hókotróit. A takarító
     * játékos ezzel a metódussal mozgatja és üzemelteti a hókotró járműveket.
     */
    @Override
    public void iranyit() {
        Skeleton.methodCalled(name + ".iranyit()");
        Skeleton.methodReturned();
    }

    /**
     * Hozzáadja az új hókotró járművet a takarító játékos hókotróit tároló listájához.
     * Vásárláskor hívódik meg, amikor a játékos új hókotrot vesz a boltban.
     *
     * @param hokotro az újonnan vásárolt {@link Hokotro} jármű
     */
    public void hokotroHozzaadas(Hokotro hokotro) {
        Skeleton.methodCalled(name + ".hokotroHozzaadas(" + hokotro.getName() + ")");
        hokotrok.add(hokotro);
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt a boltot, ahol a takarító játékos vásárolhat.
     *
     * @param b a {@link Bolt} objektum, amelyhez a játékos hozzáfér
     */
    public void setBolt(Bolt b) { this.bolt = b; }

    /**
     * Visszaadja a takarító játékos összes hókotróját.
     *
     * @return a hókotrók listája
     */
    public List<Hokotro> getHokotrok() { return hokotrok; }

    /**
     * Visszaadja a játékos pénzegyenlegét közvetlenül (Skeleton hívás nélkül).
     *
     * @return a játékos aktuális pénzegyenlege
     */
    public int getPenzErtek() { return penz; }
}
