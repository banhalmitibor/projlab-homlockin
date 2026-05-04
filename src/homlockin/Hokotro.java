package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * A hókotró járművet reprezentáló osztály.
 * A {@link Jarmu} absztrakt osztályból öröklődik. A hókotró egy {@link TakaritoJatekos} által vezérelt
 * különleges jármű, amely különböző típusú fejekkel takaríthat (hó söprése, jégtörés, sószórás stb.).
 * A hókotrónak van só-, bio-kerozin- és zúzalékkészlete, amelyek felhasználhatók az egyes fejtípusokhoz.
 * Alapból egy {@link Soprofej} típusú fejjel rendelkezik. Ütközés esetén a hókotrónak nem esik baja.
 */
public class Hokotro extends Jarmu {

    /** A hókotró összes, eddig megvásárolt/felszerelt fejének listája. */
    private List<HokotroFej> fejei;

    /** Az aktuálisan felrakott (aktív) hókotrófej. */
    private HokotroFej felrakottFeje;

    /** A hókotró tulajdonos takarítójátékosa, aki vezeti. */
    private TakaritoJatekos vezeti;

    /** A hókotró sókészletének aktuális mennyisége. */
    private int soMennyiseg;

    /** A hókotró bio-kerozinkészletének aktuális mennyisége. */
    private int bioKerozinmennyiseg;

    /** A hókotró zúzalékkészletének aktuális mennyisége. */
    private int zuzalekMennyiseg;

    /**
     * Létrehoz egy hókotró járművet a megadott azonosítóval és vezető játékossal.
     * Alapértelmezés szerint a hókotró egy {@link Soprofej} típusú fejjel van felszerelve,
     * és minden anyagkészlete (só, kerozin, zúzalék) nulla.
     *
     * @param id     a hókotró egyedi azonosítója
     * @param vezeti a takarítójátékos, aki a hókotrot vezeti
     */
    public Hokotro(String id, TakaritoJatekos vezeti) {
        super(id);
        this.vezeti = vezeti;
        this.fejei = new ArrayList<>();
        this.soMennyiseg = 0;
        this.bioKerozinmennyiseg = 0;
        this.zuzalekMennyiseg = 0;
        
        // By default it comes with a "sopro" fej according to requirements.
        HokotroFej alapFej = new Soprofej();
        alapFej.setHokotro(this);
        this.fejei.add(alapFej);
        this.felrakottFeje = alapFej;
    }

    /**
     * Lecseréli az aktív hókotrófejre a megadottat.
     * Ha a fej már a hókotrón van (korábbi vásárlás), egyszerűen aktiválja.
     * Ha új fej, hozzáadja a fejek listájához, beállítja a gazda hókotrot, majd aktiválja.
     *
     * @param ujFej az új aktív {@link HokotroFej}
     */
    public void fejetCserel(HokotroFej ujFej) {
        if (fejei.contains(ujFej)) {
            this.felrakottFeje = ujFej;
        } else {
            fejei.add(ujFej);
            ujFej.setHokotro(this);
            this.felrakottFeje = ujFej;
        }
    }

    /**
     * Közvetlenül beállítja az aktív hókotrófejat (listába való felvétel nélkül).
     *
     * @param fej az aktiválandó {@link HokotroFej}
     */
    public void setFelrakottFeje(HokotroFej fej) {
        this.felrakottFeje = fej;
    }

    /**
     * Visszaadja az aktuálisan felrakott hókotrófejat.
     *
     * @return az aktív {@link HokotroFej}
     */
    public HokotroFej getFelrakottFeje() { return felrakottFeje; }

    /**
     * Elvégzi a hókotró mozgáslépését.
     * A következő útszakaszra lép az útvonal alapján, ha az szabad. Lépés után takarítást végez.
     * Ha a következő szakasz foglalt, a hókotró nem lép.
     */
    @Override
    public void lep() {
        Utszakasz kov = utvonala.getKivantUtszakasz();
        kov = allRajta.kovetkezoUtszakasz(kov);
        if (kov == null) {
            return;
        }

        if (kov.getJarmu() != null) {
            return; 
        }

        Utszakasz regi = allRajta;
        if (regi != null) {
            regi.setJarmu(null);
        }
        
        allRajta = kov;
        allRajta.setJarmu(this);
        leptetUtvonal();
        
        /*if (allRajta != null && allRajta.getJeg() != null && allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        } else {*/
            takarit();
        //}
    }

    /**
     * A hókotró takarítást végez az aktuális útszakaszon az aktív fejjel.
     * Ha volt csapadék az útszakaszon, a vezető játékos 5 pénzegységet kap.
     */
    public void takarit() {
        if (felrakottFeje != null && allRajta != null) {
            boolean voltCsapadek = (allRajta.getHo() != null && allRajta.getHo().getMennyiseg() > 0)
                    || (allRajta.getJeg() != null && allRajta.getJeg().getMennyiseg() > 0)
                    || (allRajta.getZuzalek() != null && allRajta.getZuzalek().vanZuzalek());
            felrakottFeje.munkatVegez(allRajta);
            if (vezeti != null && voltCsapadek) {
                vezeti.penztKap(5); // Pont/Pénz a takarításért
            }
        }
    }

    /**
     * A hókotró csúszik jégen – jelenleg inaktív (kikommentezett logika).
     * A hókotrónak nincs valódi csúszás-hatása a jelenlegi implementációban.
     */
    @Override
    public void csuszkal() {
        /*Utszakasz slipTo = utvonala.getKivantUtszakasz();
        if (slipTo == null && allRajta != null) {
            slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        }
        
        if (slipTo != null) {
            if (slipTo.getJarmu() != null) {
                this.utkozik();
                slipTo.getJarmu().utkozik();
            } else {
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                leptetUtvonal();
                takarit();
            }
        }*/
    }

    /**
     * Ütközés hatása a hókotróra: a hókotrónak nem esik baja, gondtalanul folytatja útját.
     */
    @Override
    public void utkozik() {
        // "Hókotró ütközése: A hókotrónak nem esik baja, gondtalanul folytatja útját" - Vince
    }

    /** Feltölti a só-tartályt 30 egységre. */
    public void soFeltoltes() { this.soMennyiseg = 30; }

    /**
     * Felhasznál megadott mennyiségű sót, ha van elegendő.
     *
     * @param m a felhasználandó só mennyisége
     * @return {@code true}, ha sikeres volt a fogyasztás; {@code false}, ha nincs elég só
     */
    public boolean soFogyasztas(int m) {
        if (this.soMennyiseg >= m) {
            this.soMennyiseg -= m;
            return true;
        }
        return false;
    }

    /** Feltölti a bio-kerozin tartályt 30 egységre. */
    public void biokerozinFeltoltes() { this.bioKerozinmennyiseg = 30; }

    /**
     * Felhasznál megadott mennyiségű bio-kerozint, ha van elegendő.
     *
     * @param m a felhasználandó bio-kerozin mennyisége
     * @return {@code true}, ha sikeres volt a fogyasztás; {@code false}, ha nincs elég kerozin
     */
    public boolean biokerozinFogyasztas(int m) {
        if (this.bioKerozinmennyiseg >= m) {
            this.bioKerozinmennyiseg -= m;
            return true;
        }
        return false;
    }

    /** Feltölti a zúzaléktartályt 30 egységre. */
    public void zuzalekFeltoltes() { this.zuzalekMennyiseg = 30; }

    /**
     * Felhasznál megadott mennyiségű zúzalékot, ha van elegendő.
     *
     * @param m a felhasználandó zúzalék mennyisége
     * @return {@code true}, ha sikeres volt a fogyasztás; {@code false}, ha nincs elég zúzalék
     */
    public boolean zuzalekFogyasztas(int m) {
        if (this.zuzalekMennyiseg >= m) {
            this.zuzalekMennyiseg -= m;
            return true;
        }
        return false;
    }

    /**
     * Visszaadja a sókészlet aktuális mennyiségét.
     *
     * @return a só mennyisége
     */
    public int getSo() { return soMennyiseg; }

    /**
     * Visszaadja a bio-kerozinkészlet aktuális mennyiségét.
     *
     * @return a kerozin mennyisége
     */
    public int getKerozin() { return bioKerozinmennyiseg; }

    /**
     * Visszaadja a zúzalékkészlet aktuális mennyiségét.
     *
     * @return a zúzalék mennyisége
     */
    public int getZuzalek() { return zuzalekMennyiseg; }
}
