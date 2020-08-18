import java.util.*;
public class M785 {

    //For each node,
    //
    //If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
    //If it has been colored, check if the current color is the same as the color that is going to be used to color it.
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) if (colors[i] == 0 && !validColor(graph, colors, 1, i)) return false;
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) return colors[node] == color;
        colors[node] = color;
        for (int next : graph[node]) if (!validColor(graph, colors, -color, next)) return false;
        return true;
    }

    public boolean isBipartite2(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
