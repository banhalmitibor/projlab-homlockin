package homlockin;

public class Soprofej implements HokotroFej {

    @Override
    public String getName() { return "Soprofej"; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled("soprofej.munkatVegez(" + szakasz.getName() + ", hokotro)");
        szakasz.hoLesopres();
        Utszakasz jobbUt = szakasz.getJobbUt();
        if (jobbUt != null) {
            jobbUt.hoRasopres();
        }
        Skeleton.methodReturned();
    }
}
