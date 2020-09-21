public class E101 {

    private boolean isSymmetric(TreeNode t1, TreeNode t2){
        if(t1== null && t2 == null) return true;
        if(t1== null || t2 == null) return false;
        return t1.val == t2.val && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
}
