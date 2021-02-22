import Modules.Annuitator;

public class TestAnnuitClassMavenLab {

    public static void main(String[] args) {
        Annuitator annuitator = new Annuitator();
        System.out.println(annuitator.annPayment(12,25,10000));
    }
}
