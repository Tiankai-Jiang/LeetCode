public class E1351 {

    // My solution, which does not use the fact that the 2D array is vertically sorted, O(mlog(n))
    public int binarySearch(int[] arr){
        int ind = arr.length, l = 0, r = arr.length - 1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(arr[m] < 0) r = (ind = m) - 1;
            else l = m + 1;
        }
        return arr.length - ind;
    }

    public int countNegatives(int[][] grid) {
        int a = 0;
        for(int[] i : grid) a += binarySearch(i);
        return a;
    }

    // This solution uses the fact that the negative regions of the matrix will form a "staircase" shape, O(m+n)
    public int countNegatives2(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c; // there are n - c negative numbers in current row.
            }else ++c;
        }
        return cnt;
    }
}
