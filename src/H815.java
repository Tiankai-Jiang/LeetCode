import java.util.*;
public class H815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T) return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                map.putIfAbsent(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        int res = 0;

        Queue<Integer> q = new LinkedList<Integer>(){{offer(S);}};
        while(!q.isEmpty()){
            int s = q.size();
            res++;
            for(int i=0; i<s; i++){
                int cur = q.poll();
                for(int bus: map.get(cur)){
                    if(!visited.contains(bus)){
                        visited.add(bus);
                        for (int j = 0; j < routes[bus].length; j++) {
                            if(routes[bus][j]==T) return res;
                            q.offer(routes[bus][j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
