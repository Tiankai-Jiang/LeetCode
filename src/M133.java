import java.util.*;
public class M133 {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(node.neighbors == null || node.neighbors.isEmpty()) return new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<Node>(){{offer(node);}};
        while(!q.isEmpty()){
            Node n = q.poll();
            map.putIfAbsent(n.val, new Node(n.val));
            for(Node m: n.neighbors){
                if(!map.containsKey(m.val)){
                    map.put(m.val, new Node(m.val));
                    q.offer(m);
                }
                map.get(n.val).neighbors.add(map.get(m.val));
            }
        }
        return map.get(node.val);
    }

    public HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph2(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) newNode.neighbors.add(clone(neighbor));
        return newNode;
    }
}
