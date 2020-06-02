import java.util.*;
public class M1110 {

    // My solution
    private boolean delNodes(TreeNode root, Set<Integer> s, List<TreeNode> a){
        if(root.left!=null && delNodes(root.left, s, a)) root.left = null;
        if(root.right!=null && delNodes(root.right, s, a)) root.right = null;
        if(s.contains(root.val)){
            if(root.left!= null) a.add(root.left);
            if(root.right!=null) a.add(root.right);
            return true;
        }else return false;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> s = new HashSet<>();
        for(int i:to_delete) s.add(i);
        List<TreeNode> a = new ArrayList<>();
        if(!s.contains(root.val)) a.add(root);
        delNodes(root, s, a);
        return a;
    }

    // Another similar solution
    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null) return null;
        node.left = dfs(node.left, set, res);
        node.right = dfs(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }
}
