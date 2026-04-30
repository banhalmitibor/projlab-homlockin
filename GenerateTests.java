import java.nio.file.*;
import java.util.regex.*;
import java.io.File;

public class GenerateTests {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting...");
        String content = new String(Files.readAllBytes(Paths.get("update_tests.py")));
        Matcher m1 = Pattern.compile("\"palya\"\\s*:\\s*\"(.*?)\"", Pattern.DOTALL).matcher(content);
        Matcher m2 = Pattern.compile("\"input\"\\s*:\\s*\"(.*?)\"", Pattern.DOTALL).matcher(content);
        Matcher m3 = Pattern.compile("\"expected\"\\s*:\\s*\"(.*?)\"", Pattern.DOTALL).matcher(content);
        
        int idx = 1;
        new File("tests").mkdirs();
        while (m1.find() && m2.find() && m3.find()) {
            String palya = unescape(m1.group(1));
            String input = unescape(m2.group(1));
            String expected = unescape(m3.group(1));
            Files.write(Paths.get("tests/test" + idx + "_palya.txt"), palya.getBytes());
            Files.write(Paths.get("tests/test" + idx + "_teszt.txt"), input.getBytes());
            Files.write(Paths.get("tests/test" + idx + "_expected.txt"), expected.getBytes());
            idx++;
            System.out.println("Wrote test " + (idx - 1));
        }
        System.out.println("Tests generated: " + (idx - 1));
    }
    
    private static String unescape(String s) {
        return s.replace("\\n", "\n").replace("\\t", "\t");
    }
}
