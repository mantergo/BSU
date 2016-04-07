package main;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class ImageManager {
    private static Map<Integer, MImage> images = new HashMap<Integer, MImage>();

    public void LoadImage(int n, Image image) {
        MImage mimage = new MImage(image);
        images.put(n, mimage);
    }

    public MImage GetImage(int id) {
        if (images.keySet().contains(id)) {
            System.out.println("Return loaded image " + images.get(id).toString());
            return images.get(id);
        }
        else {
            System.out.println("Image not found");
            return null;
        }
    }

    public static void main(String[] args) {
        ImageManager ipane = new ImageManager();
        Scanner sc = new Scanner(System.in);
        Image image = new ImageIcon("0.jpg").getImage();
        Image image1 = new ImageIcon("1.jpg").getImage();
        Image image2 = new ImageIcon("2.jpg").getImage();

        ipane.LoadImage(12, image);
        ipane.LoadImage(13, image1);
        ipane.LoadImage(14, image2);

        ipane.GetImage(12);
        ipane.GetImage(13);
        ipane.GetImage(14);
        ipane.GetImage(0);
    }
}

