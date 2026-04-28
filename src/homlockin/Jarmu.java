package homlockin;

public abstract class Jarmu {
    protected String id;
    protected Utszakasz allRajta;
    protected Utvonal utvonala;

    public Jarmu(String id) {
        this.id = id;
        this.utvonala = new Utvonal();
    }

    public String getId() { return id; }

    public Utszakasz getAllRajta() { return allRajta; }

    public void setAllRajta(Utszakasz u) {
        if (this.allRajta != null) {
            this.allRajta.setJarmu(null);
        }
        this.allRajta = u;
        if (this.allRajta != null) {
            this.allRajta.setJarmu(this);
        }
    }

    public Utvonal getUtvonala() { return utvonala; }

    public void setUtvonala(Utvonal u) { this.utvonala = u; }

    public void leptetUtvonal() {
        if (utvonala != null) {
            utvonala.leptet();
        }
    }

    public abstract void lep();
    public abstract void utkozik();
    public abstract void csuszkal();
}
