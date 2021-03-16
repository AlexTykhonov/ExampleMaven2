import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleGui extends JFrame {

    //расписываем поля ввода текста
    private JLabel labelIncome = new JLabel("Сколько зарабатываете в месяц?");
    private JTextField inputIncome = new JTextField("1000");
    private JLabel labelTerm = new JLabel("Длина кредита, месяцев");
    private JTextField inputTerm = new JTextField("120");
    private JLabel labelRate = new JLabel("Ставка по кредиту, % годовых");
    private JTextField inputRate = new JTextField("12%");
    private JLabel labelOthPay = new JLabel("Платите по другим кредитам в месяц");
    private JTextField inputOthPay = new JTextField("100");
    private JLabel labelShare = new JLabel("Доля дохода в месяц на кредитные платежи?");
    private JTextField inputShare = new JTextField("40%");

    //описываем 2 кнопки для выбора графика погашения по кредиту
    private JRadioButton button1 = new JRadioButton("График - платежи уменьшаются, долг снижается");
    private JRadioButton button2 = new JRadioButton("Каждый месяц платим одинаковую сумму");
    private JCheckBox checkbox = new JCheckBox("Check", false);
    private JButton jButton = new JButton("Готово!");

    //     Переменные которые будут расчитаны в библиотеке Аннуитатор и придут сюда для вывода в Гуи
    Double availableLoan = 0.0; //расчетная сумма доступного кредита
    Double mntPayment = 0.0; //расчетная сумма платежа в месяц


    public SimpleGui() {
        super("Оцените свою кредитоспособность в 1 клик");
        this.setBounds(120, 120, 220, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(380, 220);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        Container container = this.getContentPane();

        // определяем форму выдачи - 2 колонки, 6 строк
        container.setLayout(new GridLayout(7, 2, 2, 2));
        container.add(labelIncome);
        container.add(inputIncome);
        container.add(labelTerm);
        container.add(inputTerm);
        container.add(labelRate);
        container.add(inputRate);
        container.add(labelOthPay);
        container.add(inputOthPay);
        container.add(labelShare);
        container.add(inputShare);

        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        container.add(button1);
        button1.setSelected(true);
        container.add(button2);
        jButton.addActionListener(new ButtonEventListener());
        container.add(jButton);
        jButton.setBackground(Color.gray);
        pack();
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            String message = "";
            message += "Выбрали параметры \n";
            message += "Ваш доход " + inputIncome.getText() + "\n" + "Период кредита " + inputTerm.getText() + "\n" + "Ставка " + inputRate.getText() + "\n" + "Другие платежи " + inputOthPay.getText() + "\n" + "Доля дохода на кредиты " + inputShare.getText() + "\n";
            message += (button1.isSelected() ? "Стандартный " : "Аннуитетный") + " график погашения.\n"+ "\n";
            message += "Доступный кредит: " + availableLoan + "\n" + "Платеж в месяц составит: " + mntPayment;
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public static void main(String[] args) {
        SimpleGui app = new SimpleGui();
        app.setVisible(true);
    }

    // getters and setters
    public double getInputIncome() {
        return Double.valueOf(inputIncome.toString());
    }

    public void setInputIncome(JTextField inputIncome) {
        this.inputIncome = inputIncome;
    }

    public int getInputTerm() {
        return Integer.getInteger(inputTerm.toString());
    }

    public void setInputTerm(JTextField inputTerm) {
        this.inputTerm = inputTerm;
    }

    public double getInputRate() {
        return Double.valueOf(inputRate.toString());
    }

    public void setInputRate(JTextField inputRate) {
        this.inputRate = inputRate;
    }

    public double getInputOthPay() {
        return Double.valueOf(inputOthPay.toString());
    }

    public void setInputOthPay(JTextField inputOthPay) {
        this.inputOthPay = inputOthPay;
    }

    public double getInputShare() {
        return Double.valueOf(inputShare.toString());
    }

    public void setInputShare(JTextField inputShare) {
        this.inputShare = inputShare;
    }

    public boolean getButton1() {
        return Boolean.getBoolean(button1.toString());
    }

    public void setButton1(JRadioButton button1) {
        this.button1 = button1;
    }

    public JRadioButton getButton2() {
        return button2;
    }

    public void setButton2(JRadioButton button2) {
        this.button2 = button2;
    }

    public Double getAvailableLoan() {
        return availableLoan;
    }

    public void setAvailableLoan(Double availableLoan) {
        this.availableLoan = availableLoan;
    }

    public Double getMntPayment() {
        return mntPayment;
    }

    public void setMntPayment(Double mntPayment) {
        this.mntPayment = mntPayment;
    }
}
