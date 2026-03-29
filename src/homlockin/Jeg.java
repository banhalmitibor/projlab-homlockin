package homlockin;

public class Jeg extends Csapadek {
    private boolean feltort;

    public void jegetTor() {
        Skeleton.methodCalled("jegetTor()");
        Skeleton.methodReturned();
    }

    public boolean jegPancel() {
        Skeleton.methodCalled("jegPancel()");
        boolean result = Skeleton.askYesNo("Jégpáncél alakult ki?");
        Skeleton.methodReturned();
        return result;
    }

    @Override
    public void eltakarit() {
        Skeleton.methodCalled("eltakarit()");
        Skeleton.methodReturned();
    }

    @Override
    public void novel(int mennyiseg) {
        Skeleton.methodCalled("novel(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    @Override
    public void csokkent(int mennyiseg) {
        Skeleton.methodCalled("csokkent(" + mennyiseg + ")");
        Skeleton.methodReturned();
    }

    @Override
    public void felsoz() {
        Skeleton.methodCalled("felsoz()");
        Skeleton.methodReturned();
    }
}
