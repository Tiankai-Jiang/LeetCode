import java.util.*;

public class M1305 {

    // My solution 1, lazy
    private void getAllElements(List<Integer> l, TreeNode root){
        if(root == null) return;
        getAllElements(l, root.left);
        l.add(root.val);
        getAllElements(l, root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>();
        getAllElements(l1, root1);
        getAllElements(l2, root2);
        l1.addAll(l2);
        l1.sort(Integer::compare);
        return l1;
    }

    // In order traversal independently for two trees and when visiting the node of the top of the stack, we visit the smaller one
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        TreeNode cur1=root1, cur2=root2;
        while(cur1!=null || cur2!=null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(cur1!=null){
                stack1.push(cur1);
                cur1=cur1.left;
            }
            while(cur2!=null){
                stack2.push(cur2);
                cur2=cur2.left;
            }
            if(stack2.isEmpty() || !stack1.isEmpty()&&stack1.peek().val<=stack2.peek().val){
                cur1=stack1.pop();
                res.add(cur1.val);
                cur1=cur1.right;
            }else{
                cur2=stack2.pop();
                res.add(cur2.val);
                cur2=cur2.right;
            }
        }
        return res;
    }
}
