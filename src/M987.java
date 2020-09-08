import java.util.*;
public class M987 {

    int min=0, max=0;
    Map<Integer, PriorityQueue<int[]>> m;
    private void dfs(TreeNode root, int vlevel, int layer){
        if(root == null) return;
        m.putIfAbsent(vlevel, new PriorityQueue<>(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0])));
        m.get(vlevel).add(new int[]{layer, root.val});
        min = Math.min(min, vlevel);
        max = Math.max(max, vlevel);
        dfs(root.left, vlevel - 1, layer + 1);
        dfs(root.right, vlevel+1, layer + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        m = new HashMap<>();
        dfs(root, 0, 0);
        for(int i=min; i<=max; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            PriorityQueue<int[]> pq = m.get(i);
            while(!pq.isEmpty()) tmp.add(pq.remove()[1]);
            res.add(tmp);
        }
        return res;
    }
}
