import java.util.*;
public class E589 {

    // My solution
    public void traverse(Node root, List<Integer> a){
        if(root == null) return;
        a.add(root.val);
        for(Node n : root.children) traverse(n, a);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> a = new ArrayList<>();
        traverse(root, a);
        return a;
    }

    // Recursive, no need to use a separate function
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder2(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for(Node node: root.children)
            preorder(node);

        return list;
    }

    // Iterative solution
    public List<Integer> preorder3(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) stack.add(root.children.get(i));
        }

        return list;
    }
}
