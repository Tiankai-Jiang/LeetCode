import java.util.*;
public class M77 {

    // My solution
    private void backtracking(int n, int k, int start, LinkedList<Integer> curr, List<List<Integer>> l){
        if(curr.size()==k) {
            l.add(new LinkedList<>(curr));
            return;
        }
        for(int i = start; i <=n; ++i){
            curr.add(i);
            backtracking(n, k, i+1, curr, l);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> a = new LinkedList<>();
        backtracking(n, k, 1, new LinkedList<>(), a);
        return a;
    }

    // Iterative
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i<k;i++) temp.add(0);
        int i = 0;
        while (i >= 0) {
            temp.set(i, temp.get(i)+ 1);
            if (temp.get(i) > n)  i--;
            else if (i == k - 1) ans.add(new ArrayList<>(temp));
            else {
                i++;
                temp.set(i, temp.get(i-1));
            }
        }
        return ans;
    }

    // Iterative 2
    public List<List<Integer>> combine3(int n, int k) {
        if (n == 0 || k == 0 || k > n) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n + 1 - k; i++) res.add(Arrays.asList(i));
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> list : res) {
                for (int m = list.get(list.size() - 1) + 1; m <= n - (k - (i - 1)) + 1; m++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(m);
                    tmp.add(newList);
                }
            }
            res = tmp;
        }
        return res;
    }

    // C ( n, k ) = C ( n - 1, k - 1) + C ( n - 1, k )
    public List<List<Integer>> combine4(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) row.add(i);
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }

    // DP
    public List<List<Integer>> combine5(int n, int k) {
        List<List<Integer>>[][] dp = new List[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = new ArrayList<>();
                if (i > j) dp[i][j].addAll(dp[i - 1][j]);
                for (List<Integer> list: dp[i - 1][j - 1]) {
                    List<Integer> tmpList = new ArrayList<>(list);
                    tmpList.add(i);
                    dp[i][j].add(tmpList);
                }
            }
        }
        return dp[n][k];
    }
}
