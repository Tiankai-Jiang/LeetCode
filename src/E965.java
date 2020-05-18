public class E965 {

    // My solution
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        boolean l = true, r = true;
        if(root.left != null) l = root.val == root.left.val;
        if(root.right != null) r = root.val == root.right.val;
        return isUnivalTree(root.left) && isUnivalTree(root.right) && l && r;
    }

    // Check all nodes have the same value as root.
    int val = -1;
    public boolean isUnivalTree2(TreeNode root) {
        if (root == null) return true;
        if (val < 0) val = root.val;
        return root.val == val && isUnivalTree(root.left)  && isUnivalTree(root.right);
    }

    // Same idea as mine but shorter
    public boolean isUnivalTree3(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) && (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }
}
