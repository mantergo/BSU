package main;

import java.util.ArrayList;

public class BaseClass {
    public static void main(String[] args) {
        ArrayList<BaseClass> list = new ArrayList<>();
        AClass a1 = new AClass();
        AClass a2 = new AClass();
        BClass b1 = new BClass();
        list.add(a1);
        list.add(b1);
        list.add(a2);

        System.out.println("1.");
        for(int i=0; i<3; i++)
            if(list.get(i) instanceof AClass)
                ((AClass) list.get(i)).fA();
            else if (list.get(i) instanceof BClass)
                ((BClass) list.get(i)).fB();

        System.out.println("2a.");
        for(int i=0; i<3; i++) {
            Class cl = list.get(i).getClass();
            String s = cl.getName();
            if(s.equals(AClass.class.getName()))
                ((AClass) list.get(i)).fA();
            else if (s.equals(BClass.class.getName()))
                ((BClass) list.get(i)).fB();
        }

        System.out.println("2b.");
        for(int i=0; i<3; i++) {
            Class cl = list.get(i).getClass();
            if(cl==AClass.class)
                ((AClass) list.get(i)).fA();
            else if (cl==BClass.class)
                ((BClass) list.get(i)).fB();
        }


    }
}

class AClass extends BaseClass {
    public void fA() {
        System.out.println("Function from A class.");
    }
}

class BClass extends BaseClass {
    public void fB() {
        System.out.println("Function from B class.");
    }
}
