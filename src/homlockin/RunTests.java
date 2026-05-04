package homlockin;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * A játék automatizált tesztelését végző osztály.
 * A {@code runTest()} metódus sorra lefuttatja az összes tesztesetet (alapértelmezetten 27-et),
 * minden tesztnél betölti a pályát, végrehajtja a bemeneti parancsokat, majd összehasonlítja
 * a tényleges kimenetét az elvárt kimenettel.
 * <p>
 * A tesztek a {@code tests/TestN/} könyvtárakban találhatók, ahol {@code N} a tesztszám.
 * Minden könyvtárban három fájlnak kell lennie:
 * <ul>
 *   <li>{@code palya.txt} – a pálya leírása</li>
 *   <li>{@code input.txt} – a végrehajtandó parancsok</li>
 *   <li>{@code expected.txt} – a várt kimenet</li>
 * </ul>
 */
public class RunTests {

    /**
     * Lefuttatja az összes tesztesetet (1-től {@code numTests}-ig) és kiírja az eredményeket.
     * <p>
     * Ha az {@code args} tömb első eleme érvényes egész szám, akkor csak az adott sorszámú
     * tesztet futtatja az {@link #runTest(int)} meghívásával; egyébként az összes tesztet
     * végigfuttatja és összesíti az eredményeket.
     *
     * @param args parancssori argumentumok; ha {@code args[0]} egy egész szám,
     *             csak az azzal azonos sorszámú teszt fut le
     */
    public static void runTest(String[] args) {
        if (args != null && args.length > 0) {
            try {
                int testNumber = Integer.parseInt(args[0]);
                runTest(testNumber);
                return;
            } catch (NumberFormatException ignored) {
                // Nem szám volt az első argumentum, lefuttatjuk az összes tesztet
            }
        }

        int passed = 0;
        int numTests = 27;
        
        for (int i = 1; i <= numTests; i++) { //Loop vissza
            if (runSingleTest(i)) passed++;
        }
        
        System.out.println(passed + "/" + numTests + " tests passed.");
    }

    /**
     * Lefuttatja az adott sorszámú tesztesetet és kiírja az eredményét.
     * <p>
     * A teszt a {@code tests/TestN/} könyvtárból töltődik be, ahol {@code N} a megadott szám.
     * Az eredményt (PASSED / FAILED) a standard kimenetre írja.
     *
     * @param testNumber a futtatandó teszt sorszáma (1-től {@code numTests}-ig)
     */
    public static void runTest(int testNumber) {
        runSingleTest(testNumber);
    }

    /**
     * Belső segédmetódus: lefuttatja az adott sorszámú tesztet.
     *
     * @param i a teszt sorszáma
     * @return {@code true}, ha a teszt átment (PASSED); {@code false}, ha nem
     */
    private static boolean runSingleTest(int i) {
        String dir = "tests/Test" + i + "/";
        String palya = dir + "palya.txt";
        String teszt = dir + "input.txt";
        String expected = dir + "expected.txt";
        
        System.out.println("Running test " + i + "...");
        
        if (!new File(palya).exists()) {
            System.out.println("Test " + i + " output files missing at " + palya);
            return false;
        }
        
        // Re-init the domain and build the palya silently
        PrintStream sysOut = System.out;
        try {
            // Silently process setup
            //System.setOut(new PrintStream(new java.io.OutputStream() { public void write(int b) {} }));
            Main.processCommand("init");
            TestParser.loadPalya(palya);
        } finally {
            System.setOut(sysOut);
        }
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        
        try {
            Scanner sc = new Scanner(new File(teszt));
            while (sc.hasNextLine()) {
                String cmd = sc.nextLine().trim();
                if (!cmd.isEmpty() && !cmd.startsWith("#")) {
                    if (cmd.startsWith("init")) continue; // Already initialized above
                    
                    if (cmd.startsWith("save")) {
                        // Only capture output state when 'save' is called
                        System.setOut(ps);
                        homlockin.StateDumper.dumpAll();
                        System.out.flush();
                        System.setOut(old);
                        continue;
                    }
                    
                    // Otherwise execute command Silently (to match expected output exactly)
                    //System.setOut(new PrintStream(new java.io.OutputStream() { public void write(int b) {} }));
                    Main.processCommand(cmd);
                    //System.setOut(old);
                }
            }
            sc.close();
            
            String actualOut = baos.toString();
            String expOut = new String(Files.readAllBytes(Paths.get(expected)));
            
            if (normalize(actualOut).equals(normalize(expOut))) {
                System.out.println("  PASSED");
                return true;
            } else {
                System.out.println("  FAILED");
                System.out.println("  Expected:\n<<" + expOut + ">>");
                System.out.println("  Actual:\n<<" + actualOut + ">>");
                return false;
            }
            
        } catch (Exception e) {
            System.setOut(old);
            System.out.println("  FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Normalizálja a szöveget az összehasonlításhoz: levágja a vezető/záró szóközöket,
     * a Windows-stílusú sortöréseket ({@code \r\n}) Unix-stílusúra ({@code \n}) alakítja,
     * majd minden egymást követő whitespace-sorozatot egyetlen szóközre cserél.
     *
     * @param s a normalizálandó szöveg
     * @return a normalizált szöveg
     */
    private static String normalize(String s) {
        return s.trim().replace("\r\n", "\n").replaceAll("\\s+", " ");
    }

    /**
     * A tesztosztály önálló futtatási belépési pontja.
     * Ha {@code args[0]} egy egész szám, csak az adott sorszámú teszt fut le;
     * egyébként az összes teszt lefut.
     * <p>
     * Példák:
     * <pre>
     *   java tests.RunTests       – összes teszt
     *   java tests.RunTests 5     – csak a 5-ös teszt
     * </pre>
     *
     * @param args parancssori argumentumok; opcionálisan egy tesztszám
     */
    public static void main(String[] args) {
        runTest(args);
    }
}
