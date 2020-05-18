public class E1295 {

    // My solution
    public int findNumbers(int[] nums) {
        int a = 0;
        for(int i=0; i<nums.length; ++i) if(Integer.toString(nums[i]).length() % 2 == 0) ++a;
        return a;
    }

    // Pay attention to the constraints!
    public int findNumbers2(int[] nums) {
        int a=0;
        for(int i=0 ; i<nums.length; ++i) if((nums[i]>9 && nums[i]<100) || (nums[i]>999 && nums[i]<10000) || (nums[i] == 100000)) ++a;
        return a;
    }
}
