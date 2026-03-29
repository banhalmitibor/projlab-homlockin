package homlockin;

public abstract class Jarmu {
    protected String name;
    protected Utszakasz jelenlegiUtszakasz;
    protected Utvonal utvonal;

    public abstract void lep();

    public void utkozes(Jarmu j2) {
        Skeleton.methodCalled(name + ".utkozik()");
        Skeleton.methodReturned();
    }

    public void csuszkal() {
        Skeleton.methodCalled(name + ".csuszkal()");
        boolean utkozesVan = Skeleton.askYesNo("Ütközés van?");
        if (utkozesVan) {
            //utkozes();
        }
        Skeleton.methodReturned();
    }

    public boolean beertAVegallomasba(){
        Skeleton.methodCalled(name + ".beertAVegallomasba()");
        boolean result = Skeleton.askYesNo("Elért az autó a végállomásra?");
        Skeleton.methodReturned();
        return result;
    }

    // Silent setters
    public void setUtvonal(Utvonal u) { this.utvonal = u; }
    public void setJelenlegiUtszakasz(Utszakasz u) { this.jelenlegiUtszakasz = u; }
    public String getName() { return name; }
}
