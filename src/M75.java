public class M75 {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0, cur = 0;
        for(int i: nums){
            if(i == 0) num0++;
            else if(i == 1) num1++;
            else num2++;
        }
        while(num0-->0) nums[cur++] = 0;
        while(num1-->0) nums[cur++] = 1;
        while(num2-->0) nums[cur++] = 2;
    }

    public void sortColors2(int[] nums) {
        int lo = 0, hi = nums.length - 1, i = 0;
        while (i <= hi) {
            if      (nums[i] == 0) swap(nums, lo++, i++);
            else if (nums[i] == 2) swap(nums, i, hi--);
            else if (nums[i] == 1) i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
