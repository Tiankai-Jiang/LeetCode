public class M74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length, lo = 0, hi = m * n -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(matrix[mid/n][mid%n] == target) return true;
            else if(matrix[mid/n][mid%n] > target) hi = mid-1;
            else lo = mid+1;
        }
        return false;
    }
}
