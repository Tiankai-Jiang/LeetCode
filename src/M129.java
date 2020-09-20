public class M129 {

    int res = 0;
    private void sumNumbers(TreeNode root, int sum) {
        if(root.left == null && root.right == null) res += (10*sum + root.val);
        if(root.left != null) sumNumbers(root.left, 10*sum+root.val);
        if(root.right != null) sumNumbers(root.right, 10*sum+root.val);
    }

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sumNumbers(root, 0);
        return res;
    }

    public int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
