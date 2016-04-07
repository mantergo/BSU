package main;

import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ImageManager {
    private static ArrayList<Pair<Integer, MImage>> images = new ArrayList<>();

    ImageManager() {
        Image image = new ImageIcon("0.jpg").getImage();
        Image image1 = new ImageIcon("1.jpg").getImage();
        Image image2 = new ImageIcon("2.jpg").getImage();

        LoadImage(1, image1);
        LoadImage(2, image2);
        LoadImage(3, image);
    }

    public void LoadImage(int n, Image image) {
        MImage mimage = new MImage(image);
        images.add(new Pair<>(n, mimage));
    }

    public MImage GetImage(int id) {
        for (int i = 0; i < 3; i++)
            if (images.get(i).getKey()==id) {
                System.out.println("Return loaded image " + images.get(i).getValue().toString());
                return images.get(i).getValue();
            }
        System.out.println("Image not found");
        return null;
    }

    public static void main(String[] args) {
        ImageManager ipane = new ImageManager();

        ipane.GetImage(3);
        ipane.GetImage(1);
        ipane.GetImage(0);
        ipane.GetImage(2);
    }
}
