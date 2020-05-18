import java.util.*;

public class M406 {

    // My solution
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));
        Map<Integer, Integer> m = new HashMap<>();
        for(int[] i : people) m.merge(i[0], 1, Integer::sum);
        List<int[]> l = new LinkedList<>(Arrays.asList(people));
        int cur = people.length-1;
        while(cur >= 0){
            for(int i = m.get(l.get(cur)[0])-1; i>=0; --i, --cur){
                int[] p = l.get(cur);
                if(p[1] != i){
                    l.add(cur+1+p[1]-i, p);
                    l.remove(cur);
                }
            }
        }
        return l.toArray(new int[people.length][2]);
    }

    // While I sort both height and number of people in ascending order,
    // We can sort the height reversely, [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
    // And number of people in front of them(p[1]) is the insert position for each person
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0])?  n1[1] - n2[1] : n2[0] - n1[0]);
        List<int[]> res = new LinkedList<>();
        for(int[] p : people)  res.add(p[1], p);
        return res.toArray(new int[people.length][2]);
    }
}
