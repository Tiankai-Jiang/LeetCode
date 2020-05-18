public class E883 {

    // My solution
    public int projectionArea(int[][] grid) {
        int z = 0, y = 0, x = 0;
        int[] xm = new int[grid.length];
        for(int i=0; i<grid.length; ++i){
            int ym=0;
            for(int j=0; j<grid.length; ++j){
                int t = grid[i][j];
                if(t!=0) z++;
                if(t>ym) ym=t;
                if(t>xm[j]) xm[j]=t;
            }
            y += ym;
        }
        for(int i : xm) x+=i;
        return x+y+z;
    }
}
