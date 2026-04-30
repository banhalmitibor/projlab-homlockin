import java.nio.file.*;

public class fix_MainSplit {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/homlockin/Main.java")));
        content = content.replace("String[] parts = cmd.split(\"(?=\\\\s-)|\\\\s+\");", "String[] parts = cmd.split(\"\\\\s+\");");
        Files.write(Paths.get("src/homlockin/Main.java"), content.getBytes());
    }
}
