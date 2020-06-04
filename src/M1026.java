public class M1026 {

    // My solution, bottom-up
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private int[] helper(TreeNode root){
        if(root==null) return null;
        int[] l = helper(root.left), r = helper(root.right);
        if(l==null && r ==null) return new int[]{root.val, root.val};
        else if(l==null) {
            min = Math.min(min, root.val-r[1]);
            max = Math.max(max, root.val-r[0]);
            return new int[]{Math.min(r[0], root.val), Math.max(r[1], root.val)};
        } else if(r==null) {
            min = Math.min(min, root.val-l[1]);
            max = Math.max(max, root.val-l[0]);
            return new int[]{Math.min(l[0], root.val), Math.max(l[1], root.val)};
        } else{
            min = Math.min(Math.min(root.val-l[1], root.val-r[1]), min);
            max = Math.max(Math.max(root.val-l[0], root.val-r[0]), max);
            return new int[]{Math.min(Math.min(l[0], r[0]), root.val), Math.max(Math.max(l[1], r[1]), root.val)};
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return Math.max(Math.abs(min), Math.abs(max));
    }

    // Top-down
    // We pass the minimum and maximum values to the children,
    // At the leaf node, we return max - min through the path from the root to the leaf.
    public int maxAncestorDiff2(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}
