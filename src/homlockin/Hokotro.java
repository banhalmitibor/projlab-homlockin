package homlockin;

import java.util.ArrayList;
import java.util.List;

public class Hokotro extends Jarmu {
    private List<HokotroFej> fejei;
    private HokotroFej felrakottFeje;
    private TakaritoJatekos vezeti;
    
    private int soMennyiseg;
    private int bioKerozinmennyiseg;
    private int zuzalekMennyiseg;

    public Hokotro(String id, TakaritoJatekos vezeti) {
        super(id);
        this.vezeti = vezeti;
        this.fejei = new ArrayList<>();
        this.soMennyiseg = 0;
        this.bioKerozinmennyiseg = 0;
        this.zuzalekMennyiseg = 0;
        
        // By default it comes with a "sopro" fej according to requirements.
        HokotroFej alapFej = new Soprofej();
        alapFej.setHokotro(this);
        this.fejei.add(alapFej);
        this.felrakottFeje = alapFej;
    }

    public void fejetCserel(HokotroFej ujFej) {
        if (fejei.contains(ujFej)) {
            this.felrakottFeje = ujFej;
        } else {
            fejei.add(ujFej);
            ujFej.setHokotro(this);
            this.felrakottFeje = ujFej;
        }
    }
    
    public void setFelrakottFeje(HokotroFej fej) {
        this.felrakottFeje = fej;
    }
    public HokotroFej getFelrakottFeje() { return felrakottFeje; }

    @Override
    public void lep() {
        Utszakasz kov = utvonala.getKivantUtszakasz();
        kov = allRajta.kovetkezoUtszakasz(kov);
        if (kov == null) {
            return;
        }

        if (kov.getJarmu() != null) {
            return; 
        }

        Utszakasz regi = allRajta;
        if (regi != null) {
            regi.setJarmu(null);
        }
        
        allRajta = kov;
        allRajta.setJarmu(this);
        leptetUtvonal();
        
        /*if (allRajta != null && allRajta.getJeg() != null && allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        } else {*/
            takarit();
        //}
    }

    public void takarit() {
        if (felrakottFeje != null && allRajta != null) {
            boolean voltCsapadek = (allRajta.getHo() != null && allRajta.getHo().getMennyiseg() > 0)
                    || (allRajta.getJeg() != null && allRajta.getJeg().getMennyiseg() > 0)
                    || (allRajta.getZuzalek() != null && allRajta.getZuzalek().vanZuzalek());
            felrakottFeje.munkatVegez(allRajta);
            if (vezeti != null && voltCsapadek) {
                vezeti.penztKap(5); // Pont/Pénz a takarításért
            }
        }
    }

    @Override
    public void csuszkal() {
        /*Utszakasz slipTo = utvonala.getKivantUtszakasz();
        if (slipTo == null && allRajta != null) {
            slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        }
        
        if (slipTo != null) {
            if (slipTo.getJarmu() != null) {
                this.utkozik();
                slipTo.getJarmu().utkozik();
            } else {
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                leptetUtvonal();
                takarit();
            }
        }*/
    }

    @Override
    public void utkozik() {
        // "Hókotró ütközése: A hókotrónak nem esik baja, gondtalanul folytatja útját" - Vince
    }

    public void soFeltoltes() { this.soMennyiseg = 30; }
    public boolean soFogyasztas(int m) {
        if (this.soMennyiseg >= m) {
            this.soMennyiseg -= m;
            return true;
        }
        return false;
    }

    public void biokerozinFeltoltes() { this.bioKerozinmennyiseg = 30; }
    public boolean biokerozinFogyasztas(int m) {
        if (this.bioKerozinmennyiseg >= m) {
            this.bioKerozinmennyiseg -= m;
            return true;
        }
        return false;
    }

    public void zuzalekFeltoltes() { this.zuzalekMennyiseg = 30; }
    public boolean zuzalekFogyasztas(int m) {
        if (this.zuzalekMennyiseg >= m) {
            this.zuzalekMennyiseg -= m;
            return true;
        }
        return false;
    }
    
    public int getSo() { return soMennyiseg; }
    public int getKerozin() { return bioKerozinmennyiseg; }
    public int getZuzalek() { return zuzalekMennyiseg; }
}
