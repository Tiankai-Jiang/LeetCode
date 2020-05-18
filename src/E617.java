public class E617 {

    // My solution 1
    public void traverse(TreeNode t1, TreeNode t2){
        t1.val += t2.val;
        if(t2.left != null){
            if(t1.left == null) t1.left = t2.left;
            else traverse(t1.left, t2.left);
        }
        if(t2.right != null){
            if(t1.right == null) t1.right = t2.right;
            else traverse(t1.right, t2.right);
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null & t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        else traverse(t1, t2);
        return t1;
    }

    // There is no need to create a new recursive function
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode n = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        n.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        n.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return n;
    }
}