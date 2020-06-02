import java.util.*

public class M1123 {

    // My solution
    private TreeNode sameParent(Map<TreeNode, TreeNode> parent, List<TreeNode> l){
        if(l.size()==1) return l.get(0);
        boolean same = true;
        for(int i=0; i < l.size()-1; ++i) if(!l.get(i).equals(l.get(i+1))) same = false;
        if(same) return l.get(0);
        else {
            for(int i=0; i < l.size(); ++i) l.set(i, parent.get(l.get(i)));
            return sameParent(parent, l);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        List<List<TreeNode>> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{add(root);}};
        while(!q.isEmpty()){
            int s = q.size();
            List<TreeNode> tmp = new ArrayList<>();
            for(int i = 0; i < s; ++i){
                TreeNode n = q.poll();
                tmp.add(n);
                if(n.left!=null) {
                    q.add(n.left);
                    parent.put(n.left, n);
                }
                if(n.right!=null) {
                    q.add(n.right);
                    parent.put(n.right, n);
                }
            }
            l.add(tmp);
        }
        return sameParent(parent, l.get(l.size()-1));
    }

    //
    class Pair {
        TreeNode node;
        int d;
        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }
    private Pair getLca(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);
        Pair l = getLca(root.left, d + 1);
        Pair r = getLca(root.right, d + 1);
        if (l.d == r.d) return new Pair(root, l.d);
        else return  l.d > r.d ? l : r;
    }

    //helper function return the deepest depth of descendants.
    //deepest represent the deepest depth.
    //We use a global variable lca to represent the result.
    //One pass, Time O(N) Space O(H)
    int deepest = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeaves3(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) return depth;
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == deepest && right == deepest) lca = node;
        return Math.max(left, right);
    }
}
