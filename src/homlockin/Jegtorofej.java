package homlockin;

public class Jegtorofej implements HokotroFej {
    private String name;

    public Jegtorofej() { this.name = "jegtorofej"; }
    public Jegtorofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.jegTores();
        Skeleton.methodReturned();
    }
}
