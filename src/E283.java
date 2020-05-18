public class E283 {

    // My solution, based on swap
    public void moveZeroes(int[] nums) {
        for(int j = 1, i = 0; j < nums.length; ++j){
            if(nums[i]==0&&nums[j]!=0) nums[i] = (nums[i]+nums[j]) - (nums[j]= nums[i]);
            else if(nums[i]==0&&nums[j]==0) i--;
            i++;
        }
    }

    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    public void moveZeroes2(int[] nums) {
        int insertPos = 0;
        for (int num: nums) if (num != 0) nums[insertPos++] = num;
        while (insertPos < nums.length) nums[insertPos++] = 0;
    }
}
