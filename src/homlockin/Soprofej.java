package homlockin;

public class Soprofej implements HokotroFej {
    private Hokotro hokotro;

    @Override
    public String getName() { return "sopro"; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Utszakasz jobb = szakasz.getJobbraLevoSzakasz();
        
        // Először megnézzük van-e hó vagy zúzalék amit söpörhetünk
        int hoMennyiseg = (szakasz.getHo() != null) ? szakasz.getHo().getMennyiseg() : 0;
        int zuzMennyiseg = (szakasz.getZuzalek() != null && szakasz.getZuzalek().vanZuzalek()) ? 1 : 0;
        int jegMennyiseg = (szakasz.getJeg() != null && szakasz.getJeg().isFeltort()) ? szakasz.getJeg().getMennyiseg() : 0;

        // Lesöpörjük az aktuális szakaszról
        szakasz.hoLesopres();
        
        // Ha van jobbra szakasz, rásöpörjük
        if (jobb != null) {
            if (hoMennyiseg > 0) jobb.hoRasopres(hoMennyiseg);
            if (zuzMennyiseg > 0) jobb.zuzalekRasopres(zuzMennyiseg);
            if (jegMennyiseg > 0) {
                jobb.getJeg().novel(jegMennyiseg);
                jobb.getJeg().setFeltort(true);
            }
        }
    }

    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
