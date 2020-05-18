import java.util.*;
public class M102 {

    // My solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> a = new ArrayList<>();
        if(root == null) return a;
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{offer(root);}};
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < s; ++i){
                TreeNode n = q.poll();
                tmp.add(n.val);
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            a.add(tmp);
        }
        return a;
    }
}
