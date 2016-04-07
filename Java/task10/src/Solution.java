import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution sol =  new Solution();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<10000; i++)
            map.put(i, (int) Math.random()*200000);
        double time1 = sol.countTimeforGet(map);
        System.out.println("HashMap mean time for \"get\": " + time1);

        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        for(int i=0; i<10000; i++)
            map2.put(i, (int) Math.random()*200000);
        double time2 = sol.countTimeforGet(map2);
        System.out.print("TreeMap mean time for \"get\": "+time2);

    }

    public double countTimeforGet(Map<Integer, Integer> map) {
        Date d1 = new Date();
        for(Integer i: map.keySet())
            map.get(i);
        Date d2 = new Date();
        //System.out.println(d2.getTime());
        return (double)(d2.getTime() - d1.getTime())/(double)map.size();
    }
}
