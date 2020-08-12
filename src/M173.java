import java.util.*;
public class M173 {

    // this is cheating
//    PriorityQueue<Integer> pq;
//    public M173(TreeNode root) {
//        pq = new PriorityQueue<>();
//        add(root);
//    }
//
//    private void add(TreeNode root){
//        if(root == null) return;
//        pq.offer(root.val);
//        add(root.left);
//        add(root.right);
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return pq.poll();
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return pq.size() > 0;
//    }
    Stack<TreeNode> s;
    public M173(TreeNode root) {
        s = new Stack<>();
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode t = s.pop(), t2 = t.right;
        while(t2 != null){
            s.push(t2);
            t2 = t2.left;
        }
        return t.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
