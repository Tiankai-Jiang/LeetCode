public class M323 {

    private int find(int[] parents, int i){
        if(parents[i] != i) parents[i] = find(parents, parents[i]);
        return parents[i];
    }

    private void union(int[] parents, int[] rank, int x, int y){
        int xroot = find(parents, x);
        int yroot = find(parents, y);

        if(xroot == yroot) return;
        if(rank[x] < rank[y]) parents[xroot] = yroot;
        else if(rank[x] > rank[y]) parents[yroot] = xroot;
        else{
            parents[xroot] = yroot;
            rank[y]++;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n], rank = new int[n];
        for(int i=0; i<n; i++) parents[i] = i;
        for(int[] edge : edges) union(parents, rank, edge[0], edge[1]);
        boolean[] nums = new boolean[n];
        int res = 0;
        for(int i=0; i<n; i++) {
            int j = find(parents, parents[i]);
            if(!nums[j]){
                nums[j] = true;
                res++;
            }
        }
        return res;
    }

    public int countComponents2(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }

    public int find2(int[] roots, int id) {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }
}
