import java.util.*;

public class M662 {
    private Integer maxWidth = 0;
    private void dfs(TreeNode node, int depth, int colIndex, List<Integer> levels) {
        if (node == null) return;
        if(levels.size() == depth) levels.add(colIndex);
        Integer firstColIndex = levels.get(depth);
        maxWidth = Math.max(this.maxWidth, colIndex - firstColIndex + 1);
        // Preorder DFS. Note: it is important to put the priority on the left child
        dfs(node.left, depth + 1, 2 * colIndex, levels);
        dfs(node.right, depth + 1, 2 * colIndex + 1, levels);
    }

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0, new LinkedList<>());
        return this.maxWidth;
    }
}
