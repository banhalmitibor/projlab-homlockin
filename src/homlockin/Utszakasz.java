package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * Az {@code Utszakasz} osztály az úthálózat alapeleme, amelyen a járművek
 * közlekednek. Az útszakaszokból épül fel a város – egy gráf reprezentálja,
 * ahol a csúcspontokat az {@code Utszakasz} objektumok képzik, az élek pedig
 * megmutatják, hogy melyik útszakaszból melyikekbe lehet közvetlen átmenni.
 * Az útszakasz felelőssége, hogy tárolja a rajta lévő hó és jég mennyiségét,
 * valamint nyilvántartsa a rajta tartózkodó járműveket. Számon tartja saját
 * járhatósági állapotát, illetve azt, hogy az autók áthaladása miatt mikor
 * alakul ki rajta jégpáncél.
 */
public class Utszakasz {

    /** Az útszakasz neve azonosítási célokra. */
    protected String name;

    /** Az útszakaszon lévő hó objektum, amely a hóállapotot kezeli. */
    protected Ho ho;

    /** Az útszakaszon lévő jég objektum, amely a jégállapotot kezeli. */
    protected Jeg jeg;

    /**
     * A tőle jobbra lévő útszakasz. A söprőfej erre tolja a havat,
     * egysávos úton eltünteti.
     */
    protected Utszakasz jobbUt;

    /**
     * Jelzi, hogy az útszakasz járhatatlan-e. Nem lehet rajta járni, mert
     * összecsúszott 2 autó, vagy a hómennyiség elérte a bizonyos határt.
     */
    protected boolean jarhatatlan;

    /**
     * Azok az útszakaszok, amelyekre az útszakaszról tovább lehet lépni
     * (a gráf szomszédos csúcsai).
     */
    protected List<Utszakasz> kovetkezok = new ArrayList<>();

    /** Az az útszakaszon jelenleg tartózkodó jármű (ha van). */
    protected Jarmu jarmu;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen útszakaszt.
     */
    public Utszakasz() {}

    /**
     * Névvel ellátott útszakaszt hoz létre.
     *
     * @param name az útszakasz neve
     */
    public Utszakasz(String name) { this.name = name; }

    /**
     * A hóesés kezelésének metódusa. Minden lépéskor meghívódik, és növeli az
     * útszakaszon lévő hó mennyiségét. Speciális útszakaszoknál (pl. alagút)
     * felülírható, hogy ne essen hó.
     */
    public void hoEsik() {
        Skeleton.methodCalled(name + ".hoEsik()");
        if (ho != null) {
            ho.novel(1);
        }
        Skeleton.methodReturned();
    }

    /**
     * Visszaadja a következő útszakaszt, amelyre a jármű tovább tud haladni
     * a célállomás irányába. Figyelembe veszi a célállomást és a lehetséges
     * következő útszakaszokat.
     *
     * @param cel az a célállomás {@link Utszakasz}, ahova a jármű el kíván jutni
     * @return a következő lépendő {@link Utszakasz} a célállomás felé
     */
    public Utszakasz kovetkezoUtszakasz(Utszakasz cel) {
        Skeleton.methodCalled(name + ".kovetkezoUtszakasz()");
        Utszakasz result = jobbUt;
        if (!kovetkezok.isEmpty()) result = kovetkezok.get(0);
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Visszaadja az adott útszakasztól jobbra lévő útszakaszt (ha van).
     * A söprőfej ezt használja a hó áthelyezéséhez.
     *
     * @return a jobbra lévő {@link Utszakasz}, vagy {@code null}, ha nincs
     */
    public Utszakasz getJobbraLevoSzakasz() {
        Skeleton.methodCalled(name + ".getJobbraLevoSzakasz()");
        Skeleton.methodReturned();
        return jobbUt;
    }

    /**
     * Meghatározza, hogy csúszás után az adott jármű melyik útszakaszra csúszik.
     * Jégpáncélos útszakaszon a jármű a következő útszakaszra csúszik irányítás
     * nélkül.
     *
     * @return az a {@link Utszakasz}, ahova a jármű csúszik, vagy {@code null}
     */
    public Utszakasz csuszvaKovetkezoUtszakasz() {
        Skeleton.methodCalled(name + ".csuszvaKovetkezoUtszakasz()");
        Utszakasz result = null;
        if (!kovetkezok.isEmpty()) result = kovetkezok.get(0);
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Megnézi a csapadék állapotát és hogy van-e jármű az útszakaszon, majd
     * visszaadja, hogy rá lehet-e lépni. Az útszakasz járhatatlan, ha magas hó
     * van rajta, vagy ha már áll rajta egy jármű.
     *
     * @return {@code true}, ha az útszakasz járható; {@code false}, ha járhatatlan
     */
    public boolean jarhato() {
        Skeleton.methodCalled(name + ".jarhato()");
        boolean result = true;
        if(ho.magasHo()){
            result = false;
        }
        if(jarmu != null){
            result = false;
        }
        Skeleton.methodReturned();
        return result;
    }

    /**
     * Kezeli, hogy egy jármű rálép az útszakaszra. Ha az útszakaszon jégpáncél
     * alakult ki, a rálépő jármű megcsúszik.
     *
     * @param j az az {@link Jarmu}, amely rálép az útszakaszra
     */
    public void stepOn(Jarmu j) { 
        Skeleton.methodCalled(name + ".stepOn()");
        if(jeg.jegPancel()){
            j.csuszkal();
        }
        Skeleton.methodReturned();
    }

    /**
     * Beállítja az útszakaszon tartózkodó járművet.
     *
     * @param j az útszakaszon elhelyezendő {@link Jarmu} objektum
     */
    public void setJarmu(Jarmu j) { 
        jarmu = j;
    }

    /**
     * Az útszakaszon a söprőfejjel vagy hányófejjel való takarítás azon részét
     * kezeli, ahogyan a fej a havat lesöpri és ezzel eltünteti az útszakaszról.
     * Mind a havat, mind a jeget eltakarítja.
     */
    public void hoLesopres() {
        Skeleton.methodCalled(name + ".hoLesopres()");
        if (ho != null) {
            ho.eltakarit();
        }
        if (jeg != null) {
            jeg.eltakarit();
        }
        Skeleton.methodReturned();
    }

    /**
     * Az útszakaszon a söprőfejjel való takarítás azon részét kezeli, ahogyan
     * az útszakaszra rásöpri a havat (az egyik sávból a másikba tolva).
     */
    public void hoRasopres() {
        Skeleton.methodCalled(name + ".hoRasopres()");
        if (ho != null) {
            ho.novel(1);
        }
        Skeleton.methodReturned();
    }

    /**
     * Az útszakaszon a jégtörőfejjel való takarítást kezeli. A jégből
     * jégtörmeléket csinál, amely hóként viselkedik tovább az útszakaszon.
     */
    public void jegTores() {
        Skeleton.methodCalled(name + ".jegTores()");
        if (jeg != null) {
            jeg.jegetTor();
        }
        Skeleton.methodReturned();
    }

    /**
     * Az útszakaszon a sószórófejjel való takarítást kezeli. Sót szór a
     * hóra és jégre, amelyek hatására azok olvadnak és lassabban képződnek újra.
     */
    public void soSzoras() {
        Skeleton.methodCalled(name + ".soSzoras()");
        if (ho != null) {
            ho.felsoz();
        }
        if (jeg != null) {
            jeg.felsoz();
        }
        Skeleton.methodReturned();
    }

    /**
     * Az útszakaszon a sárkányfejjel való takarítást kezeli. Biokerozin égetésével
     * azonnal felolvasztja a havat és a jégpáncélt az útszakaszról.
     */
    public void olvasztas() {
        Skeleton.methodCalled(name + ".olvasztas()");
        if (ho != null) {
            ho.eltakarit();
        }
        if (jeg != null) {
            jeg.eltakarit();
        }
        Skeleton.methodReturned();
    }

    /**
     * Az útszakaszon haladó jármű áthaladásakor hívódik meg, és a hó letaposását
     * kezeli. Ez azt jelenti, hogy a hó mennyiségét csökkenti, és a jég mennyiségét
     * növeli – az autók áthaladása tömöríti a havat és jéggé alakítja.
     */
    public void letapos() {
        Skeleton.methodCalled(name + ".letapos()");
        if (ho != null) {
            ho.csokkent(1);
        }
        if (jeg != null) {
            jeg.novel(1);
        }
        Skeleton.methodReturned();
    }

    /**
     * Járhatatlanná teszi az útszakaszt. Akkor hívódik meg, amikor két jármű
     * összeütközik rajta, és az ütközés következtében az útszakasz lezáródik.
     */
    public void jarhatatlannaValik() {
        Skeleton.methodCalled(name + ".jarhatatlannaValik()");
        jarhatatlan = true;
        Skeleton.methodReturned();
    }

    /**
     * Beállítja az útszakaszon lévő hó objektumot.
     *
     * @param ho a {@link Ho} objektum, amely az útszakasz hóállapotát kezeli
     */
    public void setHo(Ho ho) { this.ho = ho; }

    /**
     * Beállítja az útszakaszon lévő jég objektumot.
     *
     * @param jeg a {@link Jeg} objektum, amely az útszakasz jégállapotát kezeli
     */
    public void setJeg(Jeg jeg) { this.jeg = jeg; }

    /**
     * Beállítja a jobbra szomszédos útszakaszt.
     *
     * @param u a jobbra szomszédos {@link Utszakasz} objektum
     */
    public void setJobbUt(Utszakasz u) { this.jobbUt = u; }

    /**
     * Hozzáad egy következő (szomszédos) útszakaszt az útszakasz szomszédainak listájához.
     *
     * @param u a hozzáadandó szomszédos {@link Utszakasz} objektum
     */
    public void addKovetkezo(Utszakasz u) { this.kovetkezok.add(u); }

    /**
     * Beállítja az útszakaszon lévő csapadék objektumot (általános setter).
     *
     * @param c a {@link Csapadek} objektum
     */
    public void setCsapadek(Csapadek c) {}

    /**
     * Visszaadja az útszakaszon lévő hó objektumot.
     *
     * @return a {@link Ho} objektum
     */
    public Ho getHo() { return ho; }

    /**
     * Visszaadja az útszakaszon lévő jég objektumot.
     *
     * @return a {@link Jeg} objektum
     */
    public Jeg getJeg() { return jeg; }

    /**
     * Visszaadja a jobbra szomszédos útszakaszt.
     * A söprőfej ezt használja a hó áthelyezéséhez.
     *
     * @return a jobbra szomszédos {@link Utszakasz}, vagy {@code null}, ha nincs
     */
    public Utszakasz getJobbUt() { 
        Skeleton.methodCalled(name + ".getJobbraLevoSzakasz()");
        
        Skeleton.methodReturned();
        return jobbUt; 
    }

    /**
     * Visszaadja az útszakasz nevét.
     *
     * @return az útszakasz neve
     */
    public String getName() { return name; }

    /**
     * Visszaadja az útszakaszon jelenleg tartózkodó járművet.
     *
     * @return az útszakaszon álló {@link Jarmu}, vagy {@code null}, ha üres
     */
    public Jarmu getJarmu() {
        return jarmu;
    }
}
