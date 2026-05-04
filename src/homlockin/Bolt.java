package homlockin;

/**
 * A játékban szereplő boltot reprezentáló osztály.
 * A bolt lehetővé teszi a {@link TakaritoJatekos} számára különböző eszközök és anyagok vásárlását:
 * hókotró vásárlása, só, bio-kerozin, zúzalék feltöltése, valamint hókotrófej csere.
 * Minden vásárlás pénzbe kerül, amit a játékos egyenlegéből von le.
 */
public class Bolt {

    /** A boltban jelenleg vásárló takarítójátékos. */
    private TakaritoJatekos vasarol;

    /**
     * Létrehoz egy üres boltot vásárló beállítása nélkül.
     */
    public Bolt() {}

    /**
     * Létrehoz egy boltot a megadott vásárló takarítójátékossal.
     *
     * @param vasarol a boltban vásárló {@link TakaritoJatekos}
     */
    public Bolt(TakaritoJatekos vasarol) {
        this.vasarol = vasarol;
    }

    /**
     * Beállítja, hogy melyik takarítójátékos vásárol a boltban.
     *
     * @param vasarol a vásárló {@link TakaritoJatekos}
     */
    public void setVasarol(TakaritoJatekos vasarol) {
        this.vasarol = vasarol;
    }

    /**
     * Hókotró vásárlása a megadott takarítójátékos számára.
     * A vásárlás 100 pénzegységbe kerül. Ha a játékosnak van elegendő pénze,
     * létrehoz egy új hókotró objektumot, hozzárendeli a játékoshoz,
     * és a megadott útszakaszra helyezi.
     *
     * @param id     az új hókotró azonosítója
     * @param jatekos a vásárló {@link TakaritoJatekos}
     * @param kezdo  a kezdő útszakasz, ahol a hókotró elindul
     * @return az újonnan létrehozott {@link Hokotro}, vagy {@code null}, ha nincs elég pénz
     */
    public Hokotro hokotrotVasarol(String id, TakaritoJatekos jatekos, Utszakasz kezdo) {
        if (jatekos.getPenz() >= 100) {
            jatekos.penztLevon(100);
            Hokotro hk = new Hokotro(id, jatekos);
            hk.setAllRajta(kezdo);
            jatekos.hokotroHozzaadas(hk);
            return hk;
        }
        return null;
    }

    /**
     * Só vásárlása az aktuális vásárló nevében a megadott hókotró számára.
     * A vásárlás 10 pénzegységbe kerül. Sikeres vásárlás esetén a hókotró sótartálya feltöltődik.
     *
     * @param hk a feltöltendő {@link Hokotro}
     */
    public void sotVasarol(Hokotro hk) {
        if (vasarol != null && vasarol.getPenz() >= 10) {
            vasarol.penztLevon(10);
            hk.soFeltoltes();
        }
    }

    /**
     * Bio-kerozin vásárlása az aktuális vásárló nevében a megadott hókotró számára.
     * A vásárlás 10 pénzegységbe kerül. Sikeres vásárlás esetén a hókotró kerozin-tartálya feltöltődik.
     *
     * @param hk a feltöltendő {@link Hokotro}
     */
    public void biokerozinVasarol(Hokotro hk) {
        if (vasarol != null && vasarol.getPenz() >= 10) {
            vasarol.penztLevon(10);
            hk.biokerozinFeltoltes();
        }
    }

    /**
     * Zúzalék vásárlása az aktuális vásárló nevében a megadott hókotró számára.
     * A vásárlás 10 pénzegységbe kerül. Sikeres vásárlás esetén a hókotró zúzaléktartálya feltöltődik.
     *
     * @param hk a feltöltendő {@link Hokotro}
     */
    public void zuzalekotVasarol(Hokotro hk) {
        if (vasarol != null && vasarol.getPenz() >= 10) {
            vasarol.penztLevon(10);
            hk.zuzalekFeltoltes();
        }
    }

    /**
     * Hókotrófej vásárlása és cseréje az aktuális vásárló nevében a megadott hókotró számára.
     * A vásárlás 50 pénzegységbe kerül. Sikeres vásárlás esetén a hókotró aktív feje lecserélődik.
     *
     * @param hk       az érintett {@link Hokotro}
     * @param fejTipus az új {@link HokotroFej} példány, amelyre cserélni kell
     */
    public void hokotroFejetVasarol(Hokotro hk, HokotroFej fejTipus) {
        if (vasarol != null && vasarol.getPenz() >= 50) {
            vasarol.penztLevon(50);
            hk.fejetCserel(fejTipus);
        }
    }
}
