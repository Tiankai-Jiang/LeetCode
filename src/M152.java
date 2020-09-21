public class M152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0], curMax = nums[0], curMin = nums[0];

        for(int i=1; i<nums.length; i++){
            int tempMax = Math.max(nums[i], Math.max(curMax*nums[i], curMin*nums[i]));
            curMin = Math.min(nums[i], Math.min(curMax*nums[i], curMin*nums[i]));
            curMax = tempMax;
            res = Math.max(res, curMax);
        }
        return res;
    }
}
