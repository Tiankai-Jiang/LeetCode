public class M59 {

    // My solution 1
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        for(int i = 0; i < n-1; ++i) a[0][i] = i+1;
        int v = 1, h = 0, count = n, steps = n-1, i = 0, j = n-1;
        for(count = n; count < n*n; steps--){
            for(int l = 0; l < 2; ++l){
                for(int k = 0; k < steps; ++k, i += v, j += h) a[i][j] = count++;
                v = v == 0 ? h - (h=v) : -v - (h=-v);
            }
        }
        a[i][j] = count;
        return a;
    }

    // My solution 2
    public static int[][] generateMatrix2(int n) {
        int[][] a = new int[n][n];
        int left = 0, top = 0, right = n - 1, down = n - 1, count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j ++) a[top][j] = count++;
            top ++;
            for (int i = top; i <= down; i ++) a[i][right] = count ++;
            right --;
            for (int j = right; j >= left; j --) a[down][j] = count ++;
            down --;
            for (int i = down; i >= top; i --) a[i][left] = count ++;
            left ++;
        }
        return a;
    }
}
