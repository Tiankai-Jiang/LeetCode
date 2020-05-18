import java.util.*;
public class M429 {

    // My solution
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> a = new LinkedList<>();
        if(root==null) return a;
        Queue<Node> q = new LinkedList<Node>(){{offer(root);}};
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < s; ++i){
                Node n = q.poll();
                tmp.add(n.val);
                for(Node c: n.children) q.offer(c);
            }
            a.add(tmp);
        }
        return a;
    }

    // DFS
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(Node root, int depth, List<List<Integer>> result){
        if(root != null){
            if(result.size() < depth + 1) result.add(depth, new ArrayList<>());
            result.get(depth).add(root.val);
            depth++;
            for(Node child: root.children) dfs(child, depth, result);
        }
    }

}
