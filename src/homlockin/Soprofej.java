package homlockin;

public class Soprofej implements HokotroFej {
    private String name;

    public Soprofej() { this.name = "soprofej"; }
    public Soprofej(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void munkatVegez(Utszakasz szakasz, Hokotro hokotro) {
        Skeleton.methodCalled(name + ".munkatVegez(" + szakasz.getName() + ")");
        szakasz.hoLesopres();
        Utszakasz jobbUt = szakasz.getJobbUt();
        if (jobbUt != null) {
            jobbUt.hoRasopres();
        }
        Skeleton.methodReturned();
    }
}
