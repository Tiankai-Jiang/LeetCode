import java.util.*;
public class M547 {

    // My solution
    public int findCircleNum(int[][] M) {
        if(M.length==1) return 1;
        short[] parent = new short[M.length], rank = new short[M.length];
        for(short i = 0; i<M.length;++i) parent[i] = i;
        for(int i = 0; i<M.length-1; ++i){
            for(int j = i+1; j<M[0].length;++j){
                if(M[i][j]==1){
                    short x = find(parent, i);
                    short y = find(parent, j);
                    if(x!=y) Union(parent, rank, x, y);
                }
            }
        }
        short[] sh = new short[M.length];
        for(short i = 0; i < parent.length; ++i){
            parent[i] = find(parent, parent[i]);
            sh[parent[i]] = 1;
        }
        short a = 0;
        for(short sht:sh) if(sht==1)a++;
        return a;
    }

    private short find(short[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void Union(short[] parent, short[] rank, short x, short y ) {
        short xroot = find(parent, x);
        short yroot = find(parent, y);
        if (rank[xroot] < rank[yroot]) parent[xroot] = yroot;
        else if (rank[yroot] < rank[xroot]) parent[yroot] = xroot;
        else {
            parent[xroot] = yroot;
            rank[yroot]++;
        }
    }

    // DFS
    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
