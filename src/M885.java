public class M885 {

    // My solution
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int covered = 0, h = 1, v = 0;
        int[][] a = new int[R * C][2];
        for (int i = 1; covered < R * C; ++i) {
            for (int j = 0; j < i; ++j) {
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C){
                    a[covered] = new int[]{r0, c0};
                    covered++;
                }
                r0 += v;
                c0 += h;
            }
            v = h;
            h = 0;
            for (int j = 0; j < i; ++j) {
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C){
                    a[covered] = new int[]{r0, c0};
                    covered++;
                }
                r0 += v;
                c0 += h;
            }
            h = (-1) * v;
            v = 0;
        }
        return a;
    }
}
