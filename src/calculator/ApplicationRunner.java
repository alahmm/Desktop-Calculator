package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

class Calculator extends JFrame{
    public Calculator () {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280, 500);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null); // sets absolute positioning of components
        setVisible(true);
    }
    static int Prec(String operator)
    {
        final String divideSymbol = "\u00F7";
        final String multiplySymbol = "\u00D7";
        final String addSymbol = "\u002B";
        final String subtractSymbol = "-";
        final String squareRoot = "\\u221A";
        final String powerOfTwo = "^(2)";
        final String powerOfY = "^(";
        switch (operator) {
            case addSymbol:
            case subtractSymbol:
                return 1;

            case multiplySymbol:
            case divideSymbol:
                return 2;

            case powerOfTwo:
            case powerOfY:
                return 3;
            case squareRoot:
                return 4;
        }
        return -1;
    }
    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }

                stack.pop();
            }
            else // an operator is encountered
            {
                String c2 = exp.substring(i, i + 1);
                while (!stack.isEmpty()
                        && Prec(c2) <= Prec(stack.peek().toString())) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }

        return result;
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
        final String squareRoot = "\\u221A";
        final String powerOfTwo = "^(2)";
        final String powerOfY = "^(";
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            String c = equation.substring(i, i + 1);
            if (c.matches("[0-9]")) {
                for (int j = i; j <equation.length() ; j++) {
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
                    //case squareRoot ->
                }
            }
        }
        return stack.pop();
    }
/*    public static double calculate(String equation) {
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
    }*/
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
        ResultLabel.setBounds(5,10, 255,120);
        add(ResultLabel);
        ResultLabel.setFont(ResultLabel. getFont(). deriveFont(40f));

/*        Font font2 = new Font("Courier", Font.BOLD,12);
        ResultLabel.setFont(font2);
        ResultLabel.setFont(ResultLabel.getFont().deriveFont(20f));*/

        /**
         * second label
         */
        JLabel EquationLabel = new JLabel("", JLabel.RIGHT);
        EquationLabel.setBounds(5,125, 255,30);
        EquationLabel.setName("EquationLabel");
        add(EquationLabel);
        EquationLabel.setForeground(Color.BLUE);
        EquationLabel.setFont(EquationLabel. getFont(). deriveFont(16f));
        /**
         * delete button
         */
        JButton Delete = new JButton();
        Delete.setName("Delete");
        Delete.setBounds(200, 195, 60, 40);
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
        Clear.setBounds(135, 195, 60, 40);
        Clear.setText("C");
        add(Clear);
        Clear.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            ResultLabel.setText("0");
            EquationLabel.setText("");
        });
        /**
         * CE button
         */
        JButton ClearCE = new JButton();
        ClearCE.setName("ClearCE");
        ClearCE.setBounds(70, 195, 60, 40);
        ClearCE.setText("CE");
        add(ClearCE);
        ClearCE.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            ResultLabel.setText("0");
            EquationLabel.setText("");
        });
        /**
         * parentheses
         */
        JButton Parentheses = new JButton();
        Parentheses.setName("Parentheses");
        Parentheses.setBounds(5, 195, 60, 40);
        Parentheses.setText("( )");
        add(Parentheses);
        Parentheses.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            int countLeftParentheses = 0;
            int countRightParentheses = 0;
            for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == '(') {
                    countLeftParentheses ++;
                }
                if (content.charAt(i) == ')') {
                    countRightParentheses ++;
                }
            }
            if (countLeftParentheses == countRightParentheses || content.endsWith("(") ||
                    content.endsWith(divideSymbol) || content.endsWith(addSymbol) || content.endsWith(multiplySymbol) ||
                    content.endsWith(subtractSymbol)) {
                content += "(";
            } else {
                content += ")";
            }
            EquationLabel.setText(content);
        });

        JButton PowerTwo = new JButton();
        PowerTwo.setName("PowerTwo");
        PowerTwo.setBounds(5, 240, 60, 40);
        PowerTwo.setText("X²");
        add(PowerTwo);
        PowerTwo.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += "^" +"(2)";
            EquationLabel.setText(content);
        });

        JButton PowerY = new JButton();
        PowerY.setName("PowerY");
        PowerY.setBounds(70, 240, 60, 40);
        PowerY.setText("X");
        add(PowerY);
        PowerY.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += "^" +"(";
            EquationLabel.setText(content);
        });

        JButton SquareRoot = new JButton();
        SquareRoot.setName("SquareRoot");
        SquareRoot.setBounds(135, 240, 60, 40);
        SquareRoot.setText("√");
        add(SquareRoot);
        SquareRoot.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += "√" +"(";
            EquationLabel.setText(content);
        });

        /**
         * add buttons to it
         */

        JButton Seven = new JButton();
        Seven.setName("Seven");
        Seven.setBounds(5, 285, 60, 40);
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
        Eight.setBounds(70, 285, 60, 40);
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
        Nine.setBounds(135, 285, 60, 40);
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
        Divide.setBounds(200, 240, 60, 40);
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
        Four.setBounds(5, 330, 60, 40);
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
        Five.setBounds(70, 330, 60, 40);
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
        Six.setBounds(135, 330, 60, 40);
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
        Multiply.setBounds(200, 285, 60, 40);
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
        One.setBounds(5, 375, 60, 40);
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
        Two.setBounds(70, 375, 60, 40);
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
        Three.setBounds(135, 375, 60, 40);
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
        Add.setBounds(200, 375, 60, 40);
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
        Dot.setBounds(135, 420, 60, 40);
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
        Zero.setBounds(70, 420, 60, 40);
        add(Zero);
        Zero.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            content += Zero.getText();
            EquationLabel.setText(content);
        });

        JButton PlusMinus = new JButton();

        PlusMinus.setName("PlusMinus");
        PlusMinus.setText("±");
        PlusMinus.setBounds(5, 420, 60, 40);
        add(PlusMinus);
        PlusMinus.addActionListener(e -> {
            EquationLabel.setForeground(Color.BLUE);
            String content = EquationLabel.getText();
            if (!content.isEmpty()) {
                content = content.substring(2);
            } else {
                content = "(-" + content;
            }
            EquationLabel.setText(content);
        });

        JButton Equals = new JButton();
        Equals.setBounds(200, 420, 60, 40);
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
                //result = calculate(PostfixConverter(equation));
                result = calculate(infixToPostfix(equation));
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
        Subtract.setBounds(200, 330, 60, 40);
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
