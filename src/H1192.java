import java.util.*;
public class H1192 {

    /**
     * low[u] records the lowest vertex u can reach
     * discoveredTime[u] records the time when u was discovered
     * */
    int time = 0;
    private void dfs(int u, int pre, int[] low, int[] discoveredTime, List<Integer>[] g, List<List<Integer>> res) {
        discoveredTime[u] = low[u] = ++time;
        for(int v: g[u]){
            if(v == pre) continue;
            if(discoveredTime[v] == -1){
                dfs(v, u, low, discoveredTime, g, res);
                low[u] = Math.min(low[u], low[v]);
                if(low[v] > discoveredTime[u]) res.add(Arrays.asList(u,v));
            }else low[u] = Math.min(low[u], low[v]);
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n], discoveredTime = new int[n];
        Arrays.fill(discoveredTime, -1);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] g = new List[n];
        for(int i=0; i<n; i++) g[i] = new ArrayList<>();
        for(int i=0; i<connections.size(); i++){
            g[connections.get(i).get(0)].add(connections.get(i).get(1));
            g[connections.get(i).get(1)].add(connections.get(i).get(0));
        }
        for(int i=0; i<n; i++) if(discoveredTime[i] == -1) dfs(i, i, low, discoveredTime, g, res);
        return res;
    }
}
