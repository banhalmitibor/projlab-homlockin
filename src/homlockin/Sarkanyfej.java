package homlockin;

public class Sarkanyfej implements HokotroFej {
    private String name;
    private Hokotro hokotro;

    public Sarkanyfej() { this.name = "sarkanyfej"; }
    public Sarkanyfej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        hokotro.biokerozinFogyasztas(1);
        szakasz.olvasztas();
        Skeleton.methodReturned();
    }

    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
