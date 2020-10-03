import java.util.*;
public class M1091 {

    // I don't know why TLE.
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1]==1) return -1;
        int dist = 1, m = grid.length;
        final int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean[][] visited = new boolean[m][m];
        Queue<int[]> q = new ArrayDeque<int[]>(){{offer(new int[]{0,0});}};

        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0; i<s; i++){
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true;
                if(cur[0]==m-1&&cur[1]==m-1) return dist;
                for(int[] k: dirs){
                    if(cur[0]+k[0]>=0&&cur[0]+k[0]<m&&cur[1]+k[1]>=0&&cur[1]+k[1]<m&&!visited[cur[0]+k[0]][cur[1]+k[1]]&&grid[cur[0]+k[0]][cur[1]+k[1]]==0){
                        q.offer(new int[]{cur[0]+k[0], cur[1]+k[1]});
                    }
                }
            }
            dist++;
        }
        return -1;
    }


    public int shortestPathBinaryMatrix2(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] != 0 || grid[N-1][N-1] != 0) return -1;
        int len = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                int[] n = q.poll();
                int r = n[0], c = n[1];
                if (r == N-1 && c == N - 1) return len;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int nr = r + x;
                        int nc = c + y;
                        if (nr >= 0 && nc >= 0 && nr < N && nc < N && grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
