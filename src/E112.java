public class E112 {

    private boolean hasPathSum(TreeNode root, int sum, int cur){
        if(root.left == null && root.right==null) return (cur+ root.val) == sum;
        boolean l = false, r = false;
        if(root.left != null) l = hasPathSum(root.left, sum, cur+ root.val);
        if(root.right != null) r = hasPathSum(root.right, sum, cur+ root.val);
        return l || r;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
