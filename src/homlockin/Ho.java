package homlockin;

public class Ho extends Csapadek {

    public Ho() {}
    public Ho(String name) { super(name); }

    public boolean magasHo() {
        Skeleton.methodCalled(name + ".magasHo()");
        boolean result = Skeleton.askYesNo("Magas hó?");
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
