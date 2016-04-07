package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class ExtendedCalculatorPanel extends JPanel {
    public ExtendedCalculatorPanel(ExtendedButtonPanel extendedButtonPanel, ButtonPanel buttonPanel) {
        setLayout(new FlowLayout());
        setBorder(new EmptyBorder(30,10,30,10));

        add(extendedButtonPanel, BorderLayout.CENTER);
        add(buttonPanel);
    }
}
