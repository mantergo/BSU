package main;


public class DataItem {
    private char c;
    private int iterNum;

    DataItem(char c, int iterNum){
        this.c = c;
        this.iterNum = iterNum;
    }

    @Override
    public String toString(){ return ""+c+iterNum+" "; }
}
