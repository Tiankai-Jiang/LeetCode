import java.util.*;
public class M797 {

    // My solution
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> a = new LinkedList<>();
        Queue<LinkedList<Integer>> q = new LinkedList<>();
        q.offer(new LinkedList<Integer>(){{offer(0);}});
        while(!q.isEmpty()){
            LinkedList<Integer> l = q.poll();
            if(l.peekLast() == graph.length-1) a.add(l);
            else{
                for(int i : graph[l.peekLast()]){
                    LinkedList<Integer> n = new LinkedList<>();
                    for(int j : l) n.offer(j);
                    n.offer(i);
                    q.offer(n);
                }
            }

        }
        return a;
    }

    // DFS
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
