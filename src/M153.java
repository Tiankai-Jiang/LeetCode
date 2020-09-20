public class M153 {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]>nums[lo]) lo = mid;
            else hi = mid;
        }
        return nums[(lo+1)%nums.length];
    }

    public int findMin2(int[] nums) {
        int l = 0, h = nums.length-1;
        while(l<h){
            int mid = (l+h) / 2;
            if(nums[mid]>nums[h]) l = mid+1;
            else h = mid;
        }
        return nums[l];
    }
}
