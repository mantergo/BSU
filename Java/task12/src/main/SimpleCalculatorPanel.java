package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;



public class SimpleCalculatorPanel extends JPanel {
    public SimpleCalculatorPanel(ButtonPanel buttonPanel){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20,110,20,110));


        add(buttonPanel);
    }
}
