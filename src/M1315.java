public class M1315 {

    // My solution
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        if(root.val%2==0){
            int sum = 0;
            if(root.left != null){
                sum += root.left.left != null ? root.left.left.val: 0;
                sum += root.left.right != null ? root.left.right.val : 0;
            }
            if(root.right != null){
                sum += root.right.left != null ? root.right.left.val: 0;
                sum += root.right.right != null ? root.right.right.val : 0;
            }
            return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        }else return sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }

    // Record a node's parent and grandparent
    public int sumEvenGrandparent2(TreeNode root) {
        return helper(root, 1, 1);
    }

    public int helper(TreeNode node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }
}
