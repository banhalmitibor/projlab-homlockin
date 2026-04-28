package homlockin;

public class Soszorofej implements HokotroFej {
    private Hokotro hokotro;

    @Override
    public String getName() { return "soszoro"; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        if (hokotro != null && hokotro.soFogyasztas(1)) {
            szakasz.soSzoras();
        }
    }

    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
