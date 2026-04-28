package homlockin;

public class Soprofej implements HokotroFej {
    private Hokotro hokotro;

    @Override
    public String getName() { return "sopro"; }

    @Override
    public void munkatVegez(Utszakasz szakasz) {
        szakasz.hoLesopres(); // this will also do the right shift inside Utszakasz, wait! Actually the Utszakasz methods say: "hoLesopres(): eltünteti az útszakaszról", "hoRasopres()": rásöpri a havat. 
        // Wait, how does it move it right? It's better if Soprofej gets the right section and pushes it.
        Utszakasz jobb = szakasz.getJobbraLevoSzakasz();
        // Read snow, zuza amount
        int snow = (szakasz.getHo() != null) ? szakasz.getHo().getMennyiseg() : 0;
        boolean hasZuz = (szakasz.getZuzalek() != null && szakasz.getZuzalek().vanZuzalek());
        
        szakasz.hoLesopres(); 
        
        if (jobb != null) {
            for (int i=0; i<snow; i++) {
                jobb.hoRasopres();
            }
            if (hasZuz) {
                jobb.zuzalekRasopres();
            }
        }
    }

    @Override
    public void setHokotro(Hokotro hk) { this.hokotro = hk; }
}
