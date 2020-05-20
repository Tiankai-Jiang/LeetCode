import java.util.*;
public class M951 {

    // My solution DFS
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return (root1 == null || root2 == null) ? root1 == root2 : root1.val==root2.val && ((flipEquiv(root1.left, root2.left)&&flipEquiv(root1.right, root2.right))||(flipEquiv(root1.left, root2.right)&&flipEquiv(root1.right, root2.left)));
    }

    // BFS
    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>(){{offer(root1);}}, q2 = new LinkedList<TreeNode>(){{offer(root2);}};
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll(), n2 = q2.poll();
            if (n1 == null || n2 == null) {
                if (n1 != n2) return false;
                else continue;
            }
            if (n1.val != n2.val) return false;
            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val) q1.addAll(Arrays.asList(n1.left, n1.right));
            else q1.addAll(Arrays.asList(n1.right, n1.left));
            q2.addAll(Arrays.asList(n2.left, n2.right));
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
