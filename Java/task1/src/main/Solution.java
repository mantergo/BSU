package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Создать массив типа int, вычислить среднее арифметическое его элементов и корень из среднего арифметического.
Создать массив типа String, вычислить среднюю длину строки.*/


public class Solution {
    public static void main(String[] args) throws IOException {
        int arr[] = {7, 3, 9, 2, 7, 3, 8};
        double aver = 0;

        for(int i=0; i<arr.length; i++)
            aver += arr[i];
        aver/=(double)arr.length;
        System.out.println("Arithmetic average: " + aver);
        System.out.println("Square root from arithmetic average: " + String.format("%.2f", Math.sqrt(aver)));


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Number of strings: ");
        int n = Integer.parseInt(reader.readLine());
        double averLen = 0;

        String[] str = new String [n];
        for(int i=0; i<str.length; i++) {
            str[i] = reader.readLine();
            averLen += str[i].length();
        }

        averLen/=(double)str.length;

        System.out.println("Average length: " + String.format("%.2f", averLen));
    }
}
