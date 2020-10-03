public class M994 {
    public int orangesRotting(int[][] grid) {
        int m= grid.length, n=grid[0].length, res = 0;
        final int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(true){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j]==1){
                        for(int[] k: dirs){
                            if(i+k[0]>=0&&i+k[0]<m&&j+k[1]>=0&&j+k[1]<n&&grid[i+k[0]][j+k[1]]==2){
                                grid[i][j] = 3;
                                break;
                            }
                        }
                    }
                }
            }
            boolean newRottenOrange = false;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j]==3){
                        newRottenOrange = true;
                        grid[i][j] = 2;
                    }
                }
            }
            if(!newRottenOrange) break;
            res++;
        }

        for(int i=0; i<m; i++) for(int j=0; j<n; j++) if(grid[i][j]==1) return -1;
        return res;
    }
}
