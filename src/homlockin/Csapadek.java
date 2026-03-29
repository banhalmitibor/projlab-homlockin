package homlockin;

public abstract class Csapadek {
    protected String name;
    protected int mennyiseg;
    protected int maxSzint;
    protected int olvadasIdo;

    public Csapadek() {}
    public Csapadek(String name) { this.name = name; }

    public String getName() { return name; }

    public void novel(int mennyiseg) {
        Skeleton.methodCalled(name + ".novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled(name + ".csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    public void eltakarit() {
        Skeleton.methodCalled(name + ".eltakarit()");
        Skeleton.methodReturned();
    }

    public void felsoz() {
        Skeleton.methodCalled(name + ".felsoz()");
        Skeleton.methodReturned();
    }
}
