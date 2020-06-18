public class M96 {
    public int numTrees(int n) {
        if(n==0 || n==1) return 1;
        int[] res = new int[n+1];
        res[0] = res[1] = 1;
        for(int i=2; i<=n;++i) for(int j=0; j<i; ++j) res[i] += res[j] * res[i - j -1];
        return res[n];
    }

    public int numTrees2(int n) {
        return new int[]{1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190}[n];
    }
}
