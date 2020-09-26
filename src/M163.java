import java.util.*;
public class M163 {

    private void helper(int i, int j, List<String> res){
        if(i<j-2) res.add((i+1)+"->"+(j-1));
        else if(i==j-2) res.add(String.valueOf(i+1));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if(lower == upper) return nums.length==0 ? new ArrayList<String>(){{add(String.valueOf(lower));}} : new ArrayList<>();
        if(nums.length==0) return new ArrayList<String>(){{add(lower+"->"+upper);}};
        List<String> res = new ArrayList<>();
        if(lower == nums[0]-1) res.add(String.valueOf(lower));
        else if(lower < nums[0]-1) res.add(lower+"->"+(nums[0]-1));
        for(int i=0; i<nums.length-1; i++) helper(nums[i], nums[i+1], res);
        if(nums[nums.length-1] == upper-1) res.add(String.valueOf(upper));
        else if(nums[nums.length-1] < upper-1) res.add((nums[nums.length-1]+1)+"->"+upper);
        return res;
    }
}
