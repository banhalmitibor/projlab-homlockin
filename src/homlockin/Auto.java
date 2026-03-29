package homlockin;

public class Auto extends Jarmu {
    private boolean elakadva;

    public Auto() {}
    public Auto(String name) { this.name = name; }

    @Override
    public void lep() {
        Skeleton.methodCalled(name + ".lep()");
        if (utvonal != null) {
            Utszakasz cel = utvonal.getKivantUtszakasz();
            if (cel != null) {
                Utszakasz kovetkezo = jelenlegiUtszakasz.kovetkezoUtszakasz(cel);
                if (kovetkezo != null) {
                    boolean jarhatoE = kovetkezo.jarhato();
                    if (!jarhatoE) {
                        elakadva = true;
                    }
                    else{
                        this.setJelenlegiUtszakasz(kovetkezo);
                        kovetkezo.stepOn(this);
                        jelenlegiUtszakasz.letapos();
                    }
                }
            }
        } /*else if (jelenlegiUtszakasz != null) {
            boolean jarhatoE = jelenlegiUtszakasz.jarhato();
            if (!jarhatoE) {
                elakadva = true;
            }
        }*/
        
        Skeleton.methodReturned();
    }

    @Override
    public void csuszkal() {
        Skeleton.methodCalled(name + ".csuszkal()");
        //boolean utkozesVan = Skeleton.askYesNo("Ütközés van?");
        Utszakasz csuszkalvaKov = jelenlegiUtszakasz.csuszvaKovetkezoUtszakasz();
        Jarmu szomJarmu = csuszkalvaKov.getJarmu();
        if (szomJarmu !=null) {
            szomJarmu.utkozes(this);
            utkozes(szomJarmu);
        }
        else {
            jelenlegiUtszakasz = csuszkalvaKov;

            csuszkalvaKov.setJarmu(this);
            Skeleton.methodCalled(csuszkalvaKov.getName()+".setJarmu()");
            Skeleton.methodReturned();
        }
        Skeleton.methodReturned();
    }

    @Override
    public void utkozes(Jarmu j2) {
        Skeleton.methodCalled(name + ".utkozik()");
        if (jelenlegiUtszakasz != null) {
            jelenlegiUtszakasz.jarhatatlannaValik();
        }
        Skeleton.methodReturned();
    }

    public boolean getElakadva() {
        Skeleton.methodCalled(name + ".getElakadva()");
        boolean result = Skeleton.askYesNo("El van akadva az autó?");
        Skeleton.methodReturned();
        return result;
    }

    
}
