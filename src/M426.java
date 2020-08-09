public class M426 {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // Use a dummy node
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper (Node cur) {
        if (cur == null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
    }

    //Divide and Conquer
    public Node treeToDoublyList2(Node root) {
        if (root == null)   return null;
        Node[] nodes = divideAndConquer(root);
        Node first = nodes[0], last = nodes[1];
        first.left = last;
        last.right = first;
        return first;
    }

    private Node[] divideAndConquer(Node curr) {
        if (curr == null)   return null;
        // divide
        Node[] left = divideAndConquer(curr.left);
        Node[] right = divideAndConquer(curr.right);

        if (left != null && right != null) { // in case both left subtree and right subtree are both non-empty
            left[1].right = curr;
            curr.left = left[1];
            curr.right = right[0];
            right[0].left = curr;
            return new Node[]{left[0], right[1]};
        }else if (left != null) { // in case only left subtree is non-empty
            left[1].right = curr;
            curr.left = left[1];
            return new Node[]{left[0], curr};
        } else if (right != null) { // in case only right subtree is non-empty
            curr.right = right[0];
            right[0].left = curr;
            return new Node[]{curr, right[1]};
        } else return new Node[]{curr, curr}; // in case both subtree are empty
    }
}
