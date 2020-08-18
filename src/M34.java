public class M34 {

    private void bs(int[] num, int lo, int hi, int[]res, int target){
        if(lo >= hi) return;
        int mid = lo + (hi-lo)/2;
        if(num[mid] == target){
            if(mid < res[0]){
                res[0] = mid;
                bs(num, lo, mid-1, res, target);
            }
            if(mid > res[1]){
                res[1] = mid;
                bs(num, mid+1, hi, res, target);
            }
        }else if(num[mid] > target) bs(num, lo, mid-1, res, target);
        else bs(num, mid+1, hi, res, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        bs(nums, 0, nums.length-1, res, target);
        return res[0] == Integer.MAX_VALUE ? new int[]{-1, -1} : res;
    }
}
