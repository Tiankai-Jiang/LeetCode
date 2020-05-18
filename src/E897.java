public class E897 {

    // My solution
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        root.left = increasingBST(root.left);
        root.right = increasingBST(root.right);
        if(root.left == null) return root;
        TreeNode tmp = root.left, tmp2 = root.left;
        root.left = null;
        while(tmp2.right != null) tmp2 = tmp2.right;
        tmp2.right = root;
        return tmp;
    }

    /**
     Recursively call function increasingBST(TreeNode root, TreeNode tail)
     tail is its next node in inorder,

     If root == null, the head will be tail, so we return tail directly.

     we recursively call increasingBST(root.left, root),
     change left subtree into the linked list + current node.

     we recursively call increasingBST(root.right, tail),
     change right subtree into the linked list + tail.

     Now the result will be in a format of linked list, with right child is next node.
     Since it's single linked list, so we set root.left = null.
     Otherwise it will be TLE for Leetcode judgment to traverse over your tree.

     The result now is increasingBST(root.left) + root + increasingBST(root.right).
     * */
    public TreeNode increasingBST2(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
