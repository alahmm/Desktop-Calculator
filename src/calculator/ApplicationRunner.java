package calculator;

import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame{
    public Calculator () {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(305, 500);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null); // sets absolute positioning of components
        setVisible(true);
    }
    public void initComponents() {
        /**
         * first label
         */
        JLabel ResultLabel = new JLabel("0", JLabel.RIGHT);
        ResultLabel.setBounds(10,10, 270,30);
        add(ResultLabel);

        Font font2 = new Font("Courier", Font.BOLD,12);
        ResultLabel.setFont(font2);
        ResultLabel.setFont(ResultLabel.getFont().deriveFont(20f));

        /**
         * second label
         */
        JLabel EquationLabel = new JLabel("", JLabel.RIGHT);
        EquationLabel.setBounds(10,60, 270,30);
        add(EquationLabel);
        EquationLabel.setForeground(Color.BLUE);
        /**
         * delete button
         */
        JButton Delete = new JButton();
        Delete.setName("Delete");
        Delete.setBounds(220, 140, 60, 40);
        Delete.setText("Del");
        add(Delete);
        Delete.addActionListener(e -> {
            String content = EquationLabel.getText();
            content = content.substring(0, content.length() - 1);
            EquationLabel.setText(content);
        });
        /**
         * clear button
         */
        JButton Clear = new JButton();
        Clear.setName("Clear");
        Clear.setBounds(150, 140, 60, 40);
        Clear.setText("C");
        add(Clear);
        Clear.addActionListener(e -> {
            ResultLabel.setText("0");
            EquationLabel.setText("");
        });
/*        JTextField EquationTextField = new JTextField();
        EquationTextField.setBounds(10,10, 265,30);
        EquationTextField.setName("EquationTextField");
        add(EquationTextField);*/
        /**
         * pannel for buttons
         */
/*        JPanel panel = new JPanel(new GridLayout(4, 5));
        panel.setBounds(10,45,265,210);
        add(panel);*/

        /**
         * add buttons to it
         */

        JButton Seven = new JButton();
        Seven.setName("Seven");
        Seven.setBounds(10, 200, 60, 40);
        Seven.setText("7");
        add(Seven);
        Seven.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Seven.getText();
            } else {
                content += Seven.getText();
            }*/
            content += Seven.getText();
            EquationLabel.setText(content);
        });

        JButton Eight = new JButton();
        Eight.setName("Eight");
        Eight.setBounds(80, 200, 60, 40);
        Eight.setText("8");
        add(Eight);
        Eight.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Eight.getText();
            } else {
                content += Eight.getText();
            }*/
            content += Eight.getText();
            EquationLabel.setText(content);
        });

        JButton Nine = new JButton();
        Nine.setName("Nine");
        Nine.setBounds(150, 200, 60, 40);
        Nine.setText("9");
        add(Nine);
        Nine.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Nine.getText();
            } else {
                content += Nine.getText();
            }*/
            content += Nine.getText();
            EquationLabel.setText(content);
        });

        JButton Divide = new JButton();
        Divide.setName("Divide");
        Divide.setBounds(220, 200, 60, 40);
        Divide.setText("÷");
        add(Divide);
        Divide.addActionListener(e -> {
            String content = EquationLabel.getText();
            content += Divide.getText();
            EquationLabel.setText(content);
        });

        JButton Four = new JButton();
        Four.setName("Four");
        Four.setBounds(10, 260, 60, 40);
        Four.setText("4");
        add(Four);
        Four.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Four.getText();
            } else {
                content += Four.getText();
            }*/
            content += Four.getText();
            EquationLabel.setText(content);
        });

        JButton Five = new JButton();
        Five.setName("Five");
        Five.setBounds(80, 260, 60, 40);
        Five.setText("5");
        add(Five);
        Five.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Five.getText();
            } else {
                content += Five.getText();
            }*/
            content += Five.getText();
            EquationLabel.setText(content);
        });

        JButton Six = new JButton();
        Six.setName("Six");
        Six.setBounds(150, 260, 60, 40);
        Six.setText("6");
        add(Six);
        Six.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Six.getText();
            } else {
                content += Six.getText();
            }*/
            content += Six.getText();
            EquationLabel.setText(content);
        });

        JButton Multiply = new JButton();
        Multiply.setName("Multiply");
        Multiply.setBounds(220, 260, 60, 40);
        Multiply.setText("x");
        add(Multiply);
        Multiply.addActionListener(e -> {
            String content = EquationLabel.getText();
            content += Multiply.getText();
            EquationLabel.setText(content);
        });

        JButton One = new JButton();
        One.setName("One");
        One.setBounds(10, 310, 60, 40);
        One.setText("1");
        add(One);
        One.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = One.getText();
            } else {
                content += One.getText();
            }*/
            content += One.getText();
            EquationLabel.setText(content);
        });

        JButton Two = new JButton();
        Two.setName("Two");
        Two.setBounds(80, 310, 60, 40);
        Two.setText("2");
        add(Two);
        Two.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Two.getText();
            } else {
                content += Two.getText();
            }*/
            content += Two.getText();
            EquationLabel.setText(content);
        });

        JButton Three = new JButton();
        Three.setName("Three");
        Three.setBounds(150, 310, 60, 40);
        Three.setText("3");
        add(Three);
        Three.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Three.getText();
            } else {
                content += Three.getText();
            }*/
            content += Three.getText();
            EquationLabel.setText(content);
        });

        JButton Add = new JButton();
        Add.setName("Add");
        Add.setBounds(220, 310, 60, 40);
        Add.setText("+");
        add(Add);
        Add.addActionListener(e -> {
            String content = EquationLabel.getText();
            content += Add.getText();
            EquationLabel.setText(content);
        });

        JButton Dot = new JButton();

        Dot.setName("Dot");
        Dot.setText(".");
        Dot.setBounds(10, 370, 60, 40);
        add(Dot);
        Dot.addActionListener(e -> {
            String content = EquationLabel.getText();
            //content = ",";
            content += Dot.getText();
            EquationLabel.setText(content);
        });

        JButton Zero = new JButton();

        Zero.setName("Zero");
        Zero.setText("0");
        Zero.setBounds(80, 370, 60, 40);
        add(Zero);
        Zero.addActionListener(e -> {
            String content = EquationLabel.getText();
/*            if (content.equals("0")) {
                content = Zero.getText();
            } else {
                content += Zero.getText();
            }*/
            content += Zero.getText();
            EquationLabel.setText(content);
        });

        JButton Equals = new JButton();
        Equals.setBounds(150, 370, 60, 40);
        Equals.setText("=");
        Equals.setName("Equals");
        add(Equals);
        Equals.addActionListener(e -> {
            String equation = EquationLabel.getText();
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
                equation = arrayWithoutComma[0];
            } else {
                equation = String.format("%f", result);
            }
            ResultLabel.setText(equation);
        });

        JButton Subtract = new JButton();
        Subtract.setName("Subtract");
        Subtract.setBounds(220, 370, 60, 40);
        Subtract.setText("-");
        add(Subtract);
        Subtract.addActionListener(e -> {
            String content = EquationLabel.getText();
            content += Subtract.getText();
            EquationLabel.setText(content);
        });
    }
}
public class ApplicationRunner {
    public static void main(String[] args) {
        new Calculator();
    }
}
