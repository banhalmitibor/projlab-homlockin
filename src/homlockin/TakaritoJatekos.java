package homlockin;

import java.util.ArrayList;
import java.util.List;

public class TakaritoJatekos extends Jatekos {
    private List<Hokotro> hokotrok = new ArrayList<>();
    private Bolt bolt;
    private int penz = 1000;

    public TakaritoJatekos() {}
    public TakaritoJatekos(String name) { this.name = name; }

    public void penztKap(int osszeg) {
        Skeleton.methodCalled(name + ".penztKap(" + osszeg + ")");
        penz += osszeg;
        Skeleton.methodReturned();
    }

    public void vasarol() {
        Skeleton.methodCalled(name + ".vasarol()");
        if (bolt != null && !hokotrok.isEmpty()) {
            bolt.sotVasarol(this, hokotrok.get(0));
        } else if (bolt != null) {
            bolt.hokotrotVasarol(this);
        }
        Skeleton.methodReturned();
    }

    public int getPenz() {
        Skeleton.methodCalled(name + ".getPenz()");
        Skeleton.methodReturned();
        return penz;
    }

    public void penztLevon(int ar) {
        Skeleton.methodCalled(name + ".penztLevon(" + ar + ")");
        penz -= ar;
        Skeleton.methodReturned();
    }

    @Override
    public void iranyit() {
        Skeleton.methodCalled(name + ".iranyit()");
        Skeleton.methodReturned();
    }

    public void hokotroHozzaadas(Hokotro hokotro) {
        Skeleton.methodCalled(name + ".hokotroHozzaadas(hokotro)");
        hokotrok.add(hokotro);
        Skeleton.methodReturned();
    }

    // Silent setters
    public void setBolt(Bolt b) { this.bolt = b; }
    public List<Hokotro> getHokotrok() { return hokotrok; }
    public int getPenzErtek() { return penz; }
}
