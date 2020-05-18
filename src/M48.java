public class M48 {

    // My solution
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for(int i = 0; 2*i < l; ++i){
            for(int j = 0; j < l/2; ++j){
                int cache = matrix[l-1-j][i];
                matrix[l-1-j][i] = matrix[l-1-i][l-1-j];
                matrix[l-1-i][l-1-j] = matrix[j][l-1-i];
                matrix[j][l-1-i] = matrix[i][j];
                matrix[i][j] = cache;
            }
        }
    }

    /**
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * counterclockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */
}
