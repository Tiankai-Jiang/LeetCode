import java.util.*;
public class M22 {

    // My solution, DP
    public List<String> generateParenthesis(int n) {
        Set<String>[] s = new HashSet[n+1];
        for(int i = 1; i <= n; ++i) s[i] = new HashSet<>();
        s[1].add("()");
        for(int i = 2; i <= n; ++i)
            for(String str: s[i-1])
                for(int j = 0; j < str.length(); ++j)
                    s[i].add(new StringBuilder(str).insert(j, "()").toString());
        return new ArrayList<>(s[n]);
    }

    /**
     DP without using set
     f(0): ""

     f(1): "("f(0)")"

     f(2): "("f(0)")"f(1), "("f(1)")"

     f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"

     So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
     */
    public List<String> generateParenthesis2(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j))
                        list.add("(" + first + ")" + second);
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }

    // Back tracking
    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max) backtrack(list, str+"(", open+1, close, max);
        if(close < open) backtrack(list, str+")", open, close+1, max);
    }
}
