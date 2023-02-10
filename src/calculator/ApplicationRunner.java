package calculator;

import javax.swing.*;
import java.awt.*;

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
        EquationTextField.setBounds(10,10, 265,30);
        EquationTextField.setName("EquationTextField");
        add(EquationTextField);
        /**
         * pannel for buttons
         */
        JPanel panel = new JPanel(new GridLayout(4, 5));
        panel.setBounds(10,45,265,210);
        add(panel);

        /**
         * add buttons to it
         */

        JButton Seven = new JButton();
        Seven.setName("Seven");
        Seven.setBounds(20, 10, 40, 40);
        Seven.setText("7");
        panel.add(Seven);
        Seven.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Seven.getText();
            EquationTextField.setText(content);
        });

        JButton Eight = new JButton();
        Eight.setName("Eight");
        Eight.setBounds(80, 10, 40, 40);
        Eight.setText("8");
        panel.add(Eight);
        Eight.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Eight.getText();
            EquationTextField.setText(content);
        });

        JButton Nine = new JButton();
        Nine.setName("Nine");
        Nine.setBounds(140, 10, 40, 40);
        Nine.setText("9");
        panel.add(Nine);
        Nine.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Nine.getText();
            EquationTextField.setText(content);
        });

        JButton Divide = new JButton();
        Divide.setName("Divide");
        Divide.setBounds(200, 10, 40, 40);
        Divide.setText("/");
        panel.add(Divide);
        Divide.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Divide.getText();
            EquationTextField.setText(content);
        });

        JButton Four = new JButton();
        Four.setName("Four");
        Four.setBounds(20, 55, 40, 40);
        Four.setText("4");
        panel.add(Four);
        Four.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Four.getText();
            EquationTextField.setText(content);
        });

        JButton Five = new JButton();
        Five.setName("Five");
        Five.setBounds(80, 55, 40, 40);
        Five.setText("5");
        panel.add(Five);
        Five.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Five.getText();
            EquationTextField.setText(content);
        });

        JButton Six = new JButton();
        Six.setName("Six");
        Six.setBounds(140, 55, 40, 40);
        Six.setText("6");
        panel.add(Six);
        Six.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Six.getText();
            EquationTextField.setText(content);
        });

        JButton Multiply = new JButton();
        Multiply.setName("Multiply");
        Multiply.setBounds(200, 55, 40, 40);
        Multiply.setText("x");
        panel.add(Multiply);
        Multiply.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Multiply.getText();
            EquationTextField.setText(content);
        });

        JButton One = new JButton();
        One.setName("One");
        One.setBounds(20, 100, 40, 40);
        One.setText("1");
        panel.add(One);
        One.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += One.getText();
            EquationTextField.setText(content);
        });

        JButton Two = new JButton();
        Two.setName("Two");
        Two.setBounds(80, 100, 40, 40);
        Two.setText("2");
        panel.add(Two);
        Two.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Two.getText();
            EquationTextField.setText(content);
        });

        JButton Three = new JButton();
        Three.setName("Three");
        Three.setBounds(140, 100, 40, 40);
        Three.setText("3");
        panel.add(Three);
        Three.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Three.getText();
            EquationTextField.setText(content);
        });

        JButton Add = new JButton();
        Add.setName("Add");
        Add.setBounds(200, 100, 40, 40);
        Add.setText("+");
        panel.add(Add);
        Add.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Add.getText();
            EquationTextField.setText(content);
        });

        JButton Zero = new JButton();

        Zero.setName("Zero");
        Zero.setText("0");
        Zero.setBounds(80, 155, 40, 40);
        panel.add(Zero);
        Zero.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Zero.getText();
            EquationTextField.setText(content);
        });

        JButton Equals = new JButton();
        Equals.setBounds(140, 155, 40, 40);
        Equals.setText("=");
        Equals.setName("Equals");
        panel.add(Equals);
        Equals.addActionListener(e -> {
            String equation = EquationTextField.getText();
            int[] array = new int[2];
            String[] arrayOfString = equation.split("[+-/x]");
            array[0] = Integer.parseInt(arrayOfString[0]);
            array[1] = Integer.parseInt(arrayOfString[1]);
            String operator = "";
            float result = 0;
            for (int i = 0; i < equation.length(); i++) {
                operator += equation.charAt(i);
                if (operator.matches("\\d")) {
                    operator = "";
                } else if (operator.matches("[+-/x]")){
                    switch (operator) {
                        case "+" -> result = array[0] + array[1];
                        case "-" -> result = array[0] - array[1];
                        case "/" -> result = (float) array[0] / array[1];
                        case "x" -> result = array[0] * array[1];
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

        JButton Subtract = new JButton();
        Subtract.setName("Subtract");
        Subtract.setBounds(200, 155, 40, 40);
        Subtract.setText("-");
        panel.add(Subtract);
        Subtract.addActionListener(e -> {
            String content = EquationTextField.getText();
            content += Subtract.getText();
            EquationTextField.setText(content);
        });
    }
}
public class ApplicationRunner {
    public static void main(String[] args) {
        new Calculator();
    }
}