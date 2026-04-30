import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RestoreTests {
    public static void main(String[] args) {
        String[][] tests = {
            {"a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - e : jeg3t\ne U - : zuzalek\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 hanyo\nswap hk1 hanyo\nroute hk1 b c d e\nstep\nstep\nstep\nstep\nsave expected.txt\n", "tj1 850 hk1\n\thk1 hanyo 0 0 0\na - :\nb - :\nc - : jeg3\nd - :\ne hk1 :\n"},
            {"a U - b :\nb U bb c : ho3\nc U cc d : jeg3\nd U dd e : jeg3t\ne U ee f : zuzalek\nf U - : ho5\nbb U - :\ncc U - :\ndd U - :\nee U - :\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nroute hk1 b c d e f\nstep\nstep\nstep\nstep\nstep\nsave expected.txt\n", "tj1 925 hk1\n\thk1 sopro 0 0 0\na - :\nb - :\nc - : jeg3\nd - :\ne - : \naa - : \nbb - : ho3\ncc - :\ndd - : jeg3t\nee - : zuzalek\nf hk1 :\n"},
            {"a U - b :\nb U - : jeg3\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 jegtoro\nswap hk1 jegtoro\nroute hk1 b\nstep\nsave expected.txt\n", "tj1 855 hk1\n\thk1 jegtoro 0 0 0\na - :\nb hk1 : jeg3t\n"},
            {"a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - e : jeg3t\ne U - : zuzalek\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 sarkany\nswap hk1 sarkany\nbuy -kerozin hk1\nroute hk1 b c d e\nstep\nstep\nstep\nstep\nsave expected.txt\n", "tj1 860 hk1\n\thk1 sarkany 0 26 0\na - :\nb - :\nc - :\nd - :\ne hk1 : zuzalek\n"},
            {"a U - b :\nb U - c : jeg3\nc U - : ho2\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 zuzalek\nswap hk1 zuzalek\nbuy -zuzalek hk1\nroute hk1 b c\nstep\nstep\nsave expected.txt\n", "tj1 850 hk1\n\thk1 zuzalek 0 0 28\na - :\nb - : jeg3 zuzalek\nc hk1 : ho2 zuzalek\n"},
            {"a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - e : jeg3t\ne U - : zuzalek\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 soszoro\nswap hk1 soszoro\nbuy -so hk1\nroute hk1 b c d e\nstep\nstep\nstep\nstep\nsave expected.txt\n", "tj1 860 hk1\n\thk1 soszoro 26 0 0\na - :\nb - : ho1\nc - : jeg2\nd - : jeg3t\ne hk1 : zuzalek\n"},
            {"a U - : \n", "init palya.txt\nsnow\nsave expected.txt\n", "a - : ho1\n"},
            {"a A - :\nb U - : ho3\nc U - : jeg3\nd U - : jeg3t\n", "init palya.txt\nsnow\nsnow\nsnow\nsnow\nsave expected.txt\n", "a - :\nb - : ho5\nc - : ho4 jeg3\nd - : ho4 jeg3t\n"},
            {"a U - : ho2 zuzalek\n", "init palya.txt\nsnow\nsnow\nsave expected.txt\n", "a - : ho4\n"},
            {"a U - b :\nb U - c : ho3\nc U - : ho1 jeg1\n", "init palya.txt\ncar car1 a b c\nstep\nstep\nsave expected.txt\n", "a - :\nb - : ho2 jeg1\nc car1 : jeg2\n"},
            {"a U - b :\nb U - c :\nc U - d :\nd U - :\n", "init palya.txt\nadd -bj bj1 a d\nroute bj1 b c d\nstep\nstep\nstep\nsave expected.txt\n", "bj1 5\na - :\nb - :\nc - :\nd bj1 :\n"},
            {"a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - : jeg3t\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nroute hk1 b c d\nstep\nstep\nstep\nstep\nsave expected.txt\n", "tj1 915 hk1\n\thk1 sopro 0 0 0\na - :\nb - :\nc - : jeg3\nd hk1 :\n"},
            {"a U - b :\nb U - c :\nc U - : ho4\n", "init palya.txt\ncar car1 a b c\nstep\nstep\nstep\nsave expected.txt\n", "a - :\nb car1 :\nc - : ho4\n"},
            {"a U - b :\nb U - c : ho5\nc U - :\nd U - b :\n", "init palya.txt\ncar car1 a b c\nadd -tj tj1\nstep\nstep\nstep\nbuy -hk hk1 tj1 d\nroute hk1 b c\nstep\nstep\nsave expected.txt\n", "tj1 910 hk1\n\thk1 sopro 0 0 0\na - :\nb car1 : ho5\nc hk1 :\nd - :\n"},
            {"a U - b :\nb U - c :\nc U - :\n", "init palya.txt\ncar car1 a b c\nstep\nstep\nsave expected.txt\n", "a - :\nb - :\nc - :\n"},
            {"a U - b :\nb U - c : jeg4\nc U - :\n", "init palya.txt\ncar car1 a b c\nstep\nsave expected.txt\n", "a - :\nb - : jeg4\nc car1 :\n"},
            {"a U - b :\nb U - c : jeg4\nc U - e :\nd U - c :\ne U - :\n", "init palya.txt\ncar car1 d c e\ncar car2 a b c e\nstep\nstep\nsave expected.txt\n", "a - :\nb car1 : jeg4\nc car2 :\nd - :\ne - :\n"},
            {"a U - b :\nb U - c :\nc U - d : ho1 jeg2\nd U - e :\ne U - :\n", "init palya.txt\ncar car1 b c d e\ncar car2 a b c d e\nstep\nstep\nstep\nsave expected.txt\n", "a - :\nb - :\nc car2 : jeg3\nd car1 :\ne - :\n"},
            {"a U - b :\nb U - c : jeg4\nc U - e :\nd U - c :\ne U - :\n", "init palya.txt\nadd -bj bj1 d a\nroute bj1 c e\ncar car1 a b c\nstep\nstep\nstep\nstep\nstep\nsave expected.txt\n", "bj1 0\na - :\nb car1 : jeg4\nc - :\nd - :\ne bj1 :\n"},
            {"a U - b :\nb U - c : jeg4\nc U - e :\nd U - c :\ne U - :\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 d\nroute hk1 c e\ncar car1 a b c\nstep\nstep\nsave expected.txt\n", "tj1 900 hk1\n\thk1 sopro 0 0 0\na - :\nb car1 : jeg4\nc - :\nd - :\ne hk1 :\n"},
            {"a U - b :\nb U - c :\nc U - :\n", "init palya.txt\nadd -tj tj1\nadd -tj tj2\nbuy -hk hk1 tj1 a\nbuy -hk hk2 tj2 b\nsave expected.txt\n", "tj1 900 hk1\n\thk1 sopro 0 0 0\ntj2 900 hk2\n\thk2 sopro 0 0 0\na hk1 :\nb hk2 :\nc - :\n"},
            {"a U - :\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -so hk1\nsave expected.txt\n", "tj1 890 hk1\n\thk1 sopro 30 0 0\na hk1 :\n"},
            {"a U - :\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -kerozin hk1\nsave expected.txt\n", "tj1 890 hk1\n\thk1 sopro 0 30 0\na hk1 :\n"},
            {"a U - :\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -zuzalek hk1\nsave expected.txt\n", "tj1 890 hk1\n\thk1 sopro 0 0 30\na hk1 :\n"},
            {"a U - :\n", "init palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 soszoro\nswap hk1 soszoro\nsave expected.txt\n", "tj1 850 hk1\n\thk1 soszoro 0 0 0\na hk1 :\n"}
        };

        for (int i = 0; i < tests.length; i++) {
            int idx = i + 1;
            File dir = new File("tests/Test" + idx);
            if (!dir.exists()) dir.mkdirs();
            
            writeFile(new File(dir, "palya.txt"), tests[i][0]);
            // update input commands to use palya.txt and expected.txt locally
            String input = tests[i][1].replace("test" + idx + "_palya.txt", "palya.txt")
                                    .replace("test" + idx + "_expected.txt", "expected.txt");
            writeFile(new File(dir, "input.txt"), input);
            writeFile(new File(dir, "expected.txt"), tests[i][2]);
        }
        System.out.println("Tests restored successfully.");
    }

    private static void writeFile(File file, String content) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
