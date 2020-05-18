import java.util.*;
public class E496 {

    // My solution
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = nums2.length - 1; i >= 0; --i){
            if(i == nums2.length-1) m.put(nums2[i], -1);
            else{
                if(nums2[i] < nums2[i+1]) m.put(nums2[i], nums2[i+1]);
                else{
                    int max = nums2[i+1];
                    while(max != -1){
                        if(nums2[i] < (max = m.get(max))){
                            m.put(nums2[i], max);
                            break;
                        }
                    }
                    if(!m.containsKey(nums2[i])) m.put(nums2[i], -1);
                }
            }
        }
        for(int i = 0; i < nums1.length; ++i) nums1[i] = m.get(nums1[i]);
        return nums1;
    }

    // Use a stack
    /**
     Suppose we have a decreasing sequence followed by a greater number
     For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

     We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
     For example [9, 8, 7, 3, 2, 1, 6]
     The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6
     * */
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
