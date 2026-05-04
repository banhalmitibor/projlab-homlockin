package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy útszakaszt reprezentáló osztály a "Homlockin" játékban.
 * Az útszakaszon járművek állhatnak, csapadék (hó, jég, zúzalék) halmozódhat fel,
 * és összeköttetésben állhat más útszakaszokkal. Az útszakasz járható vagy járhatatlan állapotban lehet.
 * A hóvédett útszakaszokra (pl. híd alatti szakaszok) nem esik hó.
 */
public class Utszakasz {

    /** Az útszakasz azonosítója/neve. */
    protected String name;

    /** Az útszakaszon lévő hó. */
    protected Ho ho;

    /** Az útszakaszon lévő jég. */
    protected Jeg jeg;

    /** Az útszakaszon lévő zúzalék. */
    protected Zuzalek zuzalek;

    /** A söprés iránya: a jobbra lévő szomszédos útszakasz. */
    protected Utszakasz jobbUt;

    /** Jelzi, hogy az útszakasz járhatatlanná vált-e (pl. ütközés után). */
    protected boolean jarhatatlan;

    /** Az útszakaszból elérhető következő útszakaszok listája. */
    protected List<Utszakasz> kovetkezok = new ArrayList<>();

    /** Az útszakaszon álló jármű. */
    protected Jarmu jarmu;

    /** Jelzi, hogy az útszakasz hóvédett-e (pl. híd alatti szakasz). */
    protected boolean hoVedett = false; // pl. híd alatti útszakaszok számára

    /**
     * Létrehoz egy útszakaszt a megadott névvel, üres csapadékállapottal.
     *
     * @param name az útszakasz azonosítója/neve
     */
    public Utszakasz(String name) { 
        this.name = name; 
        this.ho = new Ho();
        this.jeg = new Jeg(this);
        this.zuzalek = new Zuzalek(this);
    }

    /**
     * Létrehoz egy névtelen útszakaszt üres névvel.
     */
    public Utszakasz() {
        this("");
    }

    /**
     * Visszaadja az útszakasz nevét/azonosítóját.
     *
     * @return az útszakasz neve
     */
    public String getName() { return name; }

    /**
     * Beállítja, hogy az útszakasz hóvédett-e.
     * Hóvédett útszakaszra nem esik hó (pl. híd alatti útszakasz).
     *
     * @param vedett {@code true}, ha hóvédett; {@code false}, ha nem
     */
    public void setHovedett(boolean vedett) {
        this.hoVedett = vedett;
    }

    /**
     * Szimulálja az útszakaszra eső havat.
     * Ha az útszakasz nem hóvédett, a hómennyiség 1-gyel nő.
     * Ha van zúzalék és a hó elér egy bizonyos szintet, a zúzalék betemetődhet.
     */
    public void hoEsik() {
        if (!hoVedett) {
            ho.novel(1);
            // Zúzalék betemetése hó 4-es vagy nagyobb értéknél
            if (zuzalek.vanZuzalek()) {
                zuzalek.eltemet();
            }
        }
    }

    /**
     * Visszaadja a következő útszakaszt az útvonaltól preferált irányban.
     * Ha a kívánt útszakasz a következők között van, azt adja vissza;
     * egyébként az első következőt; ha nincs következő, {@code null}-t.
     *
     * @param wanted a preferált következő útszakasz
     * @return a következő {@link Utszakasz}, vagy {@code null}
     */
    public Utszakasz kovetkezoUtszakasz(Utszakasz wanted) {
        if (!kovetkezok.isEmpty()) {
            if(kovetkezok.contains(wanted))
                return wanted;
            return kovetkezok.get(0);
        }
        return null;
    }

    /**
     * Visszaadja a söprés iránya szerinti jobbra lévő szomszédos útszakaszt.
     * Felülírható (pl. {@link Hid} esetén {@code null}-t ad vissza).
     *
     * @return a jobbra lévő {@link Utszakasz}, vagy {@code null}
     */
    public Utszakasz getJobbraLevoSzakasz() {
        return jobbUt;
    }

    /**
     * Csúszáskor a következő útszakaszt adja vissza (az útvonaltól függetlenül, az első következőt).
     * Ha nincs következő, {@code null}-t ad vissza.
     *
     * @return a csúszás irányában lévő {@link Utszakasz}, vagy {@code null}
     */
    public Utszakasz csuszvaKovetkezoUtszakasz() {
        if (!kovetkezok.isEmpty()) return kovetkezok.get(0);
        return null;
    }

    /**
     * Megvizsgálja, hogy az útszakasz járható-e.
     * Nem járható, ha járhatatlanná vált, ha magas a hó (legalább 4 egység),
     * vagy ha már áll rajta jármű.
     *
     * @return {@code true}, ha járható; {@code false} egyébként
     */
    public boolean jarhato() {
        if (jarhatatlan) return false;
        if (ho.magasHo()) return false;
        if (jarmu != null) return false;
        return true;
    }

    /**
     * Beállítja az útszakaszon álló járművet.
     *
     * @param j az útszakaszra érkező {@link Jarmu}, vagy {@code null}, ha elhagyta
     */
    public void setJarmu(Jarmu j) { 
        this.jarmu = j; 
    }

    /**
     * Visszaadja az útszakaszon álló járművet.
     *
     * @return a {@link Jarmu}, vagy {@code null}, ha nincs jármű az útszakaszon
     */
    public Jarmu getJarmu() {
        return this.jarmu;
    }

    /**
     * Lesöpri az útszakaszról a havat, zúzalékot, és a feltört jeget.
     * A hó és zúzalék eltávolítódik; a jég csak akkor, ha fel van törve.
     */
    public void hoLesopres() {
        ho.eltakarit();
        zuzalek.eltakarit();
        if (jeg.isFeltort()) {
            jeg.eltakarit();
        }
    }

    /**
     * Hómennyiséget söpör rá az útszakaszra (szomszédos szakaszról söpörve).
     *
     * @param amount a hozzáadandó hómennyiség
     */
    public void hoRasopres(int amount) {
        ho.novel(amount);
    }

    /**
     * Zúzalékot szór az útszakaszra (1 egységnyit).
     */
    public void zuzalekSzoras() {
        zuzalek.novel(1);
    }

    /**
     * Zúzalékot söpör rá az útszakaszra a megadott mennyiségben.
     *
     * @param amount a hozzáadandó zúzalékmennyiség
     */
    public void zuzalekRasopres(int amount) {
        zuzalek.novel(amount);
    }

    /**
     * Feltöri az útszakaszon lévő jeget, ha van jég rajta.
     * A jég "feltört" állapotba kerül.
     */
    public void jegTores() {
        if (jeg.getMennyiseg() > 0) {
            jeg.jegetTor();
        }
    }

    /**
     * Sót szór az útszakaszra: csökkenti a hó és a nem feltört jég mennyiségét.
     * Hó esetén 2-vel csökken, jég esetén (ha nem feltört) 1-gyel csökken.
     */
    public void soSzoras() {
        if (ho.getMennyiseg() > 0) {
            ho.csokkent(2);
        }
        if (jeg.getMennyiseg() > 0 && !jeg.isFeltort()) {
            jeg.csokkent(1);
        }
    }

    /**
     * Felolvasztja az útszakaszon lévő havat és jeget (sárkányfej hatása).
     * A hó és a jég eltávolítódik; a zúzalék a sárkányfejnél specifikáció szerint megmarad.
     */
    public void olvasztas() {
        ho.eltakarit();
        jeg.eltakarit();
        // Zúzalék megmarad sárkányfejnél spec szerint
    }

    /**
     * Jármű áthaladásakor a hó letaposódik: ha 1–3 egység hó van az útszakaszon,
     * a hómennyiség 1-gyel csökken és a jégmennyiség 1-gyel nő.
     */
    public void letapos() {
        if (ho.getMennyiseg() > 0 && ho.getMennyiseg() < 4) {
            ho.csokkent(1);
            jeg.novel(1);
        }
    }

    /**
     * Az útszakaszt járhatatlanná teszi (pl. ütközés után).
     * Járhatatlan útszakaszra nem léphetnek járművek.
     */
    public void jarhatatlannaValik() {
        this.jarhatatlan = true;
    }

    /**
     * Beállítja az útszakaszon lévő hó-objektumot.
     *
     * @param ho az új {@link Ho} objektum
     */
    public void setHo(Ho ho) { this.ho = ho; }

    /**
     * Visszaadja az útszakaszon lévő hó-objektumot.
     *
     * @return a {@link Ho} objektum
     */
    public Ho getHo() { return ho; }

    /**
     * Beállítja az útszakaszon lévő jég-objektumot.
     *
     * @param jeg az új {@link Jeg} objektum
     */
    public void setJeg(Jeg jeg) { this.jeg = jeg; }

    /**
     * Visszaadja az útszakaszon lévő jég-objektumot.
     *
     * @return a {@link Jeg} objektum
     */
    public Jeg getJeg() { return jeg; }

    /**
     * Beállítja az útszakaszon lévő zúzalék-objektumot.
     *
     * @param zuzalek az új {@link Zuzalek} objektum
     */
    public void setZuzalek(Zuzalek zuzalek) { this.zuzalek = zuzalek; }

    /**
     * Visszaadja az útszakaszon lévő zúzalék-objektumot.
     *
     * @return a {@link Zuzalek} objektum
     */
    public Zuzalek getZuzalek() { return zuzalek; }

    /**
     * Beállítja a söprés iránya szerinti jobbra lévő szomszédos útszakaszt.
     *
     * @param u a jobbra lévő {@link Utszakasz}
     */
    public void setJobbUt(Utszakasz u) { this.jobbUt = u; }

    /**
     * Visszaadja a jobbra lévő szomszédos útszakaszt (belső referencia).
     *
     * @return a jobbra lévő {@link Utszakasz}
     */
    public Utszakasz getJobbUt() { return jobbUt; }

    /**
     * Hozzáad egy következő útszakaszt az útszakasz lehetséges folytatásaihoz.
     *
     * @param u a hozzáadandó következő {@link Utszakasz}
     */
    public void addKovetkezo(Utszakasz u) { this.kovetkezok.add(u); }

    /**
     * Visszaadja az útszakaszból elérhető összes következő útszakaszt.
     *
     * @return a következő útszakaszok {@link List}je
     */
    public List<Utszakasz> getKovetkezok() { return kovetkezok; }

}
