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

    public char[][] updateBoard2(char[][] board, int[] click) {
        int m = board.length, n = board[0].length, row = click[0], col = click[1];
        if(board[row][col]=='M') board[row][col]='X';
        else {
            int count = 0;
            for(int[] pos: new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}})
                if(row+pos[0]>=0&&row+pos[0]<m&&col+pos[1]>=0&&col+pos[1]<n&&board[row+pos[0]][col+pos[1]] == 'M') count++;
            if(count > 0) board[row][col] = (char)(count + '0');
            else{
                board[row][col] = 'B';
                for(int[] pos: new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}})
                    if(row+pos[0]>=0&&row+pos[0]<m&&col+pos[1]>=0&&col+pos[1]<n&&board[row+pos[0]][col+pos[1]] == 'M') updateBoard(board, new int[] {row+pos[0], col+pos[1]});
            }
        }
        return board;
    }
}
