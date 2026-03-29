package homlockin;

public class Soszorofej implements HokotroFej {

    @Override
    public String getName() { return "Soszorofej"; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled("soszorofej.munkatVegez(" + szakasz.getName() + ", hokotro)");
        hokotro.soFogyasztas(1);
        szakasz.soSzoras();
        Skeleton.methodReturned();
    }
}
