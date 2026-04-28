package homlockin;

public class Jeg extends Csapadek {
    private boolean feltort;
    private Utszakasz vanRajta;

    public Jeg(Utszakasz vanRajta) {
        super();
        this.vanRajta = vanRajta;
        this.maxSzint = 5;
        this.feltort = false;
    }

    public void jegetTor() {
        this.feltort = true;
    }

    public boolean isFeltort() {
        return feltort;
    }

    public void setFeltort(boolean feltort) {
        this.feltort = feltort;
    }

    public boolean jegPancel() {
        return this.mennyiseg >= 4 && !this.feltort;
    }
}
