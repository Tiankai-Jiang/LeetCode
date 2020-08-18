import java.util.*;
public class M314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> qTree = new LinkedList<TreeNode>(){{offer(root);}};
        Queue<Integer> qCol = new LinkedList<Integer>(){{offer(0);}};
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int min = 0, max = 0;

        while(!qTree.isEmpty()){
            TreeNode n = qTree.poll();
            int col = qCol.poll();
            map.putIfAbsent(col, new LinkedList<>());
            map.get(col).add(n.val);

            if(n.left != null){
                qTree.offer(n.left);
                qCol.offer(col-1);
                min = Math.min(min, col-1);
            }
            if(n.right != null){
                qTree.offer(n.right);
                qCol.offer(col+1);
                max = Math.max(max, col+1);
            }
        }
        for(int i=min; i<=max; i++) res.add(map.get(i));
        return res;
    }
}
