package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*Создать двумерный массив типа int. С клавиатуры вводятся номер строки и столбца. Элемент на этом месте нужно занулить.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int arr[][] = { {10,4,7,2},
                        {3,81,9,1},
                        {7,2,89,2},
                        {45,3,9,1} };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pass i, j: ");

        int i = Integer.parseInt(reader.readLine());
        int j = Integer.parseInt(reader.readLine());

        arr[i][j] = 0;

        for(int k=0; k<arr.length; k++) {
            for (int l = 0; l < arr[k].length; l++)
                System.out.print(arr[k][l] + " ");
            System.out.println();
        }


    }
}
