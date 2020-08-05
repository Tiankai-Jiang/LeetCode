public class E543 {
    int max = Integer.MIN_VALUE;

    private int helper(TreeNode root){
        if(root == null) return 0;
        int l = helper(root.left), r = helper(root.right);
        max = Math.max(max, 1 + l + r);
        return 1 + Math.max(l, r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max - 1;
    }
}
