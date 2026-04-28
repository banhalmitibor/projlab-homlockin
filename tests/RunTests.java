package tests;

public class RunTests {
    public static void runTest(String[] args) {

        if (args.length == 0) {
            System.out.println("Osszes teszt fut\n");

        } 
        else {
            switch (args[0]) {
                case "1":


                    break;
                // case "2":

                default:
                    System.out.println("Nincs ilyen teszt!");
            }
        }
    }
}
