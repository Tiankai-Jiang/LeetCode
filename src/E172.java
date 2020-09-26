public class E172 {
    public int trailingZeroes(int n) {
        int res = 0;
        for(int i=1; Math.pow(5, i)<=n; i++) res += n/(int)Math.pow(5, i);
        return res;
    }
}
