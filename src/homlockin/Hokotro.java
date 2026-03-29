package homlockin;

public class Hokotro extends Jarmu {
    private HokotroFej fej;
    private int soMennyiseg;
    private int bioKerozinMennyiseg;
    private TakaritoJatekos vezeto;
    private boolean felreallva;

    public Hokotro() {}
    public Hokotro(String name) { this.name = name; }

    @Override
    public void lep() {
        Skeleton.methodCalled(name + ".lep()");
        if (!felreallva && fej != null && jelenlegiUtszakasz != null) {
            fej.munkatVegez(jelenlegiUtszakasz);
        } else if (felreallva) {
            felreall();
        }
        Skeleton.methodReturned();
    }

    public void takarit() {
        Skeleton.methodCalled(name + ".takarit()");
        if (fej != null && jelenlegiUtszakasz != null) {
            fej.munkatVegez(jelenlegiUtszakasz);
        }
        if (vezeto != null) {
            vezeto.penztKap(1);
        }
        Skeleton.methodReturned();
    }

    public void fejetCserel(HokotroFej ujFej) {
        Skeleton.methodCalled(name + ".fejetCserel(" + (ujFej != null ? ujFej.getName() : "null") + ")");
        this.fej = ujFej;
        Skeleton.methodReturned();
    }

    public void felreall() {
        Skeleton.methodCalled(name + ".felreall()");
        this.felreallva = true;
        Skeleton.methodReturned();
    }

    public boolean soFogyasztas(int mennyiseg) {
        Skeleton.methodCalled(name + ".soFogyasztas(" + mennyiseg + ")");
        boolean result = Skeleton.askYesNo("Van elég só?");
        Skeleton.methodReturned();
        return result;
    }

    public void soFeltoltes() {
        Skeleton.methodCalled(name + ".soFeltoltes()");
        Skeleton.methodReturned();
    }

    public boolean biokerozinFogyasztas(int mennyiseg) {
        Skeleton.methodCalled(name + ".biokerozinFogyasztas(" + mennyiseg + ")");
        boolean result = Skeleton.askYesNo("Van elég biokerozin?");
        Skeleton.methodReturned();
        return result;
    }

    public void biokerozinFeltoltes() {
        Skeleton.methodCalled(name + ".biokerozinFeltoltes()");
        Skeleton.methodReturned();
    }

    public void utvonalBeallit(Utvonal u) {
        Skeleton.methodCalled(name + ".utvonalBeallit(" + (u != null ? u.getName() : "null") + ")");
        this.utvonal = u;
        Skeleton.methodReturned();
    }

    // Silent setters
    public void setFej(HokotroFej f) { this.fej = f; }
    public void setVezeto(TakaritoJatekos tj) { this.vezeto = tj; }
    public void setFelreallva(boolean f) { this.felreallva = f; }
}
