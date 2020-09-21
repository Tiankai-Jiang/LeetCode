import java.util.*;
public class E118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>(){{add(new ArrayList<Integer>(){{add(1);}});}};
        if(numRows == 1) return res;
        res.add(new ArrayList<Integer>(){{add(1);add(1);}});
        if(numRows == 2) return res;
        for(int i=2; i<numRows; i++){
            res.add(new ArrayList<>());
            List<Integer> cur = res.get(i);
            cur.add(1);
            for(int j=0; j<i-1; j++) cur.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            cur.add(1);
        }
        return res;
    }
}
