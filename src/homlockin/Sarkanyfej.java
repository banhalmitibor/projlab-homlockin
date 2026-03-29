package homlockin;

public class Sarkanyfej implements HokotroFej {
    private String name;

    public Sarkanyfej() { this.name = "sarkanyfej"; }
    public Sarkanyfej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        hokotro.biokerozinFogyasztas(1);
        szakasz.olvasztas();
        Skeleton.methodReturned();
    }
}
