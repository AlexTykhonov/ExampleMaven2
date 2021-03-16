import Modules.Annuitator;

public class TestAnnuitClassMavenLab {

    public static void main(String[] args) {


        SimpleGui simpleGui = new SimpleGui();

        double income = simpleGui.getInputIncome();
        int term = simpleGui.getInputTerm();
        double rate = simpleGui.getInputRate();
        double othPay = simpleGui.getInputOthPay();
        double share = simpleGui.getInputShare();
        boolean scheduleCheck = simpleGui.getButton1();
        double loanAmount = 0.0;
        double payment = 0.0;

        Annuitator annuitator = new Annuitator();

        if (scheduleCheck) {
            loanAmount= annuitator.getAmountAn(income*share/100-othPay,rate,term);
            payment=annuitator.annPayment(term,rate,loanAmount);
        }
        simpleGui.setAvailableLoan(loanAmount);
        simpleGui.setMntPayment(payment);

        //old test for library
        //System.out.println(annuitator.annPayment(12, 25, 10000));
    }
}
