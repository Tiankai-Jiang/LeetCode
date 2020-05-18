public class M979 {

    // My solution
    private int res = 0;
    private int postorder(TreeNode root){
        if(root == null) return 0;
        int l = postorder(root.left), r = postorder(root.right);
        res += (Math.abs(l)+Math.abs(r));
        return root.val - 1 + l + r;
    }

    public int distributeCoins(TreeNode root) {
        postorder(root);
        return res;
    }

    // Without global variable
    public int distributeCoins2(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += distributeCoins(root.left);
            root.val += root.left.val - 1;
            res += Math.abs(root.left.val - 1);
        }
        if (root.right != null) {
            res += distributeCoins(root.right);
            root.val += root.right.val - 1;
            res += Math.abs(root.right.val - 1);
        }
        return res;
    }
}
