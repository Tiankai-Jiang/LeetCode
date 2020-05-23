public class M959 {
    private int dfs(byte[][] b, int i, int j){
        if(i < 0 || i >= b.length || j < 0 || j >= b[0].length || b[i][j] == 1) return 0;
        b[i][j] = 1;
        dfs(b, i-1, j);
        dfs(b, i+1, j);
        dfs(b, i, j+1);
        dfs(b, i, j-1);
        return 1;
    }

    public int regionsBySlashes(String[] grid) {
        byte[][] b = new byte[grid.length*3][grid.length*3];
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length(); ++j){
                if(grid[i].charAt(j)=='/') b[i*3][j*3+2] = b[i*3+1][j*3+1] = b[i*3+2][j*3] = 1;
                if(grid[i].charAt(j)=='\\') b[i*3][j*3] = b[i*3+1][j*3+1] = b[i*3+2][j*3+2] = 1;
            }
        }
        int a = 0;
        for(int i = 0; i < grid.length*3; ++i) for(int j = 0; j < grid.length*3;++j) a +=dfs(b,i,j);
        return a;
    }

    // Another mind fucking solution
    // https://leetcode.com/problems/regions-cut-by-slashes/discuss/205680/JavaC%2B%2BPython-Split-4-parts-and-Union-Find
}
