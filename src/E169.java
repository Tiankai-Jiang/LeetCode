import java.util.*;

public class E169 {

    // My solution O(nlogn)?
    public int majorityElement(int l, int r, int[] nums){
        if(l==r) return nums[l];
        int mid = l + (r-l)/2;
        int left = majorityElement(l, mid, nums);
        int right = majorityElement(mid+1, r, nums);
        if(left == right) return left;
        else{
            int count = 0;
            for(int i = l; i <= r; ++i) if(nums[i]==left) count++;
            return count > (r-l+1)/2 ? left : right;
        }
    }

    public int majorityElement(int[] nums) {
        return majorityElement(0, nums.length-1, nums);
    }

    // Sorting
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Hashtable, slow
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int ret=0;
        for (int num: nums) {
            m.merge(num, 1, Integer::sum);
            if (m.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // Moore voting algorithm, fast
    public int majorityElement3(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0) ret = num;
            count += num!=ret ? -1: 1;
        }
        return ret;
    }

    // Bit manipulation, slow
    public int majorityElement4(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums) for (int i=0; i<32; i++) if ((num>>(31-i) & 1) == 1) bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }
}
