import java.nio.file.*;
import java.util.*;
import homlockin.*;

public class DebugRun {
  static void runTest(String testDir) throws Exception {
    System.out.println("=== " + testDir + " ===");
    Main.processCommand("init");
    TestParser.loadPalya(testDir + "/palya.txt");
    List<String> lines = Files.readAllLines(Paths.get(testDir + "/input.txt"));
    int step=0;
    for (String raw: lines) {
      String cmd = raw.trim();
      if (cmd.isEmpty() || cmd.startsWith("#") || cmd.startsWith("init") || cmd.startsWith("save")) continue;
      Main.processCommand(cmd);
      if (cmd.equals("step")) {
        step++;
        System.out.println("-- after step " + step + " --");
        StateDumper.dumpAll();
      }
    }
  }
  public static void main(String[] args) throws Exception {
    runTest("tests/Test14");
    runTest("tests/Test17");
    runTest("tests/Test18");
  }
}
