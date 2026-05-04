package homlockin;

/**
 * Az alagút típusú útszakaszt reprezentáló osztály.
 * Az {@link Utszakasz} osztályból örökli az általános útszakasz-tulajdonságokat,
 * de az alagút belsejébe nem esik hó, ezért a {@code hoEsik()} metódus felül van írva.
 */
public class Alagut extends Utszakasz {

    /**
     * Létrehoz egy névtelen alagút-útszakaszt az alapértelmezett névvel.
     */
    public Alagut() {
        super();
    }

    /**
     * Létrehoz egy alagút-útszakaszt a megadott névvel.
     *
     * @param name az útszakasz azonosítója/neve
     */
    public Alagut(String name) {
        super(name);
    }

    /**
     * Az alagúton belül nem esik a hó, ezért ez a metódus nem csinál semmit.
     * Felülírja az {@link Utszakasz#hoEsik()} metódust.
     */
    @Override
    public void hoEsik() {
        // Alagútban nem esik a hó, ezért a metódus üres vagy direkt return.
        return;
    }
}
