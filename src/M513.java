import java.util.*;
public class M513 {

    // My solution
    private void dfs(TreeNode root, List<List<Integer>> l, int level){
        if(root == null) return;
        if(l.size() < level+1) l.add(new LinkedList<Integer>(){{add(root.val);}});
        else l.get(level).add(root.val);
        dfs(root.left, l, level+1);
        dfs(root.right, l, level+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> a = new LinkedList<>();
        dfs(root, a, 0);
        return a.get(a.size()-1).get(0);
    }

    // BFS from right to left
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    // Another DFS
    public int findBottomLeftValue3(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        return res[0];
    }
}
