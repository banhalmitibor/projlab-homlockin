package homlockin;

import java.util.Scanner;

/**
 * A {@code Main} osztály a program belépési pontja. Interaktív menüt jelenít meg,
 * amelyen keresztül a felhasználó kiválaszthatja, melyik use case-t kívánja futtatni.
 * A use case-ek a skeleton tesztelési módszertan szerint tesztelik a játék egyes
 * funkcióit, például hókotró közlekedést, takarítást, ütközéseket és vásárlásokat.
 */
public class Main {

    /** A felhasználói bemenet olvasásához használt scanner, amelyet a {@link Skeleton} oszt meg. */
    private static final Scanner scanner = Skeleton.getScanner();

    /**
     * A program belépési pontja. Megjeleníti az elérhető use case-ek listáját,
     * beolvassa a felhasználó választását, és elindítja a megfelelő use case-t
     * a {@link UseCases} osztályon keresztül. A 0 választással lehet kilépni.
     *
     * @param args parancssori argumentumok (nem használt)
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nElérhető Use-Case-ek:");
            System.out.println(" 1. Hókotró sima közlekedése (nincs takarítás)");
            System.out.println(" 2. Jégtörőfejjel jégtörés");
            System.out.println(" 3. Takarít havat/jégtörmeléket hányófejjel");
            System.out.println(" 4. Hókotró sima közlekedése, sószórófejjel");
            System.out.println(" 5. Hókotró sima közlekedése, sárkányfejjel");
            System.out.println(" 6. Takarít havat/jégtörmeléket sószórófejjel");
            System.out.println(" 7. Takarít havat/jégtörmeléket sárkányfejjel");
            System.out.println(" 8. Hó és törött jég takarítás söprőfejjel");
            System.out.println(" 9. Só vásárlás és feltöltés");
            System.out.println("10. Biokerozin vásárlás és feltöltés");
            System.out.println("11. Hókotrófej vásárlása");
            System.out.println("12. Új hókotró vásárlása");
            System.out.println("13. Ütközés jégpáncélon");
            System.out.println("14. Autó csúszkálása ütközés nélkül");
            System.out.println("15. Hó letaposása és jégpáncél");
            System.out.println("16. Busz célba érése és pontszerzés");
            System.out.println("17. Város léptetése és havazás");
            System.out.println("18. Autó elakadása");
            System.out.println("19. Játék vége ellenőrzés");
            System.out.println("20. Takarító játékos pénzt szerez (Hányófej)");
            System.out.println("21. Hókotrófej csere");
            System.out.println("22. Autó célba érése");
            System.out.println("23. Hókotró félreáll és elindul");
            System.out.println("24. Busz indulása");
            System.out.println(" 0. Kilépés");
            System.out.print("Válasszon: ");
            String line = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Érvénytelen választás.");
                continue;
            }
            if (choice == 0) break;
            switch (choice) {
                case 1: UseCases.runUseCase1(); break;
                case 2: UseCases.runUseCase2(); break;
                case 3: UseCases.runUseCase3(); break;
                case 4: UseCases.runUseCase4(); break;
                case 5: UseCases.runUseCase5(); break;
                case 6: UseCases.runUseCase6(); break; 
                case 7: UseCases.runUseCase7(); break;
                case 8: UseCases.runUseCase8(); break;
                case 9: UseCases.runUseCase9(); break;
                case 10: UseCases.runUseCase10(); break;
                case 11: UseCases.runUseCase11(); break;
                case 12: UseCases.runUseCase12(); break;
                case 13: UseCases.runUseCase13(); break; 
                case 14: UseCases.runUseCase14(); break;
                case 15: UseCases.runUseCase15(); break;
                case 16: UseCases.runUseCase16(); break;
                case 17: UseCases.runUseCase17(); break;
                case 18: UseCases.runUseCase18(); break;
                case 19: UseCases.runUseCase19(); break;
                case 20: UseCases.runUseCase20(); break;
                case 21: UseCases.runUseCase21(); break;
                case 22: UseCases.runUseCase22(); break;
                case 23: UseCases.runUseCase23(); break;
                case 24: UseCases.runUseCase24(); break; 
                default: System.out.println("Érvénytelen választás.");
            }
        }
    }


}
