package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
    public static String PostfixConverter (String equation) {
        final String divideSymbol = "\u00F7";
        final String multiplySymbol = "\u00D7";
        final String addSymbol = "\u002B";
        final String subtractSymbol = "-";
        String result = "";
        String operator = "";
        for (int i = 0; i < equation.length(); i++) {
            String c = equation.substring(i, i + 1);
            if (i == 0) {
                result += '(';
                for (int j = 0; j < equation.length(); j++) {
                    char c2 = equation.charAt(j);
                    if (Character.isDigit(c2)) {
                        result += equation.charAt(j);
                    } else if (c2 == '.') {
                        result += equation.charAt(j);
                    } else {
                        break;
                    }

                }
                result += ')';
            }
            if (c.equals(multiplySymbol) || c.equals(divideSymbol)) {
                result += '(';
                for (int j = i + 1; j <equation.length() ; j++) {
                    char c2 = equation.charAt(j);
                    if (Character.isDigit(c2)) {
                        result += equation.charAt(j);
                    } else if (c2 == '.') {
                        result += equation.charAt(j);
                    } else {
                        break;
                    }
                }
                result += ')';
                result += c;
            } else if (c.equals(subtractSymbol) || c.equals(addSymbol)) {
                result += '(';
                for (int j = i + 1; j < equation.length(); j++) {
                    char c2 = equation.charAt(j);
                    if (Character.isDigit(c2)) {
                        result += equation.charAt(j);
                    } else if (c2 == '.') {
                        result += equation.charAt(j);
                    } else {
                        break;
                    }
                }
                result += ')';
                if (i < equation.length() - 3) {
                    String s = equation.substring(i + 2, i + 3);
                    if (s.equals(divideSymbol) || s.equals(multiplySymbol)) {
                        operator += c;
                    } else {
                        result += c;
                    }
                } else {
                    operator += c;
                }
            }
        }
        if (operator.length() > 0) {
            String var = "";
            for (int i = 0; i < operator.length(); i++) {
                var += operator.charAt(operator.length() - 1 - i);
            }
            result += var;
        }
        return result;
    }
    public static double calculate(String equation) {
        String member = "";
        final String divideSymbol = "\u00F7";
        final String multiplySymbol = "\u00D7";
        final String addSymbol = "\u002B";
        final String subtractSymbol = "-";
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            String c = equation.substring(i, i + 1);
            if (c.equals("(")) {
                for (int j = i + 1; j <equation.length() ; j++) {
                    char c2 = equation.charAt(j);
                    if (Character.isDigit(c2)) {
                        member += equation.charAt(j);
                    } else if (c2 == '.') {
                        member += equation.charAt(j);
                    }else break;
                }
                stack.push(Double.parseDouble(member));
                member = "";
            } else if (c.equals(addSymbol) || c.equals(subtractSymbol) || c.equals(divideSymbol) || c.equals(multiplySymbol)) {

                double val1 = stack.pop();
                double val2 = stack.pop();

                switch (c) {
                    case addSymbol -> stack.push(val2 + val1);
                    case subtractSymbol -> stack.push(val2 - val1);
                    case divideSymbol -> stack.push(val2 / val1);
                    case multiplySymbol -> stack.push(val2 * val1);
                }
            }
        }
        return stack.pop();
    }
    public static String CommaCorrector(String content) {
        String str = "";
        List<Character> listOfContent = new ArrayList<>();
        String[] array = content.split("\\.");
        if (array.length > 1) {
            if (!array[0].matches("[0-9]")) {
                int i = content.indexOf('.');
                for (int j = 0; j < content.length(); j++) {
                    if (j != i) {
                        listOfContent.add(content.charAt(j));
                    } else {
                        listOfContent.add('0');
                        listOfContent.add('.');
                    }
                }
                for (int j = 0; j < listOfContent.size(); j++) {
                    str += listOfContent.get(j);
                }
            } else {
                str += content;
            }
        } else {
            str = "";
            int i = content.indexOf('.');
            for (int j = 0; j < content.length(); j++) {
                if (j != i) {
                    listOfContent.add(content.charAt(j));
                } else {
                    listOfContent.add('.');
                    listOfContent.add('0');
                }
            }
            for (int j = 0; j < listOfContent.size(); j++) {
                str += listOfContent.get(j);
            }
        }
        return str;
    }
    public void initComponents() {
        final String divideSymbol = "\u00F7";
        final String multiplySymbol = "\u00D7";
        final String addSymbol = "\u002B";
        final String subtractSymbol = "-";
        /**
         * first label
         */
        JLabel ResultLabel = new JLabel("0", JLabel.RIGHT);
        ResultLabel.setName("ResultLabel");
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
        EquationLabel.setName("EquationLabel");
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
            EquationLabel.setForeground(Color.BLUE);
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
            EquationLabel.setForeground(Color.BLUE);
            ResultLabel.setText("0");
            EquationLabel.setText("");
        });

        /**
         * add buttons to it
         */

        JButton Seven = new JButton();
        Seven.setName("Seven");
        Seven.setBounds(10, 200, 60, 40);
        Seven.setText("7");
        add(Seven);
        Seven.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Seven.getText();
            EquationLabel.setText(content);
        });

        JButton Eight = new JButton();
        Eight.setName("Eight");
        Eight.setBounds(80, 200, 60, 40);
        Eight.setText("8");
        add(Eight);
        Eight.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Eight.getText();
            EquationLabel.setText(content);
        });

        JButton Nine = new JButton();
        Nine.setName("Nine");
        Nine.setBounds(150, 200, 60, 40);
        Nine.setText("9");
        add(Nine);
        Nine.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Nine.getText();
            EquationLabel.setText(content);
        });

        JButton Divide = new JButton();
        Divide.setName("Divide");
        Divide.setBounds(220, 200, 60, 40);
        Divide.setText("÷");
        add(Divide);
        Divide.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            if (content.endsWith(divideSymbol) || content.endsWith(multiplySymbol) || content.endsWith(addSymbol)
                    || content.endsWith(subtractSymbol)) {
                content = content.substring(0, content.length() - 1);
            }
            if (content.contains(".")) {
                content = CommaCorrector(content);
            }
            if (!content.isEmpty()) {
                content += Divide.getText();
                EquationLabel.setText(content);
            }
        });

        JButton Four = new JButton();
        Four.setName("Four");
        Four.setBounds(10, 260, 60, 40);
        Four.setText("4");
        add(Four);
        Four.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Four.getText();
            EquationLabel.setText(content);
        });

        JButton Five = new JButton();
        Five.setName("Five");
        Five.setBounds(80, 260, 60, 40);
        Five.setText("5");
        add(Five);
        Five.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Five.getText();
            EquationLabel.setText(content);
        });

        JButton Six = new JButton();
        Six.setName("Six");
        Six.setBounds(150, 260, 60, 40);
        Six.setText("6");
        add(Six);
        Six.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Six.getText();
            EquationLabel.setText(content);
        });

        JButton Multiply = new JButton();
        Multiply.setName("Multiply");
        Multiply.setBounds(220, 260, 60, 40);
        Multiply.setText("×");
        add(Multiply);
        Multiply.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            if (content.endsWith(divideSymbol) || content.endsWith(multiplySymbol) || content.endsWith(addSymbol)
                    || content.endsWith(subtractSymbol)) {
                content = content.substring(0, content.length() - 1);
            }
            if (content.contains(".")) {
                content = CommaCorrector(content);
            }
            if (!content.isEmpty()) {
                content += Multiply.getText();
                EquationLabel.setText(content);
            }
        });

        JButton One = new JButton();
        One.setName("One");
        One.setBounds(10, 310, 60, 40);
        One.setText("1");
        add(One);
        One.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += One.getText();
            EquationLabel.setText(content);
        });

        JButton Two = new JButton();
        Two.setName("Two");
        Two.setBounds(80, 310, 60, 40);
        Two.setText("2");
        add(Two);
        Two.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Two.getText();
            EquationLabel.setText(content);
        });

        JButton Three = new JButton();
        Three.setName("Three");
        Three.setBounds(150, 310, 60, 40);
        Three.setText("3");
        add(Three);
        Three.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Three.getText();
            EquationLabel.setText(content);
        });

        JButton Add = new JButton();
        Add.setName("Add");
        Add.setBounds(220, 310, 60, 40);
        Add.setText("+");
        add(Add);
        Add.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            if (content.endsWith(divideSymbol) || content.endsWith(multiplySymbol) || content.endsWith(addSymbol)
                    || content.endsWith(subtractSymbol)) {
                content = content.substring(0, content.length() - 1);
            }
            if (content.contains(".")) {
                content = CommaCorrector(content);
            }
            if (!content.isEmpty()) {
                content += Add.getText();
                EquationLabel.setText(content);
            }
        });

        JButton Dot = new JButton();

        Dot.setName("Dot");
        Dot.setText(".");
        Dot.setBounds(10, 370, 60, 40);
        add(Dot);
        Dot.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Dot.getText();
            EquationLabel.setText(content);
        });

        JButton Zero = new JButton();

        Zero.setName("Zero");
        Zero.setText("0");
        Zero.setBounds(80, 370, 60, 40);
        add(Zero);
        Zero.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Zero.getText();
            EquationLabel.setText(content);
        });

        JButton Equals = new JButton();
        Equals.setBounds(150, 370, 60, 40);
        Equals.setText("=");
        Equals.setName("Equals");
        add(Equals);
        Equals.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String equation = EquationLabel.getText();
            double result;
            if (equation.endsWith(divideSymbol) || equation.endsWith(multiplySymbol) || equation.endsWith(addSymbol)
                    || equation.endsWith(subtractSymbol) || equation.contains(divideSymbol + "0")) {
                EquationLabel.setForeground(Color.RED.darker());
            } else {
                result = calculate(PostfixConverter(equation));
                String stringResult = String.format("%.1f", result);
                String[] arrayWithoutComma = stringResult.split(",");//\.
                if (arrayWithoutComma[1].equals("0")) {
                    equation = arrayWithoutComma[0];
                } else {
                    equation = String.format("%f", result);
                    while (equation.charAt(equation.length() - 1) == '0') {
                        equation = equation.substring(0, equation.length() - 1);
                    }
                }
                ResultLabel.setText(equation);
            }
        });

        JButton Subtract = new JButton();
        Subtract.setName("Subtract");
        Subtract.setBounds(220, 370, 60, 40);
        Subtract.setText("-");
        add(Subtract);
        Subtract.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            if (content.endsWith(divideSymbol) || content.endsWith(multiplySymbol) || content.endsWith(addSymbol)
                    || content.endsWith(subtractSymbol)) {
                content = content.substring(0, content.length() - 1);
            }
            if (content.contains(".")) {
                content = CommaCorrector(content);
            }
            if (!content.isEmpty()) {
                content += Subtract.getText();
                EquationLabel.setText(content);
            }
        });
    }
}

public class ApplicationRunner {
    public static void main(String[] args) {
        new Calculator();
    }
}
