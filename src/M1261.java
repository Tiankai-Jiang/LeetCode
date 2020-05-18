public class M1261 {

    // My solution
    TreeNode root;
    boolean[] b = new boolean[1048575];

    private void recover(TreeNode root, int val){
        root.val = val;
        if(root.left != null) recover(root.left, 2*val+1);
        if(root.right != null) recover(root.right, 2*val+2);
    }

    private void traverse(TreeNode root){
        b[root.val] = true;
        if(root.left != null) traverse(root.left);
        if(root.right != null) traverse(root.right);
    }

    public M1261(TreeNode root) {
        recover(root, 0);
        this.root = root;
        traverse(root);
    }

    public boolean find(int target) {
        return b[target];
    }
}
