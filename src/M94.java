import java.util.*;
public class M94 {

    // My solution
    private void inorderTraversal(TreeNode root, List<Integer> l){
        if(root == null) return;
        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> a = new LinkedList<>();
        inorderTraversal(root, a);
        return a;
    }

    // Iterative
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
