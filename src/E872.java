import java.util.*;
public class E872 {

    // My solution
    private boolean dfs(TreeNode root, List<Integer> l){
        if(root==null) return true;
        if(dfs(root.left, l) && dfs(root.right, l)) l.add(root.val);
        return false;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        dfs(root1, a);
        dfs(root2, b);
        return a.equals(b);
    }
}
