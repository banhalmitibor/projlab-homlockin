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
        if (allRajta != null && allRajta.getHo().getMennyiseg() >= 4) {
            return; // Stuck
        }

        Utszakasz kov = utvonala.getKivantUtszakasz();
        if (kov == null) {
            checkCélbaérés();
            return;
        }

        if (kov.getJarmu() != null || kov.getHo().getMennyiseg() >= 4) {
            return; // Wait or Stop Before
        }

        Utszakasz regi = allRajta;
        if (regi != null) {
            regi.setJarmu(null);
        }
        allRajta = kov;
        allRajta.setJarmu(this);
        leptetUtvonal();

        allRajta.letapos();

        if (allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        }
        
        checkCélbaérés();
    }

    private void checkCélbaérés() {
        if (allRajta != null && utvonala.isVege()) {
            allRajta.setJarmu(null);
            allRajta = null;
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
            if (slipTo.getJarmu() != null || slipTo.getHo().getMennyiseg() >= 4) {
                this.utkozik();
                if (slipTo.getJarmu() != null) {
                    slipTo.getJarmu().utkozik();
                }
            } else {
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                // DO NOT leptetUtvonal here!
                if (allRajta != null) {
                    allRajta.letapos();
                }
            }
        }
    }

    @Override
    public void utkozik() {
        if (!utkozott) {
            this.utkozott = true;
            Main.varos.incrementElakadas();
            if (this.allRajta != null) {
                this.allRajta.jarhatatlannaValik();
            }
        }
    }
    
    public boolean isUtkozott() { return utkozott; }
}
