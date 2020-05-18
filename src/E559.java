import java.util.*;
public class E559 {

    // My solution
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int m = 0;
        for(Node n : root.children){
            int d = maxDepth(n);
            if(d > m) m = d;
        }
        return m + 1;
    }

    // Iterative solution
    public int maxDepth2(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            for(int i = 0; i < queue.size(); i++) {
                Node current = queue.poll();
                for(Node child: current.children) queue.offer(child);
            }
            depth++;
        }
        return depth;
    }
}
