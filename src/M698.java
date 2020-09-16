import java.util.Arrays;

public class M698 {

    private boolean backtracking(int[] nums, int curSum, int start, int goal, int round, boolean[] visited){
        if(round == 0) return true;
        if(curSum == goal && backtracking(nums, 0, nums.length-1, goal, round-1, visited)) return true;
        for(int i=start; i>=0; i--){
            if(!visited[i] && curSum+nums[i]<=goal){
                visited[i] = true;
                if(backtracking(nums, curSum+nums[i], i-1, goal, round, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int i: nums) total += i;
        if(total%k != 0) return false;
        Arrays.sort(nums);
        return backtracking(nums, 0, nums.length-1, total/k, k, new boolean[nums.length]);
    }
}
