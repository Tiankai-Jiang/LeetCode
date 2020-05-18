import java.util.*;
public class M894 {

    // My solution
    public List<TreeNode> allPossibleFBT(int N) {
        if(N%2==0) return new LinkedList<TreeNode>();
        if(N==1) return new LinkedList<TreeNode>(){{add(new TreeNode(0));}};
        List<TreeNode> a = new LinkedList<>();
        for(int i = 1; i < N-1; i+=2){
            for(TreeNode t : allPossibleFBT(i)) {
                for(TreeNode u : allPossibleFBT(N-1-i)) {
                    TreeNode n = new TreeNode(0);
                    n.left = t;
                    n.right = u;
                    a.add(n);
                }
            }
        }
        return a;
    }

    // DP
    public List<TreeNode> allPossibleFBT2(int N) {
        if (N <= 0)  return new ArrayList<>();
        List<TreeNode>[] dp = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) dp[i] = new ArrayList<>();
        dp[1].add(new TreeNode(0));
        for (int numNode = 1; numNode <= N; numNode += 2) {
            for (int leftNode = 1; leftNode < numNode; leftNode += 2) {
                for (TreeNode left : dp[leftNode]) {
                    for (TreeNode right : dp[numNode - 1 - leftNode]) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        dp[numNode].add(root);
                    }
                }
            }
        }
        return dp[N];
    }
}
