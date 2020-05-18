public class E977 {

    // My solution
    public int[] sortedSquares(int[] A) {
        int m = 0, j, k, c = 1;
        int[] a = new int[A.length];
        for(int i = 0; i < A.length - 1; ++i) {
            if(Math.abs(A[i]) < Math.abs(A[i+1])) {
                m = i;
                break;
            }
            m = A.length - 1;
        }
        j = m - 1;
        k = m + 1;
        a[0] = A[m] * A[m];
        while(j >= 0 && k < A.length) a[c++] = Math.abs(A[j]) < Math.abs(A[k]) ? A[j] * A[j--] : A[k] * A[k++];
        for(; j >= 0; --j) a[c++] = A[j] * A[j];
        for(; k < A.length; ++k) a[c++] = A[k] * A[k];
        return a;
    }

    // Use two pointers to build the array from end
    public int[] sortedSquares2(int[] A) {
        if(A == null || A.length == 0) return new int[0];
        final int L = A.length;
        int[] a = new int[L];
        int l = 0, r = L - 1, idx = L - 1;
        while(l <= r) a[idx--] = Math.abs(A[l]) < Math.abs(A[r]) ? A[r] * A[r--] : A[l] * A[l++];
        return a;
    }
}
