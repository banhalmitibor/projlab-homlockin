package tests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import homlockin.Main;
import homlockin.TestParser;

public class RunTests {

    public static void runTest(String[] args) {
        int passed = 0;
        int numTests = 25;
        
        for (int i = 1; i <= numTests; i++) {
            String palya = "test" + i + "_palya.txt";
            String teszt = "test" + i + "_teszt.txt";
            String expected = "test" + i + "_expected.txt";
            
            System.out.println("Running test " + i + "...");
            
            if (!new File("tests/" + palya).exists()) {
                System.out.println("Test " + i + " output files missing.");
                continue;
            }
            
            // Re-init the domain and build the palya silently
            PrintStream sysOut = System.out;
            try {
                // Silently process setup
                System.setOut(new PrintStream(new java.io.OutputStream() { public void write(int b) {} }));
                Main.processCommand("init");
                TestParser.loadPalya(palya);
            } finally {
                System.setOut(sysOut);
            }
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            
            try {
                Scanner sc = new Scanner(new File("tests/" + teszt));
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
                        System.setOut(new PrintStream(new java.io.OutputStream() { public void write(int b) {} }));
                        Main.processCommand(cmd);
                        System.setOut(old);
                    }
                }
                sc.close();
                
                String actualOut = baos.toString().trim().replace("\r\n", "\n").replaceAll("(?m)^\\s+$", ""); // remove trailing spaces
                String expOut = new String(Files.readAllBytes(Paths.get("tests/" + expected))).trim().replace("\r\n", "\n").replaceAll("(?m)^\\s+$", "");
                
                if (actualOut.equals(expOut)) {
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
    
    public static void main(String[] args) {
        runTest(args);
    }
}
