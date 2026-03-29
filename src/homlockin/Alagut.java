package homlockin;

public class Alagut extends Utszakasz {
    public Alagut() {}
    public Alagut(String name) { super(name); }

    @Override
    public void hoEsik() {
        Skeleton.methodCalled(name + ".hoEsik()");
        // Alagútban nem esik hó
        Skeleton.methodReturned();
    }
}
