package homlockin;

import java.rmi.server.SkeletonMismatchException;

/**
 * A {@code UseCases} osztály a játék use case-eit (forgatókönyveit) valósítja meg
 * a skeleton tesztelési módszertan szerint. Minden egyes metódus egy konkrét
 * forgatókönyvet szimulál: hókotró közlekedést, takarítást különböző fejekkel,
 * ütközéseket, vásárlásokat, buszvezetést és autó elakadást. Az osztály statikus
 * mezőkben tárolja a teszteléshez szükséges objektumokat (város, játékosok,
 * útszakaszok, járművek, hókotrófejek, csapadékok és bolt).
 */
public class UseCases {
    private static Varos v;
    private static TakaritoJatekos tj;
    private static BuszvezetoJatekos bj;
    private static Utszakasz u1;
    private static Utszakasz u2;
    private static Utszakasz u3;
    private static Hokotro hk;
    private static HokotroFej fej;
    private static HokotroFej fej2;
    private static Jeg jeg1;
    private static Jeg jeg2;
    private static Ho ho1;
    private static Ho ho2;
    private static Bolt bolt;
    private static Jarmu j1;
    private static Jarmu j2;
    private static Busz busz;
    private static Utvonal utvonal;



    /**
     * Hókotró sima közlekedése takarítás nélkül. A hókotró lép a következő
     * útszakaszra, de nincs fej felszerelve, ezért takarítás nem történik.
     * Csak hóesés és léptetés zajlik le.
     */
    public static void runUseCase1() {
        String ucName = "Hókotró sima közlekedése (nincs takarítás)";
        Skeleton.startInit(ucName);
        init1();

        Skeleton.startTest(ucName);
        v.leptet();
        /*Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("u1.hoEsik()");
        Skeleton.methodReturned();
        Skeleton.methodCalled("hk.lep()");
        fej.munkatVegez(u1);
        Skeleton.methodReturned();
        Skeleton.methodReturned();*/
    }

    /**
     * Jégtörőfejjel való jégtörés forgatókönyve. A hókotró jégtörőfejjel közlekedik
     * és a jégből jégtörmeléket csinál, amely hóként viselkedik tovább.
     */
    static public void runUseCase2() {
        String ucName = "Jégtörőfejjel jégtörés";
        Skeleton.startInit(ucName);
        init8();

        Skeleton.startTest(ucName);
        //Skeleton.methodCalled("v.leptet()");
        v.leptet();
        //Skeleton.methodCalled("u.hoEsik()");
        //Skeleton.methodCalled("hh.lep()");
    }


    /**
     * Hányófejjel való hó- és jégtörmelék takarítás forgatókönyve. A hókotró
     * hányófejjel söpri el a havat az útszakaszról.
     */
    public static void runUseCase3() {
        String ucName = "Takarít havat/jégtörmeléket hányófejjel";
        Skeleton.startInit(ucName);
        init5();

        Skeleton.startTest(ucName);
        //Skeleton.methodCalled("h.lep()");
        v.leptet();
        //hanyofej.munkatVegez(jelenlegiUtszakasz);
        //Skeleton.methodReturned();
    }

    /**
     * Hókotró sima közlekedése sószórófejjel. A sószórófej sót szór az útszakaszra,
     * ezzel olvasztja a havat és a jeget, illetve lassítja a hó újbóli lerakódását.
     */
    public static void runUseCase4() {
        String ucName = "Hókotró sima közlekedése, sószórófejjel";
        Skeleton.startInit(ucName);
        init2();

        Skeleton.startTest(ucName);
        v.leptet();

        //Skeleton.methodCalled("hokotro.lep()");
        //fej.munkatVegez(u1);
        //Skeleton.methodReturned();
    }

    /**
     * Hókotró sima közlekedése sárkányfejjel. A sárkányfej biokerozin égetésével
     * azonnal elolvasztja a havat és a jégpáncélt az útszakaszról.
     */
    public static void runUseCase5() {
        String ucName = "Hókotró sima közlekedése, sárkányfejjel";
        Skeleton.startInit(ucName);
        init3();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Sószórófejjel való hó- és jégtörmelék takarítás forgatókönyve. A hókotró
     * sót szór az útszakaszra, felolvasztva a havat és a jeget.
     */
    public static void runUseCase6() {
        String ucName = "Takarít havat/jégtörmeléket sószórófejjel";
        Skeleton.startInit(ucName);
        init6();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Sárkányfejjel való hó- és jégtörmelék takarítás forgatókönyve. A sárkányfej
     * biokerozin égetésével azonnal olvasztja el a havat és a jégpáncélt.
     */
    public static void runUseCase7() {
        String ucName = "Takarít havat/jégtörmeléket sárkányfejjel";
        Skeleton.startInit(ucName);
        init7();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Hó és törött jég takarítás söprőfejjel. A söprőfej a havat áthelyezi a
     * jobbra szomszédos sávba, vagy ha nincs, eltünteti az útszakaszról.
     */
    public static void runUseCase8() {
        String ucName = "Hó és törött jég takarítás söprőfejjel";
        Skeleton.startInit(ucName);
        init4();

        Skeleton.startTest(ucName);
        v.leptet();
    }


    /**
     * Só vásárlás és a hókotró sókészletének feltöltése a boltban. Ellenőrzi,
     * hogy a takarító játékosnak van-e elegendő pénze a vásárláshoz.
     */
    static void runUseCase9() {
        String ucName = "Só vásárlás és feltöltés";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.sotVasarol(tj, hk);
    }

    /**
     * Biokerozin vásárlás és a hókotró biokerozin készletének feltöltése a boltban.
     * A biokerozint a sárkányfej használja a hó és jégpáncél olvasztásához.
     */
    static void runUseCase10() {
        String ucName = "Biokerozin vásárlás és feltöltés";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.biokerozintVasarol(tj, hk);
    }

    /**
     * Hókotrófej vásárlása a boltban. A takarító játékos sószórófejet vásárol,
     * ha elegendő pénze van rá.
     */
    static void runUseCase11() {
        String ucName = "Hókotrófej vásárlása";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.hokotroFejetVasarol(tj, hk, "Soszoro");
    }

    /**
     * Új hókotró vásárlása a boltban. A takarító játékos az összegyűjtött
     * pénzéből vesz egy új hókotró járművet.
     */
    static void runUseCase12() {
        String ucName = "Új hókotró vásárlása";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.hokotrotVasarol(tj);
    }
    
    /**
     * Ütközés jégpáncélon forgatókönyv. Amikor egy autó jégpáncélos útszakaszon
     * halad át, megcsúszik, és ha ütközés következik be, az útszakasz járhatatlanná válik.
     */
    static void runUseCase13() {
        String ucName = "Ütközés jégpáncélon";
        Skeleton.startInit(ucName);
        init14();

        Skeleton.startTest(ucName);
        v.leptet();
       
    }

    /**
     * Autó csúszkálása ütközés nélkül. Az autó jégpáncélos útszakaszon megcsúszik,
     * de szabad a szomszédos útszakasz, így ütközés nélkül csúszik oda.
     */
    static void runUseCase14() {
        String ucName = "Ütközés jégpáncélon";
        Skeleton.startInit(ucName);
        init14();
        u3.setJarmu(null);

        Skeleton.startTest(ucName);
        v.leptet();
        
    }

    /**
     * Hó letaposása és jégpáncél kialakulása. Az autók áthaladásukkor letapossák a havat,
     * ami csökkenti a hó mennyiségét és növeli a jég szintjét az útszakaszon.
     */
    static void runUseCase15() {
        String ucName = "Hó letaposása és jégpáncél";
        Skeleton.startInit(ucName);
        init12();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Busz célba érése és pontszerzés forgatókönyve. Ha a busz sikeresen eléri
     * valamelyik végállomást, a buszvezető játékos pontot kap.
     */
    static void runUseCase16() {
        String ucName = "Busz célba érése és pontszerzés";
        Skeleton.startInit(ucName);
        init10();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Város léptetése és havazás forgatókönyve. Egy lépés alatt az útszakaszokon
     * hóesés következhet be, majd a járművek is lépnek a következő útszakaszra.
     */
    static void runUseCase17() {
        String ucName = "Város léptetése és havazás";
        Skeleton.startInit(ucName);
        init9();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Autó elakadása forgatókönyve. Ha az autó előtt lévő útszakasz járhatatlan
     * (pl. magas hó miatt), az autó elakad és nem tud továbblépni.
     */
    static void runUseCase18() {
        String ucName = "Autó elakadása";
        Skeleton.startInit(ucName);
        init9();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Játék vége ellenőrzés forgatókönyve. Ellenőrzi, hogy az elakadt autók száma
     * elérte-e a maximumot – ha igen, a játéknak vége és a buszvezető játékosok nyernek.
     */
    static void runUseCase19() {
        String ucName = "Játék vége ellenőrzés";
        Skeleton.startInit(ucName);
        init9();

        Skeleton.startTest(ucName);
        v.jatekVegeEllenorzes();
    }

    /**
     * Takarító játékos pénzszerzése hányófejjel való takarítással. A sikeresen
     * letakarított útszakaszokért a takarító játékos pénzt kap.
     */
    static void runUseCase20() {
        String ucName = "Takarító játékos pénzt szerez (Hányófej)";
        Skeleton.startInit(ucName);
        init5();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Hókotrófej csere forgatókönyve. A takarító játékos lecseréli a hókotró
     * fejét egy másik típusra a hatékonyabb takarítás érdekében.
     */
    static void runUseCase21() {
        String ucName = "Hókotrófej csere";
        Skeleton.startInit(ucName);
        init2();

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.iranyit()");
        hk.fejetCserel(fej2);
        Skeleton.methodReturned();
    }

    /**
     * Autó célba érése forgatókönyve. Ha az autó eléri a munkahelyet vagy az otthont,
     * sikeresen befejezi az útját és eltávolítják a városból.
     */
    static void runUseCase22() {
        String ucName = "Autó célba érése";
        Skeleton.startInit(ucName);
        init12();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    /**
     * Hókotró félreállása és újraindulása. Ha a hókotró kifogy a nyersanyagból
     * (só vagy biokerozin), félreáll, majd a következő lépésben újraindulhat.
     */
    static void runUseCase23() {
        String ucName = "Hókotró félreáll és elindul";
        Skeleton.startInit(ucName);
        init6();

        Skeleton.startTest(ucName);
        v.leptet();

        v.leptet();

    }

    /**
     * Busz indulása forgatókönyve. A buszvezető játékos beállítja a busz útvonalát,
     * majd a busz elindul a két végállomás közötti úton.
     */
    static void runUseCase24(){
        String ucName = "Busz indulása";
        Skeleton.startInit(ucName);
        init10();

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("bj.iranyit()");
        busz.utvonalBeallit(utvonal);
        Skeleton.methodReturned();
        v.leptet();
    }



    /**
     * Inicializálás az 1. use case-hez: Hókotró sima közlekedése söprőfejjel.
     * Létrehozza a várost, a takarító játékost, két útszakaszt és a hókotró járművet
     * felszerelt söprőfejjel.
     */
    public static void init1(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        u2 = new Utszakasz("u2");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        fej = new Soprofej("fej");
        Skeleton.printInitCall("u1.addKovetkezo(u2)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás a 2. és 4. use case-hez: Hókotró sima közlekedése sószórófejjel.
     * Létrehozza a várost, a takarító játékost, egy útszakaszt és a hókotró járművet
     * felszerelt sószórófejjel.
     */
    public static void init2(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("takarito");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("szakasz");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hokotro");
        Skeleton.printNew("Soszorofej");
        fej = new Soszorofej("fej");
        Skeleton.printInitCall("fej.setHokotro(hokotro)");
        fej.setHokotro(hk);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("hokotro.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("takarito.hokotroHozzaadas(hokotro)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás az 5. use case-hez: Hókotró sima közlekedése sárkányfejjel.
     * Létrehozza a várost, a takarító játékost, egy útszakaszt és a hókotró járművet
     * felszerelt sárkányfejjel.
     */
    public static void init3(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("u");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hokotro");
        Skeleton.printNew("Sarkanyfej");
        fej = new Sarkanyfej("fej");
        Skeleton.printInitCall("fej.setHokotro(hokotro)");
        fej.setHokotro(hk);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("hokotro.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hokotro)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás a 8. use case-hez: Hó és törött jég takarítás söprőfejjel.
     * Létrehozza a várost, két útszakaszt hóval és jéggel, valamint a hókotró
     * járművet söprőfejjel.
     */
    public static void init4(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        u2 = new Utszakasz("u2");
        Skeleton.printNew("Ho");
        ho1 = new Ho("ho");
        Skeleton.printNew("Ho");
        jeg1 = new Jeg("feltortJeg");
        Skeleton.printNew("jeg");
        ho2 = new Ho("jobbHo");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        fej = new Soprofej("fej");
        Skeleton.printInitCall("u1.setHo(ho)");
        u1.setHo(ho1);
        Skeleton.printInitCall("u1.setJeg(jeg)");
        u1.setJeg(jeg1);
        Skeleton.printInitCall("u2.setHo(jobbHo)");
        u2.setHo(ho2);
        Skeleton.printInitCall("u1.setJobbUt(u2)");
        u1.setJobbUt(u2);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

    /**
     * Inicializálás a 3. és 20. use case-hez: Hányófejjel való takarítás.
     * Létrehozza a várost, egy útszakaszt hóval és jéggel, valamint a hókotró
     * járművet felszerelt hányófejjel.
     */
    public static void init5(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        ho1 = new Ho("jelenlegiHo");
        Skeleton.printNew("Jeg");
        jeg1 = new Jeg("feltortJeg");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Hanyofej");
        fej = new Hanyofej("hanyofej");
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        u1.setHo(ho1);
        Skeleton.printInitCall("jelenlegiUtszakasz.setJeg(feltortJeg)");
        u1.setJeg(jeg1);
        Skeleton.printInitCall("h.setFej(hanyofej)");
        hk.setFej(fej);
        Skeleton.printInitCall("h.setVezeto(tj)");
        hk.setVezeto(tj);



        Skeleton.printInitCall("tj.hokotroHozzaadas(h)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

    /**
     * Inicializálás a 6. és 23. use case-hez: Sószórófejjel való takarítás.
     * Létrehozza a várost, egy útszakaszt hóval és jéggel, valamint a hókotró
     * járművet sószórófejjel.
     */
    public static void init6(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("takaritoJ");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        ho1 = new Ho("jelenlegiHo");
        Skeleton.printNew("Jeg");
        jeg1 = new Jeg("jelenlegiJeg");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("h");
        Skeleton.printNew("Soszorofej");
        fej = new Soszorofej("fej");
        Skeleton.printInitCall("fej.setHokotro(h)");
        fej.setHokotro(hk);
        Skeleton.printInitCall("h.setVezeto(takaritoJ)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        u1.setHo(ho1);
        Skeleton.printInitCall("jelenlegiUtszakasz.setJeg(jelenlegiJeg)");
        u1.setJeg(jeg1);

        Skeleton.printInitCall("h.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("takaritoJ.hokotroHozzaadas(h)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

    /**
     * Inicializálás a 7. use case-hez: Sárkányfejjel való takarítás.
     * Létrehozza a várost, egy útszakaszt hóval és jéggel, valamint a hókotró
     * járművet felszerelt sárkányfejjel.
     */
    public static void init7(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("th");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        ho1 = new Ho("jelenlegiHo");
        Skeleton.printNew("Jeg");
        jeg1 = new Jeg("jelenlegiJeg");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Sarkanyfej");
        fej = new Sarkanyfej("fej");
        Skeleton.printInitCall("fej.setHokotro(hk)");
        fej.setHokotro(hk);
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        u1.setHo(ho1);
        Skeleton.printInitCall("jelenlegiUtszakasz.setJeg(jelenlegiJeg)");
        u1.setJeg(jeg1);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("hk.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("th.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

    /**
     * Inicializálás a 2. use case-hez: Jégtörőfejjel jégtörés.
     * Létrehozza a várost, egy útszakaszt jéggel, valamint a hókotró
     * járművet jégtörőfejjel.
     */
    public static void init8(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("takaritoJ");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("u");
        Skeleton.printNew("Jeg");
        jeg1 = new Jeg("jelenlegiJeg");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Jegtorofej");
        fej = new Jegtorofej("fej");
        Skeleton.printInitCall("u.setJeg(jelenlegiJeg)");
        u1.setJeg(jeg1);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("hk.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("takaritoJ.hokotroHozzaadas(hh)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás a 17., 18. és 19. use case-hez: Város léptetés, autó elakadás,
     * játék vége. Létrehozza a várost, két útszakaszt hóval és jéggel, és egy
     * autót útvonallal.
     */
    public static void init9(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        u2 = new Utszakasz("u2");
        Skeleton.printNew("Auto");
        j1 = new Auto("a");
        Skeleton.printNew("Ho");
        ho1 = new Ho("ho");
        Skeleton.printNew("Ho");
        ho2 = new Ho("celHo");
        Skeleton.printNew("Jeg");
        jeg2 = new Jeg("celjeg");
        Skeleton.printInitCall("u2.setHo(celHo)");
        u2.setHo(ho2);
        Skeleton.printInitCall("u2.setJeg(celJeg)");
        u2.setJeg(jeg2);
        Skeleton.printNew("Utvonal");
        utvonal = new Utvonal("utvonal");
        Skeleton.printInitCall("u1.setHo(ho)");
        u1.setHo(ho1);
        Skeleton.printInitCall("u1.addKovetkezo(u2)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("a.setUtvonal(utvonal)");
        j1.setUtvonal(utvonal);
        j1.setJelenlegiUtszakasz(u1);
        Skeleton.printInitCall("utvonal.setCel(u2)");
        utvonal.setCel(u2);
        v.addJarmu(j1);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás a 16. és 24. use case-hez: Busz célba érés és busz indulás.
     * Létrehozza a várost, a buszvezető játékost, a busz járművet, két útszakaszt
     * és az útvonalat.
     */
    public static void init10(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("BuszvezetoJatekos");
        bj = new BuszvezetoJatekos("bj");
        Skeleton.printNew("Busz");
        busz = new Busz("b");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        u2 = new Utszakasz("u2");
        Skeleton.printNew("Utvonal");
        utvonal = new Utvonal("utvonal");
        Skeleton.printInitCall("u1.addKovetkezo(u2)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("b.utvonalBeallit(utvonal)");
        busz.setVezeto(bj);
        bj.addBusz(busz);
        utvonal.setCel(u2);
        busz.setUtvonal(utvonal);
        busz.setJelenlegiUtszakasz(u1);
        Skeleton.printInitCall("bj.addBusz(b)");
        v.addJarmu(busz);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás a 9., 10., 11. és 12. use case-hez: Boltban való vásárlások.
     * Létrehozza a várost, a boltot, a takarító játékost, a hókotró járművet
     * és egy söprőfejet.
     */
    public static void init11(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("Bolt");
        bolt = new Bolt("bolt");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        fej = new Soprofej("fej");
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        tj.setBolt(bolt);
    }

    /**
     * Inicializálás a 15. és 22. use case-hez: Hó letaposás, jégpáncél és autó célba
     * érése. Létrehozza a várost, egy autót, két útszakaszt hóval és jéggel,
     * valamint útvonallal.
     */
    public static void init12(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("Auto");
        j1 = new Auto("a");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("uJelenlegi");
        Skeleton.printNew("Utszakasz");
        u2 = new Utszakasz("uCel");
        Skeleton.printNew("Ho");
        ho1 = new Ho("ho");
        Skeleton.printNew("Jeg");
        jeg1 = new Jeg("jeg");
        Skeleton.printNew("Ho");
        ho2 = new Ho("hoCel");
        Skeleton.printNew("Jeg");
        jeg2 = new Jeg("jegCel");
        Skeleton.printNew("Utvonal");
        utvonal = new Utvonal("u");
        Skeleton.printInitCall("uJelenlegi.setHo(ho)");
        u1.setHo(ho1);
        Skeleton.printInitCall("uJelenlegi.setJeg(jeg)");
        u1.setJeg(jeg1);
        Skeleton.printInitCall("uCel.setHo(hoCel)");
        u2.setHo(ho2);
        Skeleton.printInitCall("uCel.setJeg(jegCel)");
        u2.setJeg(jeg2);
        Skeleton.printInitCall("uJelenlegi.addKovetkezo(uCel)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("a.setUtvonal(utvonal)");
        j1.setUtvonal(utvonal);
        j1.setJelenlegiUtszakasz(u1);
        Skeleton.printInitCall("utvonal.setCel(uCel)");
        utvonal.setCel(u2);
        v.addJarmu(j1);
        v.addUtszakasz(u1);
    }

    /**
     * Inicializálás a 13. és 14. use case-hez: Ütközés jégpáncélon.
     * Létrehozza a várost, három útszakaszt, két autót, jéggel felszerelt útszakaszt
     * és útvonalat. Az egyik autó a másikba ütközik csúszás közben.
     */
    public static void init14(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("Utszakasz");
        u1 = new Utszakasz("uJelenlegi");
        Skeleton.printNew("Utszakasz");
        u2 = new Utszakasz("uCel");
        Skeleton.printNew("Utszakasz");
        u3 = new Utszakasz("uSzom");
        Skeleton.printNew("Auto");
        j1 = new Auto("erkezoJarmu");
        Skeleton.printNew("Auto");
        j2 = new Auto("szomszedosJarmu");
        Skeleton.printNew("Jeg");
        jeg1 = new Jeg("celJeg");
        Skeleton.printNew("Ho");
        ho1 = new Ho("celHo");
        Skeleton.printNew("Utvonal");
        utvonal = new Utvonal("utvonal");
        Skeleton.printInitCall("uCel.setJeg(celJeg)");
        u2.setJeg(jeg1);
        Skeleton.printInitCall("uCel.setHo(celHo)");
        u2.setHo(ho1);
        Skeleton.printInitCall("uJelenlegi.addKovetkezo(uCel)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("uCel.addKovetkezo(uSzom)");
        u2.addKovetkezo(u3);
        Skeleton.printInitCall("erkezoJarmu.setUtvonal(utvonal)");
        j1.setUtvonal(utvonal);
        j1.setJelenlegiUtszakasz(u1);
        Skeleton.printInitCall("utvonal.setCel(uCel)");
        utvonal.setCel(u2);
        u3.setJarmu(j2);
        j2.setJelenlegiUtszakasz(u3);
        v.addJarmu(j1);
    }

    /**
     * Az összes statikus tesztelési mezőt null-ra állítja, hogy a következő
     * inicializálás előtt tiszta állapot legyen. Ez szükséges a tesztek
     * izolálásához és az objektumok megfelelő újralétrehozásához.
     */
    public static void setToNull(){
        v = null;
        tj = null;
        u1 = null;
        u2 = null;
        u3 = null;
        hk = null;
        fej = null;
        jeg1 = null;
        jeg2 = null;
        ho1 = null;
        ho2 = null;
        bolt = null;
        j1 = null;
        j2 = null;
        utvonal = null;
    }

}
