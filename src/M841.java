import java.util.*;
public class M841 {

    // My solution, BFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] v = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<Integer>(){{add(0);}};
        while (!q.isEmpty()){
            int i = q.poll();
            v[i] = true;
            for(Integer j : rooms.get(i)) if(!v[j]) q.offer(j);
        }
        boolean a = true;
        for(boolean b:v) a&=b;
        return a;
    }

    // DFS
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<Integer>(){{add(0);}};
        HashSet<Integer> seen = new HashSet<Integer>(){{add(0);}};
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }
}
