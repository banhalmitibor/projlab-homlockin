package homlockin;

public class Hid extends Utszakasz {
    private Utszakasz alattaMego;

    public Hid() {}
    public Hid(String name) { super(name); }

    @Override
    public void hoEsik() {
        Skeleton.methodCalled(name + ".hoEsik()");
        // Híd védi az alatta lévő útszakaszt a hótól
        if (ho != null) {
            ho.novel(1);
        }
        Skeleton.methodReturned();
    }

    public void setAlattaMego(Utszakasz u) { this.alattaMego = u; }
    public Utszakasz getAlattaMego() { return alattaMego; }
}
