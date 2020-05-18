public class M1038 {

    // My solution
    int last = 0;
    public void bstToGstHelper(TreeNode root) {
        if(root == null) return;
        bstToGstHelper(root.right);
        last = (root.val += last);
        bstToGstHelper(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        bstToGstHelper(root);
        return root;
    }

    // A more concise version
    int pre = 0;
    public TreeNode bstToGst2(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
