package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Поработать с классом StringBuffer. Нужно задать размер массива с клавиатуры и проинициализировать его строками row_x_column_y. Вывести на экран.
Для массива 2х2 вывод такой:
row_0_column_0 row_0_column_1
row_1_column_0 row_1_column_1*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pass the number of rows and columns: ");

        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        String str[][] = new String[m][n];

        for(int i=0; i<str.length; i++) {
            for(int j=0; j<str[i].length; j++) {
                StringBuffer strBuf = new StringBuffer();
                strBuf.append("row_" + i + "_column_" + j);
                str[i][j] = strBuf.toString();
                System.out.print(str[i][j] + " ");
            }
            System.out.println();
        }
    }
}
