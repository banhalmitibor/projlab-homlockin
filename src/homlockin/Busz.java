package homlockin;

public class Busz extends Jarmu {
    private BuszvezetoJatekos vezeto;
    private Utszakasz vegallomas1;
    private Utszakasz vegallomas2;
    private int elakadasVisszaszamlalo;

    public Busz() {}
    public Busz(String name) { this.name = name; }

    @Override
    public void lep() {
        Skeleton.methodCalled(name + ".lep()");
        if (utvonal != null) {
            Utszakasz cel = utvonal.getKivantUtszakasz();
            if (cel != null) {
                jelenlegiUtszakasz.kovetkezoUtszakasz(cel);
                boolean vegallomas = Skeleton.askYesNo("Elérte a végállomást?");
                if (vegallomas && vezeto != null) {
                    vezeto.pontotKap();
                }
            }
        }
        Skeleton.methodReturned();
    }

    @Override
    public void utkozes(Jarmu j2) {
        Skeleton.methodCalled(name + ".utkozik()");
        Skeleton.methodReturned();
    }

    public void utvonalBeallit(Utvonal u) {
        Skeleton.methodCalled(name + ".utvonalBeallit(" + (u != null ? u.getName() : "null") + ")");
        this.utvonal = u;
        Skeleton.methodReturned();
    }

    // Silent setters
    public void setVezeto(BuszvezetoJatekos v) { this.vezeto = v; }
    public void setVegallomas1(Utszakasz u) { this.vegallomas1 = u; }
    public void setVegallomas2(Utszakasz u) { this.vegallomas2 = u; }
}
