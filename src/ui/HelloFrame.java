package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloFrame extends JFrame {

    public HelloFrame() {
        super("My First Swing App");//The constructor sets the title "My First Swing App" as the window's title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the default close operation
        setSize(300, 300);//the size
        setLocationRelativeTo(null);//to center the window
        setLayout(null);//set absolute coordinates
        setVisible(true);//visibility
/**
 * for label
 */
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Your Name");
        nameLabel.setBounds(40, 20, 100, 30);
        add(nameLabel);
        /**
         * for textfield
         */

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(160,20, 100,30);
        add(nameTextField);
        // to get the content of it: String name = nameTextField.getText();
        // to set a text to it: setText(someText)
        /**
         * JPanel: container smaller than JFrame
         * this panel here is for label
         */
        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(40,150,220,70);
        greenPanel.setLayout(new BorderLayout());
        greenPanel.setBackground(Color.GREEN);
        add(greenPanel);

        /**
         * add this label to panel
         */
        JLabel helloLabel = new JLabel("Hello");
        helloLabel.setBounds(50,20, 100,30);
        helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        helloLabel.setVerticalAlignment(SwingConstants.CENTER);

        Font font = new Font("Courier", Font.BOLD,12);
        helloLabel.setFont(font);
        helloLabel.setFont(helloLabel.getFont().deriveFont(16f));

        greenPanel.add(helloLabel); // adding label to the panel

        /**
         * button
         */
        JButton acceptButton = new JButton("Accept");
        acceptButton.setBounds(100, 70, 100, 30);
        add(acceptButton);
        /**
         * add actionListener to it with anonymous class / lambda
         */
        acceptButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String helloText = "Hello";
                String name = nameTextField.getText();
                if (name != null && name.trim().length() > 0) {
                    helloText += String.format(", %s", name);
                }
                helloLabel.setText(helloText);
            }
        });
        /**
         * using lambda instead of anonymous class
         *         button.addActionListener(e ->
         *                 System.out.println("The button is clicked"));
         */
        acceptButton.addActionListener(e -> {
            String helloText = "Hello";
            String name = nameTextField.getText();
            if (name != null && name.trim().length() > 0) {
                helloText += String.format(", %s", name);
            }
            helloLabel.setText(helloText);
        });

    }

    public static void main(String[] args) throws Exception {
        Runnable initFrame = new Runnable() {//initialize a frame
            @Override
            public void run() {
                new HelloFrame();
            }
        };

        SwingUtilities.invokeAndWait(initFrame);
    }
}
