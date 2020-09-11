import java.sql.SQLOutput;
import java.util.*;

public class M449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{offer(root);}};
        sb.append(root.val).append(" ");
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left == null) sb.append("null ");
            else{
                sb.append(n.left.val).append(" ");
                q.offer(n.left);
            }
            if(n.right == null) sb.append("null ");
            else{
                sb.append(n.right.val).append(" ");
                q.offer(n.right);
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("\\s");
        Queue<TreeNode> q = new LinkedList<>();
        int i=1;
        if(arr[0].equals("null")) return null;
        TreeNode res = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(res);
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j<size; j++){
                TreeNode n = q.poll();
                if(arr[i].equals("null")) n.left = null;
                else{
                    n.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(n.left);
                }
                i++;
                if(arr[i].equals("null")) n.right = null;
                else{
                    n.right= new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(n.right);
                }
                i++;
            }
        }

        return res;
    }
}
