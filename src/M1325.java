public class M1325 {

    // My solution
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.val == target && root.left == null && root.right == null){
            root = null;
            return null;
        }else return root;
    }

    // A similar one
    public TreeNode removeLeafNodes2(TreeNode root, int target) {
        if (root.left != null) root.left = removeLeafNodes(root.left, target);
        if (root.right != null) root.right = removeLeafNodes(root.right, target);
        return root.left == root.right && root.val == target ? null : root;
    }
}
