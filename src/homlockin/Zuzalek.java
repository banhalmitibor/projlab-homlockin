package homlockin;

public class Zuzalek extends Csapadek {

    private Utszakasz utszakasz;

    public Zuzalek(Utszakasz u) {
        super();
        this.utszakasz = u;
        this.maxSzint = 1;
    }

    public void eltemet() {
        this.eltakarit();
    }

    public boolean vanZuzalek() {
        return this.mennyiseg > 0;
    }
}
