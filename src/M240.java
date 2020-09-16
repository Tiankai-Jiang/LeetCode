public class M240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] < target) col ++;
            else if(matrix[row][col] > target) row--;
            else return true;
        }
        return false;
    }

    private boolean searchMatrix(int[][] matrix, int[] uL, int[] lR, int target) {
        if(uL[0]>lR[0] || uL[1]>lR[1] || lR[0]>=matrix.length || lR[1]>=matrix[0].length) return false;
        if(lR[0]-uL[0]==0 && lR[1]-uL[1]==0) return matrix[uL[0]][uL[1]] == target;
        int rowMid = (uL[0] + lR[0]) >> 1;
        int colMid = (uL[1] + lR[1]) >> 1;
        if(matrix[rowMid][colMid] > target) {
            return searchMatrix(matrix, uL, new int[]{rowMid, colMid}, target)
                    || searchMatrix(matrix, new int[]{uL[0],colMid+1}, new int[]{rowMid, lR[1]}, target)
                    || searchMatrix(matrix, new int[]{rowMid+1,uL[1]}, new int[]{lR[0], colMid}, target);
        }
        else if(matrix[rowMid][colMid] < target) {
            return searchMatrix(matrix, new int[]{uL[0], colMid+1}, new int[]{rowMid, lR[1]}, target)
                    || searchMatrix(matrix, new int[]{rowMid+1, uL[1]}, new int[]{lR[0], colMid}, target)
                    || searchMatrix(matrix, new int[]{rowMid+1, colMid+1}, lR, target);
        }
        else return true;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        return searchMatrix(matrix, new int[]{0,0}, new int[]{matrix.length-1, matrix[0].length-1}, target);
    }
}
