package homlockin;

public class Bolt {
    private String name;

    public Bolt() {}
    public Bolt(String name) { this.name = name; }

    public void hokotrotVasarol(TakaritoJatekos jatekos) {
        Skeleton.methodCalled(name + ".hokotrotVasarol(jatekos)");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz hókotróra?");
        if (elegPenz) {
            Skeleton.printNew("Hokotro");
            Hokotro ujHk = new Hokotro("ujHk");
            jatekos.hokotroHozzaadas(ujHk);
            jatekos.penztLevon(500);
        }
        Skeleton.methodReturned();
    }

    public void sotVasarol(TakaritoJatekos jatekos, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".sotVasarol(jatekos, hokotro)");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz sóra?");
        if (elegPenz) {
            jatekos.penztLevon(100);
            hokotro.soFeltoltes();
        }
        Skeleton.methodReturned();
    }

    public void biokerozintVasarol(TakaritoJatekos jatekos, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".biokerozintVasarol(jatekos, hokotro)");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz biokerozinra?");
        if (elegPenz) {
            jatekos.penztLevon(200);
            hokotro.biokerozinFeltoltes();
        }
        Skeleton.methodReturned();
    }

    public void hokotroFejetVasarol(TakaritoJatekos jatekos, Hokotro hokotro, String fejTipus) {
        Skeleton.methodCalled(name + ".hokotroFejetVasarol(jatekos, hokotro, \"" + fejTipus + "\")");
        jatekos.getPenz();
        boolean elegPenz = Skeleton.askYesNo("Van elég pénz hókotrófejre?");
        if (elegPenz) {
            HokotroFej ujFej;
            switch (fejTipus) {
                case "Soszoro": ujFej = new Soszorofej(); break;
                case "Hanyofej": ujFej = new Hanyofej(); break;
                case "Jegtorofej": ujFej = new Jegtorofej(); break;
                case "Sarkanyfej": ujFej = new Sarkanyfej(); break;
                default: ujFej = new Soprofej(); break;
            }
            Skeleton.printNew(fejTipus);
            jatekos.penztLevon(300);
            hokotro.fejetCserel(ujFej);
        }
        Skeleton.methodReturned();
    }
}
