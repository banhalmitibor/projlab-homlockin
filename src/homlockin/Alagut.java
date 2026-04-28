package homlockin;

public class Alagut extends Utszakasz {
    public Alagut() {
        super();
    }
    public Alagut(String name) {
        super(name);
    }
    
    @Override
    public void hoEsik() {
        // Alagútban nem esik a hó, ezért a metódus üres vagy direkt return.
        return;
    }
}
