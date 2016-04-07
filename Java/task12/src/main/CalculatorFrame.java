package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setLayout(new BorderLayout());
        setBounds(400, 150, 300, 500);

        Font font = new Font("Courier New", Font.PLAIN,30);
        final Font menuFont = new Font("Arial light", Font.PLAIN,16);

        menuBar = new JMenuBar();
        fileMenu  = new JMenu("File");
        helpMenu = new JMenu("Help");
        fileMenu.setFont(menuFont);
        helpMenu.setFont(menuFont);
        JMenuItem exitItem = new JMenuItem("exit");
        JMenuItem aboutItem = new JMenuItem("about");

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame infoFrame = new JFrame("Program info");
                infoFrame.setBounds(300,200,200,200);
                infoFrame.setLayout(new BorderLayout());

                JTextArea programInfo = new JTextArea();
                String info = "Calculator";
                programInfo.setFont(menuFont);
                programInfo.setText(info);
                programInfo.setEditable(false);
                programInfo.setMargin(new Insets(10,10,10,10));

                infoFrame.add(programInfo, BorderLayout.CENTER);
                infoFrame.setVisible(true);
            }
        });

        fileMenu.add(aboutItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(calculatorPanel, BorderLayout.CENTER);
        add(outputField, BorderLayout.NORTH);

        outputField.setEditable(false);
        outputField.setFont(font);
        outputField.setMargin(new Insets(20, 40, 20, 30));
        outputField.setHorizontalAlignment(JTextField.RIGHT);
        outputField.setText("0");

        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    protected JMenuBar menuBar;
    protected JMenu fileMenu;
    protected JMenu helpMenu;
    protected JTextField outputField = new JTextField();
    private SimpleCalculatorPanel simpleCalculatorPanel= new SimpleCalculatorPanel(new ButtonPanel(outputField));
    private ExtendedCalculatorPanel extendedCalculatorPanel= new ExtendedCalculatorPanel(new ExtendedButtonPanel(outputField), new ButtonPanel(outputField));
    private CalculatorPanel calculatorPanel = new CalculatorPanel(simpleCalculatorPanel, extendedCalculatorPanel, outputField);

    public static void main(String[] args) {
        CalculatorFrame calcFrame = new CalculatorFrame();
    }
}
