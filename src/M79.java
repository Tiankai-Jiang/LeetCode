public class M79 {

    // My solution
    private boolean exist(char[][]board, String word, byte[][] visited, int i, int j){
        if(board[i][j] == word.charAt(0)){
            if (word.length() == 1) return true;
            visited[i][j] = 1;
            for(int[] k : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}){
                if(i+k[0]>=0 && i+k[0]<board.length && j+k[1]>=0 && j+k[1]<board[0].length && visited[i+k[0]][j+k[1]]==0){
                    if(exist(board, word.substring(1), visited, i+k[0], j+k[1])) return true;
                    else visited[i+k[0]][j+k[1]] = 0;
                }
            }
            visited[i][j] = 0;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        byte[][] visited = new byte[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i) for(int j = 0; j < board[0].length; ++j) if(exist(board, word, visited, i, j)) return true;
        return false;
    }
}
