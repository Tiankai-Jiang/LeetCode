public class E191 {
    public int hammingWeight(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            res += (n&1);
            n >>>= 1;
        }
        return res;
    }
}
