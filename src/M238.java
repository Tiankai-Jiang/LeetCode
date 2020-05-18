public class M238 {
    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = 1;
        for(int i = 1; i < a.length; ++i) a[i] = nums[i-1]*a[i-1];
        int b = 1;
        for(int i = a.length-1; i >=0; --i) {
            a[i] *= b;
            b *= nums[i];
        }
        return a;
    }
}
