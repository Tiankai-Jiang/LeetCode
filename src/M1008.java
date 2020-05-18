public class M1008 {

    // My solution
    public TreeNode bstFromPreorder(int[] preorder, int l, int r) {
        if(l > r) return null;
        TreeNode n = new TreeNode(preorder[l]);
        int j;
        for(j = l+1; j <= r; ++j){
            if(preorder[j] > preorder[l]){
                n.left = bstFromPreorder(preorder, l+1, j-1);
                n.right = bstFromPreorder(preorder, j, r);
                break;
            }
        }
        if(j == r+1){
            n.left = bstFromPreorder(preorder, l+1, r);
            n.right = null;
        }
        return n;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length-1);
    }

    // Use a global variable to track
    int i = 0;
    public TreeNode bstFromPreorder2(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}
