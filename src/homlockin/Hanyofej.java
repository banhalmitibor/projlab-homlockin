package homlockin;

public class Hanyofej implements HokotroFej {
    private String name;
    private Hokotro hokotro;

    public Hanyofej() { this.name = "hanyofej"; }
    public Hanyofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.hoLesopres();
        Skeleton.methodReturned();
    }

    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
