import java.util.LinkedList;
import java.util.Queue;

public class H297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{offer(root);}};
        sb.append(root.val).append(' ');
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left == null) sb.append("null ");
            else{
                q.offer(n.left);
                sb.append(n.left.val).append(' ');
            }
            if(n.right == null) sb.append("null ");
            else{
                q.offer(n.right);
                sb.append(n.right.val).append(' ');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] nodes = data.split("\\s");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int y = 0; y < size; ++y) {
                TreeNode x=q.poll();
                if (nodes[i].equals("null")) x.left=null;
                else {
                    x.left=new TreeNode(Integer.parseInt(nodes[i]));
                    q.offer(x.left);
                }
                i++;
                if (nodes[i].equals("null")) x.right=null;
                else {
                    x.right=new TreeNode(Integer.parseInt(nodes[i]));
                    q.offer(x.right);
                }
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
