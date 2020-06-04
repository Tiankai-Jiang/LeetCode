import java.util.*;
public class M526 {

    // My solution
    private Set<Integer> setDiff(Set<Integer> used, Set<Integer> curr){
        Set<Integer> res = new HashSet<>();
        for(int i: curr) if(!used.contains(i)) res.add(i);
        return res;
    }

    int a;
    private void backtracking(Set<Integer> used, Set<Integer>[] sArr, int curr){
        if(used.size()==sArr.length){
            a++;
            return;
        }
        Set<Integer> diff = setDiff(used, sArr[curr]);
        if(diff.size()==0) return;
        for(int i: diff){
            used.add(i);
            backtracking(used, sArr, curr+1);
            used.remove(i);
        }
    }

    public int countArrangement(int N) {
        a = 0;
        Set<Integer>[] sArr = new Set[N];
        for(int i=1; i <=N; ++i) {
            sArr[i-1] = new HashSet<>();
            for(int j=1; j<=N; ++j) if(j%i==0||i%j==0) sArr[i-1].add(j);
        }
        backtracking(new HashSet<Integer>(), sArr, 0);
        return a;
    }

    // Another backtracking, try every possible number at each position
    int count = 0;
    public int countArrangement2(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}
