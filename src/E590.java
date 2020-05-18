import java.util.*;
public class E590 {

    // My solution 1, recursive
    List<Integer> a = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return a;
        for(Node n : root.children) postorder(n);
        a.add(root.val);
        return a;
    }

    // My solution 2, iterative
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> a = new LinkedList<>();
        Stack<Node> s1 = new Stack<>();
        if(root == null) return a;
        s1.add(root);

        while(!s1.empty()){
            Node x = s1.pop();
            a.addFirst(x.val);
            for(Node n : x.children) s1.push(n);
        }
        return a;
    }

}
