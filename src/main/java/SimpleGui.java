import Modules.Annuitator;

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
    private JLabel labelRate = new JLabel("Ставка по кредиту, %% годовых");
    private JTextField inputRate = new JTextField("12");
    private JLabel labelOthPay = new JLabel("Платите по другим кредитам в месяц");
    private JTextField inputOthPay = new JTextField("100");
    private JLabel labelShare = new JLabel("Доля дохода в месяц на кредиты, %%?");
    private JTextField inputShare = new JTextField("40");

    //описываем 2 кнопки для выбора графика погашения по кредиту
    private JRadioButton button1 = new JRadioButton("График - платежи уменьшаются, долг снижается");
    private JRadioButton button2 = new JRadioButton("Каждый месяц платим одинаковую сумму");
    private JCheckBox checkbox = new JCheckBox("Check", false);
    private JButton jButton = new JButton("Готово!");

    //     Переменные которые будут расчитаны в библиотеке Аннуитатор и придут сюда для вывода в Гуи
    Double availableLoan = 0.0; //расчетная сумма доступного кредита
    Double mntPayment = 0.0; //расчетная сумма платежа в месяц

    Annuitator annuitator = new Annuitator();

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
        container.add(button2);
        button1.setSelected(true);

        container.add(jButton);
        jButton.setBackground(Color.gray);
        pack();

        jButton.addActionListener(new ButtonEventListener());

    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {


            // ловим ошибки формата введенных значений, должны быть текстовые поля похожие на числа, не текст, не пустота

            try {
                Double i = Double.valueOf(inputIncome.getText());
                Double s = Double.valueOf(inputShare.getText());
                Double o = Double.valueOf(inputOthPay.getText());
                Integer t = Integer.valueOf(inputTerm.getText());
                Double r = Double.valueOf(inputRate.getText());
            } catch (Exception e) {
                String messageError = "Проверьте введенные значения";
                JOptionPane.showMessageDialog(null, messageError, "Формат ввода!", JOptionPane.PLAIN_MESSAGE);
            } finally {
                Double income = Double.valueOf(inputIncome.getText());
                Double share = Double.valueOf(inputShare.getText());
                Double otherPay = Double.valueOf(inputOthPay.getText());
                Integer term = Integer.valueOf(inputTerm.getText());
                Double rate = Double.valueOf(inputRate.getText());

                if (button1.isSelected()) {
                    availableLoan = Math.ceil(annuitator.getAmountAn(income * share / 100 - otherPay, rate, term));
                    mntPayment = Math.ceil((Double) annuitator.annPayment(term, rate, availableLoan));

                } else if (button2.isSelected()) {
                    availableLoan = Math.ceil(annuitator.getAmountStnd(income * share / 100 - otherPay, rate, term));
                    mntPayment = Math.ceil((availableLoan / term) + (availableLoan * rate / 1200));
                }
                String message = "";
                message += "Вы выбрали параметры \n";
                message += "Ваш доход " + inputIncome.getText() + "\n" + "Период кредита " + inputTerm.getText() + "\n" + "Ставка " + inputRate.getText() + "\n" + "Другие платежи " + inputOthPay.getText() + "\n" + "Доля дохода на кредиты " + inputShare.getText() + "\n";
                message += (button1.isSelected() ? "Стандартный " : "Аннуитетный") + " график погашения.\n" + "\n----------------\n" + "\n";
                message += "Вам доступен кредит: " + availableLoan + "\n" + "Платеж в месяц: " + mntPayment;
                JOptionPane.showMessageDialog(null, message, "Результаты:", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SimpleGui app = new SimpleGui();
        app.setVisible(true);
    }


}
