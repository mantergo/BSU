import java.io.*;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) throws IOException{
        
        object m = new object(2);
        
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        m.n = sc.nextInt();
        int e = sc.nextInt();
        long c[][] = new long[100][100];
        
        for (int i = 0; i <= m.n*(m.n-1); i++) {
            m.cur[i] = 0;
            m.max[i] = 0;
        }
        for (int i = 0; i < m.n; i++) {
            for (int h = 0; h < m.n; h++)
                c[i][h] = 0;
        }
        for (int i = 0; i < e; i++){
            int t1, t2;
            t1 =sc.nextInt();
            t2 =sc.nextInt();
            c[t1 - 1][t2 - 1] = 1;
        }
        
        for (int i = 0; i < m.n; i++) {
            m.cur[0] = 1;
            m.cur[1] = i;
            m.dfs(c, i);
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("output.out"),false);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BufferedWriter b = new BufferedWriter(fw);
        b.write(Long.toString(m.max[0] - 1));
        b.write("\n");
        
        for (int i = 1; i < m.max[0]; i++) {
            b.write(Long.toString(m.max[i] + 1));
            b.write(" ");
            b.write(Long.toString(m.max[i + 1] + 1));
            b.write("\n");
        }
        b.close();
    }
    
}

class object {
    
    int n;
    int m = 100;
    long max[] = new long[m+1];
    long cur[] = new long[m+1];
    
    public void dfs(long c[][], int k) {
        
        
        for (int j = 0; j < n; j++) {
            if (c[k][j] == 1) {
                c[k][j] = -1;
                cur[0]++;
                cur[(int)cur[0]] = j;
                dfs(c, j);
                if (max[0] < cur[0]) {
                    for (int i = 0; i < cur[0]+1; i++)
                        max[i] = cur[i];
                }
                
                cur[0]--;
                c[k][j] = 1;
            }
        }
    }
    public object (int k){
        n=k;
    }
    
}