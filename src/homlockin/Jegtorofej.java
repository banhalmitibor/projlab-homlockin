package homlockin;

public class Jegtorofej implements HokotroFej {
    private Hokotro hokotro;

    @Override
    public String getName() { return "jegtoro"; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        szakasz.jegTores();
    }

    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
