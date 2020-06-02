import java.util.*;
public class M199 {

    // My solution, as usual...
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        if(root==null) return a;
        List<List<Integer>> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{add(root);}};
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < s; ++i){
                TreeNode n = q.poll();
                tmp.add(n.val);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            l.add(tmp);
        }
        for(List<Integer> li:l) a.add(li.get(li.size()-1));
        return a;
    }

    // My solution2, as usual...
    private void dfs(TreeNode root, int level, List<Integer> l) {
        if(root==null) return;
        if(l.size()<=level) l.add(root.val);
        else l.set(level, root.val); // if visit right first, this line can be deleted
        dfs(root.left, level+1, l);
        dfs(root.right, level+1, l);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        dfs(root, 0, a);
        return a;
    }
}
