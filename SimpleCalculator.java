package test;

import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {
    private TextField display;
    private Button[] buttons;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 300);
        setLayout(new BorderLayout());

        display = new TextField();
        add(display, BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "%", "=", "+"
        };

        buttons = new Button[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new Button(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("=")) {
            try {
                String expression = display.getText();
                double result = evaluateExpression(expression);
                display.setText(Double.toString(result));
            } catch (ArithmeticException ex) {
                display.setText("Error: Divide by zero");
            } catch (NumberFormatException ex) {
                display.setText("Error: Invalid expression");
            }
        } else {
            display.setText(display.getText() + command);
        }
    }

    private double evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+*/%])|(?=[-+*/%])");
        double operand1 = Double.parseDouble(tokens[0]);
        double operand2 = Double.parseDouble(tokens[2]);
        switch (tokens[1]) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                return operand1 / operand2;
            case "%":
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
