public class M289 {

    // My solution
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int[][] a = new int[row][col];
        for(int i = 0; i < row; ++i){
            for(int j=0; j<col; ++j){
                int count = 0;
                for(int k[] : new int[][]{{-1,-1}, {0,-1}, {1,-1},{-1,0}, {1,0},{-1,1}, {0,1}, {1,1}})
                    if(i+k[0] >= 0 && i+k[0] < row && j+k[1] >= 0 && j+k[1]<col && board[i+k[0]][j+k[1]]==1) count++;
                a[i][j] = (count == 2 && board[i][j] == 1) || count == 3 ? 1 : 0;
            }
        }
        for(int i = 0;i<row;++i) for(int j=0;j<col;++j) board[i][j] = a[i][j];
    }

    // Solve it in place
    // https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
}
