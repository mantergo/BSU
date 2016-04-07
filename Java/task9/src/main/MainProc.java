package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class MainProc extends Thread {
    public Piece field[][];

    public Knight whiteKnightPos;
    public Rook blackRookPos;

    Thread thread1 = new Thread() {
        @Override
        public void run() {
            field[whiteKnightPos.x][whiteKnightPos.y].findPossibleMoves(field);
            move(1);
        }
    };

    Thread thread2 = new Thread() {
        @Override
        public void run() {
            field[blackRookPos.x][blackRookPos.y].findPossibleMoves(field);
            move(2);
        }
    };

    public void move(int piece) {
        int X, Y;
        if (piece == 1) {
            X = whiteKnightPos.x;
            Y = whiteKnightPos.y;
        } else {
            X = blackRookPos.x;
            Y = blackRookPos.y;
        }

        for (int i = 0; i < field[X][Y].possibleMoves.size(); i++)
            System.out.println((field[X][Y].possibleMoves.get(i).x + 1) + " " + (field[X][Y].possibleMoves.get(i).y + 1));
        movePiece(field[X][Y]);
        print(field);
    }

    public void loadField() {
        try {
            Scanner sc = new Scanner(new File("src//main//input.txt"));
            int m, n;
            m = sc.nextInt();
            n = sc.nextInt();

            field = new Piece[m][n];

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    switch (sc.next()) {
                        case "K":
                            field[i][j] = new Knight(i, j, 0);
                            break;
                        case "k":
                            field[i][j] = new Knight(i, j, 1);
                            whiteKnightPos = new Knight(i, j, 1);
                            break;
                        case "P":
                            field[i][j] = new Pawn(i, j, 0);
                            break;
                        case "p":
                            field[i][j] = new Pawn(i, j, 1);
                            break;
                        case "R":
                            field[i][j] = new Rook(i, j, 0);
                            blackRookPos = new Rook(i, j, 0);
                            break;
                        case "r":
                            field[i][j] = new Rook(i, j, 1);
                            break;
                        case "0":
                            field[i][j] = null;
                            break;
                    }
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void print(Piece[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++)
                if (f[i][j] == null)
                    System.out.print("0 ");
                else
                    f[i][j].draw();
            System.out.println();
        }
        System.out.println();
    }

    public boolean movePiece(Piece piece) {
        int X = piece.x;
        int Y = piece.y;
        for (int i = 0; i < piece.possibleMoves.size(); i++) {
            if (field[piece.possibleMoves.get(i).x][piece.possibleMoves.get(i).y] != null) {
                System.out.println(piece.toString() + "captures " + field[piece.possibleMoves.get(i).x][piece.possibleMoves.get(i).y].toString() +
                        "in position (" + (piece.possibleMoves.get(i).x + 1) + "," + (piece.possibleMoves.get(i).y + 1) + ").");

                piece.setCoordinates(piece.possibleMoves.get(i).x, piece.possibleMoves.get(i).y);
                piece.findPossibleMoves(field);
                field[piece.possibleMoves.get(i).x][piece.possibleMoves.get(i).y] = piece;
                if (piece.getColor() == 1)
                    whiteKnightPos.setCoordinates(piece.x, piece.y);
                else
                    blackRookPos.setCoordinates(piece.x, piece.y);

                field[X][Y] = null;
                return true;
            }
        }

        int j = (int) (Math.random() * ((piece.possibleMoves.size())));
        System.out.println(piece.toString() + "moves to position (" + (piece.possibleMoves.get(j).x + 1 + "," + (piece.possibleMoves.get(j).y + 1) + ")."));
        piece.setCoordinates(piece.possibleMoves.get(j).x, piece.possibleMoves.get(j).y);
        field[piece.x][piece.y] = piece;
        field[piece.x][piece.y].findPossibleMoves(field);
        if (piece.getColor() == 1)
            whiteKnightPos.setCoordinates(piece.x, piece.y);
        else
            blackRookPos.setCoordinates(piece.x, piece.y);

        field[X][Y] = null;
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        MainProc mainProc = new MainProc();
        mainProc.loadField();
        mainProc.print(mainProc.field);

        mainProc.thread1.start();
        mainProc.thread1.join();
        mainProc.thread2.start();
    }
}
