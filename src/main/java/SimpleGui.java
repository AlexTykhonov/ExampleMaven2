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
    private JLabel labelOthPay = new JLabel("Сколько платите по другим кредитам в месяц?");
    private JTextField inputOthPay = new JTextField("100");
    private JLabel labelShare = new JLabel("Какая часть дохода в месяц может уходить на кредитные платежи?");
    private JTextField inputShare = new JTextField("40%");

    //описываем 2 кнопки для выбора графика погашения по кредиту
    private JRadioButton button1 = new JRadioButton("Стандартный график - платежи уменьшаются, долг снижается");
    private JRadioButton button2 = new JRadioButton("Аннуитет - каждый месяц платим одинаковую сумму");
    private JCheckBox checkbox = new JCheckBox("Check", false);

    private JButton jButton = new JButton("Готово!");

    public SimpleGui() {
        super("Оцените свою кредитоспособность в 1 клик");
        this.setBounds(120, 120, 220, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(380,220);
        Container container = this.getContentPane();

        // определяем форму выдачи - 2 колонки, 6 строк
        container.setLayout(new GridLayout(5, 2, 2, 2));
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

//        ButtonGroup group = new ButtonGroup();
//        group.add(button1);
//        group.add(button2);
//        container.add(button1);
//        button1.setSelected(true);
//        container.add(button2);
//        jButton.addActionListener(new ButtonEventListener());
//        container.add(jButton);
       // pack();
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            String message = "";
            message += "Button was pressed \n";
//            message += "Text is " + input.getText() + " \n";
            message += (button1.isSelected() ? "Button 1" : "Button 2") + " is selected.\n";
//            message += "Checkbox is " + (checkbox.isSelected() ? "selected!\n " : "not selected! \n");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public static void main(String[] args) {
        SimpleGui app = new SimpleGui();
        app.setVisible(true);
    }
}
