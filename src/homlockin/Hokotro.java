package homlockin;

import java.util.List;

/**
 * A {@code Hokotro} osztály a takarító játékosok által irányított járművet modellez.
 * Felelőssége az útszakaszok megtisztítása a hótól és jégtől. A sikeresen
 * megtisztított útszakaszokért pénzt kap a takarító játékos. Számon tartja a rá
 * felszerelt hókotrófej típusát (söprőfej, hányófej, jégtörőfej, sószórófej,
 * sárkányfej), valamint a só és biokerozin készletét. Az {@link Jarmu} absztrakt
 * osztályból származik le.
 */
public class Hokotro extends Jarmu {

    /** Az a hókotrófej, amellyel a hókotró jelenleg takarít. */
    private HokotroFej fej;

    /** Az összes lehetséges hókotrófej, amelyeket a hókotróra lehet felszerelni. */
    private List<HokotroFej> fejek;

    /** A hókotróban tárolt só mennyisége. A sószórófej ezt használja takarításhoz. */
    private int soMennyiseg;

    /**
     * A hókotróban tárolt biokerozin mennyisége. A sárkányfej ezt használja
     * a hó és jégpáncél olvasztásához.
     */
    private int bioKerozinMennyiseg;

    /** Az a takarító játékos, aki ezt a hókotró járművet vezeti. */
    private TakaritoJatekos vezeto;

    /**
     * Jelzi, hogy a hókotró félre van-e állva (pl. kifogyott a nyersanyagból).
     * Félreállás esetén a hókotró nem tud takarítani.
     */
    private boolean felreallva;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen hókotró járművet.
     */
    public Hokotro() {}

    /**
     * Névvel ellátott hókotró járművet hoz létre.
     *
     * @param name a hókotró neve
     */
    public Hokotro(String name) { this.name = name; }

    /**
     * A következő útszakaszra lépteti a hókotró járművet, és ha van fej felszerelve,
     * elvégzi a takarítást az aktuális útszakaszon. A sikeresen letakarított
     * útszakaszért pénzt fizet a vezető takarító játékosnak.
     */
    @Override
    public void lep() {
        Skeleton.methodCalled(name + ".lep()");
        if (fej != null && jelenlegiUtszakasz != null) {
            fej.munkatVegez(jelenlegiUtszakasz);
            vezeto.penztKap(10);
        } 
        Skeleton.methodReturned();
    }

    /**
     * Az aktuális útszakasz takarítását végzi el. Ha van fej felszerelve,
     * a fej elvégzi a takarítást, és a vezető takarító játékos pénzt kap
     * a sikeresen megtisztított útszakaszért.
     */
    public void takarit() {
        Skeleton.methodCalled(name + ".takarit()");
        if (fej != null && jelenlegiUtszakasz != null) {
            fej.munkatVegez(jelenlegiUtszakasz);
        }
        if (vezeto != null) {
            vezeto.penztKap(1);
        }
        Skeleton.methodReturned();
    }

    /**
     * Felcseréli a hókotró fejét egy új hókotrófejre. Az új fej típusa meghatározza,
     * hogy milyen takarítást végez a hókotró a következő lépéstől.
     *
     * @param ujFej az új {@link HokotroFej}, amelyet a hókotróra szerelnek
     */
    public void fejetCserel(HokotroFej ujFej) {
        Skeleton.methodCalled(name + ".fejetCserel(" + (ujFej != null ? ujFej.getName() : "null") + ")");
        this.fej = ujFej;
        Skeleton.methodReturned();
    }

    /**
     * A hókotró félreállását kezeli. Ha a hókotró kifogy a szükséges nyersanyagból
     * (só vagy biokerozin), félre kell állnia, hogy ne akadályozza a többi járművet.
     */
    public void felreall() {
        Skeleton.methodCalled(name + ".felreall()");
        this.felreallva = true;
        Skeleton.methodReturned();
    }

    /**
     * Kezeli a sófogyasztást takarításkor. Megvizsgálja, hogy a hókotróban van-e
     * elegendő só a kért mennyiségű takarításhoz.
     *
     * @param mennyiseg a szükséges só mennyisége
     * @return {@code true}, ha van elegendő só; {@code false}, ha a készlet kifogyott
     */
    public boolean soFogyasztas(int mennyiseg) {
        Skeleton.methodCalled(name + ".soFogyasztas(" + mennyiseg + ")");
        boolean result = Skeleton.askYesNo("Van elég só?");
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Feltölti a hókotró sókészletét. A takarító játékos pénzéből levon a bolt
     * a megfelelő árat, és a hókotró sómennyisége feltöltődik.
     */
    public void soFeltoltes() {
        Skeleton.methodCalled(name + ".soFeltoltes()");
        Skeleton.methodReturned();
    }

    /**
     * Kezeli a biokerozin fogyasztást. Megvizsgálja, hogy a hókotróban van-e
     * elegendő biokerozin a kért mennyiségű takarításhoz (sárkányfej számára).
     *
     * @param mennyiseg a szükséges biokerozin mennyisége
     * @return {@code true}, ha van elegendő biokerozin; {@code false}, ha a készlet kifogyott
     */
    public boolean biokerozinFogyasztas(int mennyiseg) {
        Skeleton.methodCalled(name + ".biokerozinFogyasztas(" + mennyiseg + ")");
        boolean result = Skeleton.askYesNo("Van elég biokerozin?");
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Feltölti a hókotró biokerozin készletét. A takarító játékos pénzéből levon
     * a bolt a megfelelő árat, és a hókotró biokerozin mennyisége feltöltődik.
     */
    public void biokerozinFeltoltes() {
        Skeleton.methodCalled(name + ".biokerozinFeltoltes()");
        Skeleton.methodReturned();
    }

    /**
     * Beállítja a hókotró útvonalát. Az útvonal meghatározza, hogy a hókotró
     * melyik útszakaszokon haladjon a takarítás során.
     *
     * @param u az új {@link Utvonal} objektum, amelyet a hókotróhoz rendelünk
     */
    public void utvonalBeallit(Utvonal u) {
        Skeleton.methodCalled(name + ".utvonalBeallit(" + (u != null ? u.getName() : "null") + ")");
        this.utvonal = u;
        Skeleton.methodReturned();
    }

    /**
     * Beállítja a hókotróra felszerelt hókotrófej típusát.
     *
     * @param f az új {@link HokotroFej} objektum
     */
    public void setFej(HokotroFej f) { this.fej = f; }

    /**
     * Beállítja a hókotró vezető takarító játékosát.
     *
     * @param tj az a {@link TakaritoJatekos}, aki a hókotrot vezeti
     */
    public void setVezeto(TakaritoJatekos tj) { this.vezeto = tj; }

    /**
     * Beállítja a hókotró félreállva állapotát.
     *
     * @param f {@code true}, ha a hókotró félre van állva; {@code false} egyébként
     */
    public void setFelreallva(boolean f) { this.felreallva = f; }
}
