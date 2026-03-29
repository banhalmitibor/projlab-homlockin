package homlockin;

/**
 * A {@code Bolt} osztály felelős az adott vásárlások lebonyolításáért. A takarító
 * játékosok a takarításból szerzett pénzükből itt tudnak vásárolni hókotrókat,
 * hókotrófejeket, sót és biokerozint. A bolt ellenőrzi, hogy a játékosnak
 * elegendő pénze van-e a kívánt vásárláshoz.
 */
public class Bolt {

    /** A bolt neve azonosítási célokra. */
    private String name;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen boltot.
     */
    public Bolt() {}

    /**
     * Névvel ellátott boltot hoz létre.
     *
     * @param name a bolt neve
     */
    public Bolt(String name) { this.name = name; }

    /**
     * Visszaadja a bolt nevét.
     *
     * @return a bolt neve
     */
    public String getName() { return name; }

    /**
     * Hókotró vásárlást lebonyolító metódus. Ellenőrzi, hogy a takarító játékosnak
     * van-e elegendő pénze egy új hókotró vásárlásához. Ha igen, létrehoz egy új
     * {@link Hokotro} objektumot, hozzáadja a játékos hókotróihoz, és levonja az
     * árat a játékos pénzéből.
     *
     * @param jatekos az a {@link TakaritoJatekos}, aki a hókotrot vásárolja
     */
    public void hokotrotVasarol(TakaritoJatekos jatekos) {
        Skeleton.methodCalled(name + ".hokotrotVasarol(" + jatekos.getName() + ")");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz hókotróra?");
        if (elegPenz) {
            Skeleton.methodCalled("new Hokotro()");
            Hokotro ujHk = new Hokotro("ujHk");
            Skeleton.methodReturned();
            jatekos.hokotroHozzaadas(ujHk);
            jatekos.penztLevon(500);
        }
        Skeleton.methodReturned();
    }

    /**
     * Só vásárlást lebonyolító metódus. Ellenőrzi, hogy a takarító játékosnak van-e
     * elegendő pénze só vásárlásához. Ha igen, levonja az árat a játékos pénzéből
     * és feltölti az adott hókotró sókészletét.
     *
     * @param jatekos az a {@link TakaritoJatekos}, aki a sót vásárolja
     * @param hokotro az a {@link Hokotro}, amelynek a sókészletét feltöltik
     */
    public void sotVasarol(TakaritoJatekos jatekos, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".sotVasarol(" + jatekos.getName() + ", " + hokotro.getName() + ")");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz sóra?");
        if (elegPenz) {
            jatekos.penztLevon(100);
            hokotro.soFeltoltes();
        }
        Skeleton.methodReturned();
    }

    /**
     * Biokerozin vásárlást lebonyolító metódus. Ellenőrzi, hogy a takarító játékosnak
     * van-e elegendő pénze biokerozin vásárlásához. Ha igen, levonja az árat a
     * játékos pénzéből és feltölti az adott hókotró biokerozin készletét. A biokerozint
     * a sárkányfej használja a hó és jégpáncél olvasztásához.
     *
     * @param jatekos az a {@link TakaritoJatekos}, aki a biokerozint vásárolja
     * @param hokotro az a {@link Hokotro}, amelynek a biokerozin készletét feltöltik
     */
    public void biokerozintVasarol(TakaritoJatekos jatekos, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".biokerozintVasarol(" + jatekos.getName() + ", " + hokotro.getName() + ")");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz biokerozinra?");
        if (elegPenz) {
            jatekos.penztLevon(200);
            hokotro.biokerozinFeltoltes();
        }
        Skeleton.methodReturned();
    }

    /**
     * Hókotrófej vásárlást lebonyolító metódus. Ellenőrzi, hogy a takarító játékosnak
     * van-e elegendő pénze az adott típusú hókotrófej vásárlásához. A lehetséges
     * fejtípusok: söprőfej, hányófej, jégtörőfej, sószórófej, sárkányfej.
     * Ha elegendő pénz áll rendelkezésre, létrehoz egy megfelelő {@link HokotroFej}
     * objektumot és levonja az árat a játékos pénzéből.
     *
     * @param jatekos  az a {@link TakaritoJatekos}, aki a hókotrófejt vásárolja
     * @param hokotro  az a {@link Hokotro}, amelyre a fejet szerelik
     * @param fejTipus a vásárolni kívánt hókotrófej típusának neve (pl. "Soprofej",
     *                 "Hanyofej", "Jegtorofej", "Sarkanyfej", "Soszoro")
     */
    public void hokotroFejetVasarol(TakaritoJatekos jatekos, Hokotro hokotro, String fejTipus) {
        Skeleton.methodCalled(name + ".hokotroFejetVasarol(" + jatekos.getName() + ", " + hokotro.getName() + ", \"" + fejTipus + "\")");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz hókotrófejre?");
        if (elegPenz) {
            String className;
            HokotroFej ujFej;
            switch (fejTipus) {
                case "Soszoro": className = "Soszorofej"; ujFej = new Soszorofej("ujFej"); break;
                case "Hanyofej": className = "Hanyofej"; ujFej = new Hanyofej("ujFej"); break;
                case "Jegtorofej": className = "Jegtorofej"; ujFej = new Jegtorofej("ujFej"); break;
                case "Sarkanyfej": className = "Sarkanyfej"; ujFej = new Sarkanyfej("ujFej"); break;
                default: className = "Soprofej"; ujFej = new Soprofej("ujFej"); break;
            }
            Skeleton.methodCalled("new " + className + "()");
            Skeleton.methodReturned();
            jatekos.penztLevon(300);
        }
        Skeleton.methodReturned();
    }
}
