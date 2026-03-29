package homlockin;

public abstract class Csapadek {
    protected int mennyiseg;
    protected int maxSzint;
    protected int olvadasIdo;

    public void novel(int mennyiseg) {
        Skeleton.methodCalled("novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled("csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    public void eltakarit() {
        Skeleton.methodCalled("eltakarit()");
        Skeleton.methodReturned();
    }

    public void felsoz() {
        Skeleton.methodCalled("felsoz()");
        Skeleton.methodReturned();
    }
}
