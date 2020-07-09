import javafx.util.Pair;

public class M865 {

    // My solution
    class Wrap{
        TreeNode n;
        int l;

        public Wrap(TreeNode n, int l){
            this.n = n;
            this.l = l;
        }
    }

    public Wrap helper(TreeNode root){
        if(root==null) return new Wrap(null, 0);
        Wrap left = helper(root.left), right = helper(root.right);
        if(left.l == right.l) return new Wrap(root, left.l+1);
        else return left.l>right.l? new Wrap(left.n, left.l+1) : new Wrap(right.n, right.l+1);
    }

    public TreeNode subtreeWithAllDeepest2(TreeNode root) {
        return helper(root).n;
    }

    // Use pair
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
