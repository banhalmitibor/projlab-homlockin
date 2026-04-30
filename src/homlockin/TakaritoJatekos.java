package homlockin;

import java.util.ArrayList;
import java.util.List;

public class TakaritoJatekos extends Jatekos {
    private List<Hokotro> vezeti;
    private Bolt vasarol;
    private int penz;

    public TakaritoJatekos(String nev) {
        super(nev);
        this.vezeti = new ArrayList<>();
        this.penz = 1000; // As per doc: "játékosok kezdő pénze: 1000"
    }

    public List<Hokotro> getHokotroi() { return vezeti; }

    public void hokotroHozzaadas(Hokotro hk) {
        this.vezeti.add(hk);
    }

    public void setBolt(Bolt bolt) {
        this.vasarol = bolt;
    }

    public int getPenz() { return penz; }

    public void penztKap(int osszeg) {
        this.penz += osszeg;
    }

    public void penztLevon(int osszeg) {
        this.penz -= osszeg;
    }

    @Override
    public void iranyit(Jarmu jarmu, Utszakasz utszakasz) {
        if (vezeti.contains(jarmu)) {
            jarmu.getUtvonala().addUtszakasz(utszakasz);
        }
    }
}
