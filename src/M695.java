import java.util.Arrays;

public class M695 {

    // My solution
    private int dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) return 0;
        visited[i][j] = true;
        if(grid[i][j]==0) return 0;
        else return 1 + dfs(grid, visited, i-1, j) + dfs(grid, visited, i+1, j) + dfs(grid, visited, i, j-1) + dfs(grid, visited, i, j+1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(boolean[] b : visited) Arrays.fill(b, false);
        for(int i = 0; i < grid.length; ++i) for(int j = 0; j < grid[0].length; ++j) max = Math.max(max, dfs(grid, visited, i, j));
        return max;
    }

    // set grid[i][j] to 0 after visiting and visited can be removed, faster
    private int dfs2(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + dfs2(grid, i-1, j) + dfs2(grid, i+1, j) + dfs2(grid, i, j-1) + dfs2(grid, i, j+1);
    }

    public int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; ++i) for(int j = 0; j < grid[0].length; ++j) max = Math.max(max, dfs2(grid, i, j));
        return max;
    }
}
