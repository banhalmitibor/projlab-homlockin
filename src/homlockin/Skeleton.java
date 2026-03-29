package homlockin;

import java.util.Scanner;

public class Skeleton {
    private static int depth = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void startInit(String name) {
        System.out.println("--INIT-- " + name);
        depth = 1;
    }

    public static void startTest(String name) {
        System.out.println("--TEST-- " + name);
        depth = 1;
    }

    public static void methodCalled(String call) {
        System.out.println("\t".repeat(depth) + call);
        depth++;
    }

    public static void methodReturned() {
        depth--;
        System.out.println("\t".repeat(depth) + "return");
    }

    public static void printNew(String className) {
        System.out.println("\tnew " + className + "()");
        System.out.println("\treturn");
    }

    public static void printInitCall(String call) {
        System.out.println("\t" + call);
        System.out.println("\treturn");
    }

    public static boolean askYesNo(String question) {
        System.out.print("\t".repeat(depth) + question + " (y/n): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("y") || answer.equals("yes") || answer.equals("i") || answer.equals("igen");
    }
}
