import java.util.Arrays;

public class M16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length-1];
        for(int i=0; i<nums.length-2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int curSum = nums[i] + nums[lo] + nums[hi];
                    if (curSum < target) {
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                    } else if (curSum > target) {
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        hi--;
                    } else return curSum;

                    if (Math.abs(target - curSum) < Math.abs(target - closestSum)) closestSum = curSum;
                }
            }
        }
        return closestSum;
    }
}
