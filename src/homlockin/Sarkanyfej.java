package homlockin;

public class Sarkanyfej implements HokotroFej {

    @Override
    public String getName() { return "Sarkanyfej"; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled("sarkanyfej.munkatVegez(" + szakasz.getName() + ", hokotro)");
        hokotro.biokerozinFogyasztas(1);
        szakasz.olvasztas();
        Skeleton.methodReturned();
    }
}
