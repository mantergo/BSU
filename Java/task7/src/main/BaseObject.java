package main;


public class BaseObject implements java.io.Serializable{
    private int x;
    private int y;
    private int size;   // 1 - small, 2 - big

    BaseObject(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public int getSize() {return size;}

    public void setSize(int size) { this.size = size; }
}

class AObject extends BaseObject {
    AObject(int x, int y, int size) {
        super(x, y, size);
    }
}

class BObject extends BaseObject {
    BObject(int x, int y, int size) {
        super(x, y, size);
    }
}

class CObject extends BaseObject {
    CObject(int x, int y, int size) {
        super(x, y, size);
    }
}