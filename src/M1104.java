import java.util.*;
public class M1104 {

    // My solution
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> l = new LinkedList<>();
        int level = (int)(Math.log(label) / Math.log(2));
        while(level >= 0){
            l.add(0, label);
            label = (int)(Math.pow(2, level) - 1 - (int)((label - Math.pow(2, level))/2));
            level--;
        }
        return l;
    }
}
