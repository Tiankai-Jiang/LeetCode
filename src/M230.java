import java.util.*;

public class M230 {

    // My solution
    private void traverse(TreeNode root, List l){
        if(root == null) return;
        traverse(root.left, l);
        l.add(root.val);
        traverse(root.right, l);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new LinkedList<>();
        traverse(root, l);
        return l.get(k-1);
    }

    // DFS in-order recursive
    private static int number = 0, count = 0;
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    private void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        if (--count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

    // DFS in-order iterative
    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1; // never hit if k is valid
    }

    // Binary search
    public int kthSmallest4(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) return kthSmallest(root.left, k);
        else if (k > count + 1) return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        return root.val;
    }

    private int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
