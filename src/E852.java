public class E852 {

    // My solution
    public int peakIndexInMountainArray(int[] A) {
        for(int i = 2; i < A.length; ++i) if(A[i-2] < A[i-1] && A[i] < A[i-1]) return i-1;
        return -1;
    }

    // Check only A[i] > A[i + 1] is sufficient
    public int peakIndexInMountainArray2(int[] A) {
        for (int i = 1; i + 1 < A.length; ++i) if (A[i] > A[i + 1]) return i;
        return 0;
    }

    // Binary search
    public int peakIndexInMountainArray3(int[] A) {
        int l = 0, r = A.length - 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] < A[m + 1]) l = m + 1;
            else r = m;
        }
        return l;
    }

    // Check Golden section search and Fibonacci search

}
