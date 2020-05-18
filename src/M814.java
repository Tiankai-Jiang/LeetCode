public class M814 {

    // My solution
    public boolean pruneTreeHelper(TreeNode root){
        if(root == null) return false;
        boolean l = pruneTreeHelper(root.left), r = pruneTreeHelper(root.right);
        if(!l) root.left = null;
        if(!r) root.right = null;
        return root.val == 1 || l || r;
    }

    public TreeNode pruneTree(TreeNode root) {
        pruneTreeHelper(root);
        return root;
    }

    // In one function
    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
