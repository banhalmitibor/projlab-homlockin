package homlockin;

import java.util.ArrayList;
import java.util.List;

public class Utszakasz {
    protected String name;
    protected Ho ho;
    protected Jeg jeg;
    protected Utszakasz jobbUt;
    protected boolean jarhatatlan;
    protected List<Utszakasz> kovetkezok = new ArrayList<>();
    protected List<Jarmu> jarmuvek = new ArrayList<>();

    public Utszakasz() {}
    public Utszakasz(String name) { this.name = name; }

    public void hoEsik() {
        Skeleton.methodCalled(name + ".hoEsik()");
        if (ho != null) {
            ho.novel(1);
        }
        Skeleton.methodReturned();
    }

    public Utszakasz kovetkezoUtszakasz() {
        Skeleton.methodCalled(name + ".kovetkezoUtszakasz()");
        Utszakasz result = jobbUt;
        if (!kovetkezok.isEmpty()) result = kovetkezok.get(0);
        Skeleton.methodReturned();
        return result;
    }

    public Utszakasz getJobbraLevoSzakasz() {
        Skeleton.methodCalled(name + ".getJobbraLevoSzakasz()");
        Skeleton.methodReturned();
        return jobbUt;
    }

    public Utszakasz csuszvaKovetkezoUtszakasz() {
        Skeleton.methodCalled(name + ".csuszvaKovetkezoUtszakasz()");
        Utszakasz result = null;
        if (!kovetkezok.isEmpty()) result = kovetkezok.get(0);
        Skeleton.methodReturned();
        return result;
    }

    public boolean jarhato() {
        Skeleton.methodCalled(name + ".jarhato()");
        boolean result = Skeleton.askYesNo("Járható az út?");
        Skeleton.methodReturned();
        return result;
    }

    public void hoLesopres() {
        Skeleton.methodCalled(name + ".hoLesopres()");
        if (ho != null) {
            ho.eltakarit();
        }
        Skeleton.methodReturned();
    }

    public void hoRasopres() {
        Skeleton.methodCalled(name + ".hoRasopres()");
        if (ho != null) {
            ho.novel(1);
        }
        Skeleton.methodReturned();
    }

    public void jegTores() {
        Skeleton.methodCalled(name + ".jegTores()");
        if (jeg != null) {
            jeg.jegetTor();
        }
        Skeleton.methodReturned();
    }

    public void soSzoras() {
        Skeleton.methodCalled(name + ".soSzoras()");
        if (ho != null) {
            ho.felsoz();
        }
        if (jeg != null) {
            jeg.felsoz();
        }
        Skeleton.methodReturned();
    }

    public void olvasztas() {
        Skeleton.methodCalled(name + ".olvasztas()");
        if (ho != null) {
            ho.eltakarit();
        }
        if (jeg != null) {
            jeg.eltakarit();
        }
        Skeleton.methodReturned();
    }

    public void letapos() {
        Skeleton.methodCalled(name + ".letapos()");
        if (ho != null) {
            ho.csokkent(1);
        }
        if (jeg != null) {
            jeg.novel(1);
        }
        Skeleton.methodReturned();
    }

    public void jarhatatlannaValik() {
        Skeleton.methodCalled(name + ".jarhatatlannaValik()");
        jarhatatlan = true;
        Skeleton.methodReturned();
    }

    // Silent setters
    public void setHo(Ho ho) { this.ho = ho; }
    public void setJeg(Jeg jeg) { this.jeg = jeg; }
    public void setJobbUt(Utszakasz u) { this.jobbUt = u; }
    public void addKovetkezo(Utszakasz u) { this.kovetkezok.add(u); }
    public void setCsapadek(Csapadek c) {}
    public void addJarmu(Jarmu j) { this.jarmuvek.add(j); }
    public void removeJarmu(Jarmu j) { this.jarmuvek.remove(j); }

    public Ho getHo() { return ho; }
    public Jeg getJeg() { return jeg; }
    public Utszakasz getJobbUt() { return jobbUt; }
    public String getName() { return name; }
}
