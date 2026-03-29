package homlockin;

public class UseCases {
    private static Varos v;
    private static TakaritoJatekos tj;
    private static Utszakasz u1;
    private static Utszakasz u2;
    private static Hokotro hk;
    private static HokotroFej fej;
    private static Jeg jeg1;
    private static Ho ho1;
    private static Ho ho2;



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
        ho2 = new Ho("jobbHo");
        Skeleton.printNew("Hokotro");
        hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        fej = new Soprofej("fej");
        Skeleton.printInitCall("u1.setHo(ho)");
        u1.setHo(ho1);
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

    public static void setToNull(){
        v = null;
        tj = null;
        u1 = null;
        u2 = null;
        hk = null;
        fej = null;
        jeg1 = null;
        ho1 = null;
        ho2 = null;
    }

}
