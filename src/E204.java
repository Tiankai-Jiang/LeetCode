public class E204 {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] isNotPrime = new boolean[n];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i=2; i<Math.sqrt(n); i++){
            for(int j=2; i*j<n; j++){
                isNotPrime[i*j] = true;
            }
        }
        int res = 0;
        for(boolean b: isNotPrime) if(!b) res++;
        return res;
    }
}
