package homlockin;

/**
 * A {@code Soprofej} osztály a söprőfejjel való hókotró takarítást valósítja meg.
 * A havat áthelyezi az eggyel jobbra lévő sávba. Ha az út egysávos (nincs jobbra
 * szomszédos sáv), áthelyezi a havat az út szélére – azaz eltünteti az útszakaszról.
 * Megvalósítja a {@link HokotroFej} interfészt.
 */
public class Soprofej implements HokotroFej {

    /** A söprőfej neve azonosítási célokra. */
    private String name;

    /** Az a hókotró, amelyre ez a söprőfej van felszerelve. */
    private Hokotro hokotro;

    /**
     * Alapértelmezett konstruktor. Létrehoz egy alapértelmezett nevű söprőfejet.
     */
    public Soprofej() { this.name = "soprofej"; }

    /**
     * Névvel ellátott söprőfejet hoz létre.
     *
     * @param name a söprőfej neve
     */
    public Soprofej(String name) { this.name = name; }

    /**
     * Visszaadja a söprőfej nevét.
     *
     * @return a söprőfej neve
     */
    @Override
    public String getName() { return name; }

    /**
     * A söprőfejjel való takarítás elvégzése. Lesöpri a havat az aktuális
     * útszakaszról, majd rásöpri a jobbra szomszédos sávra. Ha nincs jobbra
     * szomszédos sáv (egysávos út), a hó eltűnik az útszakaszról.
     *
     * @param szakasz az az {@link Utszakasz}, amelyen a söprést végzik
     */
    @Override
    public void munkatVegez(Utszakasz szakasz) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.hoLesopres();
        Utszakasz jobbUt = szakasz.getJobbUt();
        if (jobbUt != null) {
            jobbUt.hoRasopres();
        }
        Skeleton.methodReturned();
    }

    /**
     * Beállítja azt a hókotró járművet, amelyre ez a söprőfej fel van szerelve.
     *
     * @param hk az a {@link Hokotro}, amelyre a söprőfej kerül
     */
    @Override
    public void setHokotro(Hokotro hk){
        hokotro = hk;
    }
}
