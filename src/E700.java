public class E700 {

    // My solution
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        return root.val == val ? root : searchBST(root.val > val ? root.left : root.right, val);
    }

    // Use iteration
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null && root.val != val) root = val<root.val? root.left:root.right;
        return root;
    }
}
