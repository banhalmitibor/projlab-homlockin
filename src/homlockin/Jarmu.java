package homlockin;

public abstract class Jarmu {
    protected String name;
    protected Utszakasz jelenlegiUtszakasz;
    protected Utvonal utvonal;

    public abstract void lep();

    public void utkozik() {
        Skeleton.methodCalled(name + ".utkozik()");
        Skeleton.methodReturned();
    }

    public void csuszkal() {
        Skeleton.methodCalled(name + ".csuszkal()");
        boolean utkozesVan = Skeleton.askYesNo("Ütközés van?");
        if (utkozesVan) {
            utkozik();
        }
        Skeleton.methodReturned();
    }

    // Silent setters
    public void setUtvonal(Utvonal u) { this.utvonal = u; }
    public void setJelenlegiUtszakasz(Utszakasz u) { this.jelenlegiUtszakasz = u; }
    public String getName() { return name; }
}
