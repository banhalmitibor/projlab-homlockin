package homlockin;

import java.util.ArrayList;
import java.util.List;

public class Hokotro extends Jarmu {
    private List<HokotroFej> fejei;
    private HokotroFej felrakottFeje;
    private TakaritoJatekos vezeti;
    
    private int soMennyiseg;
    private int bioKerozinMennyiseg;
    private int zuzalekMennyiseg;

    public Hokotro(String id, TakaritoJatekos vezeti) {
        super(id);
        this.vezeti = vezeti;
        this.fejei = new ArrayList<>();
        this.soMennyiseg = 0;
        this.bioKerozinMennyiseg = 0;
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
        // Hókotró calls takarit() every time it's on a section
        takarit();

        Utszakasz kov = utvonala.getKivantUtszakasz();
        if (kov == null) {
            return;
        }

        // Hókotró can step on any snow because it cleans its way, but let's check jarhato.
        // Actually, snow doesn't block the snowplow!
        // "A hókotró az alatta lévő útszakasz hóállapotát meg tudja változtatni."
        // Let's just say it can't step if there's a vehicle there.
        if (kov.getJarmu() != null) {
            return; 
        }

        Utszakasz regi = allRajta;
        if (regi != null) {
            regi.setJarmu(null);
            regi.letapos();
        }
        
        allRajta = kov;
        allRajta.setJarmu(this);
        leptetUtvonal();
        
        if (allRajta != null && allRajta.getJeg() != null && allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        } else {
             // Takarít when it arrives at a new section
            takarit();
        }
    }

    public void takarit() {
        if (felrakottFeje != null && allRajta != null) {
            felrakottFeje.munkatVegez(allRajta);
            if (vezeti != null) {
                vezeti.penztKap(5); // Pont/Pénz a takarításért
            }
        }
    }

    @Override
    public void csuszkal() {
        Utszakasz slipTo = utvonala.getKivantUtszakasz();
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
                    regi.letapos();
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                leptetUtvonal();
                takarit();
            }
        }
    }

    @Override
    public void utkozik() {
        // "Hókotró ütközése: A hókotrónak nem esik baja, gondtalanul folytatja útját"
        // Semmi következménye magára a hókotróra
    }

    public void soFeltoltes() { this.soMennyiseg = 30; }
    public boolean soFogyasztas(int m) {
        if (this.soMennyiseg >= m) {
            this.soMennyiseg -= m;
            return true;
        }
        return false;
    }

    public void biokerozinFeltoltes() { this.bioKerozinMennyiseg = 30; }
    public boolean biokerozinFogyasztas(int m) {
        if (this.bioKerozinMennyiseg >= m) {
            this.bioKerozinMennyiseg -= m;
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
    public int getKerozin() { return bioKerozinMennyiseg; }
    public int getZuzalek() { return zuzalekMennyiseg; }
}
