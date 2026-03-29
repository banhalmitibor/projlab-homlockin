package homlockin;

public class Jegtorofej implements HokotroFej {

    @Override
    public String getName() { return "Jegtorofej"; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled("jegtorofej.munkatVegez(" + szakasz.getName() + ")");
        szakasz.jegTores();
        Skeleton.methodReturned();
    }
}
