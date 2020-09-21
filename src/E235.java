public class E235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q == null) return null;
        if(root == p || root == q || (root.val < p.val) != (root.val < q.val)) return root;
        return lowestCommonAncestor(root.val < p.val ? root.right : root.left, p, q);
    }
}
