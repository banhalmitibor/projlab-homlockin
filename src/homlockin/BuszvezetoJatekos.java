package homlockin;

public class BuszvezetoJatekos extends Jatekos {
    private Busz busz;
    private int pontszam;

    public BuszvezetoJatekos() {}
    public BuszvezetoJatekos(String name) { this.name = name; }

    public void pontotKap() {
        Skeleton.methodCalled(name + ".pontotKap()");
        pontszam++;
        Skeleton.methodReturned();
    }

    @Override
    public void iranyit() {
        Skeleton.methodCalled(name + ".iranyit()");
        if (busz != null) {
            Utvonal ut = new Utvonal("utvonal");
            busz.utvonalBeallit(ut);
            busz.lep();
        }
        Skeleton.methodReturned();
    }

    // Silent setter
    public void addBusz(Busz b) { this.busz = b; }
    public Busz getBusz() { return busz; }
}
