public class H329 {

    private int dfs(int[][] matrix, int[][] cache, int i, int j){
        if(cache[i][j] != 0) return cache[i][j];
        for(int[] k : new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}}){
            if(i+k[0]>=0&&i+k[0]<matrix.length&&j+k[1]>=0&&j+k[1]<matrix[0].length&&matrix[i+k[0]][j+k[1]]>matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, i+k[0], j+k[1]));
            }
        }
        return ++cache[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) for(int j=0; j<matrix[0].length; j++) res = Math.max(res, dfs(matrix, cache, i, j));
        return res;
    }
}
