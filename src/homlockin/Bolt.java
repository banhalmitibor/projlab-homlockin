package homlockin;

public class Bolt {
    private TakaritoJatekos vasarol;

    public Bolt() {}

    public Bolt(TakaritoJatekos vasarol) {
        this.vasarol = vasarol;
    }
    
    public void setVasarol(TakaritoJatekos vasarol) {
        this.vasarol = vasarol;
    }

    public Hokotro hokotrotVasarol(String id, TakaritoJatekos jatekos, Utszakasz kezdo) {
        if (jatekos.getPenz() >= 100) {
            jatekos.penztLevon(100);
            Hokotro hk = new Hokotro(id, jatekos);
            hk.setAllRajta(kezdo);
            jatekos.hokotroHozzaadas(hk);
            return hk;
        }
        return null;
    }

    public void sotVasarol(Hokotro hk) {
        if (vasarol != null && vasarol.getPenz() >= 10) {
            vasarol.penztLevon(10);
            hk.soFeltoltes();
        }
    }

    public void zuzalekotVasarol(Hokotro hk) {
        if (vasarol != null && vasarol.getPenz() >= 10) {
            vasarol.penztLevon(10);
            hk.zuzalekFeltoltes();
        }
    }

    public void biokerozinVasarol(Hokotro hk) {
        if (vasarol != null && vasarol.getPenz() >= 10) {
            vasarol.penztLevon(10);
            hk.biokerozinFeltoltes();
        }
    }

    public void hokotroFejetVasarol(Hokotro hk, HokotroFej fejTipus) {
        if (vasarol != null && vasarol.getPenz() >= 50) {
            vasarol.penztLevon(50);
            hk.fejetCserel(fejTipus);
        }
    }
}
