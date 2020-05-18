import java.util.*;
public class E226 {

    // My solution
    public void invert(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    // In one function
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode tempRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
        return root;
    }

    // BFS
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
