import java.util.*;
public class E1313 {

    // My first solution, slow
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < nums.length; i+=2) {
            for (int j = 0; j < nums[i]; ++j)
                a.add(nums[i + 1]);
        }
        return a.stream().mapToInt(Integer::valueOf).toArray();
    }

    // My second solution, much faster
    public int[] decompressRLElist2(int[] nums) {
        int l = 0, cur = 0;
        for(int i = 0; i < nums.length; i += 2) l += nums[i];
        int[] a = new int[l];
        for(int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; ++j){
                a[cur + j] = nums[i+1];
            }
            cur += nums[i];
        }
        return a;
    }

    // Arrays.fill is slightly faster than for loop
    public int[] decompressRLElist3(int[] nums) {
        int arrSize = 0, startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }
        int[] result = new int[arrSize];
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
    }
}
