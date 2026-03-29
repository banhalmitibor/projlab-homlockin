package homlockin;

import java.util.Scanner;

/**
 * A {@code Skeleton} osztály a program tesztelési és nyomkövetési segédosztálya.
 * Felelős a metódushívások és visszatérések naplózásáért, valamint az interaktív
 * igen/nem kérdések feltevéséért a felhasználónak. A skeleton tesztelési módszertan
 * szerint a program végrehajtási lánca nyomon követhető és ellenőrizhető általa.
 */
public class Skeleton {

    /** A jelenlegi hívási mélység, amelyet a naplózásnál behúzáshoz használunk. */
    private static int depth = 1;

    /** A felhasználói bevitel olvasásához használt scanner objektum. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Elindítja az inicializálási fázis naplózását. Kiírja az inicializálás nevét
     * és visszaállítja a hívási mélységet 1-re.
     *
     * @param name az inicializálási eset neve
     */
    public static void startInit(String name) {
        System.out.println("--INIT-- " + name);
        depth = 1;
    }

    /**
     * Elindítja a tesztelési fázis naplózását. Kiírja a teszt nevét és visszaállítja
     * a hívási mélységet 1-re.
     *
     * @param name a teszteset neve
     */
    public static void startTest(String name) {
        System.out.println("--TEST-- " + name);
        depth = 1;
    }

    /**
     * Naplózza, hogy egy metódus meghívódott. A hívás nevét a jelenlegi mélységnek
     * megfelelő behúzással írja ki, majd növeli a mélységet.
     *
     * @param call a meghívott metódus neve (pl. "u1.hoEsik()")
     */
    public static void methodCalled(String call) {
        System.out.println("\t".repeat(depth) + call);
        depth++;
    }

    /**
     * Naplózza, hogy egy metódus visszatért. Csökkenti a hívási mélységet, majd
     * kiírja a "return" szót a megfelelő behúzással.
     */
    public static void methodReturned() {
        depth--;
        System.out.println("\t".repeat(depth) + "return");
    }

    /**
     * Naplózza egy objektum létrehozását (new operátor) a skeleton tesztelési
     * módszertan szerint.
     *
     * @param className a létrehozott osztály neve
     */
    public static void printNew(String className) {
        System.out.println("\tnew " + className + "()");
        System.out.println("\treturn");
    }

    /**
     * Naplózza egy inicializálási hívást a skeleton módszertan szerint.
     *
     * @param call az inicializálási hívás leírása
     */
    public static void printInitCall(String call) {
        System.out.println("\t" + call);
        System.out.println("\treturn");
    }

    /**
     * Interaktív igen/nem kérdést tesz fel a felhasználónak a konzolon. A válasz
     * meghatározza a program végrehajtásának irányát a tesztelés során. Elfogadja
     * az "i", "igen", "y" és "yes" válaszokat igenként.
     *
     * @param question a felteendő kérdés szövege
     * @return {@code true}, ha a felhasználó igent válaszolt; {@code false} egyébként
     */
    public static boolean askYesNo(String question) {
        System.out.print("\t".repeat(depth) + question + " (i/n): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("i") || answer.equals("igen") || answer.equals("y") || answer.equals("yes");
    }

}
