import java.util.*;
public class M508 {

    // My solution
    private int subtreeSum(TreeNode root, Map<Integer, Integer> m){
        if(root==null) return 0;
        int l = subtreeSum(root.left, m), r = subtreeSum(root.right, m), v = root.val+l+r;
        m.merge(v, 1, Integer::sum);
        return v;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[0];
        Map<Integer, Integer> m = new HashMap<>();
        subtreeSum(root, m);
        int c=0, d=0;
        int[][] b = new int[m.size()][2];
        for(Map.Entry<Integer, Integer> e: m.entrySet()) {
            b[c][0] = e.getKey();
            b[c++][1] = e.getValue();
        }
        Arrays.sort(b, Comparator.comparingInt(o->o[1]));
        List<Integer> l = new ArrayList<Integer>(){{add(b[b.length-1][0]);}};
        for(int i = b.length-2; i>=0; --i){
            if(b[i][1]==b[i+1][1]) l.add(b[i][0]);
            else break;
        }
        int[] a = new int[l.size()];
        for(int i: l) a[d++]=i;
        return a;
    }

    // Same idea shorter code, record max count so we don't have to sort later
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    int maxCount = 0;

    public int[] findFrequentTreeSum2(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int s : count.keySet()) if (count.get(s) == maxCount) res.add(s);
        return res.stream().mapToInt(i->i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int s = dfs(root.left) + dfs(root.right) + root.val;
        count.put(s, count.getOrDefault(s, 0) + 1);
        maxCount = Math.max(maxCount, count.get(s));
        return s;
    }
}
