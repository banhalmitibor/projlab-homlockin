package homlockin;

public class Bolt {
    private String name;

    public Bolt() {}
    public Bolt(String name) { this.name = name; }

    public String getName() { return name; }

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
