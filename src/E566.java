public class E566 {

    // My solution
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[0].length!=r*c) return nums;
        int[][] a = new int[r][c];
        for(int i=0, oc = nums[0].length;i<r*c;++i) a[i/c][i%c] = nums[i/oc][i%oc];
        return a;
    }
}
