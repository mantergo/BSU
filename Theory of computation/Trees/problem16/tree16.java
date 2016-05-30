import java.io.*;

public class Main implements Runnable{
    
    private static class Node {
        int Key;
        int LeftNodes;
        int RightNodes;
        Node Left;
        Node Right;
        Node Top;
        
        
        Node(int nKey) {
            Key = nKey;
            LeftNodes = 0;
            RightNodes = 0;
            Left = null;
            Right = null;
            Top = null;
        }
        
    }
    
    private static class Tree {
        
        Tree(){
            Root = null;
            
            Key = null;
            
            FindKey = null;
            
            Width = 40;
            
            Height = 20;
        }
        boolean AddNode(int nKey){
            
            if (FindNode(nKey))
                return false;
            Node Temp = new Node(nKey);
            Node Cur = Root;
            Node Prev = null;
            while (Cur != null)
            {
                Prev = Cur;
                if (Cur.Key < Temp.Key)
                {
                    Cur.RightNodes++;
                    Cur = Cur.Right;
                }
                else
                {
                    Cur.LeftNodes++;
                    Cur = Cur.Left;
                }
            }
            if (Prev == null)
                Root = Temp;
            else
            {
                if (Prev.Key < Temp.Key)
                    Prev.Right = Temp;
                else
                    Prev.Left = Temp;
                Temp.Top = Prev;
            }
            Key = null;
            return true;
        }
        
        boolean FindNode(int cKey){
            
            Node Cur = Root;
            while (Cur != null)
                if (Cur.Key < cKey)
                    Cur = Cur.Right;
                else
                    if (Cur.Key > cKey)
                        Cur = Cur.Left;
                    else
                    {
                        FindKey = Cur;
                        return true;
                    }
            FindKey = null;
            return false;
            
        }
        
        boolean Find(Tree Tree){
            if (Cmp(Root, Tree.Root))
            {
                Node Cur = Key.Top;
                Fl = (Key.Left == null && Key.Right == null);
                while (Cur != null)
                {
                    if (Cur.Key > Key.Key && FindLeftMax(Cur) == Key.Key)
                        Key = Cur;
                    Cur = Cur.Top;
                }
                return true;
            }
            Key = null;
            return false;
        }
        int GetFindKey(){
            return Key.Key;
        }
        
        boolean Cmp(Node Node1, Node Node2){
            if (Node1 == null)
                return false;
            if (Node2 == null)
            {
                if (Node1.Left != null || Node1.Right != null)
                    return false;
                Key = Node1;
                return true;
            }
            if ((Node1.LeftNodes + Node1.RightNodes) - (Node2.LeftNodes + Node2.RightNodes) != 1)
                return false;
            if (Node1.LeftNodes == Node2.LeftNodes + 1) {
                return Equ(Node1.Right, Node2.Right) && Cmp(Node1.Left, Node2.Left);
            }
            if (Node1.RightNodes == Node2.RightNodes + 1) {
                return Equ(Node1.Left, Node2.Left) && Cmp(Node1.Right, Node2.Right);
            }
            if (Node1.Left == null)
                if (Equ(Node1.Right, Node2))
                {
                    Key = Node1;
                    return true;
                }
                else
                    return false;
            if (Node1.Right == null)
                if (Equ(Node1.Left, Node2))
                {
                    Key = Node1;
                    return true;
                }
                else
                    return false;
            return false;
        }
        boolean Equ(Node Node1, Node Node2){
            if (Node1 == null && Node2 == null)
                return true;
            if (Node1 == null || Node2 == null)
                return false;
            if ((Node1.LeftNodes != Node2.LeftNodes) || (Node1.RightNodes != Node2.RightNodes))
                return false;
            boolean fl;
            fl = Equ(Node1.Left, Node2.Left);
            if (fl)
                fl = Equ(Node1.Right, Node2.Right);
            return fl;
        }
        
        int FindLeftMax(Node Node){
            if (Node.Left != null)
            {
                Node = Node.Left;
                while (Node.Right != null)
                    Node = Node.Right;
            }
            return Node.Key;
        }
        
        
        Node Root;
        Node Key;
        Node FindKey;
        int Width;
        int Height;
        boolean Fl;
    }
    
    
    // public static void main(String[] args)
    // {
    
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }
    
    public void run() {
        // здесь идёт решение
        Tree Tree1 = new Tree();
        Tree Tree2 = new Tree();
        int k=9;
        int i = 0;
        boolean flag = false;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("tst.in"));
            String line = br.readLine();
            k = Integer.parseInt(line);
            Tree1.AddNode(k);
            i++;
            
            while ((line = br.readLine()) != null) {
                if (line.toCharArray()[0] == '*'){
                    flag = true;
                    line = br.readLine();
                    
                }
                if (!flag) {
                    Tree1.AddNode(Integer.parseInt(line));
                    i++;
                }
                else {
                    Tree2.AddNode(Integer.parseInt(line));
                    i--;
                }
            }
        }
        catch(IOException e1){
            e1.printStackTrace();
        }
        
        
        boolean fl;
        if (i > 0)
        {
            fl = Tree1.Find(Tree2);
            if (fl)
                k = Tree1.GetFindKey();
        }
        else
        {
            fl = Tree2.Find(Tree1);
            if (fl)
                k = Tree2.GetFindKey();
        }
        
        Writer writer = null;
        try {
            writer = new FileWriter("tst.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        PrintWriter out = new PrintWriter(writer);
        
        // pw = new PrintWriter(writer);
        if (fl)
        {
            
            // assert pw != null;
            out.println("YES");
            out.print(k);
            
        }
        else {
            //   assert pw != null;
            out.print("NO");
        }
        out.close();
        
    }
}