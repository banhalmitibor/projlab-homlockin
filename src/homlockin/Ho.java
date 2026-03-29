package homlockin;

public class Ho extends Csapadek {

    public boolean magasHo() {
        Skeleton.methodCalled("magasHo()");
        boolean result = Skeleton.askYesNo("Magas hó?");
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
