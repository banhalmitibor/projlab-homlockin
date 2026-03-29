package homlockin;

/**
 * Az {@code Alagut} osztály egy speciális útszakaszt modellez, amely teljes hosszában
 * védett a csapadéktól, így ott hó nem rakódhat le. Az alagút felett tud haladni
 * másik út is. Az {@link Utszakasz} osztályból származik le.
 */
public class Alagut extends Utszakasz {

    /**
     * Alapértelmezett konstruktor. Létrehoz egy névtelen alagút útszakaszt.
     */
    public Alagut() {}

    /**
     * Névvel ellátott alagút útszakaszt hoz létre.
     *
     * @param name az alagút neve
     */
    public Alagut(String name) { super(name); }

    /**
     * A hóesés kezelését végző metódus. Mivel az alagút teljes hosszában védett a
     * csapadéktól, ez a metódus nem tesz semmit – alagútban nem rakódhat le hó.
     * Ez az {@link Utszakasz#hoEsik()} metódus felülírása, amely az alagút
     * speciális viselkedését valósítja meg.
     */
    @Override
    public void hoEsik() {
        Skeleton.methodCalled(name + ".hoEsik()");
        // Alagútban nem esik hó
        Skeleton.methodReturned();
    }
}
