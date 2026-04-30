package homlockin;

public class BuszvezetoJatekos extends Jatekos {
    private int pontszam;
    private Busz vezeti;

    private Utszakasz vegallomas1;
    private Utszakasz vegallomas2;

    public BuszvezetoJatekos(String nev, Utszakasz v1, Utszakasz v2) {
        super(nev);
        this.pontszam = 0;
        this.vegallomas1 = v1;
        this.vegallomas2 = v2;
    }

    public Utszakasz getVegallomas1() { return vegallomas1; }
    public Utszakasz getVegallomas2() { return vegallomas2; }

    public int getPontszam() { return pontszam; }
    
    public void pontotKap() {
        this.pontszam += 5;
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
