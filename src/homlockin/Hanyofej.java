package homlockin;

public class Hanyofej implements HokotroFej {

    @Override
    public String getName() { return "Hanyofej"; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled("hanyofej.munkatVegez(" + szakasz.getName() + ")");
        szakasz.hoLesopres();
        Skeleton.methodReturned();
    }
}
