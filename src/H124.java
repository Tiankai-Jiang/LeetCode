public class H124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(helper(root.left), 0), right = Math.max(helper(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
