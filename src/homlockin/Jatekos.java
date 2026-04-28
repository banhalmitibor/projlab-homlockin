package homlockin;

public abstract class Jatekos {
    protected String nev;

    public Jatekos(String nev) {
        this.nev = nev;
    }

    public String getNev() { return nev; }

    public abstract void iranyit(Jarmu jarmu, Utszakasz utszakasz);
}
