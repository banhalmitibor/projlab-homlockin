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
            if (zuzalek.vanZuzalek()) {
                zuzalek.eltemet();
            }
        }
    }

    public Utszakasz kovetkezoUtszakasz(Utszakasz wanted) {
        if (!kovetkezok.isEmpty()) {
            if(kovetkezok.contains(wanted))
                return wanted;
            return kovetkezok.get(0);
        }
        return null;
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

    public void setJarmu(Jarmu j) { 
        this.jarmu = j; 
    }
    
    public Jarmu getJarmu() {
        return this.jarmu;
    }

    public void hoLesopres() {
        ho.eltakarit();
        zuzalek.eltakarit();
        if (jeg.isFeltort()) {
            jeg.eltakarit();
        }
    }

    public void hoRasopres(int amount) {
        ho.novel(amount);
    }
    
    public void zuzalekSzoras() {
        zuzalek.novel(1);
    }
    
    public void zuzalekRasopres(int amount) {
        zuzalek.novel(amount);
    }

    public void jegTores() {
        if (jeg.getMennyiseg() > 0) {
            jeg.jegetTor();
        }
    }

    public void soSzoras() {
        if (ho.getMennyiseg() > 0) {
            ho.csokkent(2);
        }
        if (jeg.getMennyiseg() > 0 && !jeg.isFeltort()) {
            jeg.csokkent(1);
        }
    }

    public void olvasztas() {
        ho.eltakarit();
        jeg.eltakarit();
        // Zúzalék megmarad sárkányfejnél spec szerint
    }

    public void letapos() {
        if (ho.getMennyiseg() > 0 && ho.getMennyiseg() < 4) {
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
