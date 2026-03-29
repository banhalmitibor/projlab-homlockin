package homlockin;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = Skeleton.getScanner();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nElérhető Use-Case-ek:");
            System.out.println(" 1. Hókotró sima közlekedése (nincs takarítás)");
            System.out.println(" 2. Jégtörőfejjel jégtörés");
            System.out.println(" 3. Takarít havat/jégtörmeléket hányófejjel");
            System.out.println(" 4. Hókotró sima közlekedése, sószórófejjel");
            System.out.println(" 5. Hókotró sima közlekedése, sárkányfejjel");
            System.out.println(" 6. Takarít havat/jégtörmeléket sószórófejjel");
            System.out.println(" 7. Takarít havat/jégtörmeléket sárkányfejjel");
            System.out.println(" 8. Hó és törött jég takarítás söprőfejjel");
            System.out.println(" 9. Só vásárlás és feltöltés");
            System.out.println("10. Biokerozin vásárlás és feltöltés");
            System.out.println("11. Hókotrófej vásárlása");
            System.out.println("12. Új hókotró vásárlása");
            System.out.println("13. Ütközés jégpáncélon");
            System.out.println("14. Autó csúszkálása ütközés nélkül");
            System.out.println("15. Hó letaposása és jégpáncél");
            System.out.println("16. Busz célba érése és pontszerzés");
            System.out.println("17. Város léptetése és havazás");
            System.out.println("18. Autó elakadása");
            System.out.println("19. Játék vége ellenőrzés");
            System.out.println("20. Takarító játékos pénzt szerez (Hányófej)");
            System.out.println("21. Hókotrófej csere");
            System.out.println("22. Autó célba érése");
            System.out.println("23. Hókotró félreáll és elindul");
            System.out.println("24. Busz indulása");
            System.out.println(" 0. Kilépés");
            System.out.print("Válasszon: ");
            String line = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Érvénytelen választás.");
                continue;
            }
            if (choice == 0) break;
            switch (choice) {
                case 1: UseCases.runUseCase1(); break;
                case 2: UseCases.runUseCase2(); break;
                case 3: UseCases.runUseCase3(); break;
                case 4: UseCases.runUseCase4(); break;
                case 5: UseCases.runUseCase5(); break;
                case 6: UseCases.runUseCase6(); break; 
                case 7: UseCases.runUseCase7(); break;
                case 8: UseCases.runUseCase8(); break;
                case 9: UseCases.runUseCase9(); break;
                case 10: UseCases.runUseCase10(); break;
                case 11: UseCases.runUseCase11(); break;
                case 12: UseCases.runUseCase12(); break;
                case 13: UseCases.runUseCase13(); break; 
                case 14: UseCases.runUseCase14(); break;/*
                case 15: runUseCase15(); break;
                case 16: runUseCase16(); break;
                case 17: runUseCase17(); break;
                case 18: runUseCase18(); break;
                case 19: runUseCase19(); break;
                case 20: runUseCase20(); break;
                case 21: runUseCase21(); break;
                case 22: runUseCase22(); break;
                case 23: runUseCase23(); break;
                case 24: runUseCase24(); break; */
                default: System.out.println("Érvénytelen választás.");
            }
        }
    }

    // UC1: Hókotró sima közlekedése (nincs takarítás)
    /*static void runUseCase1() {
        String ucName = "Hókotró sima közlekedése (nincs takarítás)";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        Utszakasz u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        Utszakasz u2 = new Utszakasz("u2");
        Skeleton.printNew("Hokotro");
        Hokotro hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        Soprofej fej = new Soprofej("fej");
        Skeleton.printInitCall("u1.addKovetkezo(u2)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);
        v.addUtszakasz(u1);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("u1.hoEsik()");
        Skeleton.methodReturned();
        Skeleton.methodCalled("hk.lep()");
        fej.munkatVegez(u1, hk);
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }*/

    // UC2: Jégtörőfejjel jégtörés
    /*static void runUseCase2() {
        String ucName = "Jégtörőfejjel jégtörés";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos takaritoJ = new TakaritoJatekos("takaritoJ");
        Skeleton.printNew("Utszakasz");
        Utszakasz u = new Utszakasz("u");
        Skeleton.printNew("Jeg");
        Jeg jelenlegiJeg = new Jeg("jelenlegiJeg");
        Skeleton.printNew("Hokotro");
        Hokotro hh = new Hokotro("hh");
        Skeleton.printNew("Jegtorofej");
        Jegtorofej fej = new Jegtorofej("fej");
        Skeleton.printInitCall("u.setJeg(jelenlegiJeg)");
        u.setJeg(jelenlegiJeg);
        Skeleton.printInitCall("hh.fejetCserel(fej)");
        hh.setFej(fej);
        Skeleton.printInitCall("takaritoJ.hokotroHozzaadas(hh)");
        hh.setJelenlegiUtszakasz(u);
        v.addJarmu(hh);
        v.addUtszakasz(u);

        Skeleton.startTest(ucName);
        //Skeleton.methodCalled("v.leptet()");
        v.leptet();
        //Skeleton.methodCalled("u.hoEsik()");
        //Skeleton.methodCalled("hh.lep()");
    }*/








    /* 





    // UC3: Takarít havat/jégtörmeléket hányófejjel
    static void runUseCase3() {
        String ucName = "Takarít havat/jégtörmeléket hányófejjel";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        Utszakasz jelenlegiUtszakasz = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        Ho jelenlegiHo = new Ho("jelenlegiHo");
        Skeleton.printNew("Hokotro");
        Hokotro h = new Hokotro("h");
        Skeleton.printNew("Hanyofej");
        Hanyofej hanyofej = new Hanyofej("hanyofej");
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        jelenlegiUtszakasz.setHo(jelenlegiHo);
        Skeleton.printInitCall("h.setFej(hanyofej)");
        h.setFej(hanyofej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(h)");
        h.setJelenlegiUtszakasz(jelenlegiUtszakasz);
        v.addJarmu(h);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("h.lep()");
        hanyofej.munkatVegez(jelenlegiUtszakasz, h);
        Skeleton.methodReturned();
    }

    // UC4: Hókotró sima közlekedése, sószórófejjel
    static void runUseCase4() {
        String ucName = "Hókotró sima közlekedése, sószórófejjel";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos takarito = new TakaritoJatekos("takarito");
        Skeleton.printNew("Utszakasz");
        Utszakasz szakasz = new Utszakasz("szakasz");
        Skeleton.printNew("Hokotro");
        Hokotro hokotro = new Hokotro("hokotro");
        Skeleton.printNew("Soszorofej");
        Soszorofej fej = new Soszorofej("fej");
        Skeleton.printInitCall("hokotro.fejetCserel(fej)");
        hokotro.setFej(fej);
        Skeleton.printInitCall("takarito.hokotroHozzaadas(hokotro)");
        hokotro.setJelenlegiUtszakasz(szakasz);
        v.addJarmu(hokotro);
        v.addUtszakasz(szakasz);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("hokotro.lep()");
        fej.munkatVegez(szakasz, hokotro);
        Skeleton.methodReturned();
    }

    // UC5: Hókotró sima közlekedése, sárkányfejjel
    static void runUseCase5() {
        String ucName = "Hókotró sima közlekedése, sárkányfejjel";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        Utszakasz u = new Utszakasz("u");
        Skeleton.printNew("Hokotro");
        Hokotro hokotro = new Hokotro("hokotro");
        Skeleton.printNew("Sarkanyfej");
        Sarkanyfej fej = new Sarkanyfej("fej");
        Skeleton.printInitCall("hokotro.fejetCserel(fej)");
        hokotro.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hokotro)");
        hokotro.setJelenlegiUtszakasz(u);
        v.addJarmu(hokotro);
        v.addUtszakasz(u);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("hokotro.lep()");
        fej.munkatVegez(u, hokotro);
        Skeleton.methodReturned();
    }

    // UC6: Takarít havat/jégtörmeléket sószórófejjel
    static void runUseCase6() {
        String ucName = "Takarít havat/jégtörmeléket sószórófejjel";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos takaritod = new TakaritoJatekos("takaritod");
        Skeleton.printNew("Utszakasz");
        Utszakasz jelenlegiUtszakasz = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        Ho jelenlegiHo = new Ho("jelenlegiHo");
        Skeleton.printNew("Hokotro");
        Hokotro h = new Hokotro("h");
        Skeleton.printNew("Soszorofej");
        Soszorofej fej = new Soszorofej("fej");
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        jelenlegiUtszakasz.setHo(jelenlegiHo);
        Skeleton.printInitCall("h.fejetCserel(fej)");
        h.setFej(fej);
        Skeleton.printInitCall("takaritod.hokotroHozzaadas(h)");
        h.setJelenlegiUtszakasz(jelenlegiUtszakasz);
        v.addJarmu(h);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("h.lep()");
        fej.munkatVegez(jelenlegiUtszakasz, h);
        Skeleton.methodReturned();
    }

    // UC7: Takarít havat/jégtörmeléket sárkányfejjel
    static void runUseCase7() {
        String ucName = "Takarít havat/jégtörmeléket sárkányfejjel";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos th = new TakaritoJatekos("th");
        Skeleton.printNew("Utszakasz");
        Utszakasz jelenlegiUtszakasz = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        Ho jelenlegiHo = new Ho("jelenlegiHo");
        Skeleton.printNew("Jeg");
        Jeg jelenlegiJeg = new Jeg("jelenlegiJeg");
        Skeleton.printNew("Hokotro");
        Hokotro hk = new Hokotro("hk");
        Skeleton.printNew("Sarkanyfej");
        Sarkanyfej fej = new Sarkanyfej("fej");
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        jelenlegiUtszakasz.setHo(jelenlegiHo);
        Skeleton.printInitCall("jelenlegiUtszakasz.setJeg(jelenlegiJeg)");
        jelenlegiUtszakasz.setJeg(jelenlegiJeg);
        Skeleton.printInitCall("hk.fejetCserel(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("th.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(jelenlegiUtszakasz);
        v.addJarmu(hk);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("hk.lep()");
        fej.munkatVegez(jelenlegiUtszakasz, hk);
        Skeleton.methodReturned();
    }

    // UC8: Hó és törött jég takarítás söprőfejjel
    static void runUseCase8() {
        String ucName = "Hó és törött jég takarítás söprőfejjel";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        Utszakasz u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        Utszakasz u2 = new Utszakasz("u2");
        Skeleton.printNew("Ho");
        Ho ho = new Ho("ho");
        Skeleton.printNew("Ho");
        Ho jobbHo = new Ho("jobbHo");
        Skeleton.printNew("Hokotro");
        Hokotro hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        Soprofej fej = new Soprofej("fej");
        Skeleton.printInitCall("u1.setHo(ho)");
        u1.setHo(ho);
        Skeleton.printInitCall("u2.setHo(jobbHo)");
        u2.setHo(jobbHo);
        Skeleton.printInitCall("u1.setJobbUt(u2)");
        u1.setJobbUt(u2);
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(u1);
        v.addJarmu(hk);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("hk.lep()");
        fej.munkatVegez(u1, hk);
        Skeleton.methodReturned();
    }

    // Helper to build UC9-12 init (Bolt scenario)
    private static Object[] initBoltScenario(String ucName) {
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("Bolt");
        Bolt bolt = new Bolt("bolt");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Hokotro");
        Hokotro hk = new Hokotro("hk");
        Skeleton.printNew("Soprofej");
        Soprofej fej = new Soprofej("fej");
        Skeleton.printInitCall("hk.setFej(fej)");
        hk.setFej(fej);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        tj.setBolt(bolt);
        return new Object[]{v, bolt, tj, hk, fej};
    }

    // UC9: Só vásárlás és feltöltés
    static void runUseCase9() {
        String ucName = "Só vásárlás és feltöltés";
        Object[] obs = initBoltScenario(ucName);
        TakaritoJatekos tj = (TakaritoJatekos) obs[2];
        Hokotro hk = (Hokotro) obs[3];
        Bolt bolt = (Bolt) obs[1];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.vasarol()");
        bolt.sotVasarol(tj, hk);
        Skeleton.methodReturned();
    }

    // UC10: Biokerozin vásárlás és feltöltés
    static void runUseCase10() {
        String ucName = "Biokerozin vásárlás és feltöltés";
        Object[] obs = initBoltScenario(ucName);
        TakaritoJatekos tj = (TakaritoJatekos) obs[2];
        Hokotro hk = (Hokotro) obs[3];
        Bolt bolt = (Bolt) obs[1];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.vasarol()");
        bolt.biokerozintVasarol(tj, hk);
        Skeleton.methodReturned();
    }

    // UC11: Hókotrófej vásárlása
    static void runUseCase11() {
        String ucName = "Hókotrófej vásárlása";
        Object[] obs = initBoltScenario(ucName);
        TakaritoJatekos tj = (TakaritoJatekos) obs[2];
        Hokotro hk = (Hokotro) obs[3];
        Bolt bolt = (Bolt) obs[1];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.vasarol()");
        bolt.hokotroFejetVasarol(tj, hk, "Soszoro");
        Skeleton.methodReturned();
    }

    // UC12: Új hókotró vásárlása
    static void runUseCase12() {
        String ucName = "Új hókotró vásárlása";
        Object[] obs = initBoltScenario(ucName);
        TakaritoJatekos tj = (TakaritoJatekos) obs[2];
        Bolt bolt = (Bolt) obs[1];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.vasarol()");
        bolt.hokotrotVasarol(tj);
        Skeleton.methodReturned();
    }

    // Helper for UC13/14 init
    private static Object[] initUtkozesSzcenariot(String ucName) {
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("Utszakasz");
        Utszakasz uJelenlegi = new Utszakasz("uJelenlegi");
        Skeleton.printNew("Utszakasz");
        Utszakasz uCel = new Utszakasz("uCel");
        Skeleton.printNew("Utszakasz");
        Utszakasz uSzom = new Utszakasz("uSzom");
        Skeleton.printNew("Auto");
        Auto erkezoJarmu = new Auto("erkezoJarmu");
        Skeleton.printNew("Auto");
        Auto szomszedosJarmu = new Auto("szomszedosJarmu");
        Skeleton.printNew("Jeg");
        Jeg celJeg = new Jeg("celJeg");
        Skeleton.printNew("Utvonal");
        Utvonal utvonal = new Utvonal("utvonal");
        Skeleton.printInitCall("uJelenlegi.setJeg(celJeg)");
        uJelenlegi.setJeg(celJeg);
        Skeleton.printInitCall("uJelenlegi.addKovetkezo(uCel)");
        uJelenlegi.addKovetkezo(uCel);
        Skeleton.printInitCall("uCel.addKovetkezo(uSzom)");
        uCel.addKovetkezo(uSzom);
        Skeleton.printInitCall("erkezoJarmu.setUtvonal(utvonal)");
        erkezoJarmu.setUtvonal(utvonal);
        erkezoJarmu.setJelenlegiUtszakasz(uJelenlegi);
        Skeleton.printInitCall("utvonal.setCel(uCel)");
        utvonal.setCel(uCel);
        uCel.addJarmu(szomszedosJarmu);
        szomszedosJarmu.setJelenlegiUtszakasz(uCel);
        v.addJarmu(erkezoJarmu);
        return new Object[]{v, uJelenlegi, uCel, uSzom, erkezoJarmu, szomszedosJarmu, celJeg, utvonal};
    }

    // UC13: Ütközés jégpáncélon
    static void runUseCase13() {
        String ucName = "Ütközés jégpáncélon";
        Object[] obs = initUtkozesSzcenariot(ucName);
        Auto erkezoJarmu = (Auto) obs[4];
        Auto szomszedosJarmu = (Auto) obs[5];
        Utszakasz uJelenlegi = (Utszakasz) obs[1];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("erkezoJarmu.lep()");
        Skeleton.methodCalled("erkezoJarmu.csuszkal()");
        boolean csuszikJegpancelen = Skeleton.askYesNo("Jégpáncélon csúszik?");
        if (csuszikJegpancelen) {
            uJelenlegi.csuszvaKovetkezoUtszakasz();
            boolean vanJarmu = Skeleton.askYesNo("Van jármű a célállomáson?");
            if (vanJarmu) {
                erkezoJarmu.utkozik();
                szomszedosJarmu.utkozik();
            }
        }
        Skeleton.methodReturned(); // csuszkal
        Skeleton.methodReturned(); // lep
        Skeleton.methodReturned(); // leptet
    }

    // UC14: Autó csúszkálása ütközés nélkül
    static void runUseCase14() {
        String ucName = "Autó csúszkálása ütközés nélkül";
        Object[] obs = initUtkozesSzcenariot(ucName);
        Auto erkezoJarmu = (Auto) obs[4];
        Utszakasz uJelenlegi = (Utszakasz) obs[1];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("erkezoJarmu.lep()");
        Skeleton.methodCalled("erkezoJarmu.csuszkal()");
        boolean csuszikJegpancelen = Skeleton.askYesNo("Jégpáncélon csúszik?");
        if (csuszikJegpancelen) {
            uJelenlegi.csuszvaKovetkezoUtszakasz();
            boolean vanJarmu = Skeleton.askYesNo("Van jármű a célállomáson?");
            if (vanJarmu) {
                erkezoJarmu.utkozik();
            }
        }
        Skeleton.methodReturned(); // csuszkal
        Skeleton.methodReturned(); // lep
        Skeleton.methodReturned(); // leptet
    }

    // Helper for UC15/22 init
    private static Object[] initAutoScenario(String ucName) {
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("Auto");
        Auto a = new Auto("a");
        Skeleton.printNew("Utszakasz");
        Utszakasz uJelenlegi = new Utszakasz("uJelenlegi");
        Skeleton.printNew("Utszakasz");
        Utszakasz uCel = new Utszakasz("uCel");
        Skeleton.printNew("Ho");
        Ho ho = new Ho("ho");
        Skeleton.printNew("Jeg");
        Jeg jeg = new Jeg("jeg");
        Skeleton.printNew("Utvonal");
        Utvonal utvonal = new Utvonal("u");
        Skeleton.printInitCall("uJelenlegi.setHo(ho)");
        uJelenlegi.setHo(ho);
        Skeleton.printInitCall("uJelenlegi.setJeg(jeg)");
        uJelenlegi.setJeg(jeg);
        Skeleton.printInitCall("uJelenlegi.addKovetkezo(uCel)");
        uJelenlegi.addKovetkezo(uCel);
        Skeleton.printInitCall("a.setUtvonal(utvonal)");
        a.setUtvonal(utvonal);
        a.setJelenlegiUtszakasz(uJelenlegi);
        Skeleton.printInitCall("utvonal.setCel(uCel)");
        utvonal.setCel(uCel);
        v.addJarmu(a);
        v.addUtszakasz(uJelenlegi);
        return new Object[]{v, a, uJelenlegi, uCel, ho, jeg, utvonal};
    }

    // UC15: Hó letaposása és jégpáncél
    static void runUseCase15() {
        String ucName = "Hó letaposása és jégpáncél";
        Object[] obs = initAutoScenario(ucName);
        Varos v = (Varos) obs[0];
        Auto a = (Auto) obs[1];
        Utszakasz uJelenlegi = (Utszakasz) obs[2];
        Utszakasz uCel = (Utszakasz) obs[3];
        Ho ho = (Ho) obs[4];
        Jeg jeg = (Jeg) obs[5];
        Utvonal utvonal = (Utvonal) obs[6];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("uJelenlegi.hoEsik()");
        ho.novel(1);
        Skeleton.methodReturned();
        Skeleton.methodCalled("a.lep()");
        utvonal.getKivantUtszakasz();
        utvonal.kovetkezoUtszakasz(uCel);
        uJelenlegi.letapos();
        jeg.jegPancel();
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }

    // Helper for UC16/24 init
    private static Object[] initBuszScenario(String ucName) {
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("BuszvezetoJatekos");
        BuszvezetoJatekos bj = new BuszvezetoJatekos("bj");
        Skeleton.printNew("Busz");
        Busz b = new Busz("b");
        Skeleton.printNew("Utszakasz");
        Utszakasz u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        Utszakasz u2 = new Utszakasz("u2");
        Skeleton.printNew("Utvonal");
        Utvonal utvonal = new Utvonal("utvonal");
        Skeleton.printInitCall("u1.addKovetkezo(u2)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("b.utvonalBeallit(utvonal)");
        b.setVezeto(bj);
        bj.addBusz(b);
        utvonal.setCel(u2);
        b.setUtvonal(utvonal);
        b.setJelenlegiUtszakasz(u1);
        Skeleton.printInitCall("bj.addBusz(b)");
        v.addJarmu(b);
        v.addUtszakasz(u1);
        return new Object[]{v, bj, b, u1, u2, utvonal};
    }

    // UC16: Busz célba érése és pontszerzés
    static void runUseCase16() {
        String ucName = "Busz célba érése és pontszerzés";
        Object[] obs = initBuszScenario(ucName);
        Varos v = (Varos) obs[0];
        BuszvezetoJatekos bj = (BuszvezetoJatekos) obs[1];
        Busz b = (Busz) obs[2];
        Utszakasz u1 = (Utszakasz) obs[3];
        Utszakasz u2 = (Utszakasz) obs[4];
        Utvonal utvonal = (Utvonal) obs[5];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("u1.hoEsik()");
        Skeleton.methodReturned();
        Skeleton.methodCalled("b.lep()");
        utvonal.getKivantUtszakasz();
        Utszakasz kovetkezo = utvonal.kovetkezoUtszakasz(u2);
        if (kovetkezo == null) {
            // Elérte a végállomást
            bj.pontotKap();
        }
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }

    // Helper for UC17/18/19 init
    private static Object[] initVarosAutoScenario(String ucName) {
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("Utszakasz");
        Utszakasz u1 = new Utszakasz("u1");
        Skeleton.printNew("Utszakasz");
        Utszakasz u2 = new Utszakasz("u2");
        Skeleton.printNew("Auto");
        Auto a = new Auto("a");
        Skeleton.printNew("Ho");
        Ho ho = new Ho("ho");
        Skeleton.printNew("Utvonal");
        Utvonal utvonal = new Utvonal("utvonal");
        Skeleton.printInitCall("u1.setHo(ho)");
        u1.setHo(ho);
        Skeleton.printInitCall("u1.addKovetkezo(u2)");
        u1.addKovetkezo(u2);
        Skeleton.printInitCall("a.setUtvonal(utvonal)");
        a.setUtvonal(utvonal);
        a.setJelenlegiUtszakasz(u1);
        Skeleton.printInitCall("utvonal.setCel(u2)");
        utvonal.setCel(u2);
        v.addJarmu(a);
        v.addUtszakasz(u1);
        return new Object[]{v, u1, u2, a, ho, utvonal};
    }

    // UC17: Város léptetése és havazás
    static void runUseCase17() {
        String ucName = "Város léptetése és havazás";
        Object[] obs = initVarosAutoScenario(ucName);
        Varos v = (Varos) obs[0];
        Utszakasz u1 = (Utszakasz) obs[1];
        Utszakasz u2 = (Utszakasz) obs[2];
        Auto a = (Auto) obs[3];
        Ho ho = (Ho) obs[4];
        Utvonal utvonal = (Utvonal) obs[5];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("u1.hoEsik()");
        ho.novel(1);
        Skeleton.methodReturned();
        Skeleton.methodCalled("a.lep()");
        utvonal.getKivantUtszakasz();
        utvonal.kovetkezoUtszakasz(u2);
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }

    // UC18: Autó elakadása
    static void runUseCase18() {
        String ucName = "Autó elakadása";
        Object[] obs = initVarosAutoScenario(ucName);
        Varos v = (Varos) obs[0];
        Utszakasz u1 = (Utszakasz) obs[1];
        Utszakasz u2 = (Utszakasz) obs[2];
        Auto a = (Auto) obs[3];
        Ho ho = (Ho) obs[4];
        Utvonal utvonal = (Utvonal) obs[5];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("u1.hoEsik()");
        ho.novel(1);
        Skeleton.methodReturned();
        Skeleton.methodCalled("a.lep()");
        utvonal.getKivantUtszakasz();
        utvonal.kovetkezoUtszakasz(u2);
        boolean jarhato = Skeleton.askYesNo("Járható az út?");
        if (!jarhato) {
            // auto elakad
            System.out.println("\t\t\t[autó elakad]");
        }
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }

    // UC19: Játék vége ellenőrzés
    static void runUseCase19() {
        String ucName = "Játék vége ellenőrzés";
        Object[] obs = initVarosAutoScenario(ucName);
        Varos v = (Varos) obs[0];
        Auto a = (Auto) obs[3];

        Skeleton.startTest(ucName);
        v.jatekVegeEllenorzes();
    }

    // UC20: Takarító játékos pénzt szerez (Hányófej)
    static void runUseCase20() {
        String ucName = "Takarító játékos pénzt szerez (Hányófej)";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        Utszakasz jelenlegiUtszakasz = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        Ho jelenlegiHo = new Ho("jelenlegiHo");
        Skeleton.printNew("Hokotro");
        Hokotro hk = new Hokotro("hk");
        Skeleton.printNew("Hanyofej");
        Hanyofej hanyofej = new Hanyofej("hanyofej");
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        jelenlegiUtszakasz.setHo(jelenlegiHo);
        Skeleton.printInitCall("hk.setFej(hanyofej)");
        hk.setFej(hanyofej);
        Skeleton.printInitCall("hk.setVezeto(tj)");
        hk.setVezeto(tj);
        Skeleton.printInitCall("tj.hokotroHozzaadas(hk)");
        hk.setJelenlegiUtszakasz(jelenlegiUtszakasz);
        v.addJarmu(hk);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("hk.takarit()");
        hanyofej.munkatVegez(jelenlegiUtszakasz, hk);
        tj.penztKap(1);
        Skeleton.methodReturned();
    }

    // UC21: Hókotrófej csere
    static void runUseCase21() {
        String ucName = "Hókotrófej csere";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos tj = new TakaritoJatekos("tj");
        Skeleton.printNew("Utszakasz");
        Utszakasz u = new Utszakasz("u");
        Skeleton.printNew("Hokotro");
        Hokotro h = new Hokotro("h");
        Skeleton.printNew("Soszorofej");
        Soszorofej fej1 = new Soszorofej("fej1");
        Skeleton.printNew("Hanyofej");
        Hanyofej fej2 = new Hanyofej("fej2");
        Skeleton.printInitCall("h.setFej(fej1)");
        h.setFej(fej1);
        Skeleton.printInitCall("tj.hokotroHozzaadas(h)");
        h.setJelenlegiUtszakasz(u);
        v.addJarmu(h);

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("tj.iranyit()");
        h.fejetCserel(fej2);
        Skeleton.methodReturned();
    }

    // UC22: Autó célba érése
    static void runUseCase22() {
        String ucName = "Autó célba érése";
        Object[] obs = initAutoScenario(ucName);
        Varos v = (Varos) obs[0];
        Auto a = (Auto) obs[1];
        Utszakasz uJelenlegi = (Utszakasz) obs[2];
        Utszakasz uCel = (Utszakasz) obs[3];
        Utvonal utvonal = (Utvonal) obs[6];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("uJelenlegi.hoEsik()");
        Skeleton.methodReturned();
        Skeleton.methodCalled("a.lep()");
        utvonal.getKivantUtszakasz();
        Utszakasz kovetkezo = utvonal.kovetkezoUtszakasz(uCel);
        if (kovetkezo == null) {
            // Autó elérte a célt, eltávolítjuk
            v.removeJarmu(a);
            System.out.println("\t\t\t[autó eltávolítva a városból]");
        }
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }

    // UC23: Hókotró félreáll és elindul
    static void runUseCase23() {
        String ucName = "Hókotró félreáll és elindul";
        Skeleton.startInit(ucName);
        Skeleton.printNew("Varos");
        Varos v = new Varos("v");
        Skeleton.printNew("TakaritoJatekos");
        TakaritoJatekos takaritod = new TakaritoJatekos("takaritod");
        Skeleton.printNew("Utszakasz");
        Utszakasz jelenlegiUtszakasz = new Utszakasz("jelenlegiUtszakasz");
        Skeleton.printNew("Ho");
        Ho jelenlegiHo = new Ho("jelenlegiHo");
        Skeleton.printNew("Hokotro");
        Hokotro h = new Hokotro("h");
        Skeleton.printNew("Soszorofej");
        Soszorofej fej = new Soszorofej("fej");
        Skeleton.printInitCall("jelenlegiUtszakasz.setHo(jelenlegiHo)");
        jelenlegiUtszakasz.setHo(jelenlegiHo);
        Skeleton.printInitCall("h.fejetCserel(fej)");
        h.setFej(fej);
        Skeleton.printInitCall("takaritod.hokotroHozzaadas(h)");
        h.setJelenlegiUtszakasz(jelenlegiUtszakasz);
        v.addJarmu(h);

        Skeleton.startTest(ucName);
        // First leptet: hókotró félreáll
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("jelenlegiUtszakasz.hoEsik()");
        jelenlegiHo.novel(1);
        Skeleton.methodReturned();
        Skeleton.methodCalled("h.lep()");
        h.felreall();
        Skeleton.methodReturned();
        Skeleton.methodReturned();

        // Second leptet: hókotró folytatja munkáját
        h.setFelreallva(false);
        Skeleton.methodCalled("v.leptet()");
        Skeleton.methodCalled("jelenlegiUtszakasz.hoEsik()");
        jelenlegiHo.novel(1);
        Skeleton.methodReturned();
        Skeleton.methodCalled("h.lep()");
        fej.munkatVegez(jelenlegiUtszakasz, h);
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }

    // UC24: Busz indulása
    static void runUseCase24() {
        String ucName = "Busz indulása";
        Object[] obs = initBuszScenario(ucName);
        BuszvezetoJatekos bj = (BuszvezetoJatekos) obs[1];
        Busz b = (Busz) obs[2];
        Utszakasz u1 = (Utszakasz) obs[3];
        Utszakasz u2 = (Utszakasz) obs[4];
        Utvonal utvonal = (Utvonal) obs[5];

        Skeleton.startTest(ucName);
        Skeleton.methodCalled("bj.iranyit()");
        b.utvonalBeallit(utvonal);
        Skeleton.methodCalled("b.lep()");
        utvonal.getKivantUtszakasz();
        utvonal.kovetkezoUtszakasz(u2);
        Skeleton.methodReturned();
        Skeleton.methodReturned();
    }







    */
}
