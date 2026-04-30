import java.nio.file.*;
import java.util.*;

public class update_StateDumper {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/homlockin/StateDumper.java")));
        content = content.replace("for (Jatekos j : Main.jatekosok.values())", 
            "for (Map.Entry<String, Jatekos> mapEntry : Main.jatekosok.entrySet()) {\n            Jatekos j = mapEntry.getValue();\n            String jId = mapEntry.getKey();");
        Files.write(Paths.get("src/homlockin/StateDumper.java"), content.getBytes());
    }
}
