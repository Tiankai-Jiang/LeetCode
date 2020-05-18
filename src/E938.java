public class E938 {
    // My solution
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + ((root.val >= L && root.val <= R) ? root.val : 0);
    }

    // Exclude more cases
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if(root == null) return 0;
        else if(root.val < L) return rangeSumBST(root.right, L, R);
        else if(root.val > R) return rangeSumBST(root.left, L, R);
        else return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
    }
}


