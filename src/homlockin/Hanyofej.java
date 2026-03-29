package homlockin;

public class Hanyofej implements HokotroFej {
    private String name;

    public Hanyofej() { this.name = "hanyofej"; }
    public Hanyofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.hoLesopres();
        Skeleton.methodReturned();
    }
}
