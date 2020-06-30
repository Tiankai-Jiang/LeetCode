public class E762 {

    // My solution
    public int countPrimeSetBits(int L, int R) {
        int a = 0;
        byte[] isPrime = new byte[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};
        for(int i=L; i<=R;++i) {
            int c = 0, n = i;
            while(n!=0){
                c += (n&1);
                n >>= 1;
            }
            a += isPrime[c];
        }
        return a;
    }

    // Fuck
    public int countPrimeSetBits2(int L, int R) {
        int count = 0;
        while (L <= R) count += 665772 >> Integer.bitCount(L++) & 1;
        return count;
    }
}
