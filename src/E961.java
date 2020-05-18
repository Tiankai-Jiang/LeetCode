public class E961 {

    // My solution, O(n) time, O(n) space
    public int repeatedNTimes(int[] A) {
        int[] a = new int[10000];
        for(int i = 0; i < A.length; ++i) if(++a[A[i]]>1) return A[i];
        return 0;
    }

    /**
     Check if A[i] == A[i - 1] or A[i] == A[i - 2]
     If so, we return A[i]
     If not, it must be [x, x, y, z] or [x, y, z, x].
     We return A[0] for the cases that we miss.
     O(n) time, O(1) space ?
     * */
    public int repeatedNTimes2(int[] A) {
        for (int i = 2; i < A.length; ++i) if (A[i] == A[i - 1] || A[i] == A[i - 2]) return A[i];
        return A[0];
    }
}
