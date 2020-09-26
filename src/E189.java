public class E189 {

    private void reverse(int[] nums, int start, int end){
        while(start < end) nums[start] += nums[end] - (nums[end--] = nums[start++]);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(nums.length < 2) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
