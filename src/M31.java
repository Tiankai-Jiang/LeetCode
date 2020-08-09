import java.util.Arrays;

public class M31 {

    private void reverse(int[] nums, int i, int j){
        while(i < j) nums[i] += nums[j] - (nums[j--] = nums[i++]);
    }

    private void reverse2(int[] nums, int i, int j){
        while(i < j) {
            nums[i] ^= nums[j];
            nums[i] ^= nums[j--] ^= nums[i++];
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        boolean found = false;
        int i, j;
        for(i = nums.length-2; i >= 0; i--){
            if(nums[i+1]>nums[i]){
                found = true;
                break;
            }
        }
//        if(!found) Arrays.sort(nums);// Here change it to reverse will be faster
        if(!found) reverse(nums, 0, nums.length-1);
        else{
            for(j = nums.length-1; j > i; --j){
                if(nums[j]> nums[i]){
                    nums[i] += nums[j] - (nums[j] = nums[i]);
                    break;
                }
            }
//            Arrays.sort(nums, j, nums.length-1); // Here change it to reverse will be faster
            reverse(nums, i+1, nums.length-1);
        }
    }
}
