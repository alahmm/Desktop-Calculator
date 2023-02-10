package calculator;

import javax.swing.*;

class Calculator extends JFrame{
    public Calculator () {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null); // sets absolute positioning of components
        setVisible(true);
    }
    public void initComponents() {
        JTextField EquationTextField = new JTextField();
        EquationTextField.setBounds(140,20, 120,30);
        add(EquationTextField);

        JButton Solve = new JButton();
        Solve.setBounds(100,100,100,30);
        Solve.setText("Solve");
        add(Solve);
        Solve.addActionListener(e -> {
            String equation = EquationTextField.getText();
            int[] array = new int[2];
            String[] arrayOfString = equation.split("[+-/*]");
            array[0] = Integer.parseInt(arrayOfString[0]);
            array[1] = Integer.parseInt(arrayOfString[1]);
            String operator = "";
            float result = 0;
            for (int i = 0; i < equation.length(); i++) {
                operator += equation.charAt(i);
                if (operator.matches("\\d")) {
                    operator = "";
                } else if (operator.matches("[+-/*]")){
                    switch (operator) {
                        case "+" -> result = array[0] + array[1];
                        case "-" -> result = array[0] - array[1];
                        case "/" -> result = (float) array[0] / array[1];
                        case "*" -> result = array[0] * array[1];
                    }
                }
            }
            String stringResult = String.format("%.1f", result);
            String[] arrayWithoutComma = stringResult.split(",");
            if (arrayWithoutComma[1].equals("0")) {
                equation += "=" + arrayWithoutComma[0];
            } else {
                equation += "=" + result;
            }
            EquationTextField.setText(equation);
        });
    }
}
public class ApplicationRunner {
    public static void main(String[] args) {
        new Calculator();
    }
}