package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExtendedButtonPanel extends JPanel {

    final CalculateAndEdit calculateAndEdit = new CalculateAndEdit();

    public ExtendedButtonPanel(final JTextField display) {
        setLayout(new GridLayout(5, 2, 10, 10));

        button10x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.pow(10,Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.sin(Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.cos(Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.tan(Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonSqRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    if(Double.valueOf(display.getText())<0) {
                        calculateAndEdit.error = true;
                        calculateAndEdit.errorMessage = "Invalid input";
                        display.setText(calculateAndEdit.errorMessage);
                        return;
                    }
                    calculateAndEdit.firstValue = Math.sqrt(Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonCubeRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.cbrt(Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonXSq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.pow(Double.valueOf(display.getText()), 2);
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonXCube.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    calculateAndEdit.firstValue = Math.pow(Double.valueOf(display.getText()), 3);
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        buttonLn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && calculateAndEdit.operation=="") {
                    if(Double.valueOf(display.getText())<=0) {
                        calculateAndEdit.error = true;
                        calculateAndEdit.errorMessage = "Invalid input";
                        display.setText(calculateAndEdit.errorMessage);
                        return;
                    }
                    calculateAndEdit.firstValue = Math.log(Double.valueOf(display.getText()));
                    calculateAndEdit.setFormattedText(display, "", calculateAndEdit.firstValue);
                }
            }
        });

        add(buttonLn);
        add(buttonTan);
        add(buttonCos);
        add(buttonSin);
        add(buttonXSq);
        add(buttonSqRoot);
        add(buttonXCube);
        add(buttonCubeRoot);
        add(buttonXY);
        add(button10x);

        button10x.setFont(font);
        buttonLn.setFont(font);
        buttonCos.setFont(font);
        buttonSin.setFont(font);
        buttonTan.setFont(font);
        buttonCubeRoot.setFont(font);
        buttonSqRoot.setFont(font);
        buttonXY.setFont(font);
        buttonXCube.setFont(font);
        buttonXSq.setFont(font);
    }

    Font font = new Font("Courier New", Font.PLAIN, 20);
    JButton buttonSqRoot = new JButton("sr");
    JButton buttonCubeRoot = new JButton("cr");
    JButton buttonCos = new JButton("cos");
    JButton buttonSin = new JButton("sin");
    JButton buttonTan = new JButton("tan");
    JButton buttonLn = new JButton("ln");
    JButton button10x = new JButton("10^x");
    JButton buttonXSq = new JButton("x^2");
    JButton buttonXCube = new JButton("x^3");
    JButton buttonXY = new JButton("x^y");
}
