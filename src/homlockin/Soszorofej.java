package homlockin;

public class Soszorofej implements HokotroFej {
    private String name;

    public Soszorofej() { this.name = "soszorofej"; }
    public Soszorofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        hokotro.soFogyasztas(1);
        szakasz.soSzoras();
        Skeleton.methodReturned();
    }
}
