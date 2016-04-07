package main;

import java.io.*;
import java.util.Scanner;


public class Map implements java.io.Serializable {
    BaseObject field[][];

    Map(int n){}

    Map() {
        try {
            Scanner sc = new Scanner(new File("field.txt"));
            int m, n;
            m=sc.nextInt();
            n=sc.nextInt();

            field = new BaseObject[m][n];

            for(int i=0; i<m; i++)
                for(int j=0; j<n; j++)
                    switch (sc.next()) {
                        case "bo":
                            field[i][j] = new BaseObject(i, j, 1);
                            break;
                        case "BO":
                            field[i][j] = new BaseObject(i, j, 2);
                            break;
                        case "a":
                            field[i][j] = new AObject(i, j, 1);
                            break;
                        case "A":
                            field[i][j] = new AObject(i, j, 2);
                            break;
                        case "b":
                            field[i][j] = new BObject(i, j, 1);
                            break;
                        case "B":
                            field[i][j] = new BObject(i, j, 2);
                            break;
                        case "c":
                            field[i][j] = new CObject(i, j, 1);
                            break;
                        case "C":
                            field[i][j] = new CObject(i, j, 2);
                            break;
                        default:
                            field[i][j] = null;
                    }
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void addObject(BaseObject obj) {
        Class cl = obj.getClass();
        field[obj.getX()][obj.getY()] = obj;
        String size;
        if(obj.getSize()==1)
            size = "small ";
        else
            size = "big ";
        System.out.println("The " + size + cl.getName() + "object is added to position [" + obj.getX() + "]["+obj.getY()+"].");
    }

    public void moveObject(int xOld, int yOld, int xNew, int yNew) {
        field[xNew][yNew] = field[xOld][yOld];
        field[xOld][yOld] = null;
        System.out.println("Object moved from position ["+xOld+"]["+yOld+"] to position ["+xNew+"]["+yNew+"].");
    }

    public void changeObjectSize(int x, int y) {
        if(field[x][y].getSize()==1)
            field[x][y].setSize(2);
        else
            field[x][y].setSize(1);
        System.out.println("The size of an object ["+x+"]["+y+"] was changed.");
    }

    void deleteObject(int x, int y) {
        field[x][y]=null;
        System.out.println("The object ["+x+"]["+y+"] was deleted.");
    }

    void printMap() {
        for(int i=0; i<field.length; i++) {
            for (int j = 0; j < field[0].length; j++)
                if (field[i][j] == null)
                    System.out.print("0\t");
                else if (field[i][j].getClass() == AObject.class)
                    switch (field[i][j].getSize()) {
                        case 1:
                            System.out.print("a\t");
                            break;
                        case 2:
                            System.out.print("A\t");
                            break;
                    }
                else if (field[i][j].getClass() == BObject.class)
                    switch (field[i][j].getSize()) {
                        case 1:
                            System.out.print("b\t");
                            break;
                        case 2:
                            System.out.print("B\t");
                            break;
                    }
                else if (field[i][j].getClass() == CObject.class)
                    switch (field[i][j].getSize()) {
                        case 1:
                            System.out.print("c\t");
                            break;
                        case 2:
                            System.out.print("C\t");
                            break;
                    }
                else if (field[i][j].getClass() == BaseObject.class)
                    switch (field[i][j].getSize()) {
                        case 1:
                            System.out.print("bo\t");
                            break;
                        case 2:
                            System.out.print("BO\t");
                            break;
                    }
            System.out.println("");
        }
    }

    public void saveMap() {
        try {
            FileOutputStream fileOut = new FileOutputStream("field.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in \"field.ser\"");
        }
        catch(IOException i) {
            i.printStackTrace();
        }
    }

    public Map loadMap() {
        Map map;
        try
        {
            FileInputStream fileIn = new FileInputStream("field.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (Map) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i) {
            i.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException c) {
            System.out.println("Map class not found");
            c.printStackTrace();
            return null;
        }
        System.out.println("Deserialization of Map: ");
        return map;
    }

    public static void main(String[] args) {
        Map map = new Map();
        map.printMap();

        BObject bobj = new BObject(1, 0, 1);
        map.addObject(bobj);
        map.printMap();

        map.moveObject(1, 4, 1, 3);
        map.printMap();

        map.changeObjectSize(1, 2);
        map.printMap();

        map.deleteObject(1, 2);
        map.printMap();

        map.saveMap();
        Map map1 = map.loadMap();
        map1.printMap();
    }
}
