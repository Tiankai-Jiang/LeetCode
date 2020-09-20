import java.util.*;
public class M117 {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private void connect(Node root, List<List<Node>> levels, int level){
        if(root == null) return;
        if(level == levels.size()) levels.add(new ArrayList<>());
        levels.get(level).add(root);
        connect(root.left, levels, level+1);
        connect(root.right, levels, level+1);
    }

    public Node connect(Node root) {
        if(root == null) return null;
        List<List<Node>> levels = new ArrayList<>();
        connect(root, levels, 0);
        for(int i=0; i<levels.size(); i++){
            List<Node> l = levels.get(i);
            for(int j=0; j< l.size()-1; j++) l.get(j).next = l.get(j+1);
            l.get(l.size()-1).next = null;
        }
        return root;
    }
}
