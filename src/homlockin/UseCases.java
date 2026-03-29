package homlockin;

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

    public static void runUseCase5() {
        String ucName = "Hókotró sima közlekedése, sárkányfejjel";
        Skeleton.startInit(ucName);
        init3();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    public static void runUseCase6() {
        String ucName = "Takarít havat/jégtörmeléket sószórófejjel";
        Skeleton.startInit(ucName);
        init6();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    public static void runUseCase7() {
        String ucName = "Takarít havat/jégtörmeléket sárkányfejjel";
        Skeleton.startInit(ucName);
        init7();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    public static void runUseCase8() {
        String ucName = "Hó és törött jég takarítás söprőfejjel";
        Skeleton.startInit(ucName);
        init4();

        Skeleton.startTest(ucName);
        v.leptet();
    }


    static void runUseCase9() {
        String ucName = "Só vásárlás és feltöltés";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.sotVasarol(tj, hk);
    }

    static void runUseCase10() {
        String ucName = "Biokerozin vásárlás és feltöltés";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.biokerozintVasarol(tj, hk);
    }

    static void runUseCase11() {
        String ucName = "Hókotrófej vásárlása";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.hokotroFejetVasarol(tj, hk, "Soszoro");
    }

    static void runUseCase12() {
        String ucName = "Új hókotró vásárlása";
        Skeleton.startInit(ucName);
        init11();

        Skeleton.startTest(ucName);
        bolt.hokotrotVasarol(tj);
    }
    
    static void runUseCase13() {
        String ucName = "Ütközés jégpáncélon";
        Skeleton.startInit(ucName);
        init14();

        Skeleton.startTest(ucName);
        v.leptet();
       
    }

    static void runUseCase14() {
        String ucName = "Ütközés jégpáncélon";
        Skeleton.startInit(ucName);
        init14();
        u3.setJarmu(null);

        Skeleton.startTest(ucName);
        v.leptet();
        
    }

    static void runUseCase15() {
        String ucName = "Hó letaposása és jégpáncél";
        Skeleton.startInit(ucName);
        init12();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    static void runUseCase16() {
        String ucName = "Busz célba érése és pontszerzés";
        Skeleton.startInit(ucName);
        init10();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    static void runUseCase17() {
        String ucName = "Város léptetése és havazás";
        Skeleton.startInit(ucName);
        init9();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    static void runUseCase18() {
        String ucName = "Autó elakadása";
        Skeleton.startInit(ucName);
        init9();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    static void runUseCase19() {
        String ucName = "Játék vége ellenőrzés";
        Skeleton.startInit(ucName);
        init9();

        Skeleton.startTest(ucName);
        v.jatekVegeEllenorzes();
    }

    static void runUseCase20() {
        String ucName = "Takarító játékos pénzt szerez (Hányófej)";
        Skeleton.startInit(ucName);
        init5();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    static void runUseCase21() {
        String ucName = "Hókotrófej csere";
        Skeleton.startInit(ucName);
        init2();

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.iranyit()");
        hk.fejetCserel(fej2);
        Skeleton.methodReturned();
    }

    static void runUseCase22() {
        String ucName = "Autó célba érése";
        Skeleton.startInit(ucName);
        init12();

        Skeleton.startTest(ucName);
        v.leptet();
    }

    static void runUseCase23() {
        String ucName = "Hókotró félreáll és elindul";
        Skeleton.startInit(ucName);
        init6();

        Skeleton.startTest(ucName);
        // First leptet: hókotró félreáll
        v.leptet();


        hk.soFeltoltes();
        v.leptet();

    }

    static void runUseCase24(){

    }



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
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

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
        Skeleton.printInitCall("hokotro.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("takarito.hokotroHozzaadas(hokotro)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

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
        Skeleton.printInitCall("hokotro.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hokotro)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

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
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

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

    public static void init6(){
        setToNull();
        Skeleton.printNew("Varos");
        v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        tj = new TakaritoJatekos("takaritod");
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
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        u1.setHo(ho1);
        Skeleton.printInitCall("jelenlegiUtszakasz.setJeg(jelenlegiJeg)");
        u1.setJeg(jeg1);

        Skeleton.printInitCall("h.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("takaritod.hokotroHozzaadas(h)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

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
        Skeleton.printInitCall("hk.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("th.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
    }

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
        Skeleton.printInitCall("hh.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("takaritoJ.hokotroHozzaadas(hh)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);
    }

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
