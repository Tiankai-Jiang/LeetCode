public class E509 {
    public int fib(int N) {
        int[] a = new int[31];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i <= N; ++i) a[i] = a[i-2] + a[i-1];
        return a[N];
    }

    // Less space
    public int fib2(int N) {
        if(N <= 1) return N;
        int a = 0, b = 1;
        while(N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
