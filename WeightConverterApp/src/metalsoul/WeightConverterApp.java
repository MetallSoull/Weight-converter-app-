package metalsoul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightConverterApp implements ActionListener {

    private static JFrame newFrame;
    private static JPanel newPanel;
    private static JLabel newLabel;
    private static JLabel result;
    private static JButton killosButton;
    private static JButton poundsButton;
    private static JLabel enterLabel;
    private static JTextField enterTextField;
    private static final int HEIGHT = 240;
    private static final int WIDTH = HEIGHT * 2;

    public static void frame() {

        JFrame newFrame = new JFrame("Weight converter app");
        JPanel newPanel = new JPanel();

        newPanel.setLayout(null);

        newFrame.setSize(WIDTH, HEIGHT);
        newFrame.setLocationRelativeTo(null);
        newFrame.setLayout(new BorderLayout());
        newFrame.setResizable(false);
        newFrame.add(newPanel);

        newLabel = new JLabel("Choose your converter operation: ");
        newLabel.setBounds(125,45, 200,50);
        newPanel.add(newLabel);

        killosButton = new JButton("Killos");
        killosButton.setBounds(100,100,100,25);
        killosButton.setFocusable(false);
        killosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(killosButton)) {
                    newFrame.dispose();
                    JFrame killosFrame = new JFrame("Killos");
                    JPanel killosPanel = new JPanel();

                    killosPanel.setLayout(null);
                    killosFrame.setSize(480,240);
                    killosFrame.setLocationRelativeTo(null);
                    killosFrame.setResizable(false);
                    killosFrame.add(killosPanel);

                    enterLabel = new JLabel("Enter weight: ");
                    enterLabel.setBounds(10,10,200,25);
                    killosPanel.add(enterLabel);

                    enterTextField = new JTextField();
                    enterTextField.setBounds(90,13,100,20);
                    killosPanel.add(enterTextField);

                    result = new JLabel();
                    result.setBounds(10,50,200,20);
                    killosPanel.add(result);

                    JButton convertButton = new JButton("Convert");
                    convertButton.setBounds(90, 70, 100, 25);
                    convertButton.setFocusable(false);
                    convertButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                double weightInPounds = Double.parseDouble(enterTextField.getText());
                                double resultWeight = weightInPounds / 2.20462;
                                result.setText("Your new weight in kilograms: " + Math.round(resultWeight));
                            } catch (NumberFormatException ex) {
                                result.setText("Invalid input! Please enter a valid number.");
                            }
                        }
                    });
                    killosPanel.add(convertButton);

                    killosFrame.setVisible(true);
                }
            }
        });
        newPanel.add(killosButton);

        poundsButton = new JButton("Pounds");
        poundsButton.setBounds(250,100,100,25);
        poundsButton.setFocusable(false);
        poundsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(poundsButton)) {
                    newFrame.dispose();
                    JFrame poundsFrame = new JFrame("Pounds");
                    JPanel poundsPanel = new JPanel();
                    poundsFrame.setSize(WIDTH,HEIGHT);
                    poundsFrame.setLocationRelativeTo(null);
                    poundsFrame.setResizable(false);
                    poundsFrame.add(poundsPanel);

                    poundsPanel.setLayout(null);

                    enterLabel = new JLabel();
                    enterLabel.setBounds(10,10,200,25);
                    enterLabel.setText("Enter weight: ");
                    poundsPanel.add(enterLabel);

                    enterTextField = new JTextField();
                    enterTextField.setBounds(90,13,100,20);
                    poundsPanel.add(enterTextField);

                    result = new JLabel();
                    result.setBounds(10,40,200,25);
                    poundsPanel.add(result);

                    JButton convertButton = new JButton("Convert");
                    convertButton.setBounds(90,70,100,25);
                    convertButton.setFocusable(false);
                    convertButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String enteredNumber = enterTextField.getText();
                                double weightInKillos = Double.parseDouble(enteredNumber);
                                double resultWeight = weightInKillos * 2.20462;
                                result.setText("Your weight in pounds is: " + Math.round(resultWeight));
                            } catch(Exception f) {
                                JLabel failLabel = new JLabel();
                                failLabel.setBounds(10,50,200,25);
                                failLabel.setText("You entered a not valid number! Try again");
                                poundsPanel.add(failLabel);
                            }
                        }
                    });
                    poundsPanel.add(convertButton);

                    poundsFrame.setVisible(true);
                }
            }
        });
        newPanel.add(poundsButton);

        newFrame.setVisible(true);
    }

    public static void main(String args[]) {
        frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
