public class M998 {

    // My solution
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val) return new TreeNode(val, root, null);
        else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
