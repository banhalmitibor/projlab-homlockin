package homlockin;

public class Zuzalekfej implements HokotroFej {
    private Hokotro hokotro;

    @Override
    public String getName() { return "zuzalek"; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        if (hokotro != null && hokotro.zuzalekFogyasztas(1)) {
            szakasz.zuzalekSzoras(); 
        }
    }

    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
