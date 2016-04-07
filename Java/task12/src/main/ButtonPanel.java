package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class ButtonPanel extends JPanel {



    final CalculateAndEdit calculateAndEdit = new CalculateAndEdit();

    public ButtonPanel(final JTextField display) {
        setLayout(new GridLayout(5, 4, 10, 10));
        setBorder((new EmptyBorder(5, 5, 5, 5)));
        createButtons();

        buttonNum[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateAndEdit.error)
                    display.setText("0");

                if (calculateAndEdit.error) {
                    calculateAndEdit.error = false;
                    return;
                }

                if (!display.getText().equals("0"))
                    display.setText(display.getText() + "0");
            }
        });

        for (int i = 1; i < buttonNum.length; i++) {
            final int k = i;
            buttonNum[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().equals("0") || calculateAndEdit.error)
                        display.setText("" + k);
                    else
                        display.setText(display.getText() + "" + k);

                    if (calculateAndEdit.error)
                        calculateAndEdit.error = false;
                }
            });
        }

        buttonPi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().equals("0") || calculateAndEdit.error || !calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length())))
                    display.setText("" + pi);
                else
                    display.setText(display.getText() + "" + pi);

                if (calculateAndEdit.error)
                    calculateAndEdit.error = false;
            }
        });

        buttonExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().equals("0") || calculateAndEdit.error || !calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length())))
                    display.setText("" + exp);
                else
                    display.setText(display.getText() + "" + exp);

                if (calculateAndEdit.error)
                    calculateAndEdit.error = false;
            }
        });

        buttonDrop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && !calculateAndEdit.error
                        && ((calculateAndEdit.operation == "" && !display.getText().contains(".")) || calculateAndEdit.operation!="")) {
                    display.setText(display.getText() + ".");
                }
            }
        });

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
                calculateAndEdit.firstValue = 0;
                calculateAndEdit.secondValue = 0;
                calculateAndEdit.counter = 0;
                calculateAndEdit.operation = "";
            }
        });

        buttonCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculateAndEdit.error) {
                    display.setText("0");
                    calculateAndEdit.error = false;
                    calculateAndEdit.errorMessage = "";
                }

                if (display.getText().length() == 1) {
                    if (!display.getText().equals("0"))
                        display.setText("0");
                } else
                    display.setText(display.getText().substring(0, display.getText().length() - 1));
            }
        });

        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the last symbol
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))) {
                    if (calculateAndEdit.counter == 0) {
                        calculateAndEdit.firstValue = Double.valueOf(display.getText());
                        calculateAndEdit.operation = "+";
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                        //display.setText(calculateAndEdit.firstValue + calculateAndEdit.operation);
                    } else if (calculateAndEdit.counter == 1) {
                        calculateAndEdit.secondValue = Double.valueOf(display.getText().substring(display.getText().lastIndexOf(calculateAndEdit.operation) + 1));
                        double result = calculateAndEdit.count();
                        calculateAndEdit.operation = "+";
                        calculateAndEdit.firstValue = result;
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, result);
                        //display.setText(result + operation);
                    } else
                        display.setText("0");
                } else {
                    calculateAndEdit.operation = "+";
                    calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                    //display.setText(display.getText().substring(0, display.getText().length()-1)+ operation);
                }
            }
        });

        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))) {
                    if (calculateAndEdit.counter == 0) {
                        calculateAndEdit.firstValue = Double.valueOf(display.getText());
                        calculateAndEdit.operation = "-";
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                        //display.setText(calculateAndEdit.firstValue + operation);
                    } else if (calculateAndEdit.counter == 1) {
                        calculateAndEdit.secondValue = Double.valueOf(display.getText().substring(display.getText().lastIndexOf(calculateAndEdit.operation) + 1));
                        double result = calculateAndEdit.count();
                        calculateAndEdit.operation = "-";
                        calculateAndEdit.firstValue = result;
                        System.out.println(calculateAndEdit.firstValue);
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, result);
                        //display.setText(result + calculateAndEdit.operation);
                    } else
                        display.setText("0");
                } else {
                    calculateAndEdit.operation = "-";
                    calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                    //display.setText(display.getText().substring(0, display.getText().length()-1)+ operation);
                }
            }
        });

        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))) {
                    if (calculateAndEdit.counter == 0) {
                        calculateAndEdit.firstValue = Double.valueOf(display.getText());
                        calculateAndEdit.operation = "*";
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                        //display.setText(firstValue + operation);
                    } else if (calculateAndEdit.counter == 1) {
                        calculateAndEdit.secondValue = Double.valueOf(display.getText().substring(display.getText().lastIndexOf(calculateAndEdit.operation) + 1));
                        double result = calculateAndEdit.count();
                        calculateAndEdit.operation = "*";
                        calculateAndEdit.firstValue = result;
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, result);
                        //display.setText(result + operation);
                    } else
                        display.setText("0");
                } else {
                    calculateAndEdit.operation = "*";
                    calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                    //display.setText(display.getText().substring(0, display.getText().length()-1)+ operation);
                }
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))) {
                    if (calculateAndEdit.counter == 0) {
                        calculateAndEdit.firstValue = Double.valueOf(display.getText());
                        calculateAndEdit.operation = "/";
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                        //display.setText(firstValue + operation);
                    } else if (calculateAndEdit.counter == 1) {
                        calculateAndEdit.secondValue = Double.valueOf(display.getText().substring(display.getText().lastIndexOf(calculateAndEdit.operation) + 1));
                        double result = calculateAndEdit.count();
                        calculateAndEdit.operation = "/";
                        calculateAndEdit.firstValue = result;
                        calculateAndEdit.counter++;
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, result);
                        //display.setText(result + operation);
                    } else
                        display.setText("0");
                } else {
                    calculateAndEdit.operation = "/";
                    calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, calculateAndEdit.firstValue);
                    //display.setText(display.getText().substring(0, display.getText().length()-1)+ operation);
                }
            }
        });

        buttonCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculateAndEdit.operations.contains(display.getText().substring(display.getText().length() - 1, display.getText().length()))
                        && calculateAndEdit.operation != "") {

                    calculateAndEdit.secondValue = Double.valueOf(display.getText().substring(display.getText().lastIndexOf(calculateAndEdit.operation) + 1));
                    double result = calculateAndEdit.count();
                    if (calculateAndEdit.errorMessage.isEmpty())
                        calculateAndEdit.setFormattedText(display, calculateAndEdit.operation, result);
                        //display.setText("" + result);
                    else {
                        display.setText(calculateAndEdit.errorMessage);
                        calculateAndEdit.error = true;
                        calculateAndEdit.errorMessage = "";
                    }
                }
            }
        });

        setFont(font);
        add(buttonNum[7]);
        add(buttonNum[8]);
        add(buttonNum[9]);
        add(buttonDiv);
        add(buttonNum[4]);
        add(buttonNum[5]);
        add(buttonNum[6]);
        add(buttonMul);
        add(buttonNum[1]);
        add(buttonNum[2]);
        add(buttonNum[3]);
        add(buttonSub);
        add(buttonNum[0]);
        add(buttonDrop);
        add(buttonExp);
        add(buttonSum);
        add(buttonC);
        add(buttonCE);
        add(buttonPi);
        add(buttonCount);

        buttonCount.setFont(font);
        buttonDiv.setFont(font);
        buttonDrop.setFont(font);
        buttonMul.setFont(font);
        buttonSub.setFont(font);
        buttonSum.setFont(font);
        buttonC.setFont(font);
        buttonCE.setFont(font);
        buttonPi.setFont(font);
        buttonExp.setFont(font);
    }

    double pi = 3.1415926535897932384626433832795;
    double exp = 2.7182818284590452353602874713527;

    void createButtons() {
        for (int i = 0; i < buttonNum.length; i++) {
            buttonNum[i] = new JButton("" + i);
            buttonNum[i].setFont(font);
        }
    }


    JButton buttonNum[] = new JButton[10];
    JButton buttonSum = new JButton("+");
    JButton buttonDiv = new JButton("/");
    JButton buttonSub = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonDrop = new JButton(".");
    JButton buttonCount = new JButton("=");
    JButton buttonC = new JButton("C");
    JButton buttonCE = new JButton("<-");
    JButton buttonPi = new JButton("Pi");
    JButton buttonExp = new JButton("e");

    Font font = new Font("Courier New", Font.PLAIN, 20);


}
