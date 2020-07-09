public class M36 {

    // My solution
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], column = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    if(row[i][num]) return false;
                    else row[i][num] = true;
                    if(column[j][num]) return false;
                    else column[j][num] = true;
                    if(box[i/3][j/3][num]) return false;
                    else box[i/3][j/3][num] = true;
                }
            }
        }
        return true;
    }
}
