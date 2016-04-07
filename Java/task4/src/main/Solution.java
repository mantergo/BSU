package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*Создать ArrayList<Integer>. Инвертировать список.
Создать ArrayList<String>. Отсортировать список по алфавиту.*/


public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

        System.out.println(listInt);

        for(int i=0, j=listInt.size()-1; i<j; i++, j--) {
            int temp = listInt.get(i);
            listInt.set(i, listInt.get(j));
            listInt.set(j, temp);
        }

        System.out.println(listInt);

        ArrayList<String> listStr = new ArrayList<>(Arrays.asList("bds", "gdghbb", "cfjcc", "aclslj", "fgh"));
        Collections.sort(listStr);

        System.out.println(listStr);

    }
}
