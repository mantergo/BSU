package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Formatter {
    public static ArrayList<Literature> books = new ArrayList<>();
    private ArrayList<String> literatureInfo = new ArrayList<>();

    private void loadInfo() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src//main//input.txt"));
        while (in.hasNext())
            literatureInfo.add(in.nextLine());
        for (String s : literatureInfo)
            System.out.println(s);
    }

    public void separateWithRegExp() {
        Pattern pattern = Pattern.compile("(^(\\S+(,\\s)(\\S\\.){2}))|((\\S+\\s){1,}(?=/))|(((\\S\\.){2}\\s(\\S+)\\s?(\\S+\\s\\S+)?){1,}(?=;))|(\\S+(?=:))|((:\\s(\\S\\s?){1,}(?=,)))|(\\d{4}\\b)|(\\d{1,}(?=(\\s\\S\\b)))");
        Pattern pattern1 = Pattern.compile("(^(\\S+(,\\s)(\\S\\.){2}))");
        Literature temp;
        ArrayList<String> tempList;
        boolean mainAuthor = false;

        for (int i = 0; i < literatureInfo.size(); i++) {
            Matcher matcher = pattern.matcher(literatureInfo.get(i));
            Matcher matcher1 = pattern1.matcher(literatureInfo.get(i));
            temp = new Literature();
            tempList = new ArrayList<>();

            if (matcher1.find())
                mainAuthor = true;
            else
                mainAuthor = false;

            while (matcher.find()) {
                tempList.add(matcher.group());
            }

            int j = 0;
            if (mainAuthor)
                temp.setMainAuthor(tempList.get(j));
            else {
                temp.setMainAuthor("none");
                j=-1;
            }

            temp.setTitle(tempList.get(++j));
            temp.setAuthors(tempList.get(++j));
            temp.setPlace(tempList.get(++j));
            String publishing = tempList.get(++j);
            publishing=publishing.substring(2);
            temp.setPublishing(publishing);
            temp.setYearOfPublishing(tempList.get(++j));
            temp.setPages(tempList.get(++j));

            books.add(temp);
        }
    }

    public void printList () {
        for(Literature book: books)
            System.out.println(book.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Formatter formatter = new Formatter();
        formatter.loadInfo();
        formatter.separateWithRegExp();
        formatter.printList();
    }
}
