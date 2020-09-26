import java.util.*;
public class M103 {

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) return;
        if(level == res.size()) res.add(new LinkedList<>());
        List<Integer> cur = res.get(level);
        cur.add((level&1)==1 ? 0:cur.size(), root.val);
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
}
