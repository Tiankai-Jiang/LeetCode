public class E463 {

    // My solution
    public int islandPerimeter(int[][] grid) {
        int a = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(i == 0){
                    if(j == 0) a += 2*grid[i][j];
                    else a += (grid[i][j-1] == 1) ? 1 : 2*grid[i][j];
                }else{
                    if(j == 0) a += (grid[i-1][j] == 1) ? 1 : 2*grid[i][j];
                    else a += grid[i-1][j] != grid[i][j-1] ? 1 : (2*(grid[i][j-1]^grid[i][j]));
                }
                if(i == grid.length - 1 && grid[i][j] == 1) a++;
                if(j == grid[0].length - 1 && grid[i][j] == 1) a++;
            }
        }
        return a;
    }

    // Much simpler logic, add 4 for each 1 and minus 2 for each internal edge
    public static int islandPerimeter2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }

    // each time we encounter a boundary, count++;
    public int islandPerimeter3(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    for(int[] d:  new int[][]{{0,1},{1,0},{-1,0},{0,-1}}){
                        int x = i + d[0], y = j + d[1];
                        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0) count++;
                    }
                }
            }
        }
        return count;
    }
}
