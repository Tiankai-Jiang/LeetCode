public class M419 {

    // My solution
    public int countBattleships(char[][] board) {
        int a = 0;
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j)
                if(board[i][j] == 'X' && (i==0 || board[i-1][j] == '.') && (j==0 || board[i][j-1] == '.')) a++;
        return a;
    }
}
