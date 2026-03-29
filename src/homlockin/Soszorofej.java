package homlockin;

public class Soszorofej implements HokotroFej {
    private String name;
    public Hokotro hokotro;

    public Soszorofej() { this.name = "soszorofej"; }
    public Soszorofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        hokotro.soFogyasztas(1);
        szakasz.soSzoras();
        Skeleton.methodReturned();
    }

    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
