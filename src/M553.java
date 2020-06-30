public class M553 {

    // My solution
    public String optimalDivision(int[] nums) {
        if(nums.length==1) return Integer.toString(nums[0]);
        else if(nums.length==2) return Integer.toString(nums[0]).concat("/").concat(Integer.toString(nums[1]));
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]).append("/(");
            for(int i=1;i<nums.length-1;++i) sb.append(nums[i]).append('/');
            return sb.append(nums[nums.length-1]).append(')').toString();
        }
    }

    // Back tracking
    // So fucking complicated
    // https://leetcode.com/problems/optimal-division/discuss/101697/Java-Solution-Backtracking
}
