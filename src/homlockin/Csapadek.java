package homlockin;

public abstract class Csapadek {

    protected int mennyiseg;
    protected int maxSzint;
    protected int olvadasIdo;

    public Csapadek() {
        this.mennyiseg = 0;
        this.olvadasIdo = 0;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
        if (this.mennyiseg > maxSzint) {
            this.mennyiseg = maxSzint;
        } else if (this.mennyiseg < 0) {
            this.mennyiseg = 0;
        }
    }

    public void novel(int mennyiseg) {
        this.mennyiseg += mennyiseg;
        if (this.mennyiseg > maxSzint) {
            this.mennyiseg = maxSzint;
        }
    }

    public void csokkent(int mennyiseg) {
        this.mennyiseg -= mennyiseg;
        if (this.mennyiseg < 0) {
            this.mennyiseg = 0;
        }
    }

    public void eltakarit() {
        this.mennyiseg = 0;
    }

    public void felsoz() {
        if (this.mennyiseg > 0) {
            this.csokkent(1); // Sózás folyamatosan csökkenti a jeget/havat
        }
    }
}
