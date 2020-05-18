import java.util.*;

public class M1382 {

    // My first solution, super slow
    private void traverse(TreeNode root, List<Integer> l){
        if(root == null) return;
        traverse(root.left, l);
        l.add(root.val);
        traverse(root.right, l);
    }

    private TreeNode buildTree(List<Integer> l, int lo, int hi){
        if(lo > hi) return null;
        int ind = lo + (hi-lo)/2;
        TreeNode n = new TreeNode(l.get(ind));
        n.left = buildTree(l, lo, ind-1);
        n.right = buildTree(l, ind+1, hi);
        return n;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        traverse(root, l);
        return buildTree(l, 0, l.size()-1);
    }

    // My second solution, bug
    private int depth(TreeNode root){
        return root == null ? 0 : 1+ Math.max(depth(root.left), depth(root.right));
    }

    public TreeNode balanceBST2(TreeNode root) {
        if(root == null) return null;
        int dl = depth(root.left), dr = depth(root.right);
        while(dl-dr > 1){
            TreeNode tmp = root, tmp2 = root.left;
            root = root.left;
            while(tmp2.right != null) tmp2 = tmp2.right;
            tmp2.right = tmp;
            dl = depth(root.left);
            dr = depth(root.right);
        }
        while(dr-dl>1){
            TreeNode tmp = root, tmp2 = root.right;
            root = root.right;
            while (tmp2.left != null) tmp2 = tmp2.left;
            tmp2.left = tmp;
            dl = depth(root.left);
            dr = depth(root.right);
        }
        root.left = balanceBST(root.left);
        root.right = balanceBST(root.right);
        return root;
    }

    // Day–Stout–Warren algorithm!
    // https://csactor.blogspot.com/2018/08/dsw-day-stout-warren-algorithm-dsw.html
    /**
     1. Convert the initial tree into a vine. By doing right rotations, we flatten a tree into a 'linked list', where the head is the former leftmost node, and tail - former rightmost node.
     2. As you convert the tree into a vine, count the total number of nodes in cnt.
     3. Calculate the height of the closest perfectly balanced tree: h = log2(cnt + 1).
     4. Calculate the number of nodes in the closest perfectly balanced tree: m = pow(2, h) - 1.
     5. Left-rotate cnt - m nodes to cover up the excess of nodes.
     * */
    public TreeNode balanceBST3(TreeNode root) {
        TreeNode pseudoRoot = new TreeNode(0);
        pseudoRoot.right = root;

        int nodeCount = flattenTreeWithRightRotations(pseudoRoot);
        int heightOfTree = (int)(Math.log(nodeCount + 1) / Math.log(2));
        int numOfNodesInTree = (int) Math.pow(2, heightOfTree) - 1;

        createBalancedTreeWithLeftRotation(pseudoRoot, nodeCount - numOfNodesInTree);
        for (int numOfNodesInSubTree = (numOfNodesInTree/2); numOfNodesInSubTree > 0; numOfNodesInSubTree /= 2)
            createBalancedTreeWithLeftRotation(pseudoRoot, numOfNodesInSubTree);
        return pseudoRoot.right;
    }


    public int flattenTreeWithRightRotations(TreeNode root) {
        int nodeCount = 0;
        TreeNode pseudoRoot = root.right;
        while (pseudoRoot != null) {
            if (pseudoRoot.left != null) {
                TreeNode oldPseudoRoot = pseudoRoot;
                pseudoRoot = pseudoRoot.left;
                oldPseudoRoot.left = pseudoRoot.right;
                pseudoRoot.right = oldPseudoRoot;
                root.right = pseudoRoot;
            } else {
                ++nodeCount;
                root = pseudoRoot;
                pseudoRoot = pseudoRoot.right;
            }
        }
        return nodeCount;
    }

    void createBalancedTreeWithLeftRotation(TreeNode root, int numOfNodesInSubTree) {
        TreeNode pseudoRoot = root.right;
        while (numOfNodesInSubTree-- > 0) {
            TreeNode oldPseudoRoot = pseudoRoot;
            pseudoRoot = pseudoRoot.right;

            root.right = pseudoRoot;
            oldPseudoRoot.right = pseudoRoot.left;
            pseudoRoot.left = oldPseudoRoot;
            root = pseudoRoot;
            pseudoRoot = pseudoRoot.right;
        }
    }
}
