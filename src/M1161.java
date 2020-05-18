import java.util.*;
import java.util.stream.IntStream;

public class M1161 {

    // My solution
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE, maxLevel = 0, curLevel = 1, size = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{offer(root);}};
        while(!q.isEmpty()){
            int sum = 0;
            size = q.size();
            for(int i = 0; i < size; ++i){
                TreeNode n = q.poll();
                sum += n.val;
                if(n.left!= null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            if(sum > max){
                max = sum;
                maxLevel = curLevel;
            }
            curLevel++;
        }
        return maxLevel;
    }

    // DFS
    public int maxLevelSum2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return 1 + IntStream.range(0, list.size()).reduce(0, (a, b) -> list.get(a) < list.get(b) ? b : a);
    }
    private void dfs(TreeNode n, List<Integer> l, int level) {
        if (n == null) return;
        if (l.size() == level)  l.add(n.val);  // never reach this level before, add first value.
        else l.set(level, l.get(level) + n.val); // reached the level before, accumulate current value to old value.
        dfs(n.left, l, level + 1);
        dfs(n.right, l, level + 1);
    }
}
