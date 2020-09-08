import java.util.*;
public class M863 {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{offer(target);}};
        Set<TreeNode> seen = new HashSet<>();
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == K) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode n: queue) ans.add(n.val);
                return ans;
            }
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                seen.add(node);
                if (node.left != null && !seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (par != null && !seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
            dist++;
        }
        return new ArrayList<>();
    }
    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
