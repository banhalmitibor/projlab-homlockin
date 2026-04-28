package homlockin;

public class Auto extends Jarmu {
    private boolean utkozott;

    public Auto(String id) {
        super(id);
        this.utkozott = false;
    }

    @Override
    public void lep() {
        if (utkozott) return;

        Utszakasz kov = utvonala.getKivantUtszakasz();
        if (kov == null) {
            // Célba ért, lekerül a pályáról
            if (this.allRajta != null) {
                this.allRajta.setJarmu(null);
                this.allRajta = null;
            }
            return;
        }

        if (!kov.jarhato()) {
            // Elakad vagy várakozik, nem csúszik meg, nem lép
            return;
        }

        Utszakasz regi = allRajta;
        // Lép
        if (regi != null) {
            regi.setJarmu(null);
        }
        allRajta = kov;
        allRajta.setJarmu(this);
        
        leptetUtvonal();
        
        // Letaposás
        if (regi != null) {
            regi.letapos();
        }

        // Megcsúszás ellenőrzése új mezőn
        if (allRajta != null && allRajta.getJeg() != null && allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        }
    }

    @Override
    public void csuszkal() {
        Utvonal u = getUtvonala();
        Utszakasz slipTo = u.getKivantUtszakasz();
        if(slipTo == null){
            slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        }
        
        if (slipTo != null) {
            if (!slipTo.jarhato()) {
                // ütközött állapot
                this.utkozik();
                if (slipTo.getJarmu() != null) {
                    slipTo.getJarmu().utkozik();
                }
            } else {
                // Sikeresen átcsúszik
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                leptetUtvonal();
                if (regi != null) {
                    regi.letapos();
                }
            }
        }
    }

    @Override
    public void utkozik() {
        this.utkozott = true;
        if (this.allRajta != null) {
            this.allRajta.jarhatatlannaValik();
        }
    }
    
    public boolean isUtkozott() { return utkozott; }
}
