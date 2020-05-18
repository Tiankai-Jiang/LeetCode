public class E1304 {

    // My solution
    public int[] sumZero(int n) {
        int[] a = new int[n];
        for(int i = 0; i < n - 1; i+=2) {
            a[i] = i/2+1;
            a[i+1] = (-1)*(i/2+1);
        }
        if(n % 2 != 0) a[n-1] = 0;
        return a;
    }

    // Find the rule
    // A[i] = i * 2 - n + 1
    public int[] sumZero2(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; ++i) A[i] = i * 2 - n + 1;
        return A;
    }
}
