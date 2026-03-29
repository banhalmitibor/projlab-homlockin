package homlockin;

public class Jeg extends Csapadek {
    private boolean feltort;

    public Jeg() {}
    public Jeg(String name) { super(name); }

    public void jegetTor() {
        Skeleton.methodCalled(name + ".jegetTor()");
        feltort = true;
        Skeleton.methodReturned();
    }

    public boolean jegPancel() {
        Skeleton.methodCalled(name + ".jegPancel()");
        boolean result = Skeleton.askYesNo("Jégpáncél alakult ki?");
        Skeleton.methodReturned();
        return result;
    }

    @Override
    public void eltakarit() {
        Skeleton.methodCalled(name + ".eltakarit()");
        Skeleton.methodReturned();
    }

    @Override
    public void novel(int mennyiseg) {
        Skeleton.methodCalled(name + ".novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    @Override
    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled(name + ".csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    @Override
    public void felsoz() {
        Skeleton.methodCalled(name + ".felsoz()");
        Skeleton.methodReturned();
    }
}
