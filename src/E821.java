public class E821 {

    // My solution
    public int[] shortestToCharHelper(String S, char C){
        int[] arr = new int[S.length()];
        int cur1 = 0, cur2 = 0;
        char[] str = S.toCharArray();
        for(char c: str){
            if(c == C) for(; cur2 <= cur1; ++cur2) arr[cur2] = cur1-cur2;
            cur1++;
        }
        if(cur1 != cur2) for(; cur2 < cur1; ++cur2) arr[cur2] = 10001;
        return arr;
    }

    public int[] shortestToChar(String S, char C) {
        int[] a = new int[S.length()];
        int[] f = shortestToCharHelper(S, C);
        int[] b = shortestToCharHelper(new StringBuilder(S).reverse().toString(), C);
        for(int i = 0; i < a.length; ++i) a[i] = Math.min(f[i], b[a.length-1-i]);
        return a;
    }

    // Also two pass but it is much simpler
    public int[] shortestToChar2(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) res[i] = S.charAt(i) == C ? 0 : n;
        for (int i = 1; i < n; ++i) res[i] = Math.min(res[i], res[i - 1] + 1);
        for (int i = n - 2; i >= 0; --i) res[i] = Math.min(res[i], res[i + 1] + 1);
        return res;
    }
}
