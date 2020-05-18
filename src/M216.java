import java.util.*;
public class M216 {

    // My solution
    private void backtracking(List<List<Integer>> l, int n, int k, int start, LinkedList<Integer> curr){
        if(n == 0 && k == 0){
            l.add(new LinkedList<>(curr));
            return;
        }
        if(n == 0 || k == 0) return;
        for(int i = start; i <= 9; ++i){
            if(i > n) return;
            curr.addLast(i);
            backtracking(l, n-i, k-1, i+1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> l = new LinkedList<>();
        backtracking(l, n, k, 1, new LinkedList<>());
        return l;
    }
}
