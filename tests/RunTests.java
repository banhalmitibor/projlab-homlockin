package tests;

import homlockin.Main;
import homlockin.TestParser;
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
     * Lefuttatja az összes tesztesetet és kiírja az eredményeket a standard kimenetre.
     * <p>
     * Minden tesztnél:
     * <ol>
     *   <li>Inicializálja a játékot és betölti a pályát ({@code palya.txt})</li>
     *   <li>Végrehajtja az {@code input.txt} parancsait (az {@code init} parancsot kihagyja,
     *       mert a pálya már be van töltve)</li>
     *   <li>A {@code save} parancs helyett közvetlenül rögzíti az állapot-kimenetet
     *       ({@link homlockin.StateDumper#dumpAll()})</li>
     *   <li>Összehasonlítja a tényleges kimenetet az {@code expected.txt} tartalmával
     *       (normalizálva: whitespace-egységesítéssel)</li>
     *   <li>Kiírja, hogy a teszt PASSED vagy FAILED</li>
     * </ol>
     * A metódus végén összesíti az átment és összes teszt számát.
     *
     * @param args parancssori argumentumok (jelenleg nem használtak)
     */
    public static void runTest(String[] args) {
        int passed = 0;
        int numTests = 27;
        
        for (int i = 1; i <= numTests; i++) { //Loop vissza
            String dir = "tests/Test" + i + "/";
            String palya = dir + "palya.txt";
            String teszt = dir + "input.txt";
            String expected = dir + "expected.txt";
            
            System.out.println("Running test " + i + "...");
            
            if (!new File(palya).exists()) {
                System.out.println("Test " + i + " output files missing at " + palya);
                continue;
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
                    passed++;
                    System.out.println("  PASSED");
                } else {
                    System.out.println("  FAILED");
                    System.out.println("  Expected:\n<<" + expOut + ">>");
                    System.out.println("  Actual:\n<<" + actualOut + ">>");
                }
                
            } catch (Exception e) {
                System.setOut(old);
                System.out.println("  FAILED with exception: " + e.getMessage());
            }
        }
        
        System.out.println(passed + "/" + numTests + " tests passed.");
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
     * Meghívja a {@link #runTest(String[])} metódust a parancssori argumentumokkal.
     *
     * @param args parancssori argumentumok (jelenleg nem használtak)
     */
    public static void main(String[] args) {
        runTest(args);
    }
}
