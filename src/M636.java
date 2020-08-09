import java.util.*;
public class M636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> s = new Stack<>();
        int a[] = new int[n], t = 0;
        for(String l : logs){
            int t1 = Integer.parseInt(l.substring(l.lastIndexOf(':')+1));
            if(!s.isEmpty()) a[s.peek()] += t1 - t;
            t = t1;
            if(l.charAt(l.indexOf(':')+1) == 's') s.push(Integer.parseInt(l.substring(0, l.indexOf(':'))));
            else{
                a[s.pop()]++;
                t++;
            }
        }
        return a;
    }
}
