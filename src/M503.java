import java.util.*;
public class M503 {

    // In the second loop, no not push, just pop
    public int[] nextGreaterElements(int[] nums) {
        int[] a = new int[nums.length];
        Arrays.fill(a, -1);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < nums.length*2; ++i){
            int num = nums[i % nums.length];
            while(!s.empty() && nums[s.peek()]<num) a[s.pop()] = num;
            if(i<nums.length) s.push(i);
        }
        return a;
    }
}
