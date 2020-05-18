public class M338 {

    // My solution
    public int[] countBits(int num) {
        int[] a = new int[num+1];
        for(int i=1; i<=num; ++i) a[i] = i%2==0 ? a[i/2] : a[i-1] + 1;
        return a;
    }

    // Similar solution
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; ++i) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
