public class E572 {

    private boolean isSame(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if((s==null || t==null) || s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(isSame(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
