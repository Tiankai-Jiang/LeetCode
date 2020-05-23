public class M413 {

    // My solution
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int i = 0, j = 2, a = 0;
        while(j <= A.length){
            if(j == A.length || A[i+1]-A[i] != A[j]-A[j-1]) {
                a += (j-i-2)*(1+(j-i-2))/2;
                i = ++j - 2;
            } else j++;
        }
        return a;
    }

    // We need minimum 3 indices to make arithmetic progression,
    // So start at index 2, see if we got two diffs same, so we get a current 1 arith sequence
    // At any index i, if we see it forms arith seq with former two, that means running (curr) sequence gets extended upto this index, at the same time we get one more sequence (the three numbers ending at i), so curr++. Any time this happens, add the curr value to total sum.
    // Any time we find ith index does not form arith seq, make currently running no of seqs to zero.
    public int numberOfArithmeticSlices2(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) sum += ++curr;
            else curr = 0;
        return sum;
    }
}
