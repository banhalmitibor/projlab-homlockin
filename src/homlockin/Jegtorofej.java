package homlockin;

public class Jegtorofej implements HokotroFej {
    private String name;
    private Hokotro hokotro;

    public Jegtorofej() { this.name = "jegtorofej"; }
    public Jegtorofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.jegTores();
        Skeleton.methodReturned();
    }

    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}

