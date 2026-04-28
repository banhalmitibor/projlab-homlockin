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

    public void sotVasarol(TakaritoJatekos j, Hokotro hk) {
        if (j.getPenz() >= 10) {
            j.penztLevon(10);
            hk.soFeltoltes();
        }
    }

    public void zuzalekotVasarol(TakaritoJatekos j, Hokotro hk) {
        if (j.getPenz() >= 10) {
            j.penztLevon(10);
            hk.zuzalekFeltoltes();
        }
    }

    public void biokerozinVasarol(TakaritoJatekos j, Hokotro hk) {
        if (j.getPenz() >= 10) {
            j.penztLevon(10);
            hk.biokerozinFeltoltes();
        }
    }

    public void hokotroFejetVasarol(TakaritoJatekos j, Hokotro hk, HokotroFej fejTipus) {
        if (j.getPenz() >= 50) {
            j.penztLevon(50);
            hk.fejetCserel(fejTipus);
        }
    }
}
