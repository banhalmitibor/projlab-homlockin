package homlockin;

public class Busz extends Jarmu {
    private int elakadasVisszaszamlalo;
    private BuszvezetoJatekos vezeti;

    public Busz(String id, BuszvezetoJatekos vezeti) {
        super(id);
        this.vezeti = vezeti;
        this.elakadasVisszaszamlalo = 0;
    }

    @Override
    public void lep() {
        if (elakadasVisszaszamlalo > 0) {
            elakadasVisszaszamlalo--;
            return;
        }

        Utszakasz kov = utvonala.getKivantUtszakasz();
        kov = allRajta.kovetkezoUtszakasz(kov);
        if (kov == null) {
            return; 
        }

        if (!kov.jarhato()) {
            System.out.println("Nem jarhato");
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
        
        if (vezeti != null && (allRajta == vezeti.getVegallomas1() || allRajta == vezeti.getVegallomas2())) {
            vezeti.pontotKap();
        }

        if (allRajta != null && allRajta.getJeg() != null && allRajta.getJeg().jegPancel()) {
            this.csuszkal();
        }
    }

    @Override
    public void utkozik() {
        // "olyan állapotba kerül, hogy a busz 3 körből kimarad és újra mozgóképes lesz"
        this.elakadasVisszaszamlalo = 3;
    }

    @Override
    public void csuszkal() {
        //Utvonal u = getUtvonala();
        Utszakasz slipTo = allRajta.csuszvaKovetkezoUtszakasz(); //All rajta hopefully nem null
        /*if(slipTo == null){
            slipTo = allRajta.csuszvaKovetkezoUtszakasz();
        }*/
        
        
        if (slipTo != null) {
            if (!slipTo.jarhato()) {
                this.utkozik();
                if (slipTo.getJarmu() != null) {
                    slipTo.getJarmu().utkozik();
                }
            } else {
                Utszakasz regi = allRajta;
                if (regi != null) {
                    regi.setJarmu(null);
                    regi.letapos();
                }
                allRajta = slipTo;
                allRajta.setJarmu(this);
                leptetUtvonal();
            }
        }
    }
}
