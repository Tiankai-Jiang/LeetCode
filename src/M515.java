import java.util.*;
public class M515 {

    // My solution
    private void dfs(TreeNode root, List<Integer> l, int level){
        if(root == null) return;
        if(l.size() < level) l.add(root.val);
        else l.set(level-1, Math.max(root.val, l.get(level-1)));
        dfs(root.left, l, level+1);
        dfs(root.right, l, level+1);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> a = new LinkedList<>();
        dfs(root, a, 1);
        return a;
    }
}
