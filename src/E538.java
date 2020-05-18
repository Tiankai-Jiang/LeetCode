public class E538 {

    // My solution, the same as M1038
    int last = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        if(root.right != null) convertBST(root.right);
        last = (root.val += last);
        if(root.left != null) convertBST(root.left);
        return root;
    }
}
