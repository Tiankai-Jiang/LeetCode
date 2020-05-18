public class M1314 {

    // My solution, O(n^4)
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] a = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[0].length; ++j){
                int sum = 0, startk = Math.max(0, i-K), endk=Math.min(mat.length, i+1+K), startl = Math.max(0, j-K), endl=Math.min(mat[0].length, j+1+K);
                for(int k = startk; k < endk; ++k) for(int l = startl; l < endl; ++l) sum += mat[k][l];
                a[i][j] = sum;
            }
        }
        return a;
    }


    /**
     +-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
     |     | |       |     |        |     |     |     |         |     |     |        |
     |     | |       |     |        |     |     |     |         |     |     |        |
     +-----+-+       |     +--------+     |     |     |         |     +-----+        |
     |     | |       |  =  |              |  +  |     |         |  -  |              |
     +-----+-+       |     |              |     +-----+         |     |              |
     |               |     |              |     |               |     |              |
     |               |     |              |     |               |     |              |
     +---------------+     +--------------+     +---------------+     +--------------+
     Using the fact that
     rangeSum[i+1][j+1] = rangeSum[i][j+1] + rangeSum[i+1][j] - rangeSum[i][j] + mat[i][j] (The first two for loop)

     Then
     +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     |               |   |         |    |   |   |           |   |         |    |   |   |          |
     |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
     |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
     |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
     |   |      |    |   |         |    |   |   |           |   |              |   |              |
     |   +------+    |   +---------+    |   +---+           |   |              |   |              |
     |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
     +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     (The second two for loop)
     * */

    public int[][] matrixBlockSum2(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        return ans;
    }
}
