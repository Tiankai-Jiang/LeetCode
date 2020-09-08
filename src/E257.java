import java.util.*;
public class E257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        dfs(root, res, sb);
        return res;
    }

    private void dfs(TreeNode root, List<String> res, StringBuilder sb){
        if(root.left == null && root.right == null) {
            res.add(sb.append(root.val).toString());
            return;
        }else{
            sb.append(root.val).append("->");
            if(root.left != null) dfs(root.left, res, new StringBuilder(sb));
            if(root.right != null) dfs(root.right, res, new StringBuilder(sb));
        }
    }
}
