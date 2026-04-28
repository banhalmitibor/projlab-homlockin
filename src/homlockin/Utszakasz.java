package homlockin;

import java.util.ArrayList;
import java.util.List;

public class Utszakasz {
    protected String name;
    protected Ho ho;
    protected Jeg jeg;
    protected Zuzalek zuzalek;
    protected Utszakasz jobbUt;
    protected boolean jarhatatlan;
    protected List<Utszakasz> kovetkezok = new ArrayList<>();
    protected Jarmu jarmu;
    protected boolean hoVedett = false; // pl. híd alatti útszakaszok számára

    public Utszakasz(String name) { 
        this.name = name; 
        this.ho = new Ho();
        this.jeg = new Jeg(this);
        this.zuzalek = new Zuzalek(this);
    }
    
    public Utszakasz() {
        this("");
    }

    public String getName() { return name; }

    public void setHovedett(boolean vedett) {
        this.hoVedett = vedett;
    }

    public void hoEsik() {
        if (!hoVedett) {
            ho.novel(1);
            // Zúzalék betemetése hó 4-es vagy nagyobb értéknél
            if (ho.getMennyiseg() >= 4 && zuzalek.vanZuzalek()) {
                zuzalek.eltemet();
            }
        }
    }

    public Utszakasz kovetkezoUtszakasz(Utszakasz cel) {
        // Alapértelmezett viselkedés: első a listából (a tényleges útvonal algoritmus külső lenne,
        // de az egyszerűség kedvéért és a tesztek miatt a jármű majd kezeli az utvonalát).
        if (!kovetkezok.isEmpty()) {
            return kovetkezok.get(0);
        }
        return jobbUt;
    }

    public Utszakasz getJobbraLevoSzakasz() {
        return jobbUt;
    }

    public Utszakasz csuszvaKovetkezoUtszakasz() {
        if (!kovetkezok.isEmpty()) return kovetkezok.get(0);
        return null;
    }

    public boolean jarhato() {
        if (jarhatatlan) return false;
        if (ho.magasHo()) return false;
        if (jarmu != null) return false;
        return true;
    }

    public void stepOn(Jarmu j) {
        // Ha jégpáncél van, a jármű csúszik. Ezt a jármű osztály lekezeli.
    }

    public void setJarmu(Jarmu j) { 
        this.jarmu = j; 
    }
    
    public Jarmu getJarmu() {
        return this.jarmu;
    }

    public void hoLesopres() {
        ho.eltakarit();
        jeg.eltakarit();
    }

    public void hoRasopres() {
        ho.novel(1);
    }
    
    public void zuzalekSzoras() {
        zuzalek.novel(1);
    }
    
    public void zuzalekRasopres() {
        zuzalekSzoras();
    }

    public void jegTores() {
        if (jeg.getMennyiseg() > 0) {
            jeg.jegetTor();
            // a feltört jég hóként viselkedik
        }
    }

    public void soSzoras() {
        ho.felsoz();
        jeg.felsoz();
    }

    public void olvasztas() {
        ho.eltakarit();
        jeg.eltakarit();
    }

    public void letapos() {
        if (ho.getMennyiseg() > 0) {
            ho.csokkent(1);
            jeg.novel(1);
        }
    }

    public void jarhatatlannaValik() {
        this.jarhatatlan = true;
    }

    public void setHo(Ho ho) { this.ho = ho; }
    public Ho getHo() { return ho; }

    public void setJeg(Jeg jeg) { this.jeg = jeg; }
    public Jeg getJeg() { return jeg; }
    
    public void setZuzalek(Zuzalek zuzalek) { this.zuzalek = zuzalek; }
    public Zuzalek getZuzalek() { return zuzalek; }

    public void setJobbUt(Utszakasz u) { this.jobbUt = u; }
    public Utszakasz getJobbUt() { return jobbUt; }

    public void addKovetkezo(Utszakasz u) { this.kovetkezok.add(u); }
    public List<Utszakasz> getKovetkezok() { return kovetkezok; }

}
