import java.nio.file.*;

public class fix_Commands {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/homlockin/Main.java")));
        
        // 1. Add 'swap' and 'car' into processCommand case list
        content = content.replace("case \"buy\":",
            "case \"swap\":\n                    handleSwap(parts);\n                    break;\n" +
            "                case \"car\":\n                    handleCar(parts);\n                    break;\n" +
            "                case \"buy\":");

        // 2. Replace handleBuy totally
        String newHandleBuy = 
    "    private static void handleSwap(String[] parts) {\n" +
    "        if (parts.length < 3) return;\n" +
    "        String hkId = parts[1];\n" +
    "        String tipus = parts[2];\n" +
    "        Hokotro hk = (Hokotro) jarmuvek.get(hkId);\n" +
    "        if (hk != null) hk.csere(tipus);\n" +
    "    }\n" +
    "    \n" +
    "    private static void handleCar(String[] parts) {\n" +
    "        if (parts.length < 3) return;\n" +
    "        String id = parts[1];\n" +
    "        String startId = parts[2];\n" +
    "        Utszakasz pos = utszakaszok.get(startId);\n" +
    "        if (pos != null) {\n" +
    "            Auto a = new Auto(id);\n" +
    "            a.setAllRajta(pos);\n" +
    "            pos.setJarmu(a);\n" +
    "            varos.addJarmu(a);\n" +
    "            jarmuvek.put(id, a);\n" +
    "            for (int i = 3; i < parts.length; i++) {\n" +
    "                Utszakasz u = utszakaszok.get(parts[i]);\n" +
    "                if (u != null) a.getUtvonala().addUtszakasz(u);\n" +
    "            }\n" +
    "        }\n" +
    "    }\n" +
    "    \n" +
    "    private static TakaritoJatekos findOwner(Hokotro hk) {\n" +
    "        for (Jatekos j : jatekosok.values()) {\n" +
    "            if (j instanceof TakaritoJatekos && ((TakaritoJatekos)j).getHokotroje() == hk) {\n" +
    "                return (TakaritoJatekos) j;\n" +
    "            }\n" +
    "        }\n" +
    "        return null;\n" +
    "    }\n" +
    "\n" +
    "    private static void handleBuy(String[] parts) {\n" +
    "        if (parts.length < 3) return;\n" +
    "        String type = parts[1];\n" +
    "        \n" +
    "        if (type.equals(\"-hk\")) {\n" +
    "            if (parts.length >= 5) {\n" +
    "                String hkId = parts[2];\n" +
    "                String tjId = parts[3];\n" +
    "                String uId  = parts[4];\n" +
    "                \n" +
    "                Jatekos j = jatekosok.get(tjId);\n" +
    "                Utszakasz u = utszakaszok.get(uId);\n" +
    "                \n" +
    "                if (j instanceof TakaritoJatekos && u != null) {\n" +
    "                    Hokotro hk = bolt.hokotrotVasarol(hkId, (TakaritoJatekos)j, u);\n" +
    "                    if (hk != null) {\n" +
    "                         varos.addJarmu(hk);\n" +
    "                         jarmuvek.put(hkId, hk);\n" +
    "                         u.setJarmu(hk);\n" +
    "                    }\n" +
    "                }\n" +
    "            }\n" +
    "        } else if (type.equals(\"-fej\")) {\n" +
    "            if (parts.length >= 4) {\n" +
    "                String hkId = parts[2];\n" +
    "                String fejType = parts[3];\n" +
    "                Hokotro hk = (Hokotro) jarmuvek.get(hkId);\n" +
    "                if (hk != null) {\n" +
    "                    TakaritoJatekos tj = findOwner(hk);\n" +
    "                    bolt.fejetVasarol(hkId + \"_\" + fejType, tj, fejType);\n" +
    "                }\n" +
    "            }\n" +
    "        } else if (type.equals(\"-so\") || type.equals(\"-zuzalek\") || type.equals(\"-kerozin\")) {\n" +
    "            if (parts.length >= 3) {\n" +
    "                String hkId = parts[2];\n" +
    "                Hokotro hk = (Hokotro) jarmuvek.get(hkId);\n" +
    "                if (hk != null) {\n" +
    "                    TakaritoJatekos tj = findOwner(hk);\n" +
    "                    if (type.equals(\"-so\")) bolt.sotVasarol(tj);\n" +
    "                    else if (type.equals(\"-zuzalek\")) bolt.zuzalekotVasarol(tj);\n" +
    "                    else if (type.equals(\"-kerozin\")) bolt.biokerozintVasarol(tj);\n" +
    "                }\n" +
    "            }\n" +
    "        }\n" +
    "    }\n";
        
        content = content.replaceAll("(?s)private static void handleBuy.*?(?=private static void handleRoute)", newHandleBuy);
        
        Files.write(Paths.get("src/homlockin/Main.java"), content.getBytes());
    }
}
