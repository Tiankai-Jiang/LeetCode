public class E942 {

    // My solution
    public int[] diStringMatch(String S) {
        int[] a = new int[S.length()+1];
        int l = 0, h = 0;
        for(int i = 1; i < a.length; ++i) a[i] = S.charAt(i-1) == 'D' ? --l : ++h;
        for(int i = 0; i < a.length; ++i) a[i] -= l;
        return a;
    }

    // Magic
    public int[] diStringMatch2(String S) {
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i) res[i] = S.charAt(i) == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }
}
