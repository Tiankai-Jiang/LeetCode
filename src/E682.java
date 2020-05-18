import java.util.*;
public class E682 {

    // My solution
    public int calPoints(String[] ops) {
        int a = 0;
        LinkedList<Integer> score = new LinkedList<>();
        for(String s: ops){
            if(s.equals("+")) score.offer(score.get(score.size()-2)+score.peekLast());
            else if(s.equals("D")) score.offer(2*score.peekLast());
            else if(s.equals("C")) score.pollLast();
            else score.offer(Integer.parseInt(s));
        }
        for(Integer i: score) a+=i;
        return a;
    }
}
