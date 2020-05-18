import java.util.*;
public class M39 {

    // My solution, finally I know how to write backtracking!
    private void backtracking(int[] candidates, int target, int start, List<List<Integer>> l, List<Integer> t){
        if(target == 0) l.add(new LinkedList<>(t));
        else{
            for(int i = start; i < candidates.length; ++i){
                if(candidates[i]<=target){
                    t.add(candidates[i]);
                    backtracking(candidates, target-candidates[i], i, l, t);
                    t.remove(t.size()-1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new LinkedList<>();
        backtracking(candidates, target, 0, l, new LinkedList<>());
        return l;
    }

    // DP
    public List<List<Integer>> combinationSum2(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}
