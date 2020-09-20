import java.util.*;
public class M113 {

    private void dfs(TreeNode root, int curSum, int sum, List<Integer> curNodes, List<List<Integer>> res){
        if(root == null) return;
        if(root.left == null && root.right==null){
            if(curSum + root.val == sum) res.add(new ArrayList<Integer>(curNodes){{add(root.val);}});
        }else{
            curNodes.add(root.val);
            dfs(root.left, curSum+root.val, sum, curNodes, res);
            dfs(root.right, curSum+root.val, sum, curNodes, res);
            curNodes.remove(curNodes.size()-1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, sum, new ArrayList<>(), res);
        return res;
    }
}
