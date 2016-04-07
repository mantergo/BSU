package main;

import javafx.scene.control.Tab;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class CalculatorPanel extends JPanel {
    private JTabbedPane calcModePane;

    private Font font = new Font("Courier New", Font.PLAIN, 23);

    public CalculatorPanel(SimpleCalculatorPanel simpleCalculatorPanel, ExtendedCalculatorPanel extendedCalculatorPanel, final JTextField display) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 40, 20, 40));


        calcModePane = new JTabbedPane();
        calcModePane.setFont(font);
        calcModePane.addTab("Simple", simpleCalculatorPanel);
        calcModePane.addTab("Extended", extendedCalculatorPanel);
        calcModePane.setSelectedIndex(0);

        add(calcModePane);
    }
}
