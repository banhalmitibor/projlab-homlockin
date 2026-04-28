package homlockin;

public class Hanyofej implements HokotroFej {
    private Hokotro hokotro;

    @Override
    public String getName() { return "hanyo"; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        szakasz.hoLesopres(); 
    }

    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
