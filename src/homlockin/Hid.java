package homlockin;

public class Hid extends Utszakasz {
    private Utszakasz alattaMegy;

    public Hid() {
        super();
    }
    public Hid(String name) {
        super(name);
    }

    public void setAlattaMegy(Utszakasz u) {
        if (this.alattaMegy != null) {
            this.alattaMegy.setHovedett(false);
        }
        this.alattaMegy = u;
        if (this.alattaMegy != null) {
            this.alattaMegy.setHovedett(true);
        }
    }

    public Utszakasz getAlattaMegy() {
        return alattaMegy;
    }
    
    // A feladat köv. kikötése van: "A híd felületére esik a hó, de az alatta lévő útszakaszt megvédi a havazástól.
    // Ha egy hókotró letolja a hídról a havat az eltűnik."
    // Tehát ha valaki lekéri a jobbra lévőt, hogy rásöpröljön hókotróval, itt null-t adunk vissza, 
    // így el fog tűnni (mint az igazi letolásnál a folyóba vagy a semmibe)
    @Override
    public Utszakasz getJobbraLevoSzakasz() {
        return null;
    }
}
