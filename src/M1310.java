public class M1310 {

    // My solution, slow
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] a = new int[queries.length];
        for(int i = 0; i < queries.length; ++i){
            int b = arr[queries[i][0]];
            for(int j = queries[i][0]+1; j <= queries[i][1]; ++j) b^=arr[j];
            a[i] = b;
        }
        return a;
    }

    /**
     In-place calculate the prefix XOR of input A.

     For each query [i, j],
     if i == 0, query result = A[j]
     if i != 0, query result = A[i - 1] ^ A[j]
     * */
    public int[] xorQueries2(int[] A, int[][] queries) {
        int[] res = new int[queries.length], q;
        for (int i = 1; i < A.length; ++i) A[i] ^= A[i - 1];
        for (int i = 0; i < queries.length; ++i) {
            q = queries[i];
            res[i] = q[0] > 0 ? A[q[0] - 1] ^ A[q[1]] : A[q[1]];
        }
        return res;
    }
}
