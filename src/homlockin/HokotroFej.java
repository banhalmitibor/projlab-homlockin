package homlockin;

/**
 * A {@code HokotroFej} interfész a hókotrófejek jellemzésére szolgál. Minden
 * hókotrófej típus (söprőfej, hányófej, jégtörőfej, sószórófej, sárkányfej)
 * megvalósítja ezt az interfészt, és saját takarítási mechanizmust valósít meg
 * a {@link #munkatVegez(Utszakasz)} metódusban.
 */
public interface HokotroFej {

    /**
     * Az egyes hókotrófejek takarítási mechanizmusát írja le. Minden hókotrófej
     * típus saját implementációval rendelkezik: a söprőfej áthelyezi a havat,
     * a hányófej eltünteti, a jégtörőfej feltöri a jeget, a sószórófej sóval
     * olvasztja, a sárkányfej biokerozinnal égeti el a havat és a jégpáncélt.
     *
     * @param szakasz az az {@link Utszakasz}, amelyen a takarítást végzik
     */
    void munkatVegez(Utszakasz szakasz);

    /**
     * Visszaadja a hókotrófej nevét azonosítási célokra.
     *
     * @return a hókotrófej neve
     */
    String getName();

    /**
     * Beállítja azt a hókotró járművet, amelyre ez a hókotrófej fel van szerelve.
     * Ez szükséges ahhoz, hogy a fej hozzáférjen a hókotró erőforrásaihoz
     * (pl. sókészlet, biokerozin).
     *
     * @param hk az a {@link Hokotro}, amelyre a hókotrófej kerül
     */
    public void setHokotro(Hokotro hk);
}
