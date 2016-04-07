package main;

import java.awt.*;


public class MImage {
    public static int num=1;
    public int k;
    private Image image;

    MImage(Image image) {
        k = num;
        num++;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image number " + k ;
    }
}
