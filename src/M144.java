import java.util.*;

public class M144 {

    // My solution 1, recursive
    private void preorderTraversal(TreeNode root, List l){
        if(root == null) return;
        l.add(root.val);
        preorderTraversal(root.left, l);
        preorderTraversal(root.right, l);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> a = new LinkedList<>();
        preorderTraversal(root, a);
        return a;
    }

    // My solution 2, iterative
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> a = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return a;
        s.push(root);
        while(!s.empty()){
            TreeNode n = s.pop();
            a.add(n.val);
            if(n.right != null) s.push(n.right);
            if(n.left != null) s.push(n.left);
        }
        return a;
    }

    // Another Iterative solution, only right children are stored to stack
    public List<Integer> preorderTraversal3(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) rights.push(node.right);
            node = node.left;
            if (node == null && !rights.isEmpty()) node = rights.pop();
        }
        return list;
    }
}
