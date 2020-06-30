public class M1448 {

    // My solution
    private int goodNotes(TreeNode root, TreeNode parent){
        if(root==null) return 0;
        return root.val >= parent.val ? 1 + goodNotes(root.left, root) + goodNotes(root.right, root) : goodNotes(root.left, parent) + goodNotes(root.right, parent);
    }

    public int goodNodes(TreeNode root) {
        return goodNotes(root, root);
    }
}