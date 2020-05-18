import java.util.Random;

public class M215 {

    // My solution 1, use last as pivot 19ms, use random as pivot 1ms
    Random rn = new Random();
    public int partition(int[] nums, int l, int h) {
        int p = nums[h], i = l - 1, j = l - 1;
        while (j++ < h) if (nums[j] > p) nums[++i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
        nums[++i] = (nums[i] + nums[h]) - (nums[h] = nums[i]);
        return i;
    }

    public int findKthLargest(int[] nums, int k, int l, int h){
        int r = l + rn.nextInt(h - l + 1);
        nums[r] = (nums[r]+nums[h]) - (nums[h]=nums[r]);
        int p = partition(nums, l, h);
        return p-l==k-1 ? nums[p] : (p-l>k-1 ? findKthLargest(nums, k, l, p-1) : findKthLargest(nums, k-p+l-1, p+1, h));
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length-1);
    }
}
