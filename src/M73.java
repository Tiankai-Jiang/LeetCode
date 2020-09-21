public class M73 {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length], col = new boolean[matrix[0].length];
        for(int i=0; i< matrix.length; i++) for(int j=0; j<matrix[0].length; j++) if(matrix[i][j]==0) row[i] = col[j] = true;
        for(int i=0; i< matrix.length; i++) if(row[i]) for(int j=0; j<matrix[0].length; j++) matrix[i][j] = 0;
        for(int i=0; i< matrix[0].length; i++) if(col[i]) for(int j=0; j<matrix.length; j++) matrix[j][i] = 0;
    }

    public void setZeroes2(int[][] matrix) {
        int col0 = 1, row = matrix.length, col = matrix[0].length;

        for(int i=0; i<row; i++){
            if (matrix[i][0] == 0) col0 = 0;
            for(int j=1; j<col; j++) if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}