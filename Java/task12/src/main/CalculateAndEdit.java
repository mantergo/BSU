package main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


public class CalculateAndEdit {

    public double count() {
        double result;
        if ("+".equals(operation))
            result = firstValue + secondValue;
        else if ("-".equals(operation))
            result = firstValue - secondValue;
        else if ("*".equals(operation))
            result = firstValue * secondValue;
        else if ("/".equals(operation)) {
            if (secondValue != 0)
                result = firstValue / secondValue;
            else {
                errorMessage = "Cannot divide by zero";
                result = 0;
            }
        } else
            result = 0;

        firstValue = result;
        secondValue = 0;
        counter = 0;
        operation = "";

        return result;
    }

    public void setFormattedText(JTextField display, String oper, double value) {
        if (value % 1 == 0)
            display.setText("" + (int) value + oper);
        else
            display.setText("" + value + oper);
    }

    static double firstValue = 0;
    static double secondValue = 0;
    ArrayList<String> operations = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    static String operation = "";
    static int counter = 0; // 0 - null operations, 1 - one operation -> save secondValue, 2 - execute(count) and make counter = 1;
    String errorMessage = "";
    static boolean error = false;

}
