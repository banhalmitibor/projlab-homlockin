package homlockin;

import java.util.List;

public class Utvonal {
    private String name;
    private List<Utszakasz> vonal;
    private Utszakasz cel;

    public Utvonal() {}
    public Utvonal(String name) { this.name = name; }

    public Utszakasz getKivantUtszakasz() {
        Skeleton.methodCalled(name + ".getKivantUtszakasz()");
        Skeleton.methodReturned();
        return cel;
    }

    

    // Silent setter
    public void setCel(Utszakasz u) { this.cel = u; }
    public Utszakasz getCel() { return cel; }
    public String getName() { return name; }
}
