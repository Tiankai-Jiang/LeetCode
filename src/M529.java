public class M529 {

    // My solution
    private void change(char[][] board, int x, int y){
        if(board[x][y]=='E'){
            int c = 0;
            if(x>0) {
                if(y>0 && board[x-1][y-1]=='M')c++;
                if(y<board[0].length-1 && board[x-1][y+1]=='M')c++;
                if(board[x-1][y]=='M')c++;
            }
            if(x<board.length-1) {
                if(y>0 && board[x+1][y-1]=='M')c++;
                if(y<board[0].length-1 && board[x+1][y+1]=='M')c++;
                if(board[x+1][y]=='M')c++;
            }
            if(y>0 && board[x][y-1]=='M')c++;
            if(y<board[0].length-1 && board[x][y+1]=='M')c++;

            board[x][y] = c==0? 'B': (char)(c+'0');

            if(board[x][y] == 'B'){
                if(x>0) {
                    if(y>0) change(board, x-1, y-1);
                    if(y<board[0].length-1) change(board, x-1, y+1);
                    change(board, x-1, y);
                }
                if(x<board.length-1) {
                    if(y>0) change(board, x+1, y-1);
                    if(y<board[0].length-1) change(board, x+1, y+1);
                    change(board, x+1, y);
                }
                if(y>0) change(board, x, y-1);
                if(y<board[0].length-1) change(board, x, y+1);
            }
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M') board[click[0]][click[1]]='X';
        else change(board, click[0], click[1]);
        return board;
    }
}
