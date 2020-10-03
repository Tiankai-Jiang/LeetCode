import java.util.*;
public class M545 {

    private void helper(TreeNode root, List<Integer> res, boolean isLeftBound, boolean isRightBound){
        if(root == null) return;
        if(isLeftBound) res.add(root.val);
        if(!isLeftBound && !isRightBound && root.left == null && root.right == null) res.add(root.val);
        helper(root.left, res, isLeftBound, isRightBound && root.right == null);
        helper(root.right, res, isLeftBound && root.left == null, isRightBound);
        if(isRightBound) res.add(root.val);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        helper(root.left, res, true, false);
        helper(root.right, res, false, true);
        return res;
    }
}
