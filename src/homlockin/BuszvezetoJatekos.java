package homlockin;

public class BuszvezetoJatekos extends Jatekos {
    private int pontszam;
    private Busz vezeti;

    public BuszvezetoJatekos(String nev) {
        super(nev);
        this.pontszam = 0;
    }

    public int getPontszam() { return pontszam; }
    
    public void pontotKap(int pont) {
        this.pontszam += pont;
    }

    public Busz getVezeti() { return vezeti; }

    public void setVezeti(Busz b) {
        this.vezeti = b;
    }

    @Override
    public void iranyit(Jarmu jarmu, Utszakasz utszakasz) {
        if (this.vezeti == jarmu) {
            jarmu.getUtvonala().addUtszakasz(utszakasz);
        }
    }
}
