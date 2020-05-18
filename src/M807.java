public class M807 {

    // My solution
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int a = 0;
        int[] h = new int[grid.length], v = new int[grid.length];
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid.length; ++j){
                v[j] = Math.max(v[j], grid[i][j]);
                h[i] = Math.max(h[i], grid[i][j]);
            }
        }
        for(int i = 0; i < grid.length; ++i) for(int j = 0; j < grid.length; ++j) a += (Math.min(h[i], v[j]) - grid[i][j]);
        return a;
    }
}
