package homlockin;

public class Utvonal {
    private String name;
    private Utszakasz cel;

    public Utvonal() {}
    public Utvonal(String name) { this.name = name; }

    public Utszakasz getKivantUtszakasz() {
        Skeleton.methodCalled("utvonal.getKivantUtszakasz()");
        Skeleton.methodReturned();
        return cel;
    }

    public Utszakasz kovetkezoUtszakasz(Utszakasz csonk) {
        Skeleton.methodCalled("utvonal.kovetkezoUtszakasz(" + (csonk != null ? csonk.getName() : "null") + ")");
        boolean celElert = Skeleton.askYesNo("Elérte a célállomást?");
        Utszakasz result = celElert ? null : cel;
        Skeleton.methodReturned();
        return result;
    }

    // Silent setter
    public void setCel(Utszakasz u) { this.cel = u; }
    public Utszakasz getCel() { return cel; }
    public String getName() { return name; }
}
