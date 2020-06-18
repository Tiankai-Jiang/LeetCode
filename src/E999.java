public class E999 {

    // My solution
    public int numRookCaptures(char[][] board) {
        int r=0, c=0, a=0;
        for(int b=0; b<64; ++b) if(board[r=b/8][c=b%8]=='R') break;
        for(int i=r-1; i>=0;--i) {
            if(board[i][c]=='p') {
                a++;
                break;
            }else if(board[i][c]=='B') break;
        }
        for(int i=r+1; i<8;++i){
            if(board[i][c]=='p') {
                a++;
                break;
            }else if(board[i][c]=='B') break;
        }
        for(int i=c-1; i>=0;--i){
            if(board[r][i]=='p') {
                a++;
                break;
            }else if(board[r][i]=='B') break;
        }
        for(int i=c+1; i<8;++i){
            if(board[r][i]=='p') {
                a++;
                break;
            }else if(board[r][i]=='B') break;
        }
        return a;
    }

    // Shorter
    public int numRookCaptures2(char[][] board) {
        int x0 = 0, y0 = 0, res = 0;
        for(int b=0; b<64; ++b) if(board[x0=b/8][y0=b%8]=='R') break;
        for (int[] d : new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
            for (int x = x0 + d[0], y = y0 + d[1]; 0 <= x && x < 8 && 0 <= y && y < 8; x += d[0], y += d[1]) {
                if (board[x][y] == 'p') res++;
                if (board[x][y] != '.') break;
            }
        }
        return res;
    }
}
