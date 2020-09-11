import java.util.*;
public class M105 {
    int preInd;
    private TreeNode helper(int lo, int hi, int[] preorder, int[] inorder, HashMap<Integer, Integer> m){
        if(lo == hi) return null;

        TreeNode root = new TreeNode(preorder[preInd]);

        int inInd = m.get(preorder[preInd++]);

        root.left = helper(lo, inInd, preorder, inorder, m);
        root.right = helper(inInd+1, hi, preorder, inorder, m);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preInd = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<inorder.length; i++) m.put(inorder[i], i);
        return helper(0, preorder.length, preorder, inorder, m);
    }
}
