package homlockin;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy jármű tervezett útvonalát reprezentáló osztály.
 * Az útvonal útszakaszok rendezett listáját tartalmazza, amelyeken a jármű végig kíván haladni.
 * Az aktuális pozíciót egy index jelzi; léptetéskor az index növekszik.
 */
public class Utvonal {

    /** Az útvonalat alkotó, preferált útszakaszok listája. */
    private List<Utszakasz> utvonalatKeres;

    /** Az útvonallista aktuális pozícióindexe. */
    private int currentIndex = 0;

    /**
     * Létrehoz egy üres útvonalat.
     */
    public Utvonal() {
        this.utvonalatKeres = new ArrayList<>();
    }

    /**
     * Hozzáad egy útszakaszt az útvonal végéhez.
     *
     * @param u a hozzáadandó {@link Utszakasz}
     */
    public void addUtszakasz(Utszakasz u) {
        this.utvonalatKeres.add(u);
    }

    /**
     * Visszaadja az útvonal aktuális, következő kívánt útszakaszát.
     * Ha az index elérte a lista végét, {@code null}-t ad vissza.
     *
     * @return a következő kívánt {@link Utszakasz}, vagy {@code null}, ha vége az útvonalnak
     */
    public Utszakasz getKivantUtszakasz() {
        if (currentIndex < utvonalatKeres.size()) {
            return utvonalatKeres.get(currentIndex);
        }
        return null;
    }

    /**
     * Lépteti az útvonal indexét (egy útszakaszon való áthaladást jelez).
     */
    public void leptet() {
        currentIndex++;
    }

    /**
     * Megvizsgálja, hogy az útvonalnak vége van-e (minden útszakaszon áthaladt a jármű).
     *
     * @return {@code true}, ha az index elérte vagy meghaladta a lista méretét; {@code false} egyébként
     */
    public boolean isVege() {
        return currentIndex >= utvonalatKeres.size();
    }

    /**
     * Törli az útvonal tartalmát és visszaállítja az indexet nullára.
     */
    public void clear() {
        this.utvonalatKeres.clear();
        this.currentIndex = 0;
    }
}
