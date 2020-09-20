public class M116 {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

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

    public Node connect(Node root) {
        if(root == null) return null;
        Node curLevel = root;
        while(curLevel.left != null){
            Node nextStart = curLevel.left;
            while(curLevel != null){
                curLevel.left.next = curLevel.right;
                Node last = curLevel.right;
                curLevel = curLevel.next;
                if(curLevel != null) last.next = curLevel.left;
            }
            curLevel = nextStart;
        }
        return root;
    }
}
