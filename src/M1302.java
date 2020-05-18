import java.util.*;

public class M1302 {

    // My solution, level oder traversal, similar to E637
    public int deepestLeavesSum(TreeNode root) {
        int a = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size(), tmp = 0;
            for(int i = 0; i < n; ++i){
                TreeNode t = q.poll();
                if(t.left != null){
                    q.offer(t.left);
                    tmp += t.left.val;
                }
                if(t.right != null){
                    q.offer(t.right);
                    tmp += t.right.val;
                }
            }
            if(tmp != 0) a = tmp;
        }
        return a;
    }

    // More concise
    public int deepestLeavesSum2(TreeNode root) {
        int res=0;
        if(root == null) return 0;
        LinkedList<TreeNode> togo = new LinkedList<TreeNode>();
        togo.add(root);
        while(!togo.isEmpty()) {
            res=0; // starting a new level
            for(int sz=togo.size()-1;sz>=0;sz--) {
                TreeNode node = togo.poll();
                res += node.val;
                if(node.right != null) togo.add(node.right);
                if(node.left  != null) togo.add(node.left);
            }
        }
        return res;
    }
}
