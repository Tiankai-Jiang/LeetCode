public class E766 {

    // My solution
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length < 2 || matrix[0].length < 2) return true;
        for(int i=1; i < matrix.length; ++i) for(int j = 1; j < matrix[0].length; ++j) if(matrix[i][j]!=matrix[i-1][j-1]) return false;
        return true;
    }

    // Save one line, but why it goes from 0ms to 1ms?
    public boolean isToeplitzMatrix2(int[][] matrix) {
        for(int i=0; i < matrix.length-1; ++i) for(int j = 0; j < matrix[0].length-1; ++j) if(matrix[i][j]!=matrix[i+1][j+1]) return false;
        return true;
    }
}
