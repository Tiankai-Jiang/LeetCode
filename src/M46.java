import java.util.*;
public class M46 {

    // My solution
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 1){
            res.add(new LinkedList<Integer>(){{add(nums[0]);}});
            return res;
        }
        for(int i : nums){
            int[] arr = new int[nums.length-1];
            int j = 0, k = 0;
            while(j < nums.length){
                if(nums[j] == i) j++;
                else arr[k++] = nums[j++];
            }
            for(List<Integer> l : permute(arr)){
                l.add(0, i);
                res.add(l);
            }
        }
        return res;
    }

    // Iterative
    public List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; ++j){
                for (List<Integer> l : ans){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }

    // Back tracking
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
