package main;

import java.awt.*;
import java.util.ArrayList;



public class Piece {

    public int x;
    public int y;
    private int color; //0-black, 1-white
    public final ArrayList<Point> possibleMoves = new ArrayList<>();

    Piece(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    } //0-black, 1-white

    public void findPossibleMoves(Piece[][] f) {
    }

    public void draw() {
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final int getColor() {
        return color;
    }
}

class Knight extends Piece {

    Knight(int x, int y, int color) {
        super(x, y, color);
    }

    public void findPossibleMoves(final Piece[][] f) {
        final int xCur = this.x;
        final int yCur = this.y;
        final int color = this.getColor();

        possibleMoves.clear();

        class CheckForMovement {
            public void checkForMovePossibility(int Y, int k) {
                switch (k) {
                    case 1:
                        if (xCur - 2 >= 0)
                            addIfPossible(xCur - 2, Y);
                        if (xCur + 2 < f.length)
                            addIfPossible(xCur + 2, Y);
                        break;
                    case 2:
                        if (xCur - 1 >= 0)
                            addIfPossible(xCur - 1, Y);
                        if (xCur + 1 < f.length)
                            addIfPossible(xCur + 1, Y);
                        break;
                }
            }

            public void addIfPossible(int i, int j) {
                if (f[i][j] == null)
                    possibleMoves.add(new Point(i, j));
                else if (f[i][j].getColor() != color)
                    possibleMoves.add(new Point(i, j));
            }
        }

        CheckForMovement check = new CheckForMovement();

        for (int k = 1; k <= 2; k++) {
            if (yCur - k >= 0)
                check.checkForMovePossibility(yCur - k, k);
            if (yCur + k < f.length)
                check.checkForMovePossibility(yCur + k, k);
        }
    }

    @Override
    public String toString() {
        if (this.getColor() == 0)
            return "Black KNIGHT ";
        else
            return "White KNIGHT ";
    }

    public void draw() {
        if (this.getColor() == 0)
            System.out.print("K ");
        else
            System.out.print("k ");
    }
}

class Rook extends Piece {

    Rook(int x, int y, int color) {
        super(x, y, color);
    }

    public void findPossibleMoves(final Piece[][] f) {

        class CheckForMovement {
            public boolean addIfPossible(int i, int j) {
                if (f[i][j] != null) {
                    if (f[i][j].getColor() != getColor()) {
                        possibleMoves.add(new Point(i, j));
                    }
                    return true;
                } else
                    possibleMoves.add(new Point(i, j));
                return false;
            }

            public void checkForMovePossibility() {
                int i = x;
                int j = y;
                int k = y;
                while (++j < f.length) {
                    boolean check = addIfPossible(i, j);
                    if (check)
                        break;
                }

                while (--k >= 0) {
                    boolean check = addIfPossible(i, k);
                    if (check)
                        break;
                }

                i = x;
                k = x;
                j = y;
                while (++i < f.length) {
                    boolean check = addIfPossible(i, j);
                    if (check)
                        break;
                }

                while (--k >= 0) {
                    boolean check = addIfPossible(k, j);
                    if (check)
                        break;
                }
            }
        }

        CheckForMovement check = new CheckForMovement();
        check.checkForMovePossibility();

    }

    @Override
    public String toString() {
        if (this.getColor() == 0)
            return "Black ROOK ";
        else
            return "White ROOK ";
    }

    public void draw() {
        if (this.getColor() == 0)
            System.out.print("R ");
        else
            System.out.print("r ");
    }
}


class Pawn extends Piece {
    Pawn(int x, int y, int color) {
        super(x, y, color);
    }

    @Override
    public String toString() {
        if (this.getColor() == 0)
            return "Black PAWN ";
        else
            return "White PAWN ";
    }

    public void draw() {
        if (this.getColor() == 0)
            System.out.print("P ");
        else
            System.out.print("p ");
    }
}

